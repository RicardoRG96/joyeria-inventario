package com.mycompany.joyeriaInventario.view.tableModel;

import com.mycompany.joyeriaInventario.model.entities.Customer;
import com.mycompany.joyeriaInventario.model.entities.Sale;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SalesTableModel extends AbstractTableModel {

    private final String[] columns = {"ID", "Cliente", "Total"};
    
    private List<Sale> sales = new ArrayList<>();
    
    private List<Customer> customers = new ArrayList<>();

    public void setSales(List<Sale> sales) {
        this.sales = sales;
        fireTableDataChanged();
    }
    
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    
    @Override
    public int getRowCount() {
        return sales.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sale sale = sales.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> sale.getId();
            case 1 -> getCustomerName(sale.getCustomerId());
            case 2 -> sale.getTotal();
            default -> null;  
        };
    }
    
    private String getCustomerName(Long id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow()
                .getName();
    }
    
    public Sale getSaleInRow(int row) {
        return sales.get(row);
    }
    
}
