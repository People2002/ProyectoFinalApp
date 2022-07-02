package com.andy.proyectofinalapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.andy.proyectofinalapp.entidad.Producto;
import com.andy.proyectofinalapp.modelo.DAOProducto;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersonalizadoElimi extends RecyclerView.Adapter<AdaptadorPersonalizadoElimi.MiviewHolder2>{
    private Context context;
    private List<Producto> listaproductos = new ArrayList<>();

    public AdaptadorPersonalizadoElimi(Context context, List<Producto> listaproductos){
        this.context = context;
        this.listaproductos = listaproductos;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizadoElimi.MiviewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.fila_eliminar_producto,parent, false);
        return new MiviewHolder2(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizadoElimi.MiviewHolder2 holder, @SuppressLint("RecyclerView") int position) {
        holder.filaNomEli.setText(listaproductos.get(position).getNombre() + "");
        holder.filaCanEli.setText("Can:" + listaproductos.get(position).getCantidad() + "");
        holder.filaElimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ventana = new AlertDialog.Builder(context);
                ventana.setTitle("Confirmar elminar");
                ventana.setMessage("Desea eliminar el auto "+listaproductos.get(position).getNombre()+"?");
                ventana.setNegativeButton("NO", null);
                ventana.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DAOProducto daoProducto = new DAOProducto(context);
                        daoProducto.abriBD();
                        String mensaje = daoProducto.eliminarProducto(listaproductos.get(position).getId());

                        AlertDialog.Builder ven2 = new AlertDialog.Builder(context);
                        ven2.setTitle("Mensaje Informativo");
                        ven2.setMessage(mensaje);
                        ven2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(context, eliminar4.class);
                                context.startActivity(intent);
                            }
                        });
                        ven2.create().show();
                    }
                });

                ventana.create().show();
            }
        });
    }

    @Override
    public int getItemCount() { return listaproductos.size();}

    public class MiviewHolder2 extends RecyclerView.ViewHolder {
        TextView filaNomEli, filaCanEli;
        ImageButton filaElimi;
        public MiviewHolder2(@NonNull View itemView) {
            super(itemView);
            filaNomEli = itemView.findViewById(R.id.filaNombreEli);
            filaCanEli = itemView.findViewById(R.id.filaCantidad_Nom_Eli);
            filaElimi = itemView.findViewById(R.id.filaEliminar);
        }
    }
}
