package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Almacen_Detalles_Producto extends AppCompatActivity {
    TextView lblNombre, lblCodigo, lblPasillo, lblStock;
    ImageView imagen;
    String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacen_detalles_producto);
        asignarReferencias();
        recuperarDatos();
        decidirFoto();
    }

    private void recuperarDatos(){
        lblNombre.setText(getIntent().getStringExtra("paramNombre"));
        lblCodigo.setText(getIntent().getStringExtra("paramCodigo"));
        lblPasillo.setText("Pasillo "+getIntent().getStringExtra("paramPasillo"));
        lblStock.setText(getIntent().getStringExtra("paramUnidades")+" unidades");
        nombre = getIntent().getStringExtra("paramName");
    }

    private void asignarReferencias() {
        lblNombre = findViewById(R.id.det_nombre_prod);
        lblCodigo = findViewById(R.id.det_codigo_prod);
        lblPasillo = findViewById(R.id.det_pasillo_prod);
        lblStock = findViewById(R.id.det_unidades_prod);
        imagen = findViewById(R.id.imageView2);
    }

    public static int stringCompare(String str1, String str2)
    {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        if (l1 != l2) {
            return l1 - l2;
        }
        else {
            return 0;
        }
    }

    void decidirFoto(){
        if(nombre.startsWith("Per")){
            imagen.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/pernos", null, getPackageName())));
        }
        if(nombre.startsWith("Ret")){
            imagen.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/reten", null, getPackageName())));
        }
        if(nombre.startsWith("Pino")){
            imagen.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/pinon", null, getPackageName())));
        }
        if(nombre.startsWith("Esfe")){
            imagen.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/esferas", null, getPackageName())));
        }
        if(nombre.startsWith("Baque")){
            imagen.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/baquelita", null, getPackageName())));
        }
    }
}