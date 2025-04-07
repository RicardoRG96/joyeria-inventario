package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.sale.SaleNotFoundException;
import com.mycompany.joyeriaInventario.model.entities.Invoice;
import java.util.List;

public interface InvoiceDAO extends DAO<Invoice, Long> {

    @Override
    Invoice getById(Long id) throws DAOException, InvalidInputException;
    
    @Override
    List<Invoice> getAll() throws DAOException, InvalidInputException;
    
    List<Invoice> getBySaleId(Long saleId) throws DAOException, SaleNotFoundException, InvalidInputException;
    
    @Override
    void insert(Invoice invoice) throws DAOException;
    
    @Override
    void update(Long id, Invoice invoice) throws DAOException;
    
    @Override
    void delete(Long id) throws DAOException;
    
}
