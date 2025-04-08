package com.mycompany.joyeriaInventario.view.reports;

import com.mycompany.joyeriaInventario.controller.TopCustomerViewController;
import com.mycompany.joyeriaInventario.model.views.TopCustomerView;
import com.mycompany.joyeriaInventario.view.tableModel.TopCustomersTableModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JOptionPane;

public class TopCustomersReport extends javax.swing.JFrame {

    private final TopCustomerViewController topCustomerViewController;
    
    private final TopCustomersTableModel topCustomersTableModel;
    
    public TopCustomersReport() throws SQLException {
        this.topCustomerViewController = new TopCustomerViewController();
        this.topCustomersTableModel = new TopCustomersTableModel();
        
        initComponents();
        topCustomersTable.setModel(topCustomersTableModel);
        loadDataInTable();
    }
    
    private void loadDataInTable() {
        List<TopCustomerView> topCustomersView = topCustomerViewController.getAll();
        topCustomersTableModel.setData(topCustomersView);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        filterCustomerNameTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fromJDateChooser = new com.toedter.calendar.JDateChooser();
        toJDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        exportToExcelTopCustomersBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        topCustomersTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 250, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(217, 234, 253));

        jLabel2.setBackground(new java.awt.Color(217, 234, 253));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 54, 63));
        jLabel2.setText("Clientes con más compras");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(500, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 40));

        jPanel3.setBackground(new java.awt.Color(248, 250, 252));

        jLabel8.setBackground(new java.awt.Color(248, 250, 252));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(49, 54, 63));
        jLabel8.setText("Cliente:");

        filterCustomerNameTxt.setBackground(new java.awt.Color(248, 250, 252));
        filterCustomerNameTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        filterCustomerNameTxt.setForeground(new java.awt.Color(49, 54, 63));

        jLabel9.setBackground(new java.awt.Color(248, 250, 252));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(49, 54, 63));
        jLabel9.setText("Hasta:");

        fromJDateChooser.setBackground(new java.awt.Color(248, 250, 252));
        fromJDateChooser.setForeground(new java.awt.Color(49, 54, 63));

        toJDateChooser.setBackground(new java.awt.Color(248, 250, 252));
        toJDateChooser.setForeground(new java.awt.Color(49, 54, 63));

        jLabel10.setBackground(new java.awt.Color(248, 250, 252));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(49, 54, 63));
        jLabel10.setText("Desde:");

        exportToExcelTopCustomersBtn.setBackground(new java.awt.Color(248, 250, 252));
        exportToExcelTopCustomersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        exportToExcelTopCustomersBtn.setText("jButton1");
        exportToExcelTopCustomersBtn.setBorder(null);
        exportToExcelTopCustomersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setBackground(new java.awt.Color(248, 250, 252));
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(49, 54, 63));
        jLabel1.setText("Exportar a Excel");

        searchBtn.setBackground(new java.awt.Color(248, 250, 252));
        searchBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(49, 54, 63));
        searchBtn.setText("Buscar");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(exportToExcelTopCustomersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterCustomerNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(searchBtn))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchBtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(exportToExcelTopCustomersBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(filterCustomerNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(fromJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(toJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 750, 60));

        jScrollPane1.setForeground(new java.awt.Color(248, 250, 252));

        topCustomersTable.setBackground(new java.awt.Color(248, 250, 252));
        topCustomersTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        topCustomersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Compras totales", "Total Gastado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(topCustomersTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 750, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        validateBothDateFiltersApplied();
        applyFilters();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void applyFilters() {
        if (isNameFilterApplied() && isDateFilterApplied()) {
            String customerName = filterCustomerNameTxt.getText();
            LocalDate from = fromJDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate to = toJDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            List<TopCustomerView> topCustomersView = topCustomerViewController.onFilter(customerName, from, to);
            topCustomersTableModel.setData(topCustomersView);
            return;
        }
        if (isNameFilterApplied() && !isDateFilterApplied()) {
            String customerName = filterCustomerNameTxt.getText();
            List<TopCustomerView> topCustomersView = topCustomerViewController.onFilter(customerName, null, null);
            topCustomersTableModel.setData(topCustomersView);
            return;
        }
        if (!isNameFilterApplied() && isDateFilterApplied()) {
            LocalDate from = fromJDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate to = toJDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            List<TopCustomerView> topCustomersView = topCustomerViewController.onFilter(null, from, to);
            topCustomersTableModel.setData(topCustomersView);
            return;
        }
        if (!isNameFilterApplied() && !isDateFilterApplied()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un filtro");
            return;
        }
    }
    
    private boolean isNameFilterApplied() {
        if (filterCustomerNameTxt.getText().isBlank()) {
            return false;
        }
        return true;
    }
    
    private boolean isDateFilterApplied() {
        if (
            fromJDateChooser.getDate() == null ||
            toJDateChooser.getDate() == null
        ) {
            return false;
        }
        return true;
    }
    
    private void validateBothDateFiltersApplied() {
        if (
            fromJDateChooser.getDate() != null &&
            toJDateChooser.getDate() == null
        ) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar ambos filtros de fechas");
            return;
        }
        if (
            fromJDateChooser.getDate() == null &&
            toJDateChooser.getDate() != null
        ) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar ambos filtros de fechas");
            return;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportToExcelTopCustomersBtn;
    private javax.swing.JTextField filterCustomerNameTxt;
    private com.toedter.calendar.JDateChooser fromJDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchBtn;
    private com.toedter.calendar.JDateChooser toJDateChooser;
    private javax.swing.JTable topCustomersTable;
    // End of variables declaration//GEN-END:variables
}
