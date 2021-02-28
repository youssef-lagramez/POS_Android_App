package com.lp.pos_android_app.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lp.pos_android_app.model.Contact;
import com.lp.pos_android_app.database.dataBase.MyDataBAseHelper;

import java.util.ArrayList;

public class ContactDAO {
    MyDataBAseHelper helper;
    private SQLiteDatabase db;
    private final String nom_table="Contact";

    public ContactDAO(MyDataBAseHelper helper) {
        this.helper = helper;
        db=helper.getWritableDatabase();
    }

    public long ajouterContact(Contact p){
        ContentValues values=new ContentValues();
        values.put("nameSupplier",p.getNameSupplier());
        values.put("Telephone",p.getTelephone());
        values.put("Type",p.getType());

        long idp= db.insert(nom_table,null,values);
        return idp;
    }
    public void supprimerContact(int code){
        db.delete(nom_table," idContact=?",new String[]{Integer.toString(code)});
    }
    private void modifierContact(int codeOld,Contact newProd){
        ContentValues values=new ContentValues();
        values.put("nameSupplier",newProd.getNameSupplier());
        values.put("Telephone",newProd.getTelephone());
        values.put("Type",newProd.getType());
        db.update(nom_table,values,"idContact=?",new String[]{String.valueOf(codeOld)});
    }
    public ArrayList<Contact> listerContact(){
        ArrayList<Contact> liste =new ArrayList<Contact>();
        Cursor cursor=db.rawQuery("select * from "+nom_table,null);//
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int idContact=cursor.getInt(cursor.getColumnIndex("idContact"));
            String nameSupplier=cursor.getString(cursor.getColumnIndex("nameSupplier"));
            String telephone=cursor.getString(cursor.getColumnIndex("Telephone"));
            String type=cursor.getString(cursor.getColumnIndex("Type"));


            Contact pr=new Contact(idContact,telephone,nameSupplier,type);
            liste.add(pr);
            cursor.moveToNext();
        }
        return liste;
    }
}
