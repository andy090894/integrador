package com.flores.appfogata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adaptador extends RecyclerView.Adapter<ViewHolder> {

    List<Fuente> ListaObjeto;
    public adaptador(List<Fuente> listaObjeto){
        ListaObjeto = listaObjeto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(vista,ListaObjeto);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(ListaObjeto.get(position).getTitulo());
        holder.imagen.setImageResource(ListaObjeto.get(position).getImagen());

    }

    @Override
    public int getItemCount() {
        return ListaObjeto.size();
    }
}
