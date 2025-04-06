package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.entities.Customer;
import java.util.List;

public interface CustomerDAO extends DAO<Customer, Long> {

    @Override
    Customer getById(Long id) throws DAOException;
    
    @Override
    List<Customer> getAll() throws DAOException;
    
    @Override
    void insert(Customer customer) throws DAOException;
    
    @Override
    void update(Long id, Customer customer) throws DAOException;
    
    @Override
    void delete(Long id) throws DAOException;
    
}
