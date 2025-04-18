package com.mycompany.joyeriaInventario.view.invoice;

public class InvoicesView extends javax.swing.JFrame {

    public InvoicesView() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        orderSaleToBillTxt = new javax.swing.JTextField();
        totalAmountOrderToBillTxt = new javax.swing.JTextField();
        customerOrderToBillTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        totalQuantityOrderToBillTxt = new javax.swing.JTextField();
        seeInvoiceBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        billBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 250, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(217, 234, 253));

        jLabel2.setBackground(new java.awt.Color(217, 234, 253));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 54, 63));
        jLabel2.setText("Factura");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 40));

        jLabel8.setBackground(new java.awt.Color(248, 250, 252));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(49, 54, 63));
        jLabel8.setText("Total:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel9.setBackground(new java.awt.Color(248, 250, 252));
        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(49, 54, 63));
        jLabel9.setText("Ver Factura");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, 20));

        jLabel10.setBackground(new java.awt.Color(248, 250, 252));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(49, 54, 63));
        jLabel10.setText("Cliente:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        orderSaleToBillTxt.setEditable(false);
        orderSaleToBillTxt.setBackground(new java.awt.Color(248, 250, 252));
        orderSaleToBillTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        orderSaleToBillTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(orderSaleToBillTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 230, 20));

        totalAmountOrderToBillTxt.setEditable(false);
        totalAmountOrderToBillTxt.setBackground(new java.awt.Color(248, 250, 252));
        totalAmountOrderToBillTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        totalAmountOrderToBillTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(totalAmountOrderToBillTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 230, 20));

        customerOrderToBillTxt.setEditable(false);
        customerOrderToBillTxt.setBackground(new java.awt.Color(248, 250, 252));
        customerOrderToBillTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        customerOrderToBillTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(customerOrderToBillTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 230, 20));

        jLabel12.setBackground(new java.awt.Color(248, 250, 252));
        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(49, 54, 63));
        jLabel12.setText("Cantidad Total:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        totalQuantityOrderToBillTxt.setEditable(false);
        totalQuantityOrderToBillTxt.setBackground(new java.awt.Color(248, 250, 252));
        totalQuantityOrderToBillTxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        totalQuantityOrderToBillTxt.setForeground(new java.awt.Color(49, 54, 63));
        jPanel1.add(totalQuantityOrderToBillTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 230, 20));

        seeInvoiceBtn.setBackground(new java.awt.Color(248, 250, 252));
        seeInvoiceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/see-invoice.png"))); // NOI18N
        seeInvoiceBtn.setBorder(null);
        seeInvoiceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seeInvoiceBtn.setPreferredSize(new java.awt.Dimension(48, 48));
        jPanel1.add(seeInvoiceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 50, 50));

        jLabel11.setBackground(new java.awt.Color(248, 250, 252));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(49, 54, 63));
        jLabel11.setText("Orden de Venta:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        billBtn.setBackground(new java.awt.Color(248, 250, 252));
        billBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bill.png"))); // NOI18N
        billBtn.setBorder(null);
        billBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(billBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 50, 50));

        jLabel13.setBackground(new java.awt.Color(248, 250, 252));
        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(49, 54, 63));
        jLabel13.setText("Facturar");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton billBtn;
    private javax.swing.JTextField customerOrderToBillTxt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField orderSaleToBillTxt;
    private javax.swing.JButton seeInvoiceBtn;
    private javax.swing.JTextField totalAmountOrderToBillTxt;
    private javax.swing.JTextField totalQuantityOrderToBillTxt;
    // End of variables declaration//GEN-END:variables
}
