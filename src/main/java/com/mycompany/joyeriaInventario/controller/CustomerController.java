package com.mycompany.joyeriaInventario.controller;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.customer.CustomerNotFoundException;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.postgreSQL.PostgreSQLDAOManager;
import com.mycompany.joyeriaInventario.model.entities.Customer;
import java.sql.SQLException;
import java.util.List;

public class CustomerController {

    private DAOManager manager;
    
    public CustomerController() throws SQLException {
        this.manager = new PostgreSQLDAOManager("localhost", "5432", "joyeria_inventario", "postgres", "ricardo1996");
    }
    
    public List<Customer> getAllCustomers() throws DAOException, InvalidInputException {
        return manager.getCustomerDAO().getAll();
    }
    
    public String getCustomerName(Long id) throws DAOException, InvalidInputException, CustomerNotFoundException {
        return manager.getCustomerDAO().getById(id).getName();
    }
    
}
