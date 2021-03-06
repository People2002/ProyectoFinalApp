package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.andy.proyectofinalapp.entidad.Producto;
import com.andy.proyectofinalapp.modelo.DAOProducto;

import java.util.ArrayList;
import java.util.List;

public class Eliminar extends AppCompatActivity {
    RecyclerView rvProdcutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacen1);
        asignarReferencias();
        mostrarProductos();
    }

    private void mostrarProductos() {
        List<Producto> listaproductos = new ArrayList<>();
        DAOProducto daoProducto = new DAOProducto(this);
        AdaptadorPersonalizado adaptador;

        daoProducto.abriBD();
        listaproductos = daoProducto.cargarProductos();
        adaptador = new AdaptadorPersonalizado(Eliminar.this, listaproductos);
        rvProdcutos.setAdapter(adaptador);
        rvProdcutos.setLayoutManager(new LinearLayoutManager(Eliminar.this));
    }
    private void asignarReferencias(){
        rvProdcutos = findViewById(R.id.rv_productos);
    }
}