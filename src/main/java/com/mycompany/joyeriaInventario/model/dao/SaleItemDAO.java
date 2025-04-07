package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.saleItem.SaleItemNotFoundException;
import com.mycompany.joyeriaInventario.model.entities.SaleItem;
import java.util.List;

public interface SaleItemDAO extends DAO<SaleItem, Long> {

    @Override
    SaleItem getById(Long id) throws DAOException, InvalidInputException, SaleItemNotFoundException;
    
    @Override
    List<SaleItem> getAll() throws DAOException, InvalidInputException;
    
    List<SaleItem> getBySaleId(Long saleId) throws DAOException, SaleItemNotFoundException, InvalidInputException;
    
    List<SaleItem> getByJewelId(Long jewelId) throws DAOException, SaleItemNotFoundException, InvalidInputException;
    
    @Override
    void insert(SaleItem saleItem) throws DAOException;
    
    @Override
    void update(Long id, SaleItem saleItem) throws DAOException;
    
    @Override
    void delete(Long id) throws DAOException;
    
}