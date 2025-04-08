package com.mycompany.joyeriaInventario.model.views;

public class TopJewelView {

    private Long jewelId;
    
    private String name;
    
    private Long totalQuantitySold;
    
    private double totalRevenue;

    public TopJewelView() {
    }

    public TopJewelView(Long jewelId, String name, Long totalQuantitySold, double totalRevenue) {
        this.jewelId = jewelId;
        this.name = name;
        this.totalQuantitySold = totalQuantitySold;
        this.totalRevenue = totalRevenue;
    }

    public Long getJewelId() {
        return jewelId;
    }

    public void setJewelId(Long jewelId) {
        this.jewelId = jewelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalQuantitySold() {
        return totalQuantitySold;
    }

    public void setTotalQuantitySold(Long totalQuantitySold) {
        this.totalQuantitySold = totalQuantitySold;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "TopJewelView{" + "jewelId=" + jewelId + ", name=" + name + ", totalQuantitySold=" + totalQuantitySold + ", totalRevenue=" + totalRevenue + '}';
    }
    
}
