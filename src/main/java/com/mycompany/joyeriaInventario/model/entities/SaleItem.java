package com.mycompany.joyeriaInventario.model.entities;

import com.mycompany.joyeriaInventario.exception.common.InvalidInputException;
import com.mycompany.joyeriaInventario.model.vo.JewelPriceVO;
import com.mycompany.joyeriaInventario.model.vo.SaleQuantityVO;
import java.sql.Timestamp;
import java.util.Objects;

public class SaleItem {

    private Long id;
    
    private Long saleId;
    
    private Long jewelId;
    
    private SaleQuantityVO quantity;
    
    private JewelPriceVO price;
    
    private Double subTotal;
    
    private Timestamp createdAt;
    
    private Timestamp updatedAt;

    public SaleItem() {
    }

    public SaleItem(Long saleId, Long jewelId, int quantity, Double price, Double subTotal) throws InvalidInputException {
        this.saleId = saleId;
        this.jewelId = jewelId;
        this.quantity = new SaleQuantityVO(quantity);
        this.price = new JewelPriceVO(price);
        this.subTotal = subTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getJewelId() {
        return jewelId;
    }

    public void setJewelId(Long jewelId) {
        this.jewelId = jewelId;
    }

    public int getQuantity() {
        return quantity.getQuantity();
    }

    public void setQuantity(int quantity) throws InvalidInputException {
        this.quantity = new SaleQuantityVO(quantity);
    }

    public Double getPrice() {
        return price.getPrice();
    }

    public void setPrice(Double price) throws InvalidInputException {
        this.price = new JewelPriceVO(price);
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
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
        return "SaleItem{" + "id=" + id + ", saleId=" + saleId + ", jewelId=" + jewelId + ", quantity=" + quantity + ", price=" + price + ", subTotal=" + subTotal + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.saleId);
        hash = 59 * hash + Objects.hashCode(this.jewelId);
        hash = 59 * hash + Objects.hashCode(this.quantity);
        hash = 59 * hash + Objects.hashCode(this.price);
        hash = 59 * hash + Objects.hashCode(this.subTotal);
        hash = 59 * hash + Objects.hashCode(this.createdAt);
        hash = 59 * hash + Objects.hashCode(this.updatedAt);
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
        final SaleItem other = (SaleItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.saleId, other.saleId)) {
            return false;
        }
        if (!Objects.equals(this.jewelId, other.jewelId)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.subTotal, other.subTotal)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return Objects.equals(this.updatedAt, other.updatedAt);
    }

    
}