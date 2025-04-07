package com.mycompany.joyeriaInventario.view.jewel;

import com.mycompany.joyeriaInventario.controller.JewelController;
import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.model.dto.JewelDTO;
import com.mycompany.joyeriaInventario.model.entities.Material;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class CreateJewelView extends javax.swing.JFrame {

    private JewelController jewelController;
    
    public CreateJewelView() throws SQLException, DAOException, InvalidInputException {
        initComponents();
        this.jewelController = new JewelController();
        loadMaterials();
    }
    
    private void loadMaterials() {
        try {
            List<Material> materials = jewelController.getAllMaterials();
            List<String> materialNames = materials.stream()
                            .map(m -> m.getName())
                            .collect(Collectors.toList());
            
            materialNames.stream()
                    .forEach(material -> jewelMaterialCbx.addItem(material));
        } catch (DAOException | InvalidInputException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jewelWeightTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jewelStockTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jewelNameTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jewelPriceTxt = new javax.swing.JTextField();
        cancelJewelCreationBtn = new javax.swing.JButton();
        createJewelBtn = new javax.swing.JButton();
        jewelMaterialCbx = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(217, 234, 253));

        jPanel1.setBackground(new java.awt.Color(232, 249, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(248, 250, 252));
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(49, 54, 63));
        jLabel1.setText("Stock:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        jewelWeightTxt.setBackground(new java.awt.Color(248, 250, 252));
        jewelWeightTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jewelWeightTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(jewelWeightTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 230, 20));

        jLabel2.setBackground(new java.awt.Color(248, 250, 252));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 54, 63));
        jLabel2.setText("Crear Joya");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(248, 250, 252));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(49, 54, 63));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jewelStockTxt.setBackground(new java.awt.Color(248, 250, 252));
        jewelStockTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jewelStockTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(jewelStockTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 230, 20));

        jLabel4.setBackground(new java.awt.Color(248, 250, 252));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(49, 54, 63));
        jLabel4.setText("Material:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel5.setBackground(new java.awt.Color(248, 250, 252));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(49, 54, 63));
        jLabel5.setText("Peso:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jewelNameTxt.setBackground(new java.awt.Color(248, 250, 252));
        jewelNameTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jewelNameTxt.setForeground(new java.awt.Color(49, 54, 63));
        jewelNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jewelNameTxtActionPerformed(evt);
            }
        });
        jPanel1.add(jewelNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 230, 20));

        jLabel6.setBackground(new java.awt.Color(248, 250, 252));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 54, 63));
        jLabel6.setText("Precio:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        jewelPriceTxt.setBackground(new java.awt.Color(248, 250, 252));
        jewelPriceTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jewelPriceTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(jewelPriceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 230, 20));

        cancelJewelCreationBtn.setBackground(new java.awt.Color(251, 251, 251));
        cancelJewelCreationBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cancelJewelCreationBtn.setForeground(new java.awt.Color(49, 54, 63));
        cancelJewelCreationBtn.setText("Cancelar");
        cancelJewelCreationBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelJewelCreationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJewelCreationBtnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelJewelCreationBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 90, 30));

        createJewelBtn.setBackground(new java.awt.Color(251, 251, 251));
        createJewelBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        createJewelBtn.setForeground(new java.awt.Color(49, 54, 63));
        createJewelBtn.setText("Aceptar");
        createJewelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createJewelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createJewelBtnActionPerformed(evt);
            }
        });
        jPanel1.add(createJewelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 90, 30));

        jewelMaterialCbx.setBackground(new java.awt.Color(248, 250, 252));
        jewelMaterialCbx.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jewelMaterialCbx.setForeground(new java.awt.Color(49, 54, 63));
        jewelMaterialCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jewelMaterialCbxActionPerformed(evt);
            }
        });
        jPanel1.add(jewelMaterialCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 230, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jewelNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jewelNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jewelNameTxtActionPerformed

    private void cancelJewelCreationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJewelCreationBtnActionPerformed
        int question = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cancelar?");
        if (question == 0) {
            setVisible(false);
        }
    }//GEN-LAST:event_cancelJewelCreationBtnActionPerformed

    private void createJewelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createJewelBtnActionPerformed
        String materialName = jewelMaterialCbx.getSelectedItem().toString();
        String name = jewelNameTxt.getText();
        String price = jewelPriceTxt.getText();
        String stock = jewelStockTxt.getText();
        String weight = jewelWeightTxt.getText();
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
                JewelDTO jewelDTO = new JewelDTO();
                jewelDTO.setName(jewelNameTxt.getText());
                jewelDTO.setMaterialName(jewelMaterialCbx.getSelectedItem().toString());
                jewelDTO.setWeight(Double.parseDouble(jewelWeightTxt.getText()));
                jewelDTO.setPrice(Double.parseDouble(jewelPriceTxt.getText()));
                jewelDTO.setStock(Integer.parseInt(jewelStockTxt.getText()));
                jewelController.createJewel(jewelDTO);
                setVisible(false);
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_createJewelBtnActionPerformed

    private void jewelMaterialCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jewelMaterialCbxActionPerformed
        
    }//GEN-LAST:event_jewelMaterialCbxActionPerformed

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
            java.util.logging.Logger.getLogger(CreateJewelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateJewelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateJewelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateJewelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new CreateJewelView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CreateJewelView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DAOException ex) {
                    Logger.getLogger(CreateJewelView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidInputException ex) {
                    Logger.getLogger(CreateJewelView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelJewelCreationBtn;
    private javax.swing.JButton createJewelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jewelMaterialCbx;
    private javax.swing.JTextField jewelNameTxt;
    private javax.swing.JTextField jewelPriceTxt;
    private javax.swing.JTextField jewelStockTxt;
    private javax.swing.JTextField jewelWeightTxt;
    // End of variables declaration//GEN-END:variables
}
