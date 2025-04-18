package com.mycompany.joyeriaInventario.view.sale;

import com.mycompany.joyeriaInventario.controller.CustomerController;
import com.mycompany.joyeriaInventario.controller.JewelController;
import com.mycompany.joyeriaInventario.controller.SaleController;
import com.mycompany.joyeriaInventario.controller.SaleItemController;
import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.exception.customer.CustomerNotFoundException;
import com.mycompany.joyeriaInventario.exception.jewel.InsufficientStockException;
import com.mycompany.joyeriaInventario.model.dto.SaleDTO;
import com.mycompany.joyeriaInventario.model.dto.SaleItemDTO;
import com.mycompany.joyeriaInventario.model.entities.Customer;
import com.mycompany.joyeriaInventario.model.entities.Jewel;
import com.mycompany.joyeriaInventario.model.entities.Sale;
import com.mycompany.joyeriaInventario.model.entities.SaleItem;
import com.mycompany.joyeriaInventario.view.listener.UpdateableList;
import com.mycompany.joyeriaInventario.view.tableModel.SaleItemTableEntity;
import com.mycompany.joyeriaInventario.view.tableModel.SaleItemsTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateSales extends javax.swing.JFrame {

    private final SaleController saleController;
    
    private final CustomerController customerController;
    
    private final JewelController jewelController;
    
    private final SaleItemController saleItemController;
    
    private final Sale sale;
    
    private final SaleItemsTableModel saleItemsTableModel;
  
    private final UpdateableList callback;
    
    public CreateSales(JFrame parent, Sale sale, UpdateableList callback) 
            throws SQLException {
        this.saleController = new SaleController();
        this.customerController = new CustomerController();
        this.jewelController = new JewelController();
        this.saleItemController = new SaleItemController();
        this.sale = sale;
        this.callback = callback;
        this.saleItemsTableModel = new SaleItemsTableModel();
        
        initComponents();
        saleItemsTable.setModel(saleItemsTableModel);
        loadCustomersInComboBox();
        loadJewelryInComboBox();
        loadSaleItemsToEditInTable();
        loadSaleItemDataInComboBoxAndTextField();
        totalAmountTxt.setText(String.valueOf(calculateSaleTotalAmount()));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void loadCustomersInComboBox() {
        try {
            List<Customer> customers = customerController.getAllCustomers();
            List<String> customerNames = customers.stream()
                            .map(c -> c.getName())
                            .collect(Collectors.toList());
            
            customerNames.stream()
                    .forEach(customer -> customerSaleCbx.addItem(customer));
        } catch (DAOException | InvalidInputException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadJewelryInComboBox() {
        try {
            List<Jewel> jewels = jewelController.getAllJewels();
            List<String> jewelsNames = jewels.stream()
                            .map(j -> j.getName())
                            .collect(Collectors.toList());
            
            jewelsNames.stream()
                    .forEach(jewel -> jewelSaleCbx.addItem(jewel));
        } catch (DAOException | InvalidInputException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadSaleItemsToEditInTable() {
        if (sale == null) {
            return;
        }
        try {
            Long saleSelectedOnHomeView = sale.getId();
            List<SaleItem> saleItemsOfSaleSelectedOnHomeView = 
                    saleItemController.getSaleItemBySaleId(saleSelectedOnHomeView);
            
            List<SaleItemTableEntity> saleItemsTableEntity = 
                    convertToSaleItemTableEntity(saleItemsOfSaleSelectedOnHomeView);
            saleItemsTableEntity.stream()
                    .forEach(item -> saleItemsTableModel.addItems(item));
            
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private void loadSaleItemDataInComboBoxAndTextField() {
        try {
            if (sale != null) {
                int row = 0;
                SaleItemTableEntity selectedSaleItem = saleItemsTableModel.getSaleItemInRow(row);
                String customerName = customerController.getCustomerName(sale.getCustomerId());
                String jewelName = selectedSaleItem.getJewelName();
                String quantity = selectedSaleItem.getQuantity();
                customerSaleCbx.setSelectedItem(customerName);
                jewelSaleCbx.setSelectedItem(jewelName);
                quantitySaleTxt.setText(quantity);
                saleItemsTable.setRowSelectionInterval(0, 0);
                saleItemsTable.requestFocus();
            }
        } catch (DAOException | InvalidInputException | CustomerNotFoundException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private List<SaleItemTableEntity> convertToSaleItemTableEntity(List<SaleItem> saleItems) throws DAOException {
        List<SaleItemTableEntity> saleItemsTableEntity = new ArrayList<>();
        for (SaleItem saleItem : saleItems) {
            SaleItemTableEntity saleItemTableEntity = new SaleItemTableEntity();
            String jewelName = jewelController.getJewelById(saleItem.getJewelId()).getName();
            saleItemTableEntity.setJewelName(jewelName);
            saleItemTableEntity.setQuantity(String.valueOf(saleItem.getQuantity()));
            saleItemTableEntity.setPrice(String.valueOf(saleItem.getPrice()));
            saleItemTableEntity.setSubtotal(String.valueOf(saleItem.getSubTotal()));
            saleItemsTableEntity.add(saleItemTableEntity);
        }
        return saleItemsTableEntity;
    }
    
    private Double calculateSaleTotalAmount() {
        if (saleItemsTable.getRowCount() <= 0) {
            return 0d;
        }
        List<SaleItemTableEntity> saleItemsFromTable = saleItemsTableModel.getSaleItems();
        return saleItemsFromTable.stream()
                    .mapToDouble(item -> Double.parseDouble(item.getSubtotal()))
                    .sum();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jewelSaleCbx = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        customerSaleCbx = new javax.swing.JComboBox<>();
        totalAmountTxt = new javax.swing.JTextField();
        cancelSaleBtn = new javax.swing.JButton();
        addProductToOrderSaleBtn = new javax.swing.JButton();
        createSaleBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        saleItemsTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        quantitySaleTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        deleteSaleItem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(232, 249, 255));

        jPanel1.setBackground(new java.awt.Color(232, 249, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 273));
        jPanel1.setPreferredSize(new java.awt.Dimension(787, 490));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(248, 250, 252));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 54, 63));
        jLabel2.setText("Nuevo Pedido de Venta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setBackground(new java.awt.Color(248, 250, 252));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 54, 63));
        jLabel6.setText("Joya");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        jewelSaleCbx.setBackground(new java.awt.Color(248, 250, 252));
        jewelSaleCbx.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jewelSaleCbx.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(jewelSaleCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 200, 20));

        jLabel7.setBackground(new java.awt.Color(248, 250, 252));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(49, 54, 63));
        jLabel7.setText("Cantidad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        jLabel8.setBackground(new java.awt.Color(248, 250, 252));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(49, 54, 63));
        jLabel8.setText("Monto Total:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, -1, -1));

        customerSaleCbx.setBackground(new java.awt.Color(248, 250, 252));
        customerSaleCbx.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        customerSaleCbx.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(customerSaleCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 200, 20));

        totalAmountTxt.setBackground(new java.awt.Color(248, 250, 252));
        totalAmountTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        totalAmountTxt.setForeground(new java.awt.Color(49, 54, 63));
        totalAmountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountTxtActionPerformed(evt);
            }
        });
        jPanel1.add(totalAmountTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 110, 20));

        cancelSaleBtn.setBackground(new java.awt.Color(251, 251, 251));
        cancelSaleBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cancelSaleBtn.setForeground(new java.awt.Color(49, 54, 63));
        cancelSaleBtn.setText("Cancelar");
        cancelSaleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelSaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSaleBtnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelSaleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 120, 30));

        addProductToOrderSaleBtn.setBackground(new java.awt.Color(251, 251, 251));
        addProductToOrderSaleBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        addProductToOrderSaleBtn.setForeground(new java.awt.Color(49, 54, 63));
        addProductToOrderSaleBtn.setText("Agregar");
        addProductToOrderSaleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProductToOrderSaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductToOrderSaleBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addProductToOrderSaleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, 20));

        createSaleBtn.setBackground(new java.awt.Color(251, 251, 251));
        createSaleBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        createSaleBtn.setForeground(new java.awt.Color(49, 54, 63));
        createSaleBtn.setText("Crear pedido");
        createSaleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createSaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSaleBtnActionPerformed(evt);
            }
        });
        jPanel1.add(createSaleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 120, 30));

        jScrollPane1.setBackground(new java.awt.Color(248, 250, 252));

        saleItemsTable.setBackground(new java.awt.Color(248, 250, 252));
        saleItemsTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        saleItemsTable.setForeground(new java.awt.Color(49, 54, 63));
        saleItemsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        saleItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleItemsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(saleItemsTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 710, 300));

        jLabel9.setBackground(new java.awt.Color(248, 250, 252));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(49, 54, 63));
        jLabel9.setText("Cliente");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        quantitySaleTxt.setBackground(new java.awt.Color(248, 250, 252));
        quantitySaleTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        quantitySaleTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(quantitySaleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 90, 20));

        jPanel2.setBackground(new java.awt.Color(232, 249, 255));
        jPanel2.setForeground(new java.awt.Color(49, 54, 63));

        deleteSaleItem.setBackground(new java.awt.Color(248, 250, 252));
        deleteSaleItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        deleteSaleItem.setBorder(null);
        deleteSaleItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteSaleItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSaleItemActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(248, 250, 252));
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(49, 54, 63));
        jLabel1.setText("Eliminar Linea");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(deleteSaleItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(deleteSaleItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 120, 30));

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

    private void cancelSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSaleBtnActionPerformed
        int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cancelar?");
        if (question == 0) {
            dispose();
        }
    }//GEN-LAST:event_cancelSaleBtnActionPerformed

    private void addProductToOrderSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductToOrderSaleBtnActionPerformed
        addToSaleItemsTable();
        totalAmountTxt.setText(String.valueOf(calculateSaleTotalAmount()));
    }//GEN-LAST:event_addProductToOrderSaleBtnActionPerformed

    private void addToSaleItemsTable() {
        try {
            SaleItemTableEntity saleItem = new SaleItemTableEntity();
            
            String customerName = customerSaleCbx.getSelectedItem().toString();
            String jewelName = jewelSaleCbx.getSelectedItem().toString();
            String jewelQuantity = quantitySaleTxt.getText();
            if (customerName.isBlank()) {
                JOptionPane.showMessageDialog(this, "El nombre del cliente es obligatorio");
                return;
            }
            if (jewelName.isBlank()) {
                JOptionPane.showMessageDialog(this, "La joya es obligatoria");
                return;
            }
            if (jewelQuantity.isBlank()) {
                JOptionPane.showMessageDialog(this, "La cantidad es obligatoria");
                return;
            }
            double price = jewelController.getJewelByName(jewelName).getPrice();
            String jewelPrice = String.valueOf(price);
            String subtotal = String.valueOf(calculateSubtotal(price, Integer.valueOf(jewelQuantity)));
            
            saleItem.setJewelName(jewelName);
            saleItem.setQuantity(jewelQuantity);
            saleItem.setPrice(jewelPrice);
            saleItem.setSubtotal(subtotal);
            if (
                isJewelAlreadyInOrder(jewelName) &&
                !wasRowSelected()
            ) {
                JOptionPane.showMessageDialog(this, "La joya seleccionada ya se encuentra en la orden");
                return;
            }
            if (
                isJewelAlreadyInOrder(jewelName) &&
                wasRowSelected()
            ) {
                int row = saleItemsTable.getSelectedRow();
                subtotal = String.valueOf(calculateSubtotal(price, Integer.valueOf(jewelQuantity)));
                jewelController.checkAvailableStock(jewelName, Integer.parseInt(jewelQuantity));
                saleItemsTableModel.updateItemQuantity(row, jewelQuantity);
                saleItemsTableModel.updateItemSubtotal(row, subtotal);
                return;
            }
            jewelController.checkAvailableStock(jewelName, Integer.parseInt(jewelQuantity));
            saleItemsTableModel.addItems(saleItem);
            
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InsufficientStockException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private Double calculateSubtotal(double price, int quantity) {
        return price * quantity;
    }
    
    private boolean wasRowSelected() {
        return saleItemsTable.getSelectedRow() >= 0;
    }
    
    private boolean isJewelAlreadyInOrder(String jewelName) {
        return saleItemsTableModel.getSaleItems()
                .stream()
                .map(j -> j.getJewelName())
                .anyMatch(name -> name.equals(jewelName));
    }
   
    private void createSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSaleBtnActionPerformed
        createSale();
    }//GEN-LAST:event_createSaleBtnActionPerformed
    
    private void createSale() {
        String customerName = customerSaleCbx.getSelectedItem().toString();
        String jewelName = jewelSaleCbx.getSelectedItem().toString();
        String quantity = quantitySaleTxt.getText();
        String total = totalAmountTxt.getText();
        if (customerName.isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre del cliente es obligatorio");
            return;
        }
        if (jewelName.isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre del producto es obligatorio");
            return;
        }
        if (quantity.isBlank()) {
            JOptionPane.showMessageDialog(this, "La cantidad de la venta es obligatorio");
            return;
        }
        
        int question = 
                JOptionPane.showConfirmDialog(null, "¿Está seguro que los datos están correctos?");
        if (question == 0) {
            try {
                SaleDTO saleDTO = new SaleDTO();
                saleDTO.setCustomerName(customerName);
                saleDTO.setTotal(Double.parseDouble(total));
                
                // la vista 'Home' pasa un objeto 'sale' al constructor de esta vista
                // cuando es para editar, pasa el objeto correspondiente al item seleccionado en la tabla ventas
                // de la vista 'Home'. Cuando es para crear, pasa a sale como null.
                // por eso aqui comprueba si es null, para poder llamar al metodo correcto del DAO (insert o update)
                boolean isCreateSaleMode = sale == null;
                if (isCreateSaleMode) {
                    Long cratedSaleId = saleController.createSaleWithReturningId(saleDTO);
                    saveCreatedSaleItems(cratedSaleId);
                    callback.updateList();
                    dispose();
                } else {
                    saleController.updateSale(sale.getId(), saleDTO);
                    saveAddedSaleItems(sale.getId());
                    saveDeletedSaleItems(sale.getId());
                    updateRemainingSaleItems(sale.getId());
                    callback.updateList();
                    dispose();
                }
                
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, 
                        "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void saveCreatedSaleItems(Long saleId) {
        List<SaleItemTableEntity> saleItemsFromTable = saleItemsTableModel.getSaleItems();
        saleItemsFromTable.stream()
                    .forEach(item -> {
                        SaleItemDTO saleItemDTO = new SaleItemDTO();
                        saleItemDTO.setSaleId(saleId);
                        saleItemDTO.setJewelName(item.getJewelName());
                        saleItemDTO.setQuantity(Integer.parseInt(item.getQuantity()));
                        saleItemDTO.setPrice(Double.parseDouble(item.getPrice()));
                        saleItemDTO.setSubtotal(Double.parseDouble(item.getSubtotal()));
                        try {
                            saleItemController.createSaleItem(saleItemDTO);
                            jewelController.updateJewelStock(
                                    item.getJewelName(), 
                                    Integer.parseInt(item.getQuantity())
                            );
                        } catch (DAOException e) {
                            JOptionPane.showMessageDialog(this, 
                                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (InsufficientStockException e) {
                            JOptionPane.showMessageDialog(this, 
                                    e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
    }
    
    private void saveAddedSaleItems(Long saleId) {
        try {
            List<SaleItem> previousSaleItemsSavedInDB = saleItemController.getSaleItemBySaleId(saleId);
            List<SaleItemTableEntity> saleItemsFromTable = saleItemsTableModel.getSaleItems();
            List<SaleItemTableEntity> saleItemsToAdd = saleItemsToAddInSaleUpdate(
                    previousSaleItemsSavedInDB, saleItemsFromTable);
            if (saleItemsToAdd.isEmpty()) {
                return;
            }
            saleItemsToAdd.stream()
                        .forEach(item -> {  
                            SaleItemDTO saleItemDTO = new SaleItemDTO();
                            saleItemDTO.setSaleId(saleId);
                            saleItemDTO.setJewelName(item.getJewelName());
                            saleItemDTO.setQuantity(Integer.parseInt(item.getQuantity()));
                            saleItemDTO.setPrice(Double.parseDouble(item.getPrice()));
                            saleItemDTO.setSubtotal(Double.parseDouble(item.getSubtotal()));
                            try {
                                saleItemController.createSaleItem(saleItemDTO);
                                jewelController.updateJewelStock(
                                        item.getJewelName(), 
                                        Integer.parseInt(item.getQuantity())
                                );
                            } catch (DAOException e) {
                                JOptionPane.showMessageDialog(this, 
                                        "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (InsufficientStockException e) {
                                JOptionPane.showMessageDialog(this, 
                                        e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        });
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private List<SaleItemTableEntity> saleItemsToAddInSaleUpdate(
            List<SaleItem> saleItemsInDB,
            List<SaleItemTableEntity> saleItemsFromTable
    ) {
        List<SaleItemTableEntity> result = new ArrayList<>();
        try {
            List<String> saleItemsNames = saleItemsNamesToAddInSaleUpdate(saleItemsInDB, saleItemsFromTable);
        
            for (SaleItemTableEntity saleItem : saleItemsFromTable) {
                if (saleItemsNames.contains(saleItem.getJewelName())) {
                    result.add(saleItem);
                }
            }
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return result;
    }
    
    private List<String> saleItemsNamesToAddInSaleUpdate(
            List<SaleItem> saleItemsInDB,
            List<SaleItemTableEntity> saleItemsFromTable
    )  throws DAOException 
        {
        List<String> result = new ArrayList<>();
        List<String> saleItemsNamesInDB = new ArrayList<>();

        for (SaleItem s : saleItemsInDB) {
            Jewel jewel = jewelController.getJewelById(s.getJewelId());
            String name = jewel.getName();
            saleItemsNamesInDB.add(name);
        }

        List<String> saleItemsNamesFromTable = saleItemsFromTable.stream()
                 .map(s -> s.getJewelName())
                 .collect(Collectors.toList());

         for (String nameSaleItemInTable : saleItemsNamesFromTable) {
             if (!saleItemsNamesInDB.contains(nameSaleItemInTable)) {
                 result.add(nameSaleItemInTable);
             }
         }
        return result;
    }
    
    private void saveDeletedSaleItems(Long saleId) {
        try {
            List<SaleItem> previousSaleItemsSavedInDB = saleItemController.getSaleItemBySaleId(saleId);
            List<SaleItemTableEntity> saleItemsFromTable = saleItemsTableModel.getSaleItems();
            List<SaleItemTableEntity> saleItemsToDelete = saleItemsToDeleteInSaleUpdate(
                    previousSaleItemsSavedInDB, saleItemsFromTable);
            if (saleItemsToDelete.isEmpty()) {
                return;
            }
            saleItemsToDelete.stream()
                        .forEach(item -> {  
                            SaleItemDTO saleItemDTO = new SaleItemDTO();
                            saleItemDTO.setSaleId(saleId);
                            saleItemDTO.setJewelName(item.getJewelName());
                            saleItemDTO.setQuantity(Integer.parseInt(item.getQuantity()));
                            saleItemDTO.setPrice(Double.parseDouble(item.getPrice()));
                            saleItemDTO.setSubtotal(Double.parseDouble(item.getSubtotal()));
                            try {
                                Long jewelId = jewelController.getJewelByName(item.getJewelName()).getId();
                                saleItemController.deleteBySaleIdAndJewelId(saleId, jewelId);
                                jewelController.updateJewelStock(
                                        item.getJewelName(), 
                                        Integer.parseInt(item.getQuantity())
                                );
                            } catch (DAOException e) {
                                JOptionPane.showMessageDialog(this, 
                                        "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (InsufficientStockException e) {
                                JOptionPane.showMessageDialog(this, 
                                        e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        });
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private List<SaleItemTableEntity> saleItemsToDeleteInSaleUpdate(
            List<SaleItem> saleItemsInDB,
            List<SaleItemTableEntity> saleItemsFromTable
    ) {
        List<SaleItemTableEntity> result = new ArrayList<>();
        try {
            List<String> saleItemsNames = saleItemsNamesToDeleteInSaleUpdate(saleItemsInDB, saleItemsFromTable);
        
            for (SaleItemTableEntity saleItem : saleItemsFromTable) {
                if (saleItemsNames.contains(saleItem.getJewelName())) {
                    result.add(saleItem);
                }
            }
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return result;
    }
    
    private List<String> saleItemsNamesToDeleteInSaleUpdate(
            List<SaleItem> saleItemsInDB,
            List<SaleItemTableEntity> saleItemsFromTable
    )  throws DAOException 
        {
        List<String> result = new ArrayList<>();
        List<String> saleItemsNamesInDB = new ArrayList<>();

        for (SaleItem s : saleItemsInDB) {
            Jewel jewel = jewelController.getJewelById(s.getJewelId());
            String name = jewel.getName();
            saleItemsNamesInDB.add(name);
        }

        List<String> saleItemsNamesFromTable = saleItemsFromTable.stream()
                 .map(s -> s.getJewelName())
                 .collect(Collectors.toList());

         for (String saleItemNameInDB : saleItemsNamesInDB) {
             if (!saleItemsNamesFromTable.contains(saleItemNameInDB)) {
                 result.add(saleItemNameInDB);
             }
         }
        return result;
    }
    
    private void updateRemainingSaleItems(Long saleId) {
        List<SaleItemTableEntity> saleItemsFromTable = saleItemsTableModel.getSaleItems();

        saleItemsFromTable.stream()
                    .forEach(item -> {  
                        SaleItemDTO saleItemDTO = new SaleItemDTO();
                        saleItemDTO.setSaleId(saleId);
                        saleItemDTO.setJewelName(item.getJewelName());
                        saleItemDTO.setQuantity(Integer.parseInt(item.getQuantity()));
                        saleItemDTO.setPrice(Double.parseDouble(item.getPrice()));
                        saleItemDTO.setSubtotal(Double.parseDouble(item.getSubtotal()));
                        try {
                            Long jewelId = jewelController.getJewelByName(item.getJewelName()).getId();
                            saleItemController.updateBySaleIdAndJewelId(saleId, jewelId);
                            jewelController.updateJewelStock(
                                    item.getJewelName(), 
                                    Integer.parseInt(item.getQuantity())
                            );
                        } catch (DAOException e) {
                            JOptionPane.showMessageDialog(this, 
                                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (InsufficientStockException e) {
                            JOptionPane.showMessageDialog(this, 
                                    e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
    }
    
    private void deleteSaleItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSaleItemActionPerformed
        deleteLineFromSaleItemsTable();
        totalAmountTxt.setText(String.valueOf(calculateSaleTotalAmount()));
    }//GEN-LAST:event_deleteSaleItemActionPerformed

    private void deleteLineFromSaleItemsTable() {
        int row = saleItemsTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una linea.");
            return;
        }
        saleItemsTableModel.removeItem(row);
    }
    
    private void totalAmountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountTxtActionPerformed

    private void saleItemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleItemsTableMouseClicked
        try {
            setSelectedRowDataOnTextFields();
        } catch (DAOException | InvalidInputException | CustomerNotFoundException e) {
            JOptionPane.showMessageDialog(this, 
                    "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_saleItemsTableMouseClicked

    private void setSelectedRowDataOnTextFields() 
            throws DAOException, InvalidInputException, CustomerNotFoundException {
        boolean isEditingMode = sale != null;
        if (isEditingMode) {
            int row = saleItemsTable.getSelectedRow();
            SaleItemTableEntity selectedSaleItem = saleItemsTableModel.getSaleItemInRow(row);
            String customerName = customerController.getCustomerName(sale.getCustomerId());
            String jewelName = selectedSaleItem.getJewelName();
            String quantity = selectedSaleItem.getQuantity();
            customerSaleCbx.setSelectedItem(customerName);
            jewelSaleCbx.setSelectedItem(jewelName);
            quantitySaleTxt.setText(quantity);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductToOrderSaleBtn;
    private javax.swing.JButton cancelSaleBtn;
    private javax.swing.JButton createSaleBtn;
    private javax.swing.JComboBox<String> customerSaleCbx;
    private javax.swing.JButton deleteSaleItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jewelSaleCbx;
    private javax.swing.JTextField quantitySaleTxt;
    private javax.swing.JTable saleItemsTable;
    private javax.swing.JTextField totalAmountTxt;
    // End of variables declaration//GEN-END:variables
}
