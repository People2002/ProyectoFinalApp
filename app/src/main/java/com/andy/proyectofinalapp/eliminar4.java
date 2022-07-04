package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import com.andy.proyectofinalapp.entidad.Producto;
import com.andy.proyectofinalapp.modelo.DAOProducto;

import java.util.ArrayList;
import java.util.List;

public class eliminar4 extends AppCompatActivity implements SearchView.OnQueryTextListener{
    RecyclerView rvProdcutos;
    SearchView txtBuscarMerma;
    AdaptadorPersonalizadoElimi adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar4);
        asignarReferencias2();
        mostrarProductos2();
    }

    private void mostrarProductos2() {
        List<Producto> listaproductos = new ArrayList<>();
        DAOProducto daoProducto = new DAOProducto(this);

        daoProducto.abriBD();
        listaproductos = daoProducto.cargarProductos();
        adaptador = new AdaptadorPersonalizadoElimi(eliminar4.this, listaproductos);
        rvProdcutos.setAdapter(adaptador);
        rvProdcutos.setLayoutManager(new LinearLayoutManager(eliminar4.this));
    }
    private void asignarReferencias2(){
        rvProdcutos = findViewById(R.id.rv_productosEli);
        txtBuscarMerma = findViewById(R.id.txtBuscarMerma);
        txtBuscarMerma.setOnQueryTextListener(this);
        int id = txtBuscarMerma.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView) txtBuscarMerma.findViewById(id);
        textView.setTextColor(Color.BLACK);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adaptador.filtrado2(s);
        return false;
    }
}