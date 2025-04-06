package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.dao.SaleDao;
import com.mycompany.joyeriaInventario.model.entities.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<Sale> getAll() throws DAOException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<Sale> sales = new ArrayList<>();
       try {
           preparedStatement = conn.prepareStatement(GET_ALL);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               sales.add(convert(resultSet));
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener todas las ordenes de venta", e);
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
       return sales;
    }

    @Override
    public void insert(Sale sale) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
           preparedStatement = conn.prepareStatement(INSERT);
           preparedStatement.setLong(1, sale.getCustomerId());
           preparedStatement.setDouble(2, sale.getTotal());
           boolean wasCreated = preparedStatement.executeUpdate() > 0;
           if (!wasCreated) {
               throw new DAOException("La orden venta no pudo ser ingresada");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar crear la orden de venta", e);
       } finally {
           if (preparedStatement == null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
       }
    }

    @Override
    public void update(Long id, Sale sale) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
           preparedStatement = conn.prepareStatement(UPDATE);
           preparedStatement.setLong(1, sale.getCustomerId());
           preparedStatement.setDouble(2, sale.getTotal());
           preparedStatement.setLong(3, id);
           boolean wasUpdated = preparedStatement.executeUpdate() > 0;
           if (!wasUpdated) {
               throw new DAOException("La orden venta no pudo ser actualizada");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar actualizar la orden de venta", e);
       } finally {
           if (preparedStatement == null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
       }
    }

    @Override
    public void delete(Long id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
           preparedStatement = conn.prepareStatement(DELETE);
           preparedStatement.setLong(1, id);
           boolean wasDeleted = preparedStatement.executeUpdate() > 0;
           if (!wasDeleted) {
               throw new DAOException("La orden venta no pudo ser eliminada");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar eliminar la orden de venta", e);
       } finally {
           if (preparedStatement == null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
       }
    }
    
}
