package com.lp.pos_android_app.model;

public class Product {
    private Integer idProd;
    private String nameProd;
    private Double price;
    private Integer idCat;
    private Integer idStock;

    public Product(String nameProd, Double price, Integer idCat, Integer idStock) {
        this.nameProd = nameProd;
        this.price = price;
        this.idCat = idCat;
        this.idStock = idStock;
    }

    public Product(Integer idProd, String nameProd, Double price, Integer idCat, Integer idStock) {
        this.idProd = idProd;
        this.nameProd = nameProd;
        this.price = price;
        this.idCat = idCat;
        this.idStock = idStock;
    }

    public Integer getIdStock() {
        return idStock;
    }



    public void setIdStock(Integer idStock) {
        this.idStock = idStock;
    }

    public Integer getIdCat() {
        return idCat;
    }

    public void setIdCat(Integer idCat) {
        this.idCat = idCat;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    public String getNameProd() {
        return nameProd;
    }

    public void setNameProd(String nameProd) {
        this.nameProd = nameProd;
    }
}
