package com.lp.pos_android_app.database.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDataBAseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME="androidDB.db";
    private static final Integer DATABASE_VERSION=1;


    public MyDataBAseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
