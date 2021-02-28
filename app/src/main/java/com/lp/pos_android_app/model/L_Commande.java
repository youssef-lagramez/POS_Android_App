package com.lp.pos_android_app.model;

import java.util.Date;

public class L_Commande {
    private int idProduit;
    private int idCommande;
    private double quantity;
    private Date dateOrder;

    public L_Commande(int idProduit, int idCommande, double quantity, Date dateOrder) {
        this.idProduit = idProduit;
        this.idCommande = idCommande;
        this.quantity = quantity;
        this.dateOrder = dateOrder;
    }

    public L_Commande(double quantity, Date dateOrder) {
        this.quantity = quantity;
        this.dateOrder = dateOrder;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }
}
