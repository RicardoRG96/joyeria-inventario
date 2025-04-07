package com.mycompany.joyeriaInventario.model.dto;

public class SaleDTO {

    private String customerName;
    
    private double total;

    public SaleDTO() {
    }

    public SaleDTO(String customerName, double total) {
        this.customerName = customerName;
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SaleDTO{" + "customerName=" + customerName + ", total=" + total + '}';
    }
 
}
