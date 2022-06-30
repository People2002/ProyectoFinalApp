package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_Supervisor_Opciones extends AppCompatActivity {

    Button btnSolic, btnAlmac, btnEmple, btnNoti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_supervisor_opciones);
        asignarReferencias();
    }

    private void asignarReferencias() {
        btnSolic = findViewById(R.id.btnSolicitudesSupervisorOpcion);
        btnAlmac = findViewById(R.id.btnAlmacenSupervisorOpcion);
        btnEmple = findViewById(R.id.btnEmpleadosSupervisorOpcion);
        btnNoti = findViewById(R.id.btnNotificacionesSupervisorOpcion);

        btnSolic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Supervisor_Opciones.this, Solicitud_Trabajador_1.class);
                startActivity(intent);
            }
        });

        btnAlmac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Supervisor_Opciones.this, Eliminar.class);
                startActivity(intent);
            }
        });

        btnEmple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Supervisor_Opciones.this, Empleado_1.class);
                startActivity(intent);
            }
        });

        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Supervisor_Opciones.this, Notificaciones1.class);
                startActivity(intent);
            }
        });


    }
}