package com.andy.proyectofinalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andy.proyectofinalapp.entidad.Producto;
import com.andy.proyectofinalapp.util.ProductoBD;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.MiviewHolder> {
    private Context context;
    private List<Producto> listaproductos = new ArrayList<>();

    public AdaptadorPersonalizado(Context context, List<Producto> listaproductos){
        this.context = context;
        this.listaproductos = listaproductos;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.MiviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.fila_producto,parent, false);
        return new MiviewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.MiviewHolder holder, int position) {
        holder.filacantidad.setText(listaproductos.get(position).getCantidad() + "");
        holder.filapasillo.setText(listaproductos.get(position).getPasillo() + "");
        holder.filanombre.setText(listaproductos.get(position).getNombre() + "");
        holder.filadescripcion.setText(listaproductos.get(position).getDetallesNombre() + "");
    }

    @Override
    public int getItemCount() { return listaproductos.size();}

    public class MiviewHolder extends RecyclerView.ViewHolder{
        TextView filacantidad, filapasillo, filanombre, filadescripcion;
        public MiviewHolder(@NonNull View itemView) {
            super(itemView);
            filacantidad = itemView.findViewById(R.id.filaUnidadesProd);
            filapasillo = itemView.findViewById(R.id.filaPasilloProd);
            filanombre = itemView.findViewById(R.id.filaNombreProd);
            filadescripcion = itemView.findViewById(R.id.filaDetallesProd);
        }
    }
}
