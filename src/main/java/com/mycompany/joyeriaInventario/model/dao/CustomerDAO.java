package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.customer.CustomerNotFoundException;
import com.mycompany.joyeriaInventario.model.entities.Customer;
import java.util.List;

public interface CustomerDAO extends DAO<Customer, Long> {

    @Override
    Customer getById(Long id) throws DAOException, InvalidInputException, CustomerNotFoundException;
    
    @Override
    List<Customer> getAll() throws DAOException, InvalidInputException;
    
    Customer getByName(String name) throws DAOException, CustomerNotFoundException, InvalidInputException;
    
    @Override
    void insert(Customer customer) throws DAOException;
    
    @Override
    void update(Long id, Customer customer) throws DAOException;
    
    @Override
    void delete(Long id) throws DAOException;
    
}
