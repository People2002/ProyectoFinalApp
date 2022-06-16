package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_Trabajador extends AppCompatActivity {
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_trabajador);
        asignarReferencias();
    }

    private void asignarReferencias(){
        btnIniciarSesion = findViewById(R.id.btnIniciarSesionTraba);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Trabajador.this, Login_Trabajador_Opciones.class);
                startActivity(intent);
            }
        });
    }
}