package com.lp.pos_android_app.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lp.pos_android_app.database.dataBase.MyDataBAseHelper;
import com.lp.pos_android_app.model.Product;

import java.util.ArrayList;

public class ProductDAO {
    MyDataBAseHelper helper;
    private SQLiteDatabase db;
    private final String nom_table="Product";
    public ProductDAO(MyDataBAseHelper helper) {
        this.helper = helper;
        db=helper.getWritableDatabase();
    }

    public long ajouterProduit(Product p){
        ContentValues values=new ContentValues();
        values.put("nameProd",p.getNameProd());
        values.put("price",p.getPrice());
        values.put("idCat",p.getIdCat());
        values.put("id_stock",p.getIdStock());
        long idp= db.insert(nom_table,null,values);
        return idp;
    }
    public void supprimerProduit(int code){
        db.delete(nom_table," idProd=?",new String[]{Integer.toString(code)});
    }
    private void modifierProduit(int codeOld,Product newProd){
        ContentValues values=new ContentValues();
        values.put("nameProd",newProd.getNameProd());
        values.put("price",newProd.getPrice());
        values.put("idCat",newProd.getIdCat());
        values.put("id_stock",newProd.getIdStock());
        db.update(nom_table,values,"idProd=?",new String[]{String.valueOf(codeOld)});
    }
    public ArrayList<Product> listerProduit(){
        ArrayList<Product> liste =new ArrayList<Product>();
        Cursor cursor=db.rawQuery("select * from "+nom_table,null);//
                cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int idProd=cursor.getInt(cursor.getColumnIndex("idProd"));
            String nameProd=cursor.getString(cursor.getColumnIndex("name"));
            double price=cursor.getDouble(cursor.getColumnIndex("price"));
            int idCat=cursor.getInt(cursor.getColumnIndex("idCat"));
            int idStock=cursor.getInt(cursor.getColumnIndex("id_stock"));
            Product pr=new Product(idProd,nameProd,price,idCat,idStock);
            liste.add(pr);
            cursor.moveToNext();
        }
        return liste;
    }

}
