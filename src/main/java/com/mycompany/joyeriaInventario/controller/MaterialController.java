package com.mycompany.joyeriaInventario.controller;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.postgreSQL.PostgreSQLDAOManager;
import com.mycompany.joyeriaInventario.model.entities.Material;
import java.sql.SQLException;
import java.util.List;

public class MaterialController {

    private DAOManager manager;
    
    public MaterialController() throws SQLException {
        this.manager = new PostgreSQLDAOManager("localhost", "5432", "joyeria_inventario", "postgres", "ricardo1996");
    }
   
    public List<Material> getAllMaterials() throws DAOException, InvalidInputException {
        return manager.getMaterialDAO().getAll();
    }
    
    public String getMaterialName(Long id) throws DAOException, InvalidInputException {
        return manager.getMaterialDAO().getById(id).getName();
    }
    
}
