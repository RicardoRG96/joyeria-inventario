package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.model.dao.MaterialDAO;
import com.mycompany.joyeriaInventario.model.entities.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLMaterialDAO implements MaterialDAO {

    private final String GET_ONE = "SELECT * FROM materials WHERE id = ?";
    
    private final String GET_ALL = "SELECT * FROM materials ORDER BY id ASC";
    
    private final String GET_BY_NAME = "SELECT * FROM materials WHERE name = ?";

    private final String INSERT = "INSERT INTO materials (name, description) VALUES (?, ?)";
    
    private final String UPDATE = "UPDATE materials SET name = ?, description = ? WHERE id = ?";
    
    private final String DELETE = "DELETE FROM materials WHERE id = ?";
    
    private Connection conn;

    public PostgreSQLMaterialDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Material getById(Long id) throws DAOException, InvalidInputException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       Material material = null;
       try {
           preparedStatement = conn.prepareStatement(GET_ONE);
           preparedStatement.setLong(1, id);
           resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               material = convert(resultSet);
           } else {
               throw new DAOException("No se ha encontrado el material");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener el material de la joya", e);
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
       return material;
    }
    
    private Material convert(ResultSet rs) throws SQLException, InvalidInputException {
        String name = rs.getString("name");
        String description = rs.getString("description");
        Material material = new Material(name, description);
        material.setId(rs.getLong("id"));
        material.setCreatedAt(rs.getTimestamp("created_at"));
        material.setUpdatedAt(rs.getTimestamp("updated_at"));
        
        return material;
    }

    @Override
    public List<Material> getAll() throws DAOException, InvalidInputException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<Material> materials = new ArrayList<>();
       try {
           preparedStatement = conn.prepareStatement(GET_ALL);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               materials.add(convert(resultSet));
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener todos los materiales", e);
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
       return materials;
    }
    
    @Override
    public Material getByName(String name) throws DAOException, InvalidInputException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       Material material = null;
       try {
           preparedStatement = conn.prepareStatement(GET_BY_NAME);
           preparedStatement.setString(1, name);
           resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               material = convert(resultSet);
           } else {
               throw new DAOException("No se ha encontrado el material");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener el material de la joya", e);
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
       return material;
    }

    @Override
    public void insert(Material material) throws DAOException {
       PreparedStatement preparedStatement = null;
       try {
           preparedStatement = conn.prepareStatement(INSERT);
           preparedStatement.setString(1, material.getName());
           preparedStatement.setString(2, material.getDescription());
           boolean wasCreated = preparedStatement.executeUpdate() > 0;
           
           if (!wasCreated) {
               throw new DAOException("El material de la joya no pudo ser ingresado");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar crear material", e);
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
    public void update(Long id, Material material) throws DAOException {
       PreparedStatement preparedStatement = null;
       try {
           preparedStatement = conn.prepareStatement(UPDATE);
           preparedStatement.setString(1, material.getName());
           preparedStatement.setString(2, material.getDescription());
           preparedStatement.setLong(3, id);
           boolean wasUpdated = preparedStatement.executeUpdate() > 0;
           
           if (!wasUpdated) {
               throw new DAOException("El material de la joya no pudo ser actualizado");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar actualizar material", e);
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
           boolean wasDeleted = preparedStatement.executeUpdate() > 0;
           
           if (!wasDeleted) {
               throw new DAOException("El material no pudo ser eliminado");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar eliminar material", e);
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
