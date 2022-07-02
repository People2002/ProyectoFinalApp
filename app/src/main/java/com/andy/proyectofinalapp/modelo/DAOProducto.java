package com.andy.proyectofinalapp.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.andy.proyectofinalapp.entidad.Producto;
import com.andy.proyectofinalapp.util.ProductoBD;

import java.util.ArrayList;
import java.util.List;

public class DAOProducto {
    ProductoBD productoBD;
    SQLiteDatabase db;
    Context context;

    public DAOProducto(Context con){
        this.context = con;
        productoBD = new ProductoBD(con);
    }

    public void abriBD(){db = productoBD.getWritableDatabase();}

    public String registrarProducto(Producto objProducto){
        String respuesta = "";
        try{
            ContentValues valores = new ContentValues();
            valores.put("codigo", objProducto.getCodigo());
            valores.put("nombre", objProducto.getNombre());
            valores.put("detallesNombre", objProducto.getDetallesNombre());
            valores.put("cantidad", objProducto.getCantidad());
            valores.put("pasillo", objProducto.getPasillo());

            long rpta = db.insert("productos", null, valores);
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

    public String modificarProducto(Producto objProducto){
        String respuesta = "";

        try{
            ContentValues valores = new ContentValues();
            valores.put("codigo", objProducto.getCodigo());
            valores.put("nombre", objProducto.getNombre());
            valores.put("detallesNombre", objProducto.getDetallesNombre());
            valores.put("cantidad", objProducto.getCantidad());
            valores.put("pasillo", objProducto.getPasillo());

            long rpta = db.update("productos", valores, "id="+objProducto.getId(), null);
            if(rpta == -1) {
                respuesta = "Error al actualizar";
            }else{
                respuesta = "Se actualizo correctamente";
            }
        }catch (Exception e){
            Log.d("===>", e.getMessage());
        }
        return respuesta;
    }

    public String eliminarProducto(int id){
        String respuesta = "";

        try{
            long rpta = db.delete("productos", "id="+id, null);
            if(rpta == -1) {
                respuesta = "Error al eliminar";
            }else{
                respuesta = "Se elimino correctamente";
            }
        }catch (Exception e){
            Log.d("===>", e.getMessage());
        }

        return respuesta;
    }

    public List<Producto> cargarProductos(){
        List<Producto> listarProductos = new ArrayList<>();
        try{
            Cursor c = db.rawQuery("SELECT * FROM productos", null);
            while (c.moveToNext()){
                listarProductos.add(new Producto(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4), c.getInt(5)));
            }
        }catch (Exception e){
            Log.d("===>", e.getMessage());
        }
        return listarProductos;
    }
}
