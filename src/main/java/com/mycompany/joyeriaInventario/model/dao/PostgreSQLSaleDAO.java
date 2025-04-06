package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.entities.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PostgreSQLSaleDAO implements SaleDao {
    
    private final String GET_ONE = "SELECT * FROM sales WHERE id = ?";
    
    private final String GET_ALL = "SELECT * FROM sales";

    private final String INSERT = "INSERT INTO sales (customer_id, total) VALUES (?, ?)";
    
    private final String UPDATE = "UPDATE sales SET customer_id = ?, total = ? WHERE id = ?";
    
    private final String DELETE = "DELETE FROM sales WHERE id = ?";
    
    private Connection conn;

    public PostgreSQLSaleDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public Sale getById(Long id) throws DAOException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       Sale sale = null;
       try {
           preparedStatement = conn.prepareStatement(GET_ONE);
           preparedStatement.setLong(1, id);
           resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               sale = convert(resultSet);
           } else {
               throw new DAOException("No se ha encontrado la orden de venta");
           }
       } catch (SQLException e) {
           throw new DAOException("Error en SQL", e);
       } finally {
           if (preparedStatement == null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error en SQL", e);
               }
           }
           if (resultSet == null) {
               try {
                   resultSet.close();
               } catch (SQLException e) {
                   throw new DAOException("Error en SQL", e);
               }
           }
       }
       return sale;
    }
    
    private Sale convert(ResultSet rs) throws SQLException {
        Long customerId = rs.getLong("customer_id");
        Double total = rs.getDouble("total");
        Sale sale = new Sale(customerId, total);
        sale.setId(rs.getLong("id"));
        sale.setCreatedAt(rs.getTimestamp("created_at"));
        sale.setUpdatedAt(rs.getTimestamp("updated_at"));
        
        return sale;
    }

    @Override
    public List<Sale> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Sale sale) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Long id, Sale sale) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
