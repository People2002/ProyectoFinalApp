package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login2_Trabajador_Opciones extends AppCompatActivity {
    Button btnMerma, btnAlmac, btnSolic, btnRegis, btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2_trabajador_opciones);
        asignarReferencias();
    }

    private void asignarReferencias() {
        btnAlmac = findViewById(R.id.btnAlmacenTrabajadorOpcion2);
        btnMerma = findViewById(R.id.btnMermaTrabajadorOpcion2);
        btnSolic = findViewById(R.id.btnSolicitudesTrabajadorOpcion2);
        btnRegis = findViewById(R.id.btnRegistrosTrabajadorOpcion2);
        btnReturn = findViewById(R.id.btnSalir_Regresar2);


        btnAlmac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login2_Trabajador_Opciones.this, Almacen_1.class);
                startActivity(intent);
            }
        });

        btnMerma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login2_Trabajador_Opciones.this, eliminar4.class);
                startActivity(intent);
            }
        });

        btnSolic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login2_Trabajador_Opciones.this, Solicitud_Trabajador_1.class);
                startActivity(intent);
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login2_Trabajador_Opciones.this, Registros1.class);
                startActivity(intent);
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login2_Trabajador_Opciones.this, MainActivity.class);
                startActivity(intent);
            }

        });


    }
}