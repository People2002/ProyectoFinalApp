package com.andy.proyectofinalapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.andy.proyectofinalapp.entidad.Producto;
import com.andy.proyectofinalapp.modelo.DAOProducto;

public class Solicitud_Trabajador_1 extends AppCompatActivity {
    EditText txtcodigo, txtnombre, txtdetallesNombre, txtcantidad, txtpasillo;
    Producto objProducto;
    Button btnRegistrar;

    boolean registrar = true;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_trabajador1);
        asignarReferencias();
    }

    private void asignarReferencias(){
        txtcodigo = findViewById(R.id.txtAgregarCodigo);
        txtnombre = findViewById(R.id.txtAgregarNombre);
        txtdetallesNombre = findViewById(R.id.txtAgregarDescripcion);
        txtcantidad = findViewById(R.id.txtAgregarCantidad);
        txtpasillo = findViewById(R.id.txtAgregarPasillo);
        btnRegistrar = findViewById(R.id.btnAgregarNuevoProducto);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(capturarDatos()){
                    DAOProducto daoProducto = new DAOProducto(Solicitud_Trabajador_1.this);
                    daoProducto.abriBD();

                    String mensaje;

                    if(registrar){
                        mensaje = daoProducto.registrarProducto(objProducto);
                    }else{
                        mensaje = daoProducto.modificarProducto(objProducto);
                    }


                    AlertDialog.Builder ventana = new AlertDialog.Builder(Solicitud_Trabajador_1.this);
                    ventana.setTitle("Mensaje Informativo");
                    ventana.setMessage(mensaje);
                    ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Solicitud_Trabajador_1.this, Login_Trabajador_Opciones.class);
                            startActivity(intent);
                        }
                    });
                    ventana.create().show();
                }
            }
        });
    };

    private boolean capturarDatos(){
        boolean valida = true;
        String cod = txtcodigo.getText().toString();
        String nom = txtnombre.getText().toString();
        String detalleNom = txtdetallesNombre.getText().toString();
        String cant = txtcantidad.getText().toString();
        String pasil = txtpasillo.getText().toString();

        if(cod.equals("")){
            txtcodigo.setError("Codigo es obligatorio");
            valida = false;
        }

        if(nom.equals("")){
            txtnombre.setError("Nombre es obligatorio");
            valida = false;
        }

        if(detalleNom.equals("")){
            txtdetallesNombre.setError("Descripcion es obligatorio");
            valida = false;
        }

        if(cant.equals("")){
            txtcantidad.setError("Cantidad es obligatorio");
            valida = false;
        }

        if(pasil.equals("")){
            txtpasillo.setError("Pasillo es obligatorio");
            valida = false;
        }


        if(valida){
            if(registrar) {
                objProducto = new Producto(cod, nom, detalleNom, Integer.parseInt(cant), Integer.parseInt(pasil));
            }else{
                objProducto = new Producto(id, cod, nom, detalleNom, Integer.parseInt(cant), Integer.parseInt(pasil));
            }

        }

        return valida;
    }
}