package com.andy.proyectofinalapp.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.andy.proyectofinalapp.AdaptadorPersonalizadoElimi;
import com.andy.proyectofinalapp.entidad.Registro;
import com.andy.proyectofinalapp.util.RegistroBD;

import java.util.ArrayList;
import java.util.List;

public class DAORegistro {
    RegistroBD registroBD;
    SQLiteDatabase db;
    Context context;

    public DAORegistro(Context con){
        this.context = con;
        registroBD = new RegistroBD(con);
    }

    public void abriBD(){db = registroBD.getWritableDatabase();}

    public String registrarRegistro(Registro objRegistro){
        String respuesta = "";
        try{
            ContentValues valores = new ContentValues();
            valores.put("mensajeRegistro", objRegistro.getMensajeRegistro());

            long rpta = db.insert("registros", null, valores);
            if(rpta == -1) {
                respuesta = "Error al insertar";
            }else{
                respuesta = "Se registro correctamente";
            }
        }catch (Exception e){
            Log.d("===>", e.getMessage());
        }

        return respuesta;
    }

    public List<Registro> cargarRegistros(){
        List<Registro> listarRegistos = new ArrayList<>();
        try{
            Cursor c = db.rawQuery("SELECT * FROM registros", null);
            while (c.moveToNext()){
                listarRegistos.add(new Registro(c.getInt(0), c.getString(1)));
            }
        }catch (Exception e){
            Log.d("===>", e.getMessage());
        }
        return listarRegistos;
    }
}
