package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.entities.Invoice;
import java.util.List;

public interface InvoiceDAO extends DAO<Invoice, Long> {

    @Override
    Invoice getById(Long id) throws DAOException;
    
    @Override
    List<Invoice> getAll() throws DAOException;
    
    @Override
    void insert(Invoice invoice) throws DAOException;
    
    @Override
    void update(Long id, Invoice invoice) throws DAOException;
    
    @Override
    void delete(Long id) throws DAOException;
    
}
