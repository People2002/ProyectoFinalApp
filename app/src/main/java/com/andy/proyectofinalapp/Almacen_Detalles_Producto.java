package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Almacen_Detalles_Producto extends AppCompatActivity {
    TextView lblNombre, lblCodigo, lblPasillo, lblStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacen_detalles_producto);
        asignarReferencias();
        recuperarDatos();
    }

    private void recuperarDatos(){
        lblNombre.setText(getIntent().getStringExtra("paramNombre"));
        lblCodigo.setText(getIntent().getStringExtra("paramCodigo"));
        lblPasillo.setText("Pasillo "+getIntent().getStringExtra("paramPasillo"));
        lblStock.setText(getIntent().getStringExtra("paramUnidades")+" unidades");
    }

    private void asignarReferencias() {
        lblNombre = findViewById(R.id.det_nombre_prod);
        lblCodigo = findViewById(R.id.det_codigo_prod);
        lblPasillo = findViewById(R.id.det_pasillo_prod);
        lblStock = findViewById(R.id.det_unidades_prod);
    }
}