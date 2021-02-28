package com.lp.pos_android_app.database.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lp.pos_android_app.database.dataBase.MyDataBAseHelper;

public class DataBaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static  DataBaseAccess instance;
    // a private constructor for not initialise from outside
    private DataBaseAccess(Context context){
        this.openHelper = new MyDataBAseHelper(context);

    }
    //to return the single instance of database
    public static DataBaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DataBaseAccess(context);
        }
        return instance;
    }
    // to open the connection
    public void Open(){
        this.db=openHelper.getWritableDatabase();
    }
     // for closing the connection
    public void Close(){
        if (db!=null){
            this.db.close();
        }
    }


}
