package com.mycompany.joyeriaInventario.view.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SaleItemsTableModel extends AbstractTableModel {
    
    private final String[] columns = {"Joya", "Cantidad", "Precio", "Subtotal"};
    
    private List<SaleItemTableEntity> saleItems = new ArrayList<>();
    
    public List<SaleItemTableEntity> getSaleItems() {
        return saleItems;
    }
    
    public void addItems(SaleItemTableEntity saleItem) {
        this.saleItems.add(saleItem);
        fireTableDataChanged();
    }
    
    public void removeItem(int index) {
        this.saleItems.remove(index);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return saleItems.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SaleItemTableEntity saleItem = saleItems.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> saleItem.getJewelName();
            case 1 -> saleItem.getQuantity();
            case 2 -> saleItem.getPrice();
            case 3 -> saleItem.getSubtotal();
            default -> null;  
        };
    }
  
    public SaleItemTableEntity getSaleItemInRow(int row) {
        return saleItems.get(row);
    }
    
}
