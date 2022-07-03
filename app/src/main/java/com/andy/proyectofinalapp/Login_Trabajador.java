package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.andy.proyectofinalapp.entidad.Producto;

public class Login_Trabajador extends AppCompatActivity {
    EditText txtNombreTra;
    EditText txtContraTra;
    Button btnIniciarSesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_trabajador);
        asignarReferencias();
    }

    private void asignarReferencias(){
        txtNombreTra = findViewById(R.id.txtUsuarioTra);
        txtContraTra = findViewById(R.id.txtContraTraba);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesionTraba);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(capturarDatos()){
                    Intent intent = new Intent(Login_Trabajador.this, Login_Trabajador_Opciones.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean capturarDatos(){
        boolean valida = false;
        String NomTra = txtNombreTra.getText().toString();
        String ConTra = txtContraTra.getText().toString();

        if(NomTra.equals("")){
            txtNombreTra.setError("Usuario es obligatorio");
            valida = false;
        }
        if(ConTra.equals("")){
            txtContraTra.setError("Contraseña es obligatorio");
            valida = false;
        }

        if(NomTra.equals("Sebastian") && ConTra.equals("N00206599")){
            valida = true;
            txtNombreTra.setText("");
            txtContraTra.setText("");
        }
        if(!NomTra.equals("Sebastian") && ConTra.equals("N00206599")){
            valida = false;
            txtNombreTra.setError("Usuario incorrecto");
        }
        if(NomTra.equals("Sebastian") && !ConTra.equals("N00206599")){
            valida = false;
            txtContraTra.setError("Contraseña incorrecta");
        }


        if(NomTra.equals("Adrian") && ConTra.equals("N00206600")){
            valida = true;
            txtNombreTra.setText("");
            txtContraTra.setText("");
        }
        if(!NomTra.equals("Adrian") && ConTra.equals("N00206600")){
            valida = false;
            txtNombreTra.setError("Usuario incorrecto");
        }
        if(NomTra.equals("Adrian") && !ConTra.equals("N00206600")){
            valida = false;
            txtContraTra.setError("Contraseña incorrecta");
        }


        if(NomTra.equals("Andy") && ConTra.equals("N00206601")){
            valida = true;
            txtNombreTra.setText("");
            txtContraTra.setText("");
        }
        if(!NomTra.equals("Andy") && ConTra.equals("N00206601")){
            valida = false;
            txtNombreTra.setError("Usuario incorrecto");
        }
        if(NomTra.equals("Andy") && !ConTra.equals("N00206601")){
            valida = false;
            txtContraTra.setError("Contraseña incorrecta");
        }

        return valida;
    }
}