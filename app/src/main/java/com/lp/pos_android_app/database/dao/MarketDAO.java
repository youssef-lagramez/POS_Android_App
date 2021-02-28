package com.lp.pos_android_app.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lp.pos_android_app.model.Market;
import com.lp.pos_android_app.database.dataBase.MyDataBAseHelper;

import java.util.ArrayList;

public class MarketDAO {
    MyDataBAseHelper helper;
    private SQLiteDatabase db;
    private final String nom_table="Market";

    public MarketDAO(MyDataBAseHelper helper) {
        this.helper = helper;
        db=helper.getWritableDatabase();
    }

    public long ajouterMarket(Market p){
        ContentValues values=new ContentValues();
        values.put("password",p.getPassword());
        values.put("nameMarket",p.getNameMarket());


        long idp= db.insert(nom_table,null,values);
        return idp;
    }
    public void supprimerMarket(int code){
        db.delete(nom_table," id=?",new String[]{Integer.toString(code)});
    }
    private void modifierMarket(int codeOld,Market newProd){
        ContentValues values=new ContentValues();
        values.put("password",newProd.getPassword());
        values.put("nameMarket",newProd.getNameMarket());
        db.update(nom_table,values,"id=?",new String[]{String.valueOf(codeOld)});
    }
    public ArrayList<Market> listerMarket(){
        ArrayList<Market> liste =new ArrayList<Market>();
        Cursor cursor=db.rawQuery("select * from "+nom_table,null);//
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int idMarket=cursor.getInt(cursor.getColumnIndex("id"));
            String nameMarket=cursor.getString(cursor.getColumnIndex("nameMarket"));
            String password=cursor.getString(cursor.getColumnIndex("password"));



            Market pr=new Market(idMarket,password,nameMarket);
            liste.add(pr);
            cursor.moveToNext();
        }
        return liste;
    }
}
