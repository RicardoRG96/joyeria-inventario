package com.mycompany.joyeriaInventario.controller;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.postgreSQL.PostgreSQLDAOManager;
import com.mycompany.joyeriaInventario.model.views.TopJewelView;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class TopJewelViewController {

    private DAOManager manager;

    public TopJewelViewController() throws SQLException {
        this.manager = new PostgreSQLDAOManager("localhost", "5432", "joyeria_inventario", "postgres", "ricardo1996");
    }
    
    public List<TopJewelView> getAll() {
        List<TopJewelView> topJewelsView = null;
        try {
            topJewelsView = manager.getTopJewelViewDAO().getAll();
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener reporte: " + e.getMessage());
        }
        return topJewelsView;
    }
    
}
