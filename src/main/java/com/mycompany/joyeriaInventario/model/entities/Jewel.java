package com.mycompany.joyeriaInventario.model.entities;

import com.mycompany.joyeriaInventario.model.vo.JewelPriceVO;
import com.mycompany.joyeriaInventario.model.vo.JewelStockVO;
import com.mycompany.joyeriaInventario.model.vo.JewelWeightVO;
import com.mycompany.joyeriaInventario.model.vo.NameVO;
import java.sql.Timestamp;
import java.util.Objects;

public class Jewel {

    private Long id;
    
    private NameVO name;
    
    private Long materialId;
    
    private JewelWeightVO weight;
    
    private JewelPriceVO price;
    
    private JewelStockVO stock;
    
    private Timestamp createdAt;
    
    private Timestamp updatedAt;

    public Jewel() {
    }

    public Jewel(String name, Long materialId, double weight, double price, int stock) {
        this.name = new NameVO(name);
        this.materialId = materialId;
        this.weight = new JewelWeightVO(weight);
        this.price = new JewelPriceVO(price);
        this.stock = new JewelStockVO(stock);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name.getName();
    }

    public void setName(String name) {
        this.name = new NameVO(name);
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public double getWeight() {
        return weight.getWeight();
    }

    public void setWeight(double weight) {
        this.weight = new JewelWeightVO(weight);
    }

    public double getPrice() {
        return price.getPrice();
    }

    public void setPrice(double price) {
        this.price = new JewelPriceVO(price);
    }

    public int getStock() {
        return stock.getStock();
    }

    public void setStock(int stock) {
        this.stock = new JewelStockVO(stock);
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Jewel{" + "id=" + id + ", name=" + name + ", materialId=" + materialId + ", weight=" + weight + ", price=" + price + ", stock=" + stock + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.materialId);
        hash = 31 * hash + Objects.hashCode(this.weight);
        hash = 31 * hash + Objects.hashCode(this.price);
        hash = 31 * hash + Objects.hashCode(this.stock);
        hash = 31 * hash + Objects.hashCode(this.createdAt);
        hash = 31 * hash + Objects.hashCode(this.updatedAt);
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
        final Jewel other = (Jewel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.materialId, other.materialId)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.stock, other.stock)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return Objects.equals(this.updatedAt, other.updatedAt);
    }

}
