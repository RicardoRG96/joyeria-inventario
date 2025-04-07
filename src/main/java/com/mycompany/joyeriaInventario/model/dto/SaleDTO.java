package com.mycompany.joyeriaInventario.model.dto;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.customerName);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SaleDTO other = (SaleDTO) obj;
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        return Objects.equals(this.customerName, other.customerName);
    }
    
}
