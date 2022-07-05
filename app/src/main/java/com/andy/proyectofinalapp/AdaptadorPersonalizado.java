package com.andy.proyectofinalapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andy.proyectofinalapp.entidad.Producto;
import com.andy.proyectofinalapp.util.ProductoBD;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.MiviewHolder> {
    private Context context;
    private List<Producto> listaproductos = new ArrayList<>();
    private List<Producto> listaproductosORIGINAL;

    public AdaptadorPersonalizado(Context context, List<Producto> listaproductos){
        this.context = context;
        this.listaproductos = listaproductos;

        listaproductosORIGINAL = new ArrayList<>();
        listaproductosORIGINAL.addAll(listaproductos);
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.MiviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.fila_producto,parent, false);
        return new MiviewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.MiviewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.filacantidad.setText(listaproductos.get(position).getCantidad() + " unidades");
        holder.filapasillo.setText("Pasillo "+listaproductos.get(position).getPasillo());
        holder.filanombre.setText(listaproductos.get(position).getNombre() + "");
        holder.filadescripcion.setText(listaproductos.get(position).getDetallesNombre() + "");
        holder.filabtnDetallesProducto.setOnClickListener(new View.OnClickListener() {
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
    }

    @Override
    public int getItemCount() { return listaproductos.size();}

    public class MiviewHolder extends RecyclerView.ViewHolder{
        TextView filacantidad, filapasillo, filanombre, filadescripcion;
        Button filabtnDetallesProducto;
        public MiviewHolder(@NonNull View itemView) {
            super(itemView);
            filacantidad = itemView.findViewById(R.id.filaUnidadesProd);
            filapasillo = itemView.findViewById(R.id.filaPasilloProd);
            filanombre = itemView.findViewById(R.id.filaNombreProd);
            filadescripcion = itemView.findViewById(R.id.filaDetallesProd);
            filabtnDetallesProducto = itemView.findViewById(R.id.filabtnProductoDetalles);
        }
    }

    public void filtrado(final String txtBuscarProducto){
        int longitud = txtBuscarProducto.length();
        if(longitud == 0){
            listaproductos.clear();
            listaproductos.addAll(listaproductosORIGINAL);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Producto> collecion = listaproductos.stream().filter(i -> i.getNombre().toLowerCase().contains(txtBuscarProducto.toLowerCase())).collect(Collectors.toList());
                listaproductos.clear();
                listaproductos.addAll(collecion);
            }else{
                for (Producto p: listaproductosORIGINAL) {
                    if(p.getNombre().toLowerCase().contains(txtBuscarProducto.toLowerCase())){
                        listaproductos.add(p);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
}
