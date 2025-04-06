package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.entities.Jewel;
import java.util.List;

public interface JewelDAO extends DAO<Jewel, Long> {

    @Override
    Jewel getById(Long id) throws DAOException;
    
    @Override
    List<Jewel> getAll() throws DAOException;
    
    @Override
    void insert(Jewel jewel) throws DAOException;
    
    @Override
    void update(Long id, Jewel jewel) throws DAOException;
    
    @Override
    void delete(Long id) throws DAOException;
    
}
