package com.mycompany.joyeriaInventario.model.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Sale {

    private Long id;
    
    private Long customerId;
    
    private Double total;
    
    private Timestamp createdAt;
    
    private Timestamp updatedAt;

    public Sale() {
    }

    public Sale(Long customerId, Double total) {
        this.customerId = customerId;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        return "Sale{" + "id=" + id + ", customerId=" + customerId + ", total=" + total + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.customerId);
        hash = 89 * hash + Objects.hashCode(this.total);
        hash = 89 * hash + Objects.hashCode(this.createdAt);
        hash = 89 * hash + Objects.hashCode(this.updatedAt);
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
        final Sale other = (Sale) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.customerId, other.customerId)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return Objects.equals(this.updatedAt, other.updatedAt);
    }
    
}
