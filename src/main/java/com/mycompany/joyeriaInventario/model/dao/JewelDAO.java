package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.jewel.JewelNotFoundException;
import com.mycompany.joyeriaInventario.model.entities.Jewel;
import java.util.List;

public interface JewelDAO extends DAO<Jewel, Long> {

    @Override
    Jewel getById(Long id) throws DAOException, JewelNotFoundException, InvalidInputException;
    
    @Override
    List<Jewel> getAll() throws DAOException, InvalidInputException;
    
    Jewel getByName(String name) throws DAOException, JewelNotFoundException, InvalidInputException;
    
    @Override
    void insert(Jewel jewel) throws DAOException;
    
    @Override
    void update(Long id, Jewel jewel) throws DAOException;
    
    @Override
    void delete(Long id) throws DAOException;
    
}
