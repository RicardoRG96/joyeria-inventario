package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.jewel.JewelNotFoundException;
import com.mycompany.joyeriaInventario.model.dao.JewelDAO;
import com.mycompany.joyeriaInventario.model.entities.Jewel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLJewelDAO implements JewelDAO {
    
    private final String GET_ONE = "SELECT * FROM jewelry WHERE id = ?";
    
    private final String GET_ALL = "SELECT * FROM jewelry";
    
    private final String GET_BY_NAME = "SELECT * FROM jewelry WHERE name = ?";

    private final String INSERT = "INSERT INTO jewelry (name, material_id, weight, price, stock) VALUES (?, ?, ?, ?, ?)";
    
    private final String UPDATE = 
            "UPDATE jewelry SET name = ?, material_id = ?, weight = ?, price = ?, stock = ? WHERE id = ?";
    
    private final String DELETE = "DELETE FROM jewelry WHERE id = ?";
    
    private Connection conn;

    public PostgreSQLJewelDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Jewel getById(Long id) throws DAOException, JewelNotFoundException, InvalidInputException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Jewel jewel = null;
        try {
            preparedStatement = conn.prepareStatement(GET_ONE);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                jewel = convert(resultSet);
            } else {
                throw new JewelNotFoundException("No se ha encontrado el producto");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar obtener el producto", e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al intentar cerrar la conexion", ex);
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al intentar cerrar la conexion", ex);  
                }
            }
            
        }
        return jewel;
    }
    
    private Jewel convert(ResultSet rs) throws SQLException, InvalidInputException {
        String name = rs.getString("name");
        Long materialId = rs.getLong("material_id");
        Double weight = rs.getDouble("weight");
        Double price = rs.getDouble("price");
        int stock = rs.getInt("stock");
        Jewel jewel = new Jewel(name, materialId, weight, price, stock);
        jewel.setId(rs.getLong("id"));
        jewel.setCreatedAt(rs.getTimestamp("created_at"));
        jewel.setUpdatedAt(rs.getTimestamp("updated_at"));
        
        return jewel;
    }

    @Override
    public List<Jewel> getAll() throws DAOException, InvalidInputException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Jewel> jewels = new ArrayList<>();
        try {
            preparedStatement = conn.prepareStatement(GET_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jewels.add(convert(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar obtener todos los productos", e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al intentar cerrar la conexion", ex);
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al intentar cerrar la conexion", ex);  
                }
            }
            
        }
        return jewels;
    }
    
    @Override
    public Jewel getByName(String name) throws DAOException, JewelNotFoundException, InvalidInputException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Jewel jewel = null;
        try {
            preparedStatement = conn.prepareStatement(GET_BY_NAME);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                jewel = convert(resultSet);
            } else {
                throw new JewelNotFoundException("No se ha encontrado el producto");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar obtener el producto", e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al intentar cerrar la conexion", ex);
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al intentar cerrar la conexion", ex);  
                }
            }
            
        }
        return jewel;
    }

    @Override
    public void insert(Jewel jewel) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(INSERT);
            preparedStatement.setString(1, jewel.getName());
            preparedStatement.setLong(2, jewel.getMaterialId());
            preparedStatement.setDouble(3, jewel.getWeight());
            preparedStatement.setDouble(4, jewel.getPrice());
            preparedStatement.setInt(5, jewel.getStock());
            boolean wasCreated = preparedStatement.executeUpdate() > 0;
            if (!wasCreated) {
                throw new DAOException("El producto no pudo ser ingresado");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar crear el producto", e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al intentar cerrar la conexion", ex);
                }
            }            
        }
    }

    @Override
    public void update(Long id, Jewel jewel) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(UPDATE);
            preparedStatement.setString(1, jewel.getName());
            preparedStatement.setLong(2, jewel.getMaterialId());
            preparedStatement.setDouble(3, jewel.getWeight());
            preparedStatement.setDouble(4, jewel.getPrice());
            preparedStatement.setInt(5, jewel.getStock());
            preparedStatement.setLong(6, id);
            boolean wasUpdated = preparedStatement.executeUpdate() > 0;
            if (!wasUpdated) {
                throw new DAOException("El producto no pudo ser actualizado");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar crear el producto", e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al intentar cerrar la conexion", ex);
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
                throw new DAOException("El producto no pudo ser eliminado");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar crear el producto", e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al intentar cerrar la conexion", ex);
                }
            }            
        }
    }

}