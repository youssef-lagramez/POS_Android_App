package com.lp.pos_android_app.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lp.pos_android_app.model.Category;
import com.lp.pos_android_app.database.dataBase.MyDataBAseHelper;

import java.util.ArrayList;

public class CategoryDAO {
    MyDataBAseHelper helper;
    private SQLiteDatabase db;
    private final String nom_table="Category";
    public CategoryDAO(MyDataBAseHelper helper) {
        this.helper = helper;
        db=helper.getWritableDatabase();
    }

    public long ajouterCategory(Category p){
        ContentValues values=new ContentValues();
        values.put("nameCat",p.getNameCat());

        long idp= db.insert(nom_table,null,values);
        return idp;
    }
    public void supprimerCategory(int code){
        db.delete(nom_table," idCat=?",new String[]{Integer.toString(code)});
    }
    private void modifierCategory(int codeOld,Category newProd){
        ContentValues values=new ContentValues();
        values.put("nameCat",newProd.getNameCat());
        db.update(nom_table,values,"idCat=?",new String[]{String.valueOf(codeOld)});
    }
    public ArrayList<Category> listerCategory(){
        ArrayList<Category> liste =new ArrayList<Category>();
        Cursor cursor=db.rawQuery("select * from "+nom_table,null);//
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int idCategory=cursor.getInt(cursor.getColumnIndex("idCat"));
            String nameCat=cursor.getString(cursor.getColumnIndex("nameCat"));


            Category pr=new Category(idCategory,nameCat);
            liste.add(pr);
            cursor.moveToNext();
        }
        return liste;
    }
}
