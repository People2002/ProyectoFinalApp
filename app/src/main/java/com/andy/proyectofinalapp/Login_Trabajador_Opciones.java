package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login_Trabajador_Opciones extends AppCompatActivity {

    Button btnMerma, btnAlmac, btnSolic, btnRegis, btnReturn;
    TextView lblNombre, lblCodigo;
    String nombre, codigo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_trabajador_opciones);
        asignarReferencias();
        recuperarDatos();
    }

    private void recuperarDatos(){
        lblNombre.setText("Bienvenido "+getIntent().getStringExtra("paramNombre")+"!");
        lblCodigo.setText("Cod: "+getIntent().getStringExtra("paramCodigo"));
        nombre = getIntent().getStringExtra("paramNombre");
        codigo = getIntent().getStringExtra("paramCodigo");
    }

    private void asignarReferencias() {
        lblNombre = findViewById(R.id.lblNombreTrabajador);
        lblCodigo = findViewById(R.id.lblCodigoTrabajador);
        btnAlmac = findViewById(R.id.btnAlmacenTrabajadorOpcion);
        btnMerma = findViewById(R.id.btnMermaTrabajadorOpcion);
        btnSolic = findViewById(R.id.btnSolicitudesTrabajadorOpcion);
        btnRegis = findViewById(R.id.btnRegistrosTrabajadorOpcion);
        btnReturn = findViewById(R.id.btnSalir_Regresar);


        btnAlmac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Trabajador_Opciones.this, Almacen_1.class);
                startActivity(intent);
            }
        });

        btnMerma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Trabajador_Opciones.this, eliminar4.class);
                startActivity(intent);
            }
        });

        btnSolic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Trabajador_Opciones.this, Solicitud_Trabajador_1.class);
                intent.putExtra("paramNombre", nombre);
                intent.putExtra("paramCodigo", codigo);
                startActivity(intent);
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Trabajador_Opciones.this, Registros1.class);
                startActivity(intent);
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Trabajador_Opciones.this, MainActivity.class);
                startActivity(intent);
            }

        });


    }
}