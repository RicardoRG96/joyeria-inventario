package com.mycompany.joyeriaInventario.model.views;

public class TopCustomerView {

    private Long customerId;
    
    private String name;
    
    private int totalSales;
    
    private double totalSpent;

    public TopCustomerView() {
    }

    public TopCustomerView(Long customerId, String name, int totalSales, double totalSpent) {
        this.customerId = customerId;
        this.name = name;
        this.totalSales = totalSales;
        this.totalSpent = totalSpent;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    @Override
    public String toString() {
        return "TopCustomerView{" + "customerId=" + customerId + ", name=" + name + ", totalSales=" + totalSales + ", totalSpent=" + totalSpent + '}';
    }
    
}
