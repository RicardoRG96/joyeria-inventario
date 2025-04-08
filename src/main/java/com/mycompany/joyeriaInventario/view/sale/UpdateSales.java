package com.mycompany.joyeriaInventario.view.sale;

import com.mycompany.joyeriaInventario.controller.CustomerController;
import com.mycompany.joyeriaInventario.controller.JewelController;
import com.mycompany.joyeriaInventario.controller.SaleController;
import com.mycompany.joyeriaInventario.controller.SaleItemController;
import com.mycompany.joyeriaInventario.model.entities.Sale;
import com.mycompany.joyeriaInventario.view.listener.UpdateableList;
import com.mycompany.joyeriaInventario.view.tableModel.SaleItemsTableModel;
import java.sql.SQLException;
import javax.swing.JFrame;

public class UpdateSales extends javax.swing.JFrame {
    
    private final SaleController saleController;
    
    private final CustomerController customerController;
    
    private final JewelController jewelController;
    
    private final SaleItemController saleItemController;
    
    private final SaleItemsTableModel saleItemsTableModel;
    
    private UpdateableList callback;

    public UpdateSales(JFrame parent, Sale sale, UpdateableList callback) throws SQLException {
        this.saleController = new SaleController();
        this.customerController = new CustomerController();
        this.jewelController = new JewelController();
        this.saleItemController = new SaleItemController();
        this.callback = callback;
        this.saleItemsTableModel = new SaleItemsTableModel();
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        saleIdTxt = new javax.swing.JLabel();
        editCustomerSaleCbx = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        editQuantitySaleTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        editJewelSaleCbx = new javax.swing.JComboBox<>();
        cancelSaleEditionBtn = new javax.swing.JButton();
        saveSaleEditionBtn1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        addProductEditedToOrderSaleBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        totalAmountEditedOrderTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordertItemsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(232, 249, 255));
        jPanel1.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.setPreferredSize(new java.awt.Dimension(787, 490));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(248, 250, 252));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 54, 63));
        jLabel2.setText("Editar Pedido de Venta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        saleIdTxt.setBackground(new java.awt.Color(248, 250, 252));
        saleIdTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        saleIdTxt.setForeground(new java.awt.Color(49, 54, 63));
        saleIdTxt.setText("_____");
        jPanel1.add(saleIdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 30));

        editCustomerSaleCbx.setBackground(new java.awt.Color(248, 250, 252));
        editCustomerSaleCbx.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editCustomerSaleCbx.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(editCustomerSaleCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 200, 20));

        jLabel7.setBackground(new java.awt.Color(248, 250, 252));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(49, 54, 63));
        jLabel7.setText("Cantidad:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        editQuantitySaleTxt.setBackground(new java.awt.Color(248, 250, 252));
        editQuantitySaleTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editQuantitySaleTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(editQuantitySaleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 90, 20));

        jLabel6.setBackground(new java.awt.Color(248, 250, 252));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 54, 63));
        jLabel6.setText("Joya:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        editJewelSaleCbx.setBackground(new java.awt.Color(248, 250, 252));
        editJewelSaleCbx.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJewelSaleCbx.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(editJewelSaleCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 200, 20));

        cancelSaleEditionBtn.setBackground(new java.awt.Color(251, 251, 251));
        cancelSaleEditionBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cancelSaleEditionBtn.setForeground(new java.awt.Color(49, 54, 63));
        cancelSaleEditionBtn.setText("Cancelar");
        cancelSaleEditionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelSaleEditionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSaleEditionBtnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelSaleEditionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 120, 30));

        saveSaleEditionBtn1.setBackground(new java.awt.Color(251, 251, 251));
        saveSaleEditionBtn1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        saveSaleEditionBtn1.setForeground(new java.awt.Color(49, 54, 63));
        saveSaleEditionBtn1.setText("Guardar");
        saveSaleEditionBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveSaleEditionBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSaleEditionBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(saveSaleEditionBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 120, 30));

        jLabel9.setBackground(new java.awt.Color(248, 250, 252));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(49, 54, 63));
        jLabel9.setText("Cliente:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        addProductEditedToOrderSaleBtn.setBackground(new java.awt.Color(251, 251, 251));
        addProductEditedToOrderSaleBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        addProductEditedToOrderSaleBtn.setForeground(new java.awt.Color(49, 54, 63));
        addProductEditedToOrderSaleBtn.setText("Agregar");
        addProductEditedToOrderSaleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProductEditedToOrderSaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductEditedToOrderSaleBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addProductEditedToOrderSaleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, 20));

        jLabel8.setBackground(new java.awt.Color(248, 250, 252));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(49, 54, 63));
        jLabel8.setText("Monto Total:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, -1));

        totalAmountEditedOrderTxt.setBackground(new java.awt.Color(248, 250, 252));
        totalAmountEditedOrderTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        totalAmountEditedOrderTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(totalAmountEditedOrderTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 70, 20));

        jScrollPane1.setBackground(new java.awt.Color(248, 250, 252));

        ordertItemsTable.setBackground(new java.awt.Color(248, 250, 252));
        ordertItemsTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ordertItemsTable.setForeground(new java.awt.Color(49, 54, 63));
        ordertItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Joya", "Cantidad", "Precio", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ordertItemsTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 710, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelSaleEditionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSaleEditionBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelSaleEditionBtnActionPerformed

    private void saveSaleEditionBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSaleEditionBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveSaleEditionBtn1ActionPerformed

    private void addProductEditedToOrderSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductEditedToOrderSaleBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProductEditedToOrderSaleBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductEditedToOrderSaleBtn;
    private javax.swing.JButton cancelSaleEditionBtn;
    private javax.swing.JComboBox<String> editCustomerSaleCbx;
    private javax.swing.JComboBox<String> editJewelSaleCbx;
    private javax.swing.JTextField editQuantitySaleTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ordertItemsTable;
    private javax.swing.JLabel saleIdTxt;
    private javax.swing.JButton saveSaleEditionBtn1;
    private javax.swing.JTextField totalAmountEditedOrderTxt;
    // End of variables declaration//GEN-END:variables
}
