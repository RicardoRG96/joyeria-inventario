package com.mycompany.joyeriaInventario.controller;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.customer.CustomerNotFoundException;
import com.mycompany.joyeriaInventario.exception.sale.SaleNotFoundException;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.postgreSQL.PostgreSQLDAOManager;
import com.mycompany.joyeriaInventario.model.dto.SaleDTO;
import com.mycompany.joyeriaInventario.model.entities.Invoice;
import com.mycompany.joyeriaInventario.model.entities.Sale;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class SaleController {
    
    private DAOManager manager;

    public SaleController() throws SQLException {
        this.manager = new PostgreSQLDAOManager("localhost", "5432", "joyeria_inventario", "postgres", "ricardo1996");
    }
    
    public Sale getSaleById(Long id) throws DAOException {
        Sale sale = null;
        try {
            sale = manager.getSaleDAO().getById(id);
        } catch (InvalidInputException | SaleNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el pedido de venta: " + e.getMessage());
        }
        return sale;
    }
    
    public List<Sale> getAllSales() throws DAOException, InvalidInputException {
        return manager.getSaleDAO().getAll();
    }
    
    public void createSale(SaleDTO saleDTO) throws DAOException {
        try {
            Sale sale = new Sale();
            Long customerId = manager.getCustomerDAO().getByName(saleDTO.getCustomerName()).getId();

            sale.setCustomerId(customerId);
            sale.setTotal(saleDTO.getTotal());

            manager.getSaleDAO().insert(sale);
        } catch (InvalidInputException | CustomerNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el pedido de venta: " + e.getMessage());
        }
    }
    
    public void updateSale(Long id, SaleDTO saleDTO) throws DAOException {
        try {
            Sale sale = new Sale();
            Long customerId = manager.getCustomerDAO().getByName(saleDTO.getCustomerName()).getId();
            
            sale.setCustomerId(customerId);
            sale.setTotal(saleDTO.getTotal());

            manager.getSaleDAO().update(id, sale);
        } catch (InvalidInputException | CustomerNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el pedido de venta: " + e.getMessage());
        }
    }
    
    public void deleteSale(Long id) throws DAOException {
        try {
            if (!validateSaleHasInvoices(id)) {
                manager.getSaleDAO().delete(id);
            }
        } catch (InvalidInputException | SaleNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Pedido se encuentra facturado, no puede eliminarse " + e.getMessage());
        }
    }
    
    public boolean validateSaleHasInvoices(Long saleId) throws DAOException, SaleNotFoundException, InvalidInputException {
        List<Invoice> invoices = manager.getInvoiceDAO().getBySaleId(saleId);
        return invoices.size() > 0;
    }
    
}
