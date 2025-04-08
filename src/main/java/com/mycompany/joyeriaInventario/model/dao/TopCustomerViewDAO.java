package com.mycompany.joyeriaInventario.model.dao;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.views.TopCustomerView;
import java.time.LocalDate;
import java.util.List;

public interface TopCustomerViewDAO {
    
    List<TopCustomerView> getAll() throws DAOException;
    
    List<TopCustomerView> 
        findByFilters(String customerName, LocalDate fromDate, LocalDate toDate) throws DAOException;
    
}
