package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.model.dao.CustomerDAO;
import com.mycompany.joyeriaInventario.model.dao.DAOManager;
import com.mycompany.joyeriaInventario.model.dao.InvoiceDAO;
import com.mycompany.joyeriaInventario.model.dao.JewelDAO;
import com.mycompany.joyeriaInventario.model.dao.MaterialDAO;
import com.mycompany.joyeriaInventario.model.dao.SaleDao;
import com.mycompany.joyeriaInventario.model.dao.SaleItemDAO;
import com.mycompany.joyeriaInventario.model.entities.Jewel;
import com.mycompany.joyeriaInventario.model.entities.Material;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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
    
    public static void main(String[] args) throws SQLException, DAOException, InvalidInputException {
        DAOManager daoManager = 
                new PostgreSQLDAOManager("localhost", "5432", "joyeria_inventario", "postgres", "ricardo1996");
        List<String> items = daoManager.getJewelDAO().getAll()
                .stream()
                .map(jewel -> jewel.getName())
                .collect(Collectors.toList());
//        String materialName = daoManager.getMaterialDAO().getById(1L).getName();
//        System.out.println(materialName);
        System.out.println(items);
    }

    
}
