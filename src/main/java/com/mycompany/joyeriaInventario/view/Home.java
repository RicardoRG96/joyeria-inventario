package com.mycompany.joyeriaInventario.view;

import com.mycompany.joyeriaInventario.controller.CustomerController;
import com.mycompany.joyeriaInventario.controller.JewelController;
import com.mycompany.joyeriaInventario.controller.MaterialController;
import com.mycompany.joyeriaInventario.controller.SaleController;
import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.model.entities.Customer;
import com.mycompany.joyeriaInventario.model.entities.Jewel;
import com.mycompany.joyeriaInventario.model.entities.Material;
import com.mycompany.joyeriaInventario.model.entities.Sale;
import com.mycompany.joyeriaInventario.view.jewel.CreateJewelView;
import com.mycompany.joyeriaInventario.view.jewel.UpdateJewelView;
import com.mycompany.joyeriaInventario.view.listener.UpdateableList;
import com.mycompany.joyeriaInventario.view.sale.CreateSales;
import com.mycompany.joyeriaInventario.view.tableModel.JewelryTableModel;
import com.mycompany.joyeriaInventario.view.tableModel.SalesTableModel;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame implements UpdateableList {
    
    private final JewelController jewelController;
    
    private final SaleController saleController;
    
    private final MaterialController materialController;
    
    private final CustomerController customerController;
    
    private final JewelryTableModel jewelryTableModel;
    
    private final SalesTableModel salesTableModel;

    public Home() throws SQLException {
        initComponents();
        this.jewelController = new JewelController();
        this.saleController = new SaleController();
        this.materialController = new MaterialController();
        this.customerController = new CustomerController();
        this.jewelryTableModel = new JewelryTableModel();
        this.salesTableModel = new SalesTableModel();
        
        inventoryTable.setModel(jewelryTableModel);
        salesTable.setModel(salesTableModel);
        loadJewelsInTable();
        loadSalesInTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        inventoryTab = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        inventoryTab1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        inventoryTab2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        addJewelBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        updateStockBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        deleteJewelBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        editJewelBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        addNewSaleBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        invoiceBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        updateSaleBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        updateSalesTableBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        deleteSaleBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        totalSalesBtn = new javax.swing.JButton();
        bestSellingJewelryBtn = new javax.swing.JButton();
        topCustomersBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(217, 234, 253));

        inventoryTab.setBackground(new java.awt.Color(217, 234, 253));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(49, 54, 63));
        jLabel15.setText("Inventario");

        javax.swing.GroupLayout inventoryTabLayout = new javax.swing.GroupLayout(inventoryTab);
        inventoryTab.setLayout(inventoryTabLayout);
        inventoryTabLayout.setHorizontalGroup(
            inventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryTabLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inventoryTabLayout.setVerticalGroup(
            inventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryTabLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(217, 234, 253));

        jLabel4.setBackground(new java.awt.Color(217, 234, 253));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(49, 54, 63));
        jLabel4.setText("Bienvenido");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        inventoryTab1.setBackground(new java.awt.Color(217, 234, 253));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(49, 54, 63));
        jLabel16.setText("Ventas");

        javax.swing.GroupLayout inventoryTab1Layout = new javax.swing.GroupLayout(inventoryTab1);
        inventoryTab1.setLayout(inventoryTab1Layout);
        inventoryTab1Layout.setHorizontalGroup(
            inventoryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryTab1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inventoryTab1Layout.setVerticalGroup(
            inventoryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryTab1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        inventoryTab2.setBackground(new java.awt.Color(217, 234, 253));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(49, 54, 63));
        jLabel17.setText("Reportes");

        javax.swing.GroupLayout inventoryTab2Layout = new javax.swing.GroupLayout(inventoryTab2);
        inventoryTab2.setLayout(inventoryTab2Layout);
        inventoryTab2Layout.setHorizontalGroup(
            inventoryTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryTab2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inventoryTab2Layout.setVerticalGroup(
            inventoryTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryTab2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inventoryTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inventoryTab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(inventoryTab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(inventoryTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inventoryTab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inventoryTab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 189, 490));

        jTabbedPane1.setBackground(new java.awt.Color(248, 250, 252));
        jTabbedPane1.setForeground(new java.awt.Color(34, 40, 49));

        jPanel3.setBackground(new java.awt.Color(248, 250, 252));

        jPanel7.setBackground(new java.awt.Color(248, 250, 252));

        addJewelBtn.setBackground(new java.awt.Color(255, 255, 255));
        addJewelBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        addJewelBtn.setForeground(new java.awt.Color(34, 40, 49));
        addJewelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        addJewelBtn.setBorder(null);
        addJewelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addJewelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJewelBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(34, 40, 49));
        jLabel5.setText("Agregar Joya");

        updateStockBtn.setBackground(new java.awt.Color(255, 255, 255));
        updateStockBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        updateStockBtn.setForeground(new java.awt.Color(34, 40, 49));
        updateStockBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        updateStockBtn.setBorder(null);
        updateStockBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateStockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStockBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(34, 40, 49));
        jLabel6.setText("Actualizar Stock");

        deleteJewelBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteJewelBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        deleteJewelBtn.setForeground(new java.awt.Color(34, 40, 49));
        deleteJewelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        deleteJewelBtn.setBorder(null);
        deleteJewelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteJewelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJewelBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(34, 40, 49));
        jLabel7.setText("Eliminar");

        editJewelBtn.setBackground(new java.awt.Color(255, 255, 255));
        editJewelBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        editJewelBtn.setForeground(new java.awt.Color(34, 40, 49));
        editJewelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        editJewelBtn.setBorder(null);
        editJewelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editJewelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJewelBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(34, 40, 49));
        jLabel8.setText("Editar Joya");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(addJewelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(editJewelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteJewelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteJewelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addJewelBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editJewelBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)))
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        inventoryTable.setBackground(new java.awt.Color(248, 250, 252));
        inventoryTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Material", "Peso", "Precio", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(inventoryTable);
        if (inventoryTable.getColumnModel().getColumnCount() > 0) {
            inventoryTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            inventoryTable.getColumnModel().getColumn(1).setPreferredWidth(40);
            inventoryTable.getColumnModel().getColumn(2).setPreferredWidth(35);
            inventoryTable.getColumnModel().getColumn(3).setPreferredWidth(25);
            inventoryTable.getColumnModel().getColumn(4).setPreferredWidth(25);
            inventoryTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inventario", jPanel3);

        jPanel4.setBackground(new java.awt.Color(248, 250, 252));

        jLabel9.setBackground(new java.awt.Color(248, 250, 252));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(49, 54, 63));
        jLabel9.setText("Ventas");

        jPanel8.setBackground(new java.awt.Color(248, 250, 252));

        addNewSaleBtn.setBackground(new java.awt.Color(248, 250, 252));
        addNewSaleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-sale.png"))); // NOI18N
        addNewSaleBtn.setBorder(null);
        addNewSaleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNewSaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewSaleBtnActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(248, 250, 252));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(49, 54, 63));
        jLabel10.setText("Nueva venta");

        invoiceBtn.setBackground(new java.awt.Color(248, 250, 252));
        invoiceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/invoice.png"))); // NOI18N
        invoiceBtn.setText("ALTER TABLE sale_items ADD CONSTRAINT sale_items_sale_id_fkey FOREIGN KEY (sale_id) REFERENCES sales(id) ON DELETE CASCADE;");
        invoiceBtn.setBorder(null);
        invoiceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setBackground(new java.awt.Color(248, 250, 252));
        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(49, 54, 63));
        jLabel12.setText("Actualizar");

        updateSaleBtn.setBackground(new java.awt.Color(248, 250, 252));
        updateSaleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        updateSaleBtn.setBorder(null);
        updateSaleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel13.setBackground(new java.awt.Color(248, 250, 252));
        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(49, 54, 63));
        jLabel13.setText("Editar");

        updateSalesTableBtn.setBackground(new java.awt.Color(248, 250, 252));
        updateSalesTableBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        updateSalesTableBtn.setBorder(null);
        updateSalesTableBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel14.setBackground(new java.awt.Color(248, 250, 252));
        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(49, 54, 63));
        jLabel14.setText("Factura");

        deleteSaleBtn.setBackground(new java.awt.Color(248, 250, 252));
        deleteSaleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        deleteSaleBtn.setBorder(null);
        deleteSaleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteSaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSaleBtnActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(248, 250, 252));
        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(49, 54, 63));
        jLabel18.setText("Eliminar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(addNewSaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(updateSaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(updateSalesTableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(invoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteSaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteSaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(addNewSaleBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateSaleBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateSalesTableBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane2.setBackground(new java.awt.Color(248, 250, 252));

        salesTable.setBackground(new java.awt.Color(248, 250, 252));
        salesTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(salesTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas", jPanel4);

        jPanel5.setBackground(new java.awt.Color(248, 250, 252));
        jPanel5.setForeground(new java.awt.Color(49, 54, 63));

        totalSalesBtn.setBackground(new java.awt.Color(255, 255, 255));
        totalSalesBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        totalSalesBtn.setForeground(new java.awt.Color(92, 179, 56));
        totalSalesBtn.setText("Total de ventas");
        totalSalesBtn.setBorder(null);
        totalSalesBtn.setContentAreaFilled(false);
        totalSalesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        totalSalesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalSalesBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        bestSellingJewelryBtn.setBackground(new java.awt.Color(255, 255, 255));
        bestSellingJewelryBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        bestSellingJewelryBtn.setForeground(new java.awt.Color(92, 179, 56));
        bestSellingJewelryBtn.setText("Joyas más vendidas");
        bestSellingJewelryBtn.setBorder(null);
        bestSellingJewelryBtn.setContentAreaFilled(false);
        bestSellingJewelryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bestSellingJewelryBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bestSellingJewelryBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        topCustomersBtn.setBackground(new java.awt.Color(255, 255, 255));
        topCustomersBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        topCustomersBtn.setForeground(new java.awt.Color(92, 179, 56));
        topCustomersBtn.setText("Clientes con más compras");
        topCustomersBtn.setBorder(null);
        topCustomersBtn.setContentAreaFilled(false);
        topCustomersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        topCustomersBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        topCustomersBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel11.setBackground(new java.awt.Color(248, 250, 252));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(49, 54, 63));
        jLabel11.setText("Reportes");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bestSellingJewelryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalSalesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(topCustomersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(396, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(40, 40, 40)
                .addComponent(totalSalesBtn)
                .addGap(18, 18, 18)
                .addComponent(bestSellingJewelryBtn)
                .addGap(18, 18, 18)
                .addComponent(topCustomersBtn)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reportes", jPanel5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 0, 600, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void updateList() {
        loadJewelsInTable();
        loadSalesInTable();
    }
    
    private void loadJewelsInTable() {
        try {
            List<Jewel> jewels = jewelController.getAllJewels();
            List<Material> materials = materialController.getAllMaterials();
            jewelryTableModel.setJewels(jewels);
            jewelryTableModel.setMaterials(materials);
        } catch (DAOException | InvalidInputException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadSalesInTable() {
        try {
            List<Sale> sales = saleController.getAllSales();
            List<Customer> customers = customerController.getAllCustomers();
            salesTableModel.setSales(sales);
            salesTableModel.setCustomers(customers);
        } catch (DAOException | InvalidInputException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void addJewelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJewelBtnActionPerformed
        try {
            openCreateJewelForm();
        } catch (DAOException | InvalidInputException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addJewelBtnActionPerformed

    private void openCreateJewelForm() throws SQLException, DAOException, InvalidInputException {
        CreateJewelView createJewelView = new CreateJewelView(this, this);
        createJewelView.setVisible(true);
        createJewelView.setLocationRelativeTo(null);
    }
    
    private void editJewelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJewelBtnActionPerformed
        try {
            openUpdateJewelForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editJewelBtnActionPerformed

    private void openUpdateJewelForm() throws SQLException {
        int row = inventoryTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto.");
            return;
        }
        Jewel selectedJewel = jewelryTableModel.getJewelInRow(row);
        UpdateJewelView updateJewelView = new UpdateJewelView(this, selectedJewel, this);
        updateJewelView.setVisible(true);
        updateJewelView.setLocationRelativeTo(null);
    }
    
    private void deleteJewelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJewelBtnActionPerformed
        int row = inventoryTable.getSelectedRow();
        try {
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un producto.");
                return;
            }
            int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?");
            if (question == 0) {
                Long selectedJewelId = jewelryTableModel.getJewelInRow(row).getId();
                jewelController.deleteJewel(selectedJewelId);
                updateList();
            }
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteJewelBtnActionPerformed

    private void updateStockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStockBtnActionPerformed
        updateList();
        
    }//GEN-LAST:event_updateStockBtnActionPerformed

    private void deleteSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSaleBtnActionPerformed
        int row = salesTable.getSelectedRow();
        try {
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una venta.");
                return;
            }
            int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?");
            if (question == 0) {
                Long selectedSaleId = salesTableModel.getSaleInRow(row).getId();
                saleController.deleteSale(selectedSaleId);
                updateList();
            }
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteSaleBtnActionPerformed

    private void addNewSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewSaleBtnActionPerformed
        try {
            openCreateSaleForm();
        } catch (DAOException | InvalidInputException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addNewSaleBtnActionPerformed

    private void openCreateSaleForm() throws SQLException, DAOException, InvalidInputException {
        CreateSales createSalesView = new CreateSales(this, this);
        createSalesView.setVisible(true);
        createSalesView.setLocationRelativeTo(null);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJewelBtn;
    private javax.swing.JButton addNewSaleBtn;
    private javax.swing.JButton bestSellingJewelryBtn;
    private javax.swing.JButton deleteJewelBtn;
    private javax.swing.JButton deleteSaleBtn;
    private javax.swing.JButton editJewelBtn;
    private javax.swing.JPanel inventoryTab;
    private javax.swing.JPanel inventoryTab1;
    private javax.swing.JPanel inventoryTab2;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JButton invoiceBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable salesTable;
    private javax.swing.JButton topCustomersBtn;
    private javax.swing.JButton totalSalesBtn;
    private javax.swing.JButton updateSaleBtn;
    private javax.swing.JButton updateSalesTableBtn;
    private javax.swing.JButton updateStockBtn;
    // End of variables declaration//GEN-END:variables

}
