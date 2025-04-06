package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import java.util.List;

public interface DAO<T, K> {

    T getById(K id) throws DAOException;
    
    List<T> getAll() throws DAOException;
    
    void insert(T item) throws DAOException;
    
    void update(K id, T item) throws DAOException;
    
    void delete(K id) throws DAOException;
    
}
