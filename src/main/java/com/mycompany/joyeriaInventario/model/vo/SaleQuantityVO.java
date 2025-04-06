package com.mycompany.joyeriaInventario.model.vo;

public class SaleQuantityVO {

    private int quantity;

    public SaleQuantityVO(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SaleQuantityVO other = (SaleQuantityVO) obj;
        return quantity == other.quantity;
    }
    
}
