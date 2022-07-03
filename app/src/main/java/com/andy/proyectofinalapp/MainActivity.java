package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn01, btn02, btnMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Primera Prueba
        //Segunda Prueba
        //Tercera prueba
        //Cuarta Prueba
        //Quinta Prueba
        //HOLA MUNDO
        asignarReferencias();
    }

    private void asignarReferencias(){
        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btnMapa = findViewById(R.id.btnMapa);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login_Supervisor.class);
                startActivity(intent);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login_Trabajador.class);
                startActivity(intent);
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapaActivity.class);
                startActivity(intent);
            }
        });
    }
}