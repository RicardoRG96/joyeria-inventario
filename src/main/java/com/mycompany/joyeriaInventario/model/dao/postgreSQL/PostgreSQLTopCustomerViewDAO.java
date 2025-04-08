package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.dao.TopCustomerViewDAO;
import com.mycompany.joyeriaInventario.model.views.TopCustomerView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
           if (preparedStatement == null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
           if (resultSet == null) {
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
    
}
