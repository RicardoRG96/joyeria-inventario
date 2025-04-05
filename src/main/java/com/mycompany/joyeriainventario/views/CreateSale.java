/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.joyeriainventario.views;

/**
 *
 * @author ricar
 */
public class CreateSale extends javax.swing.JFrame {

    /**
     * Creates new form CreateSale
     */
    public CreateSale() {
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
        jLabel6 = new javax.swing.JLabel();
        jewelSaleCbx = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        customerSaleCbx = new javax.swing.JComboBox<>();
        quantitySaleTxt = new javax.swing.JTextField();
        createSaleBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(232, 249, 255));
        setPreferredSize(new java.awt.Dimension(630, 273));

        jPanel1.setBackground(new java.awt.Color(232, 249, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(248, 250, 252));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 54, 63));
        jLabel2.setText("Nuevo Pedido de Venta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setBackground(new java.awt.Color(248, 250, 252));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 54, 63));
        jLabel6.setText("Joya:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        jewelSaleCbx.setBackground(new java.awt.Color(248, 250, 252));
        jewelSaleCbx.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jewelSaleCbx.setForeground(new java.awt.Color(49, 54, 63));
        jewelSaleCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jewelSaleCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 200, 20));

        jLabel7.setBackground(new java.awt.Color(248, 250, 252));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(49, 54, 63));
        jLabel7.setText("Cantidad:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel8.setBackground(new java.awt.Color(248, 250, 252));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(49, 54, 63));
        jLabel8.setText("Cliente:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        customerSaleCbx.setBackground(new java.awt.Color(248, 250, 252));
        customerSaleCbx.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        customerSaleCbx.setForeground(new java.awt.Color(49, 54, 63));
        customerSaleCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(customerSaleCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 200, 20));

        quantitySaleTxt.setBackground(new java.awt.Color(248, 250, 252));
        quantitySaleTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        quantitySaleTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(quantitySaleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 80, 20));

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
        jPanel1.add(createSaleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSaleBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createSaleBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CreateSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createSaleBtn;
    private javax.swing.JComboBox<String> customerSaleCbx;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jewelSaleCbx;
    private javax.swing.JTextField quantitySaleTxt;
    // End of variables declaration//GEN-END:variables
}
