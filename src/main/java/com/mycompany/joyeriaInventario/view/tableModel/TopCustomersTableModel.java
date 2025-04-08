package com.mycompany.joyeriaInventario.view.tableModel;

import com.mycompany.joyeriaInventario.model.views.TopCustomerView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TopCustomersTableModel extends AbstractTableModel {

    private final String[] columns = {"ID", "Nombre", "Compras Totales", "Total Gastado"};
    
    private List<TopCustomerView> topCustomersView = new ArrayList<>();
    
    public void setData(List<TopCustomerView> topCustomersView) {
        this.topCustomersView = topCustomersView;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return topCustomersView.size();
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
        TopCustomerView topCustomerView = topCustomersView.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> topCustomerView.getCustomerId();
            case 1 -> topCustomerView.getName();
            case 2 -> topCustomerView.getTotalSales();
            case 3 -> topCustomerView.getTotalSpent();
            default -> null;  
        };
    }
    
}
