package com.mycompany.joyeriaInventario.model.vo;

import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;

public class JewelStockVO {
    
    private int stock;
    
    public JewelStockVO(int stock) throws InvalidInputException {
        if (stock < 0) {
            throw new InvalidInputException("El stock no puede ser menor a cero");
        }
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.stock;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        JewelStockVO other = (JewelStockVO) obj;
        return stock == other.stock;
    }
    
}
