package com.mycompany.joyeriaInventario.model.vo;

public class JewelWeightVO {
    
    private double weight;

    public JewelWeightVO(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a cero");
        }
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        JewelWeightVO other = (JewelWeightVO) obj;
        return Double.compare(weight, other.weight) == 0;
    }
    
}
