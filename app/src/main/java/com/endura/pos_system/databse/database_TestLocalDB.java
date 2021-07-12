package com.endura.pos_system.databse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database_TestLocalDB extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "pos.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "user";
    private static final String COLUM_ID = "id";
    private static final String COLUM_USERNAME = "username";
    private static final String COLUM_PASSWORD = "password";


    public database_TestLocalDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query=
                "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUM_ID + " INTERGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUM_USERNAME + " TEXT, " +
                        COLUM_PASSWORD + " INTEGER );";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
