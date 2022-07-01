package com.andy.proyectofinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Empleado_1 extends AppCompatActivity {

    ImageButton btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado1);
        asignarReferencias();
    }

    private void asignarReferencias() {
        btn1 = findViewById(R.id.emp_btn1);
        btn2 = findViewById(R.id.emp_btn2);
        btn3 = findViewById(R.id.emp_btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Empleado_1.this, Empleado_2.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Empleado_1.this, Empleado_3.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Empleado_1.this, Empleado_4.class);
                startActivity(intent);
            }
        });


    }
}