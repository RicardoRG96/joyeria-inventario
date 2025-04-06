package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.dao.CustomerDAO;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.InvoiceDAO;
import com.mycompany.joyeriaInventario.model.dao.JewelDAO;
import com.mycompany.joyeriaInventario.model.dao.MaterialDAO;
import com.mycompany.joyeriaInventario.model.dao.SaleDao;
import com.mycompany.joyeriaInventario.model.dao.SaleItemDAO;
import com.mycompany.joyeriaInventario.model.entities.Customer;
import com.mycompany.joyeriaInventario.model.entities.Jewel;
import com.mycompany.joyeriaInventario.model.entities.Sale;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class PostgreSQLDAOManager implements DAOManager {
    
    private Connection conn;
    
    private JewelDAO jewelry = null;
    
    private SaleDao sales = null;
    
    private CustomerDAO customers = null;
    
    private SaleItemDAO saleItems = null;
    
    private MaterialDAO materials = null;
    
    private InvoiceDAO invoices = null;
    
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
    
}
