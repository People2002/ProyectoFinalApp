package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.andy.proyectofinalapp.entidad.Producto;
import com.andy.proyectofinalapp.modelo.DAOProducto;

import java.util.ArrayList;
import java.util.List;

public class Almacen_1 extends AppCompatActivity  implements SearchView.OnQueryTextListener{
    RecyclerView rvProdcutos;
    SearchView txtBuscarProducto;
    AdaptadorPersonalizado adaptador;

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


        daoProducto.abriBD();
        listaproductos = daoProducto.cargarProductos();
        adaptador = new AdaptadorPersonalizado(Almacen_1.this, listaproductos);
        rvProdcutos.setAdapter(adaptador);
        rvProdcutos.setLayoutManager(new LinearLayoutManager(Almacen_1.this));
    }
    private void asignarReferencias(){
        txtBuscarProducto = findViewById(R.id.txtBuscarProducto);
        rvProdcutos = findViewById(R.id.rv_productos);

        txtBuscarProducto.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adaptador.filtrado(s);
        return false;
    }
}