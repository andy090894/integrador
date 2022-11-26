package com.flores.appfogata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Bienvenido extends AppCompatActivity {

    //private RecyclerView rvLista;
    //private adaptador adapter;
    //private List<itemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);


        final TextView mensaje=(TextView) findViewById(R.id.mensaje);
        Intent i = this.getIntent();
        String nombre = i.getStringExtra("nombre");
        int edad = i.getIntExtra("edad",-1);
        mensaje.setText(mensaje.getText()+": "+nombre+" edad:"+edad+"");

        ArrayList<Fuente> lista = new ArrayList<Fuente>();
        lista.add(new Fuente("1/4 de Pollo a la brasa",R.drawable.pollocuarto,0));
        lista.add(new Fuente("1/2 Pollo a la brasa",R.drawable.mediopollo,0));
        lista.add(new Fuente("1 Pollo a la brasa",R.drawable.pollobrasa,0));
            RecyclerView contenedor = (RecyclerView) findViewById(R.id.contenedor);
            contenedor.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        contenedor.setAdapter(new adaptador(lista));
        contenedor.setLayoutManager(layout);


    }

    //private void initViews(){
    //    rvLista= findViewById(R.id.rvLista);
    //}

    //private void initValues(){
    //    LinearLayoutManager manager= new LinearLayoutManager(this);
    //    rvLista.setLayoutManager(manager);

    //    items=getItems();
    //    adapter=new adaptador(items);
    //    rvLista.setAdapter(adapter);
    //}
    //private List<itemList> getItems(){
    //    List<itemList> itemLists=new ArrayList<>();
    //        itemLists.add(new itemList("Pollo a la brasa",R.drawable.pollobrasa));
    //    itemLists.add(new itemList("Parrillas",R.drawable.parrilas));
     //       return itemLists;
    //    }
    }
