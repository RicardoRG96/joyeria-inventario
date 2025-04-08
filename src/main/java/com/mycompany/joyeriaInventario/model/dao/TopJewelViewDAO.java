package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.views.TopJewelView;
import java.util.List;

public interface TopJewelViewDAO {

    List<TopJewelView> getAll() throws DAOException;
    
}
