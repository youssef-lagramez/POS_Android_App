package com.lp.pos_android_app.model;

public class Contact {
    private int idContact;
    private String telephone;
    private String nameSupplier;
    private String type;

    public Contact(int idContact, String telephone, String nameSupplier, String type) {
        this.idContact = idContact;
        this.telephone = telephone;
        this.nameSupplier = nameSupplier;
        this.type = type;
    }

    public Contact(String telephone, String nameSupplier, String type) {
        this.telephone = telephone;
        this.nameSupplier = nameSupplier;
        this.type = type;
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
