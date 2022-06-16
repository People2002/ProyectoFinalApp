package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_Trabajador_Opciones extends AppCompatActivity {

    Button btnAlmac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_trabajador_opciones);
        asignarReferencias();
    }

    private void asignarReferencias() {
        btnAlmac = findViewById(R.id.btnAlmacenTrabajadorOpcion);

        btnAlmac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Trabajador_Opciones.this, Almacen_1.class);
                startActivity(intent);
            }
        });


    }
}