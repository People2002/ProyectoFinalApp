package com.andy.proyectofinalapp.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RegistroBD extends SQLiteOpenHelper {
    public RegistroBD(Context context){super(context, "probd_app_regis2.db", null, 12);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE registros" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "mensajeRegistro TEXT NOT NULL);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
