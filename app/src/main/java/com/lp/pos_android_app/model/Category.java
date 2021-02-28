package com.lp.pos_android_app.model;

public class Category {
    private Integer idCat;
    private String nameCat;

    public Category(String nameCat) {
        this.nameCat = nameCat;
    }

    public Category(Integer idCat, String nameCat) {
        this.idCat = idCat;
        this.nameCat = nameCat;
    }

    public Integer getIdCat() {
        return idCat;
    }

    public void setIdCat(Integer idCat) {
        this.idCat = idCat;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }
}
