package com.lp.pos_android_app.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lp.pos_android_app.model.Commande;
import com.lp.pos_android_app.database.dataBase.MyDataBAseHelper;

import java.util.ArrayList;

public class CommandeDAO {
    MyDataBAseHelper helper;
    private SQLiteDatabase db;
    private final String nom_table="Commande";

    public CommandeDAO(MyDataBAseHelper helper) {
        this.helper = helper;
        db=helper.getWritableDatabase();
    }

    public long ajouterCommande(Commande p){
        ContentValues values=new ContentValues();
        long idp= db.insert(nom_table,null,values);
        return idp;
    }
    public void supprimerCommande(int code){
        db.delete(nom_table," idCmd=?",new String[]{Integer.toString(code)});
    }
    private void modifierCommande(int codeOld,Commande newProd){
        ContentValues values=new ContentValues();

        db.update(nom_table,values,"idCmd=?",new String[]{String.valueOf(codeOld)});
    }
    public ArrayList<Commande> listerCommande(){
        ArrayList<Commande> liste =new ArrayList<Commande>();
        Cursor cursor=db.rawQuery("select * from "+nom_table,null);//
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int idCommande=cursor.getInt(cursor.getColumnIndex("idCmd"));
            Commande pr=new Commande(idCommande);
            liste.add(pr);
            cursor.moveToNext();
        }
        return liste;
    }
}
