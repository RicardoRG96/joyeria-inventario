/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.joyeriainventario.views;

/**
 *
 * @author ricar
 */
public class EditSale extends javax.swing.JFrame {

    /**
     * Creates new form EditSale
     */
    public EditSale() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        editCustomerSaleCbx = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        editQuantitySaleTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        editJewelSaleCbx = new javax.swing.JComboBox<>();
        saveSaleEditionBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(232, 249, 255));
        jPanel1.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(248, 250, 252));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 54, 63));
        jLabel2.setText("Editar Pedido de Venta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel8.setBackground(new java.awt.Color(248, 250, 252));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(49, 54, 63));
        jLabel8.setText("Cliente:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        editCustomerSaleCbx.setBackground(new java.awt.Color(248, 250, 252));
        editCustomerSaleCbx.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editCustomerSaleCbx.setForeground(new java.awt.Color(49, 54, 63));
        editCustomerSaleCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(editCustomerSaleCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 200, 20));

        jLabel7.setBackground(new java.awt.Color(248, 250, 252));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(49, 54, 63));
        jLabel7.setText("Cantidad:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        editQuantitySaleTxt.setBackground(new java.awt.Color(248, 250, 252));
        editQuantitySaleTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editQuantitySaleTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(editQuantitySaleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 80, 20));

        jLabel6.setBackground(new java.awt.Color(248, 250, 252));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 54, 63));
        jLabel6.setText("Joya:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        editJewelSaleCbx.setBackground(new java.awt.Color(248, 250, 252));
        editJewelSaleCbx.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJewelSaleCbx.setForeground(new java.awt.Color(49, 54, 63));
        editJewelSaleCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(editJewelSaleCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 200, 20));

        saveSaleEditionBtn.setBackground(new java.awt.Color(251, 251, 251));
        saveSaleEditionBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        saveSaleEditionBtn.setForeground(new java.awt.Color(49, 54, 63));
        saveSaleEditionBtn.setText("Guardar");
        saveSaleEditionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveSaleEditionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSaleEditionBtnActionPerformed(evt);
            }
        });
        jPanel1.add(saveSaleEditionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 120, 30));

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

    private void saveSaleEditionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSaleEditionBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveSaleEditionBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EditSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> editCustomerSaleCbx;
    private javax.swing.JComboBox<String> editJewelSaleCbx;
    private javax.swing.JTextField editQuantitySaleTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton saveSaleEditionBtn;
    // End of variables declaration//GEN-END:variables
}
