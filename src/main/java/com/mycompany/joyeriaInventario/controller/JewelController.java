package com.mycompany.joyeriaInventario.controller;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.jewel.JewelNotFoundException;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.postgreSQL.PostgreSQLDAOManager;
import com.mycompany.joyeriaInventario.model.dto.JewelDTO;
import com.mycompany.joyeriaInventario.model.entities.Jewel;
import com.mycompany.joyeriaInventario.model.entities.Material;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;

public class JewelController {
    
    private DAOManager manager;

    public JewelController() throws SQLException {
        this.manager = new PostgreSQLDAOManager("localhost", "5432", "joyeria_inventario", "postgres", "ricardo1996");
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
    
    public void updateJewel(JewelDTO jewelDTO) throws DAOException {
       try {
            Jewel jewel = new Jewel();
            Long materialId = manager.getMaterialDAO().getByName(jewelDTO.getMaterialName()).getId();
            Long jewelId = manager.getJewelDAO().getByName(jewelDTO.getName()).getId();

            jewel.setName(jewelDTO.getName());
            jewel.setMaterialId(materialId);
            jewel.setWeight(jewelDTO.getWeight());
            jewel.setPrice(jewelDTO.getPrice());
            jewel.setStock(jewelDTO.getStock());

            manager.getJewelDAO().update(jewelId, jewel);
       } catch (InvalidInputException | JewelNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage());
       }
    }
    
    public List<Material> getAllMaterials() throws DAOException, InvalidInputException {
        return manager.getMaterialDAO().getAll();
    }
    
}
