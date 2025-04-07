package com.mycompany.joyeriaInventario.view.tableModel;

import com.mycompany.joyeriaInventario.model.entities.Jewel;
import com.mycompany.joyeriaInventario.model.entities.Material;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class JewelryTableModel extends AbstractTableModel {

    private final String[] columns = {"ID", "Nombre", "Material", "Peso", "Precio", "Stock"};
    
    private List<Jewel> jewels = new ArrayList<>();
    
    private List<Material> materials = new ArrayList<>();

    public void setJewels(List<Jewel> jewels) {
        this.jewels = jewels;
        fireTableDataChanged();
    }
    
    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
    
    @Override
    public int getRowCount() {
        return jewels.size();
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
        Jewel jewel = jewels.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> jewel.getId();
            case 1 -> jewel.getName();
            case 2 -> getMaterialName(jewel.getMaterialId());
            case 3 -> jewel.getWeight();
            case 4 -> jewel.getPrice();
            case 5 -> jewel.getStock();
            default -> null;  
        };
    }
    
    private String getMaterialName(Long id) {
        return materials.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElseThrow()
                .getName();
    }
    
    public Jewel getJewelInRow(int row) {
        return jewels.get(row);
    }
    
}
