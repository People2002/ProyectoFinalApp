package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_Supervisor extends AppCompatActivity {
    EditText txtNombreSup;
    EditText txtContraSup;
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_supervisor);
        asignarReferencias();
    }

    private void asignarReferencias(){
        txtNombreSup = findViewById(R.id.txtUsuarioSup);
        txtContraSup = findViewById(R.id.txtContraSupe);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(capturarDatos()){

                    Intent intent = new Intent(Login_Supervisor.this, Login_Supervisor_Opciones.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean capturarDatos(){
        boolean valida = false;
        String NomSup = txtNombreSup.getText().toString();
        String ConSup = txtContraSup.getText().toString();

        if(NomSup.equals("")){
            txtNombreSup.setError("Usuario es obligatorio");
            valida = false;
        }
        if(ConSup.equals("")){
            txtContraSup.setError("Contraseña es obligatorio");
            valida = false;
        }
        if(NomSup.equals("Estefano") && !ConSup.equals("N00206969")){
            valida = false;
            txtContraSup.setError("Contraseña incorrecta");
        }
        if(!NomSup.equals("Estefano") && ConSup.equals("N00206969")){
            valida = false;
            txtNombreSup.setError("Usuario incorrecto");
        }

        if(NomSup.equals("Estefano") && ConSup.equals("N00206969")){
            valida = true;
            txtNombreSup.setText("");
            txtContraSup.setText("");
        }
        return valida;
    }
}