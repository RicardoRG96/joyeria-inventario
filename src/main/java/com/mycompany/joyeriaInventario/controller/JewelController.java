package com.mycompany.joyeriaInventario.controller;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.jewel.InsufficientStockException;
import com.mycompany.joyeriaInventario.exception.jewel.JewelNotFoundException;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.postgreSQL.PostgreSQLDAOManager;
import com.mycompany.joyeriaInventario.model.dto.JewelDTO;
import com.mycompany.joyeriaInventario.model.entities.Jewel;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;

public class JewelController {
    
    private DAOManager manager;

    public JewelController() throws SQLException {
        this.manager = new PostgreSQLDAOManager("localhost", "5432", "joyeria_inventario", "postgres", "ricardo1996");
    }
    
    public Jewel getJewelById(Long id) throws DAOException {
        Jewel jewel = null;
        try {
            jewel = manager.getJewelDAO().getById(id);
        } catch (InvalidInputException | JewelNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener joya: " + e.getMessage());
        }
        return jewel;
    }
    
    public Jewel getJewelByName(String name) throws DAOException {
        Jewel jewel = null;
        try {
            jewel = manager.getJewelDAO().getByName(name);
        } catch (InvalidInputException | JewelNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener joya: " + e.getMessage());
        }
        return jewel;
    }
    
    public void createJewel(JewelDTO jewelDTO) throws DAOException {
       try {
            Jewel jewel = new Jewel();
            Long materialId = manager.getMaterialDAO().getByName(jewelDTO.getMaterialName()).getId();

            jewel.setName(jewelDTO.getName());
            jewel.setMaterialId(materialId);
            jewel.setWeight(jewelDTO.getWeight());
            jewel.setPrice(jewelDTO.getPrice());
            jewel.setStock(jewelDTO.getStock());

            manager.getJewelDAO().insert(jewel);
       } catch (InvalidInputException e) {
           JOptionPane.showMessageDialog(null, "Error al crear el producto: " + e.getMessage());
       }
    }
    
    public void updateJewel(Long id, JewelDTO jewelDTO) throws DAOException {
       try {
            Jewel jewel = new Jewel();
            Long materialId = manager.getMaterialDAO().getByName(jewelDTO.getMaterialName()).getId();

            jewel.setName(jewelDTO.getName());
            jewel.setMaterialId(materialId);
            jewel.setWeight(jewelDTO.getWeight());
            jewel.setPrice(jewelDTO.getPrice());
            jewel.setStock(jewelDTO.getStock());

            manager.getJewelDAO().update(id, jewel);
       } catch (InvalidInputException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage());
       }
    }
    
    public List<Jewel> getAllJewels() throws DAOException, InvalidInputException {
        return manager.getJewelDAO().getAll();
    }
    
    public void deleteJewel(Long id) throws DAOException {
        manager.getJewelDAO().delete(id);
    }
    
    public void checkAvailableStock(String jewelName, int quantity) throws InsufficientStockException, DAOException {
        try {
            Jewel jewel = manager.getJewelDAO().getByName(jewelName);
            int availableStock = jewel.getStock();
            if (quantity > availableStock) {
                throw new InsufficientStockException("No hay suficiente stock para el producto: " +
                            jewel.getName());
            } 
        } catch (InvalidInputException | JewelNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener joya: " + e.getMessage());
        }
    }
    
    public void updateJewelStock(String jewelName, int quantityToDeduct) throws DAOException, InsufficientStockException {
        try {
            Jewel jewel = manager.getJewelDAO().getByName(jewelName);
            Long jewelId = jewel.getId();
            int updatedStockQuantity = jewel.getStock() - quantityToDeduct;
            if (updatedStockQuantity < 0) {
                throw new InsufficientStockException("No hay suficiente stock para el producto: " +
                            jewel.getName());
            }
            jewel.setStock(updatedStockQuantity);
            manager.getJewelDAO().update(jewelId, jewel);
        } catch (InvalidInputException | JewelNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener joya: " + e.getMessage());
        }
    }
    
}
