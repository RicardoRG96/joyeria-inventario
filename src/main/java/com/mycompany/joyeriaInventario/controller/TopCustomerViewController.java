package com.mycompany.joyeriaInventario.controller;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.postgreSQL.PostgreSQLDAOManager;
import com.mycompany.joyeriaInventario.model.views.TopCustomerView;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

public class TopCustomerViewController {

    private DAOManager manager;

    public TopCustomerViewController() throws SQLException {
        this.manager = new PostgreSQLDAOManager("localhost", "5432", "joyeria_inventario", "postgres", "ricardo1996");
    }
    
    public List<TopCustomerView> getAll() {
        List<TopCustomerView> topCustomersView = null;
        try {
            topCustomersView = manager.getTopCustomerViewDAO().getAll();
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener reporte: " + e.getMessage());
        }
        return topCustomersView;
    }
    
    public List<TopCustomerView> onFilter(String name, LocalDate from, LocalDate to) {
        List<TopCustomerView> topCustomersView = null;
        try {
            topCustomersView = manager.getTopCustomerViewDAO().findByFilters(name, from, to);
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar el filtro: " + e.getMessage());
        }
        return topCustomersView;
    }
    
}
