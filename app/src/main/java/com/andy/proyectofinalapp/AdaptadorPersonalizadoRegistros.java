package com.andy.proyectofinalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andy.proyectofinalapp.entidad.Producto;
import com.andy.proyectofinalapp.entidad.Registro;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersonalizadoRegistros extends RecyclerView.Adapter<AdaptadorPersonalizadoRegistros.MiviewHolder3> {
    private Context context;
    private List<Registro> listaregistros = new ArrayList<>();

    public AdaptadorPersonalizadoRegistros(Context context, List<Registro> listaregistros){
        this.context = context;
        this.listaregistros = listaregistros;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizadoRegistros.MiviewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.fila_registros_notifica,parent, false);
        return new MiviewHolder3(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizadoRegistros.MiviewHolder3 holder, int position) {
        holder.filamensaje.setText(listaregistros.get(position).getMensajeRegistro()+ "");
    }

    @Override
    public int getItemCount() {
        return listaregistros.size();
    }

    public class MiviewHolder3 extends RecyclerView.ViewHolder {
        TextView filamensaje;
        public MiviewHolder3(@NonNull View itemView) {
            super(itemView);
            filamensaje = itemView.findViewById(R.id.filaMensajeImport);
        }
    }
}
