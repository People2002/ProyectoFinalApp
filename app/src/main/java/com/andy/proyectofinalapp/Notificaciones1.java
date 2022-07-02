package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.andy.proyectofinalapp.entidad.Registro;
import com.andy.proyectofinalapp.modelo.DAORegistro;

import java.util.ArrayList;
import java.util.List;

public class Notificaciones1 extends AppCompatActivity {
    RecyclerView rvProdcutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones1);
        asignarReferencias();
        mostrarProductos();
    }

    private void mostrarProductos() {
        List<Registro> listaregistros = new ArrayList<>();
        DAORegistro daoRegistro = new DAORegistro(this);
        AdaptadorPersonalizadoRegistros adaptador;

        daoRegistro.abriBD();
        listaregistros = daoRegistro.cargarRegistros();
        adaptador = new AdaptadorPersonalizadoRegistros(Notificaciones1.this, listaregistros);
        rvProdcutos.setAdapter(adaptador);
        rvProdcutos.setLayoutManager(new LinearLayoutManager(Notificaciones1.this));
    }
    private void asignarReferencias(){
        rvProdcutos = findViewById(R.id.rv_productos_regis2);
    }
}