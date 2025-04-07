package com.mycompany.joyeriaInventario.model.dto;

public class SaleItemDTO {

    private Long saleId;
    
    private String jewelName;
    
    private int quantity;
    
    private double price;
    
    private double subtotal;

    public SaleItemDTO() {
    }

    public SaleItemDTO(Long saleId, String jewelName, int quantity, double price, double subtotal) {
        this.saleId = saleId;
        this.jewelName = jewelName;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public String getJewelName() {
        return jewelName;
    }

    public void setJewelName(String jewelName) {
        this.jewelName = jewelName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "SaleItemDTO{" + "saleId=" + saleId + ", jewelName=" + jewelName + ", quantity=" + quantity + ", price=" + price + ", subtotal=" + subtotal + '}';
    }
    
}
