package com.mycompany.joyeriaInventario.view.jewel;

import com.mycompany.joyeriaInventario.controller.JewelController;
import com.mycompany.joyeriaInventario.controller.MaterialController;
import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.model.dto.JewelDTO;
import com.mycompany.joyeriaInventario.model.entities.Jewel;
import com.mycompany.joyeriaInventario.model.entities.Material;
import com.mycompany.joyeriaInventario.view.listener.UpdateableList;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UpdateJewelView extends javax.swing.JFrame {
    
    private final JewelController jewelController;
    
    private final MaterialController materialController;
    
    private final Jewel jewel;
    
    private final UpdateableList callback;

    public UpdateJewelView(JFrame parent, Jewel jewel, UpdateableList callback) throws SQLException {
        initComponents();
        this.jewelController = new JewelController();
        this.materialController = new MaterialController();
        this.jewel = jewel;
        this.callback = callback;
        loadMaterials();
        loadDataToUpdate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void loadMaterials() {
        try {
            List<Material> materials = materialController.getAllMaterials();
            List<String> materialNames = materials.stream()
                            .map(m -> m.getName())
                            .collect(Collectors.toList());
            
            materialNames.stream()
                    .forEach(material -> editJewelMaterialCbx.addItem(material));
        } catch (DAOException | InvalidInputException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadDataToUpdate() {
        try {
            String materialName = materialController.getMaterialName(jewel.getMaterialId());
            editJewelMaterialCbx.setSelectedItem(materialName);
            editJewelNameTxt.setText(jewel.getName());
            editJewelPriceTxt.setText(String.valueOf(jewel.getPrice()));
            editJewelStockTxt.setText(String.valueOf(jewel.getStock()));
            editJewelWeightTxt.setText(String.valueOf(jewel.getWeight()));
        } catch (DAOException | InvalidInputException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editJewelWeightTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        editJewelStockTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editJewelPriceTxt = new javax.swing.JTextField();
        cancelJewelEditionBtn = new javax.swing.JButton();
        confirmEditionJewelBtn = new javax.swing.JButton();
        editJewelMaterialCbx = new javax.swing.JComboBox<>();
        editJewelNameTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(232, 249, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(630, 273));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(248, 250, 252));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 54, 63));
        jLabel2.setText("Editar Joya");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(248, 250, 252));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(49, 54, 63));
        jLabel3.setText("Peso:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        editJewelWeightTxt.setBackground(new java.awt.Color(248, 250, 252));
        editJewelWeightTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJewelWeightTxt.setForeground(new java.awt.Color(49, 54, 63));
        editJewelWeightTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJewelWeightTxtActionPerformed(evt);
            }
        });
        jPanel1.add(editJewelWeightTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 230, 20));

        jLabel4.setBackground(new java.awt.Color(248, 250, 252));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(49, 54, 63));
        jLabel4.setText("Stock:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        editJewelStockTxt.setBackground(new java.awt.Color(248, 250, 252));
        editJewelStockTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJewelStockTxt.setForeground(new java.awt.Color(49, 54, 63));
        editJewelStockTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJewelStockTxtActionPerformed(evt);
            }
        });
        jPanel1.add(editJewelStockTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 230, 20));

        jLabel5.setBackground(new java.awt.Color(248, 250, 252));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(49, 54, 63));
        jLabel5.setText("Material:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel6.setBackground(new java.awt.Color(248, 250, 252));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 54, 63));
        jLabel6.setText("Nombre:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setBackground(new java.awt.Color(248, 250, 252));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(49, 54, 63));
        jLabel7.setText("Precio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        editJewelPriceTxt.setBackground(new java.awt.Color(248, 250, 252));
        editJewelPriceTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJewelPriceTxt.setForeground(new java.awt.Color(49, 54, 63));
        editJewelPriceTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJewelPriceTxtActionPerformed(evt);
            }
        });
        jPanel1.add(editJewelPriceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 230, 20));

        cancelJewelEditionBtn.setBackground(new java.awt.Color(251, 251, 251));
        cancelJewelEditionBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cancelJewelEditionBtn.setForeground(new java.awt.Color(49, 54, 63));
        cancelJewelEditionBtn.setText("Cancelar");
        cancelJewelEditionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelJewelEditionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJewelEditionBtnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelJewelEditionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 100, 30));

        confirmEditionJewelBtn.setBackground(new java.awt.Color(251, 251, 251));
        confirmEditionJewelBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        confirmEditionJewelBtn.setForeground(new java.awt.Color(49, 54, 63));
        confirmEditionJewelBtn.setText("Aceptar");
        confirmEditionJewelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmEditionJewelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmEditionJewelBtnActionPerformed(evt);
            }
        });
        jPanel1.add(confirmEditionJewelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 100, 30));

        editJewelMaterialCbx.setBackground(new java.awt.Color(248, 250, 252));
        editJewelMaterialCbx.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        editJewelMaterialCbx.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(editJewelMaterialCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 230, -1));

        editJewelNameTxt.setBackground(new java.awt.Color(248, 250, 252));
        editJewelNameTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJewelNameTxt.setForeground(new java.awt.Color(49, 54, 63));
        editJewelNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJewelNameTxtActionPerformed(evt);
            }
        });
        jPanel1.add(editJewelNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 230, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editJewelWeightTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJewelWeightTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editJewelWeightTxtActionPerformed

    private void editJewelStockTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJewelStockTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editJewelStockTxtActionPerformed

    private void editJewelPriceTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJewelPriceTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editJewelPriceTxtActionPerformed

    private void cancelJewelEditionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJewelEditionBtnActionPerformed
        int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cancelar?");
        if (question == 0) {
            setVisible(false);
        }
    }//GEN-LAST:event_cancelJewelEditionBtnActionPerformed

    private void confirmEditionJewelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmEditionJewelBtnActionPerformed
        save();
    }//GEN-LAST:event_confirmEditionJewelBtnActionPerformed
    
    private void save() {
        String materialName = editJewelMaterialCbx.getSelectedItem().toString();
        String name = editJewelNameTxt.getText();
        String price = editJewelPriceTxt.getText();
        String stock = editJewelStockTxt.getText();
        String weight = editJewelWeightTxt.getText();
        if (materialName.isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre del material es obligatorio");
            return;
        }
        if (name.isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre de la joya es obligatorio");
            return;
        }
        if (price.isBlank()) {
            JOptionPane.showMessageDialog(this, "El precio es obligatorio");
            return;
        }
        if (stock.isBlank()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar stock del producto");
            return;
        }
        if (weight.isBlank()) {
            JOptionPane.showMessageDialog(this, "El peso es obligatorio");
            return;
        }
        int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que los datos están correctos?");
        if (question == 0) {
            try {
                Long jewelId = jewel.getId();
                JewelDTO jewelDTO = new JewelDTO();
                jewelDTO.setName(name);
                jewelDTO.setMaterialName(materialName);
                jewelDTO.setWeight(Double.parseDouble(weight));
                jewelDTO.setPrice(Double.parseDouble(price));
                jewelDTO.setStock(Integer.parseInt(stock));

                jewelController.updateJewel(jewelId, jewelDTO);
                callback.updateList();
                dispose();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void editJewelNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJewelNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editJewelNameTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelJewelEditionBtn;
    private javax.swing.JButton confirmEditionJewelBtn;
    private javax.swing.JComboBox<String> editJewelMaterialCbx;
    private javax.swing.JTextField editJewelNameTxt;
    private javax.swing.JTextField editJewelPriceTxt;
    private javax.swing.JTextField editJewelStockTxt;
    private javax.swing.JTextField editJewelWeightTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
