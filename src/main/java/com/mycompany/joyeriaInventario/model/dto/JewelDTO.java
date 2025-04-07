package com.mycompany.joyeriaInventario.model.dto;

public class JewelDTO {

    private String name;
    
    private String materialName;
    
    private double weight;
    
    private double price;
    
    private int stock;

    public JewelDTO() {
    }

    public JewelDTO(String name, String materialName, double weight, double price, int stock) {
        this.name = name;
        this.materialName = materialName;
        this.weight = weight;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "JewelDTO{" + "name=" + name + ", materialName=" + materialName + ", weight=" + weight + ", price=" + price + ", stock=" + stock + '}';
    }
    
}
