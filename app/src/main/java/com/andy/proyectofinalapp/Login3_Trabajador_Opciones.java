package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login3_Trabajador_Opciones extends AppCompatActivity {
    Button btnMerma, btnAlmac, btnSolic, btnRegis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3_trabajador_opciones);
        asignarReferencias();
    }

    private void asignarReferencias() {
        btnAlmac = findViewById(R.id.btnAlmacenTrabajadorOpcion3);
        btnMerma = findViewById(R.id.btnMermaTrabajadorOpcion3);
        btnSolic = findViewById(R.id.btnSolicitudesTrabajadorOpcion3);
        btnRegis = findViewById(R.id.btnRegistrosTrabajadorOpcion3);


        btnAlmac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login3_Trabajador_Opciones.this, Almacen_1.class);
                startActivity(intent);
            }
        });

        btnMerma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login3_Trabajador_Opciones.this, eliminar4.class);
                startActivity(intent);
            }
        });

        btnSolic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login3_Trabajador_Opciones.this, Solicitud_Trabajador_1.class);
                startActivity(intent);
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login3_Trabajador_Opciones.this, Registros1.class);
                startActivity(intent);
            }
        });


    }
}