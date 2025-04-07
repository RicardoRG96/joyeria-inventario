package com.mycompany.joyeriaInventario.view.tableModel;

public class SaleItemTableEntity {

    private String jewelName;
    
    private String quantity;
    
    private String price;
    
    private String subtotal;

    public SaleItemTableEntity() {
    }

    public SaleItemTableEntity(String jewelName, String quantity, String price, String subtotal) {
        this.jewelName = jewelName;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
    }

    public String getJewelName() {
        return jewelName;
    }

    public void setJewelName(String jewelName) {
        this.jewelName = jewelName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "SaleItemTableEntity{" + "jewelName=" + jewelName + ", quantity=" + quantity + ", price=" + price + ", subtotal=" + subtotal + '}';
    }
    
}
