package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.entities.Material;
import java.util.List;

public interface MaterialDAO extends DAO<Material, Long> {
    
    @Override
    Material getById(Long id) throws DAOException;
    
    @Override
    List<Material> getAll() throws DAOException;
    
    @Override
    void insert(Material material) throws DAOException;
    
    @Override
    void update(Long id, Material material) throws DAOException;
    
    @Override
    void delete(Long id) throws DAOException;
    
}
