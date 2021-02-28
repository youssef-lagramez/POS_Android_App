package com.lp.pos_android_app.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lp.pos_android_app.database.dataBase.MyDataBAseHelper;
import com.lp.pos_android_app.model.Stock;

import java.util.ArrayList;

public class StockDAO {
    MyDataBAseHelper helper;
    private SQLiteDatabase db;
    private final String nom_table="Stock";
    public StockDAO(MyDataBAseHelper helper) {
        this.helper = helper;
        db=helper.getWritableDatabase();
    }

    public long ajouterStock(Stock p){
        ContentValues values=new ContentValues();
        values.put("quantity",p.getQuantityStock());

        long idp= db.insert(nom_table,null,values);
        return idp;
    }
    public void supprimerStock(int code){
        db.delete(nom_table," idStock=?",new String[]{Integer.toString(code)});
    }
    private void modifierStock(int codeOld,Stock newProd){
        ContentValues values=new ContentValues();
        values.put("quantity",newProd.getQuantityStock());
        db.update(nom_table,values,"idStock=?",new String[]{String.valueOf(codeOld)});
    }
    public ArrayList<Stock> listerStock(){
        ArrayList<Stock> liste =new ArrayList<Stock>();
        Cursor cursor=db.rawQuery("select * from "+nom_table,null);//
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int idStock=cursor.getInt(cursor.getColumnIndex("idStock"));
            double quantityStock=cursor.getDouble(cursor.getColumnIndex("quantityStock"));


            Stock pr=new Stock(idStock,quantityStock);
            liste.add(pr);
            cursor.moveToNext();
        }
        return liste;
    }
}
