package com.mycompany.joyeriaInventario.model.vo;

public class JewelPriceVO {

    private double price;

    public JewelPriceVO(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        JewelPriceVO other = (JewelPriceVO) obj;
        return Double.compare(price, other.price) == 0;
    }
    
}
