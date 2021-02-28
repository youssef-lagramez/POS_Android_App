package com.lp.pos_android_app.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lp.pos_android_app.model.L_Commande;
import com.lp.pos_android_app.database.dataBase.MyDataBAseHelper;

import java.util.ArrayList;
import java.util.Date;

public class L_CommandeDAO {
    MyDataBAseHelper helper;
    private SQLiteDatabase db;
    private final String nom_table="L_Commande";

    public L_CommandeDAO(MyDataBAseHelper helper) {
        this.helper = helper;
        db=helper.getWritableDatabase();
    }

    public long ajouterL_Commande(L_Commande p){
        ContentValues values=new ContentValues();
        values.put("quantityCmd",p.getQuantity());
        values.put("date",p.getDateOrder().toString());
        values.put("idProd",p.getIdProduit());
        values.put("idCmd",p.getIdCommande());
        long idp= db.insert(nom_table,null,values);
        return idp;
    }
    public void supprimerL_Commande(int code){
        db.delete(nom_table," idCmd=?",new String[]{Integer.toString(code)});
    }
    private void modifierL_Commande(int codeOld,L_Commande newComm){
        ContentValues values=new ContentValues();
        values.put("quantityCmd",newComm.getQuantity());
        values.put("date",newComm.getDateOrder().toString());
        values.put("idProd",newComm.getIdProduit());
        db.update(nom_table,values,"idCmd=?",new String[]{String.valueOf(codeOld)});
    }
    public ArrayList<L_Commande> listerL_Commande(){
        ArrayList<L_Commande> liste =new ArrayList<L_Commande>();
        Cursor cursor=db.rawQuery("select * from "+nom_table,null);//
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int idL_Commande=cursor.getInt(cursor.getColumnIndex("idCmd"));
            int idProd=cursor.getInt(cursor.getColumnIndex("idProd"));
            double qantityCmd=cursor.getDouble(cursor.getColumnIndex("quantityCmd"));
            Date dateOrder=new Date( cursor.getString(cursor.getColumnIndex("dateOrder")));
           


            L_Commande pr=new L_Commande(idL_Commande,idProd,qantityCmd,dateOrder);
            liste.add(pr);
            cursor.moveToNext();
        }
        return liste;
    }
}
