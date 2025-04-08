package com.mycompany.joyeriaInventario.controller;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.jewel.JewelNotFoundException;
import com.mycompany.joyeriaInventario.exception.saleItem.SaleItemNotFoundException;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.postgreSQL.PostgreSQLDAOManager;
import com.mycompany.joyeriaInventario.model.dto.SaleItemDTO;
import com.mycompany.joyeriaInventario.model.entities.SaleItem;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class SaleItemController {
 
    private DAOManager manager;

    public SaleItemController() throws SQLException {
        this.manager = new PostgreSQLDAOManager("localhost", "5432", "joyeria_inventario", "postgres", "ricardo1996");
    }
    
    public SaleItem getSaleItemById(Long id) throws DAOException {
        SaleItem saleItem = null;
        try {
            saleItem = manager.getSaleItemDAO().getById(id);
        } catch (InvalidInputException | SaleItemNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener items del pedido de venta: " + e.getMessage());
        }
        return saleItem;
    }
    
    public List<SaleItem> getAllSalesItems(Long id) throws DAOException {
        List<SaleItem> saleItems = null;
        try {
            saleItems = manager.getSaleItemDAO().getAll();
        } catch (InvalidInputException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener items del pedido de venta: " + e.getMessage());
        }
        return saleItems;
    }
    
    public List<SaleItem> getSaleItemBySaleId(Long id) throws DAOException {
        List<SaleItem> saleItems = null;
        try {
            saleItems = manager.getSaleItemDAO().getBySaleId(id);
        } catch (InvalidInputException | SaleItemNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener items del pedido de venta: " + e.getMessage());
        }
        return saleItems;
    }
    
    public List<SaleItem> getSaleItemByJewelId(Long id) throws DAOException {
        List<SaleItem> saleItems = null;
        try {
            saleItems = manager.getSaleItemDAO().getByJewelId(id);
        } catch (InvalidInputException | SaleItemNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener items del pedido de venta: " + e.getMessage());
        }
        return saleItems;
    }
    
    public void createSaleItem(SaleItemDTO saleItemDTO) throws DAOException {
        try {
            SaleItem saleItem = new SaleItem();
            Long jewelId = manager.getJewelDAO().getByName(saleItemDTO.getJewelName()).getId();

            saleItem.setSaleId(saleItemDTO.getSaleId());
            saleItem.setJewelId(jewelId);
            saleItem.setQuantity(saleItemDTO.getQuantity());
            saleItem.setPrice(saleItemDTO.getPrice());
            saleItem.setSubTotal(saleItemDTO.getSubtotal());

            manager.getSaleItemDAO().insert(saleItem);
        } catch (InvalidInputException | JewelNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar liena de pedido de venta: " + e.getMessage());
        }
    }
    
    public void updateSaleItem(Long id, SaleItemDTO saleItemDTO) throws DAOException {
        try {
            SaleItem saleItem = new SaleItem();
            Long jewelId = manager.getJewelDAO().getByName(saleItemDTO.getJewelName()).getId();

            saleItem.setSaleId(saleItemDTO.getSaleId());
            saleItem.setJewelId(jewelId);
            saleItem.setQuantity(saleItemDTO.getQuantity());
            saleItem.setPrice(saleItemDTO.getPrice());
            saleItem.setSubTotal(saleItemDTO.getSubtotal());

            manager.getSaleItemDAO().update(id, saleItem);
        } catch (InvalidInputException | JewelNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar liena de pedido de venta: " + e.getMessage());
        }
    }
    
    public void deleteSaleItem(Long id) throws DAOException {
        manager.getSaleDAO().delete(id);
    }
    
    public void deleteBySaleIdAndJewelId(Long saleId, Long jewelId) {
        try {
            manager.getSaleItemDAO().deleteBySaleIdAndJewelId(saleId, jewelId);
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar item de venta: " + e.getMessage());
        }
    }
    
    public void updateBySaleIdAndJewelId(Long saleId, Long jewelId) {
        try {
            manager.getSaleItemDAO().updateBySaleIdAndJewelId(saleId, jewelId);
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar item de venta: " + e.getMessage());
        }
    }
    
}
