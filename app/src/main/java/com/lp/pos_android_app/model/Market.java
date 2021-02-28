package com.lp.pos_android_app.model;

public class Market {
    private  int idMarket;
    private String password;
    private String nameMarket;

    public Market(int idMarket, String password, String nameMarket) {
        this.idMarket = idMarket;
        this.password = password;
        this.nameMarket = nameMarket;
    }

    public Market(String password, String nameMarket) {
        this.password = password;
        this.nameMarket = nameMarket;
    }

    public int getIdMarket() {
        return idMarket;
    }

    public void setIdMarket(int idMarket) {
        this.idMarket = idMarket;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameMarket() {
        return nameMarket;
    }

    public void setNameMarket(String nameMarket) {
        this.nameMarket = nameMarket;
    }
}
