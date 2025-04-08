package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.saleItem.SaleItemNotFoundException;
import com.mycompany.joyeriaInventario.model.dao.SaleItemDAO;
import com.mycompany.joyeriaInventario.model.entities.SaleItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLSaleItemDAO implements SaleItemDAO {
    
    private final String GET_ONE = "SELECT * FROM sale_items WHERE id = ?";
    
    private final String GET_ALL = "SELECT * FROM sale_items ORDER BY id ASC";
    
    private final String GET_BY_SALE_ID = "SELECT * FROM sale_items WHERE sale_id = ?";
    
    private final String GET_BY_JEWEL_ID = "SELECT * FROM sale_items WHERE jewel_id = ?";

    private final String INSERT = 
            "INSERT INTO sale_items (sale_id, jewel_id, quantity, price, subtotal) VALUES (?, ?, ?, ?, ?)";
    
    private final String UPDATE = 
            "UPDATE sale_items SET sale_id = ?, jewel_id = ?, quantity = ?, price = ?, subtotal = ? WHERE id = ?";
    
    private final String UPDATE_BY_SALE_ID_AND_JEWEL_ID = 
            "UPDATE sale_items SET sale_id = ?, jewel_id = ?, quantity = ?, price = ?, subtotal = ? WHERE sale_id = ? AND jewel_id = ?";
    
    private final String DELETE = "DELETE FROM sale_items WHERE id = ?";
    
    private final String DELETE_BY_SALE_ID_AND_JEWEL_ID = 
            "DELETE FROM sale_items WHERE sale_id = ? AND jewel_id = ?";
    
    private Connection conn;

    public PostgreSQLSaleItemDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public SaleItem getById(Long id) throws DAOException, InvalidInputException, SaleItemNotFoundException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       SaleItem saleItem = null;
       try {
           preparedStatement = conn.prepareStatement(GET_ONE);
           preparedStatement.setLong(1, id);
           resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               saleItem = convert(resultSet);
           } else {
               throw new SaleItemNotFoundException("No se ha encontrado item de la orden de venta");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener el item de la orden de venta", e);
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
       return saleItem;
    }
    
    private SaleItem convert(ResultSet rs) throws SQLException, InvalidInputException {
        Long saleId = rs.getLong("sale_id");
        Long jewelId = rs.getLong("jewel_id");
        int quantity = rs.getInt("quantity");
        Double price = rs.getDouble("price");
        Double subtotal = rs.getDouble("subtotal");
        SaleItem saleItem = new SaleItem(saleId, jewelId, quantity, price, subtotal);
        saleItem.setId(rs.getLong("id"));
        saleItem.setCreatedAt(rs.getTimestamp("created_at"));
        saleItem.setUpdatedAt(rs.getTimestamp("updated_at"));
        
        return saleItem;
    }

    @Override
    public List<SaleItem> getAll() throws DAOException, InvalidInputException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<SaleItem> saleItems = new ArrayList<>();
       try {
           preparedStatement = conn.prepareStatement(GET_ALL);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               saleItems.add(convert(resultSet));
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener todos los items", e);
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
       return saleItems;
    }
    
    @Override
    public List<SaleItem> getBySaleId(Long saleId) throws DAOException, SaleItemNotFoundException, InvalidInputException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<SaleItem> saleItems = new ArrayList<>();
       try {
           preparedStatement = conn.prepareStatement(GET_BY_SALE_ID);
           preparedStatement.setLong(1, saleId);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               saleItems.add(convert(resultSet));
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener todos los items", e);
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
       return saleItems;
    }

    @Override
    public List<SaleItem> getByJewelId(Long jewelId) throws DAOException, SaleItemNotFoundException, InvalidInputException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<SaleItem> saleItems = new ArrayList<>();
       try {
           preparedStatement = conn.prepareStatement(GET_BY_JEWEL_ID);
           preparedStatement.setLong(1, jewelId);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               saleItems.add(convert(resultSet));
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener todos los items", e);
       } finally {
           if (preparedStatement == null) {
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
       return saleItems;
    }

    @Override
    public void insert(SaleItem saleItem) throws DAOException {
       PreparedStatement preparedStatement = null;
       try {
           preparedStatement = conn.prepareStatement(INSERT);
           preparedStatement.setLong(1, saleItem.getSaleId());
           preparedStatement.setLong(2, saleItem.getJewelId());
           preparedStatement.setInt(3, saleItem.getQuantity());
           preparedStatement.setDouble(4, saleItem.getPrice());
           preparedStatement.setDouble(5, saleItem.getSubTotal());
           boolean wasCreated = preparedStatement.executeUpdate() > 0;
           if (!wasCreated) {
               throw new DAOException("El item de la venta no pudo ser ingresado");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar crear item de venta", e);
       } finally {
           if (preparedStatement != null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
       }
    }

    @Override
    public void update(Long id, SaleItem saleItem) throws DAOException {
       PreparedStatement preparedStatement = null;
       try {
           preparedStatement = conn.prepareStatement(UPDATE);
           preparedStatement.setLong(1, saleItem.getSaleId());
           preparedStatement.setLong(2, saleItem.getJewelId());
           preparedStatement.setInt(3, saleItem.getQuantity());
           preparedStatement.setDouble(4, saleItem.getPrice());
           preparedStatement.setDouble(5, saleItem.getSubTotal());
           preparedStatement.setLong(6, id);
           boolean wasCreated = preparedStatement.executeUpdate() > 0;
           if (!wasCreated) {
               throw new DAOException("El item de la venta no pudo ser actualizado");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar actualizar item de venta", e);
       } finally {
           if (preparedStatement != null) {
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
           boolean wasCreated = preparedStatement.executeUpdate() > 0;
           if (!wasCreated) {
               throw new DAOException("El item de la venta no pudo ser eliminado");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar eliminar item de venta", e);
       } finally {
           if (preparedStatement != null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
       }
    }
    
    @Override
    public void updateBySaleIdAndJewelId(Long saleId, Long jewelId) throws DAOException {
         PreparedStatement preparedStatement = null;
       try {
           preparedStatement = conn.prepareStatement(UPDATE_BY_SALE_ID_AND_JEWEL_ID);
           preparedStatement.setLong(1, saleId);
           preparedStatement.setLong(2, jewelId);
           boolean wasCreated = preparedStatement.executeUpdate() > 0;
           if (!wasCreated) {
               throw new DAOException("El item de la venta no pudo ser actualizado");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar actualizar item de venta", e);
       } finally {
           if (preparedStatement != null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
       }
    }

    @Override
    public void deleteBySaleIdAndJewelId(Long saleId, Long jewelId) throws DAOException {
        PreparedStatement preparedStatement = null;
       try {
           preparedStatement = conn.prepareStatement(DELETE_BY_SALE_ID_AND_JEWEL_ID);
           preparedStatement.setLong(1, saleId);
           preparedStatement.setLong(2, jewelId);
           boolean wasCreated = preparedStatement.executeUpdate() > 0;
           if (!wasCreated) {
               throw new DAOException("El item de la venta no pudo ser eliminado");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar eliminar item de venta", e);
       } finally {
           if (preparedStatement != null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
       }
    }

}