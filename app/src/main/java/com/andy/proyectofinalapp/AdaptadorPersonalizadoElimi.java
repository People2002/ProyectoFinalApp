package com.andy.proyectofinalapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.andy.proyectofinalapp.entidad.Producto;
import com.andy.proyectofinalapp.entidad.Registro;
import com.andy.proyectofinalapp.modelo.DAOProducto;
import com.andy.proyectofinalapp.modelo.DAORegistro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdaptadorPersonalizadoElimi extends RecyclerView.Adapter<AdaptadorPersonalizadoElimi.MiviewHolder2>{
    private Context context;
    private List<Producto> listaproductos = new ArrayList<>();
    private List<Producto> listamermaORIGINAL;
    Registro objRegistro;

    public AdaptadorPersonalizadoElimi(Context context, List<Producto> listaproductos){
        this.context = context;
        this.listaproductos = listaproductos;
        listamermaORIGINAL = new ArrayList<>();
        listamermaORIGINAL.addAll(listaproductos);
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
        holder.filaNomEli.setText(listaproductos.get(position).getDetallesNombre() + "");
        holder.filaCanEli.setText("Can:" + listaproductos.get(position).getCantidad() + "");
        holder.filaDeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Almacen_Detalles_Producto.class);
                intent.putExtra("paramId", listaproductos.get(position).getId()+"");
                intent.putExtra("paramCodigo", listaproductos.get(position).getCodigo()+"");
                intent.putExtra("paramName", listaproductos.get(position).getNombre()+"");
                intent.putExtra("paramNombre", listaproductos.get(position).getDetallesNombre()+"");
                intent.putExtra("paramPasillo", listaproductos.get(position).getPasillo()+"");
                intent.putExtra("paramUnidades", listaproductos.get(position).getCantidad()+"");
                context.startActivity(intent);
            }
        });
        holder.filaElimi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder ventana = new AlertDialog.Builder(context);
                ventana.setTitle("Confirmar elminar");
                ventana.setMessage("Desea eliminar el producto "+listaproductos.get(position).getNombre()+"?");
                ventana.setNegativeButton("NO", null);
                ventana.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DAOProducto daoProducto = new DAOProducto(context);
                        daoProducto.abriBD();
                        String mensaje = daoProducto.eliminarProducto(listaproductos.get(position).getId());

                        ////////
                        String mensaj = "Se elimino el producto " + listaproductos.get(position).getNombre() + " por ser inservible en su estado actual.";
                        objRegistro = new Registro(mensaj);

                        DAORegistro daoRegistro = new DAORegistro(context);
                        daoRegistro.abriBD();
                        String mensaje22;
                        mensaje22 = daoRegistro.registrarRegistro(objRegistro);
                        /////////

                        AlertDialog.Builder ven2 = new AlertDialog.Builder(context);
                        ven2.setTitle("Mensaje Informativo");
                        ven2.setMessage(mensaje);
                        ven2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(context, Login_Trabajador_Opciones.class);
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
        Button filaDeta;
        public MiviewHolder2(@NonNull View itemView) {
            super(itemView);
            filaNomEli = itemView.findViewById(R.id.filaNombreEli);
            filaCanEli = itemView.findViewById(R.id.filaCantidad_Nom_Eli);
            filaElimi = itemView.findViewById(R.id.filaEliminar);
            filaDeta= itemView.findViewById(R.id.filabtn_detalles_elim_prod);
        }
    }

    public void filtrado2(String txtBuscarMerma){
        int longitud = txtBuscarMerma.length();
        if (longitud == 0){
            listaproductos.clear();
            listaproductos.addAll(listamermaORIGINAL);
        }else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Producto> collecion = listaproductos.stream().filter(i -> i.getNombre().toLowerCase().contains(txtBuscarMerma.toLowerCase())).collect(Collectors.toList());
                listaproductos.clear();
                listaproductos.addAll(collecion);
            }else{
                for (Producto p: listamermaORIGINAL) {
                    if(p.getNombre().toLowerCase().contains(txtBuscarMerma.toLowerCase())){
                        listaproductos.add(p);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
}
