package com.lp.pos_android_app.model;

public class Stock {
    private int idStock;
    private Double quantityStock;

    public Stock(Double quantityStock) {
        this.quantityStock = quantityStock;
    }

    public Stock(int idStock, Double quantityStock) {
        this.idStock = idStock;
        this.quantityStock = quantityStock;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Double getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(Double quantityStock) {
        this.quantityStock = quantityStock;
    }
}
