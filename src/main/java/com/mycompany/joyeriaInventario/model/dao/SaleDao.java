package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.entities.Sale;
import java.util.List;

public interface SaleDao extends DAO<Sale, Long> {
    
    @Override
    Sale getById(Long id) throws DAOException;
    
    @Override
    List<Sale> getAll() throws DAOException;
    
    @Override
    void insert(Sale sale) throws DAOException;
    
    @Override
    void update(Long id, Sale sale) throws DAOException;
    
    @Override
    void delete(Long id) throws DAOException;
    
}
