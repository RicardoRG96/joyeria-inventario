package com.mycompany.joyeriaInventario.view.tableModel;

import com.mycompany.joyeriaInventario.model.views.TopJewelView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TopJewelTableModel extends AbstractTableModel {

    private final String[] columns = {"ID", "Nombre", "Cantidad Total Vendida", "Ganancia Total"};
    
    private List<TopJewelView> topJewelsView = new ArrayList<>();
    
    public void setData(List<TopJewelView> topJewelsView) {
        this.topJewelsView = topJewelsView;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return topJewelsView.size();
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
        TopJewelView topJewelView = topJewelsView.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> topJewelView.getJewelId();
            case 1 -> topJewelView.getName();
            case 2 -> topJewelView.getTotalQuantitySold();
            case 3 -> topJewelView.getTotalRevenue();
            default -> null;  
        };
    }
    
    
    
}
