package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.sale.SaleNotFoundException;
import com.mycompany.joyeriaInventario.model.dao.InvoiceDAO;
import com.mycompany.joyeriaInventario.model.entities.Invoice;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLInvoiceDAO implements InvoiceDAO{

    private final String GET_ONE = "SELECT * FROM invoices WHERE id = ?";
    
    private final String GET_ALL = "SELECT * FROM invoices ORDER BY id ASC";
    
    private final String GET_BY_SALE_ID = "SELECT * FROM invoices WHERE sale_id = ?";

    private final String INSERT = 
            "INSERT INTO invoices (sale_id, invoice_ number, customer_name, customer_rut, billing_address, total, tax, issue_date, status) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private final String UPDATE = 
            "UPDATE invoices "
            + "SET sale_id = ?, invoice_ number = ?, customer_name = ?, customer_rut = ?, billing_address = ?, total = ?, tax = ?, issue_date = ?, status = ? "
            + "WHERE id = ?";
    
    private final String DELETE = "DELETE FROM invoices WHERE id = ?";
    
    private Connection conn;

    public PostgreSQLInvoiceDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Invoice getById(Long id) throws DAOException, InvalidInputException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       Invoice invoice = null;
       try {
           preparedStatement = conn.prepareStatement(GET_ONE);
           preparedStatement.setLong(1, id);
           resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               invoice = convert(resultSet);
           } else {
               throw new DAOException("No se ha encontrado la factura de la orden de venta");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener la factura de la orden de venta", e);
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
       return invoice;
    }
    
    private Invoice convert(ResultSet rs) throws SQLException, InvalidInputException {
        Long saleId = rs.getLong("sale_id");
        String invoiceNumber = rs.getString("invoice_number");
        String customerName = rs.getString("customer_name");
        String customerRut = rs.getString("customer_rut");
        String billingAddress = rs.getString("billing_address");
        Double total = rs.getDouble("total");
        Double tax = rs.getDouble("tax");
        Date issueDate = rs.getDate("issue_date");
        String status = rs.getString("status");
        Invoice invoice = new Invoice(saleId, invoiceNumber, customerName, customerRut, billingAddress, total, tax, issueDate, status);
        invoice.setId(rs.getLong("id"));
        
        return invoice;
    }

    @Override
    public List<Invoice> getAll() throws DAOException, InvalidInputException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<Invoice> invoices = new ArrayList<>();
       try {
           preparedStatement = conn.prepareStatement(GET_ALL);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               invoices.add(convert(resultSet));
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener todas las facturas", e);
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
       return invoices;
    }
    
    @Override
    public List<Invoice> getBySaleId(Long saleId) 
            throws DAOException, SaleNotFoundException, InvalidInputException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<Invoice> invoices = new ArrayList<>();
       try {
           preparedStatement = conn.prepareStatement(GET_BY_SALE_ID);
           preparedStatement.setLong(1, saleId);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               invoices.add(convert(resultSet));
           }
       } catch (SQLException e) {
           throw new SaleNotFoundException("Error al intentar obtener las facturas asociadas a la venta indicada", e);
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
       return invoices;
    }

    @Override
    public void insert(Invoice invoice) throws DAOException {
       PreparedStatement preparedStatement = null;
       try {
           preparedStatement = conn.prepareStatement(INSERT);
           preparedStatement.setLong(1, invoice.getSaleId());
           preparedStatement.setString(2, invoice.getInvoiceNumber());
           preparedStatement.setString(3, invoice.getCustomerName());
           preparedStatement.setString(4, invoice.getCustomerRut());
           preparedStatement.setString(5, invoice.getBillingAddress());
           preparedStatement.setDouble(6, invoice.getTotal());
           preparedStatement.setDouble(7, invoice.getTax());
           preparedStatement.setDate(8, invoice.getIssueDate());
           preparedStatement.setString(9, invoice.getStatus());
           boolean wasCreated = preparedStatement.executeUpdate() > 0;
           
           if (!wasCreated) {
               throw new DAOException("La factura de la venta no pudo ser creada");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar insertar la factura", e);
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
    public void update(Long id, Invoice invoice) throws DAOException {
       PreparedStatement preparedStatement = null;
       try {
           preparedStatement = conn.prepareStatement(UPDATE);
           preparedStatement.setLong(1, invoice.getSaleId());
           preparedStatement.setString(2, invoice.getInvoiceNumber());
           preparedStatement.setString(3, invoice.getCustomerName());
           preparedStatement.setString(4, invoice.getCustomerRut());
           preparedStatement.setString(5, invoice.getBillingAddress());
           preparedStatement.setDouble(6, invoice.getTotal());
           preparedStatement.setDouble(7, invoice.getTax());
           preparedStatement.setDate(8, invoice.getIssueDate());
           preparedStatement.setString(9, invoice.getStatus());
           preparedStatement.setLong(10, id);
           boolean wasUpdated = preparedStatement.executeUpdate() > 0;
           
           if (!wasUpdated) {
               throw new DAOException("La factura de la venta no pudo ser actualizada");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar actualizar la factura", e);
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
               throw new DAOException("La factura de la venta no pudo ser eliminada");
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar eliminar la factura", e);
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
