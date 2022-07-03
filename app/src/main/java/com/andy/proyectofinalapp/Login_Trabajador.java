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
                    String NomTra2 = txtNombreTra.getText().toString();
                    String NomTra3 = txtNombreTra.getText().toString();
                    String NomTra4 = txtNombreTra.getText().toString();
                    if (NomTra2.equals("Sebastian")){
                        txtNombreTra.setText("");
                        txtContraTra.setText("");
                        Intent intent = new Intent(Login_Trabajador.this, Login_Trabajador_Opciones.class);
                        startActivity(intent);
                    }
                    if (NomTra3.equals("Adrian")){
                        txtNombreTra.setText("");
                        txtContraTra.setText("");
                        Intent intent = new Intent(Login_Trabajador.this, Login2_Trabajador_Opciones.class);
                        startActivity(intent);
                    }
                    if (NomTra4.equals("Andy")){
                        txtNombreTra.setText("");
                        txtContraTra.setText("");
                        Intent intent = new Intent(Login_Trabajador.this, Login3_Trabajador_Opciones.class);
                        startActivity(intent);
                    }
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
        }
        if(!NomTra.equals("Sebastian") && ConTra.equals("N00206599")){
            valida = false;
            txtNombreTra.setError("Usuario incorrecto");
        }
        if(NomTra.equals("Sebastian") && !ConTra.equals("N00206599")){
            valida = false;
            txtContraTra.setError("Contraseña incorrecta");
        }


        if(NomTra.equals("Adrian") && ConTra.equals("N00206915")){
            valida = true;
        }
        if(!NomTra.equals("Adrian") && ConTra.equals("N00206915")){
            valida = false;
            txtNombreTra.setError("Usuario incorrecto");
        }
        if(NomTra.equals("Adrian") && !ConTra.equals("N00206915")){
            valida = false;
            txtContraTra.setError("Contraseña incorrecta");
        }


        if(NomTra.equals("Andy") && ConTra.equals("N00197416")){
            valida = true;
        }
        if(!NomTra.equals("Andy") && ConTra.equals("N00197416")){
            valida = false;
            txtNombreTra.setError("Usuario incorrecto");
        }
        if(NomTra.equals("Andy") && !ConTra.equals("N00197416")){
            valida = false;
            txtContraTra.setError("Contraseña incorrecta");
        }

        return valida;
    }
}