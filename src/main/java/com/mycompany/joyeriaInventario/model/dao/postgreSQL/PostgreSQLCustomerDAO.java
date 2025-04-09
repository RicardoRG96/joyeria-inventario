package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.customer.CustomerNotFoundException;
import com.mycompany.joyeriaInventario.model.dao.CustomerDAO;
import com.mycompany.joyeriaInventario.model.entities.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLCustomerDAO implements CustomerDAO {

    private final String GET_ONE = "SELECT * FROM customers WHERE id = ?";
    
    private final String GET_ALL = "SELECT * FROM customers ORDER BY id ASC";
    
    private final String GET_BY_NAME = "SELECT * FROM customers WHERE name = ?";

    private final String INSERT = "INSERT INTO customers (name, rut, email, phone, address) VALUES (?, ?, ?, ?, ?)";
    
    private final String UPDATE = 
            "UPDATE customers SET name = ?, rut = ?, email = ?, phone = ?, address = ?, WHERE id = ?";
    
    private final String DELETE = "DELETE FROM customers WHERE id = ?";
    
    private Connection conn;

    public PostgreSQLCustomerDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Customer getById(Long id) 
            throws DAOException, InvalidInputException, CustomerNotFoundException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        try {
            preparedStatement = conn.prepareStatement(GET_ONE);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = convert(resultSet);
            } else {
                throw new CustomerNotFoundException("No se ha encontrado el cliente");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar obtener el cliente", e);
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
        return customer;
    }
    
    private Customer convert(ResultSet rs) 
            throws SQLException, InvalidInputException {
        String name = rs.getString("name");
        String rut = rs.getString("rut");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String address = rs.getString("address");
        Customer customer = new Customer(name, rut, email, phone, address);
        customer.setId(rs.getLong("id"));
        customer.setCreatedAt(rs.getTimestamp("created_at"));
        customer.setUpdatedAt(rs.getTimestamp("updated_at"));
        
        return customer;
    }
    
    @Override
    public List<Customer> getAll() 
            throws DAOException, InvalidInputException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Customer> customers = new ArrayList<>();
        try {
            preparedStatement = conn.prepareStatement(GET_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(convert(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar obtener todos los clientes", e);
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
        return customers;
    }

    @Override
    public Customer getByName(String name) 
            throws DAOException, CustomerNotFoundException, InvalidInputException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        try {
            preparedStatement = conn.prepareStatement(GET_BY_NAME);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = convert(resultSet);
            } else {
                throw new CustomerNotFoundException("No se ha encontrado el cliente");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar obtener el cliente", e);
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
        return customer;
    }
    
    @Override
    public void insert(Customer customer) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(INSERT);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getRut());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhone());
            preparedStatement.setString(5, customer.getAddress());
            boolean wasCreated = preparedStatement.executeUpdate() > 0;
            if (!wasCreated) {
                throw new DAOException("El cliente no pudo ser ingresado");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar crear a cliente", e);
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
    public void update(Long id, Customer customer) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(UPDATE);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getRut());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhone());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setLong(6, id);
            boolean wasUpdated = preparedStatement.executeUpdate() > 0;
            if (!wasUpdated) {
                throw new DAOException("El cliente no pudo ser actualizado");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar actualizar a cliente", e);
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
                throw new DAOException("El cliente no pudo ser eliminado");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al intentar eliminar a cliente", e);
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
