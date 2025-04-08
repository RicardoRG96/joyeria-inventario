package com.mycompany.joyeriaInventario.model.dao;

public interface DAOManager {

    JewelDAO getJewelDAO();
    
    SaleDao getSaleDAO();
    
    CustomerDAO getCustomerDAO();
    
    SaleItemDAO getSaleItemDAO();
    
    MaterialDAO getMaterialDAO();
    
    InvoiceDAO getInvoiceDAO();
    
    TopCustomerViewDAO getTopCustomerViewDAO();
    
    TopJewelViewDAO getTopJewelViewDAO();
    
}
