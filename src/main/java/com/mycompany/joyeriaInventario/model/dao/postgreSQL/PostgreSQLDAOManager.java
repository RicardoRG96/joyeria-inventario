package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.model.dao.CustomerDAO;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.InvoiceDAO;
import com.mycompany.joyeriaInventario.model.dao.JewelDAO;
import com.mycompany.joyeriaInventario.model.dao.MaterialDAO;
import com.mycompany.joyeriaInventario.model.dao.SaleDao;
import com.mycompany.joyeriaInventario.model.dao.SaleItemDAO;
import com.mycompany.joyeriaInventario.model.dao.TopCustomerViewDAO;
import com.mycompany.joyeriaInventario.model.dao.TopJewelViewDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLDAOManager implements DAOManager {
    
    private Connection conn;
    
    private JewelDAO jewelry = null;
    
    private SaleDao sales = null;
    
    private CustomerDAO customers = null;
    
    private SaleItemDAO saleItems = null;
    
    private MaterialDAO materials = null;
    
    private InvoiceDAO invoices = null;
    
    private TopCustomerViewDAO topCustomersView = null;
    
    private TopJewelViewDAO topJewelsView = null;
    
    public PostgreSQLDAOManager(String host, String port, String database, String username, String password) 
            throws SQLException {
        conn = DriverManager
                    .getConnection("jdbc:postgresql://" + host + ":" + port + "/" + database, username, password );
    }

    @Override
    public JewelDAO getJewelDAO() {
       if (jewelry == null) {
           jewelry = new PostgreSQLJewelDAO(conn);
       }
       return jewelry;
    }

    @Override
    public SaleDao getSaleDAO() {
       if (sales == null) {
           sales = new PostgreSQLSaleDAO(conn);
       }
       return sales;
    }

    @Override
    public CustomerDAO getCustomerDAO() {
       if (customers == null) {
           customers = new PostgreSQLCustomerDAO(conn);
       }
       return customers;
    }

    @Override
    public SaleItemDAO getSaleItemDAO() {
       if (saleItems == null) {
           saleItems = new PostgreSQLSaleItemDAO(conn);
       }
       return saleItems;
    }

    @Override
    public MaterialDAO getMaterialDAO() {
       if (materials == null) {
           materials = new PostgreSQLMaterialDAO(conn);
       }
       return materials;
    }

    @Override
    public InvoiceDAO getInvoiceDAO() {
       if (invoices == null) {
           invoices = new PostgreSQLInvoiceDAO(conn);
       }
       return invoices;
    }
    
    @Override
    public TopCustomerViewDAO getTopCustomerViewDAO() {
        if (topCustomersView == null) {
            topCustomersView = new PostgreSQLTopCustomerViewDAO(conn);
        }
        return topCustomersView;
    }

    @Override
    public TopJewelViewDAO getTopJewelViewDAO() {
       if (topJewelsView == null) {
            topJewelsView = new PostgreSQLTopJewelViewDAO(conn);
        }
        return topJewelsView; 
    }
    
}
