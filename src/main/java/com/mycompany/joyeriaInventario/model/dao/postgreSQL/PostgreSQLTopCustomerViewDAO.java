package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.dao.TopCustomerViewDAO;
import com.mycompany.joyeriaInventario.model.views.TopCustomerView;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLTopCustomerViewDAO implements TopCustomerViewDAO {

    private final String GET_ALL = "SELECT * FROM top_customers ORDER BY total_spent DESC";
    
    private Connection conn;

    public PostgreSQLTopCustomerViewDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<TopCustomerView> getAll() throws DAOException {
        PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<TopCustomerView> TopCustomersView = new ArrayList<>();
       try {
           preparedStatement = conn.prepareStatement(GET_ALL);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               TopCustomersView.add(convert(resultSet));
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener los clientes con más compras", e);
       } finally {
           if (preparedStatement != null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
           if (resultSet != null) {
               try {
                   resultSet.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
       }
       return TopCustomersView;
    }
    
    private TopCustomerView convert(ResultSet rs) throws SQLException {
        Long customerId = rs.getLong("customer_id");
        String customerName = rs.getString("name");
        int totalSales = rs.getInt("total_sales");
        double totalSpent = rs.getDouble("total_spent");
        TopCustomerView topCustomerView = new TopCustomerView(customerId, customerName, totalSales, totalSpent);
        
        return topCustomerView;
    }

    @Override
    public List<TopCustomerView> findByFilters(String customerName, LocalDate fromDate, LocalDate toDate) 
            throws DAOException {
       ResultSet resultSet = null;
       List<TopCustomerView> topCustomersView = new ArrayList<>();
       StringBuilder sql = new StringBuilder(
            "SELECT c.id AS customer_id, c.name, COUNT(s.id) AS total_sale, SUM(s.total) AS total_spent " +
            "FROM sales s " +
            "JOIN customers c ON s.customer_id = c.id " +
            "WHERE 1=1 " +
            "GROUP BY c.id, c.name "
        );
           
           if (customerName != null && !customerName.isBlank()) {
                sql.append("AND LOWER(c.name) LIKE ? ");
            }
            if (fromDate != null) {
                sql.append("AND s.created_at >= ? ");
            }
            if (toDate != null) {
                sql.append("AND s.created_at <= ? ");
            }
       try (PreparedStatement preparedStatement = conn.prepareStatement(sql.toString())) { 
            int paramIndex = 1;
            if (customerName != null && !customerName.isBlank()) {
                preparedStatement.setString(paramIndex++, "%" + customerName.toLowerCase() + "%");
            }
            if (fromDate != null) {
                preparedStatement.setDate(paramIndex++, Date.valueOf(fromDate));
            }
            if (toDate != null) {
                preparedStatement.setDate(paramIndex++, Date.valueOf(toDate));
            }
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               topCustomersView.add(convert(resultSet));
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar filtrar los clientes con más compras", e);
       } finally {
           if (resultSet != null) {
               try {
                   resultSet.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
       }
       return topCustomersView;
    }
    
}
