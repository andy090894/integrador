package com.flores.appfogata;

import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    Button btn1;
    ImageView imagen;
    TextView titulo;
    int Position;
    List<Fuente> ListaObjeto;


    public ViewHolder(@NonNull View itemView,List<Fuente> datos) {
        super(itemView);

        btn1 =(Button) itemView.findViewById(R.id.btn1);
        imagen= (ImageView) itemView.findViewById(R.id.imagen);
        titulo= (TextView) itemView.findViewById(R.id.texto);
        ListaObjeto= datos;

        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition() ;
        Fuente objeto = ListaObjeto.get(position); // obtengo el objeto en el cual se conformo mi row dentro de mi recyclerview

        if (view.getId() == btn1.getId()){
        Toast.makeText(btn1.getContext(),"Agrego la opcion " +objeto.getTitulo() + " Al carrito de compras ",Toast.LENGTH_SHORT).show();
    }
    }
}
