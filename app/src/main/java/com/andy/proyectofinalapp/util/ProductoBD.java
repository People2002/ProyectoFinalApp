package com.andy.proyectofinalapp.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductoBD extends SQLiteOpenHelper {
    public ProductoBD(Context context){super(context, "probd_app.db", null, 12);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE productos" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "codigo TEXT NOT NULL, " +
                        "nombre TEXT NOT NULL, " +
                        "detallesNombre TEXT NOT NULL, " +
                        "cantidad INTEGER NOT NULL, " +
                        "pasillo INTEGER NOT NULL);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
