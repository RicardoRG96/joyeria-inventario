package com.mycompany.joyeriaInventario.model.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Invoice {

    private Long id;
    
    private Long saleId;
    
    private String invoiceNumber;
    
    private String customerName;
    
    private String customerRut;
    
    private String billingAddress;
    
    private Double total;
    
    private Double tax;
    
    private Date issueDate;
    
    private String status;
    
    private Timestamp createdAt;
    
    private Timestamp updatedAt;

    public Invoice() {
    }

    public Invoice(Long saleId, String invoiceNumber, String customerName, String customerRut, String billingAddress, Double total, Double tax, Date issueDate, String status) {
        this.saleId = saleId;
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.customerRut = customerRut;
        this.billingAddress = billingAddress;
        this.total = total;
        this.tax = tax;
        this.issueDate = issueDate;
        this.status = status;
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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerRut() {
        return customerRut;
    }

    public void setCustomerRut(String customerRut) {
        this.customerRut = customerRut;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "Invoice{" + "id=" + id + ", saleId=" + saleId + ", invoiceNumber=" + invoiceNumber + ", customerName=" + customerName + ", customerRut=" + customerRut + ", billingAddress=" + billingAddress + ", total=" + total + ", tax=" + tax + ", issueDate=" + issueDate + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.saleId);
        hash = 59 * hash + Objects.hashCode(this.invoiceNumber);
        hash = 59 * hash + Objects.hashCode(this.customerName);
        hash = 59 * hash + Objects.hashCode(this.customerRut);
        hash = 59 * hash + Objects.hashCode(this.billingAddress);
        hash = 59 * hash + Objects.hashCode(this.total);
        hash = 59 * hash + Objects.hashCode(this.tax);
        hash = 59 * hash + Objects.hashCode(this.issueDate);
        hash = 59 * hash + Objects.hashCode(this.status);
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
        final Invoice other = (Invoice) obj;
        if (!Objects.equals(this.invoiceNumber, other.invoiceNumber)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.customerRut, other.customerRut)) {
            return false;
        }
        if (!Objects.equals(this.billingAddress, other.billingAddress)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.saleId, other.saleId)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        if (!Objects.equals(this.issueDate, other.issueDate)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return Objects.equals(this.updatedAt, other.updatedAt);
    }
    
}
