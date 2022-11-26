package com.flores.appfogata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.flores.appfogata.Controlador.MyAPIAdapter;
import com.flores.appfogata.Modelo.Comida;
import com.flores.appfogata.Modelo.UResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Bienvenido extends AppCompatActivity implements Callback<UResponse> {
    int currentRow = 0;
    private RecyclerView recyclerView;
    private ArrayList<Comida> arregloMain;
    private MyLocalAdapter listAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);


        final TextView mensaje = (TextView) findViewById(R.id.mensaje);
        Intent i = this.getIntent();
        String nombre = i.getStringExtra("nombre");
        int edad = i.getIntExtra("edad", -1);
        mensaje.setText(mensaje.getText() + ": " + nombre + " edad:" + edad + "");
        recyclerView = (RecyclerView) findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<UResponse> call = MyAPIAdapter.getApiService().getComidas();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<UResponse> call, Response<UResponse> response) {
        if (response.isSuccessful()) {
            UResponse respuesta = response.body();
            Log.d("onResponse RETRO", "Tamaño del array=> " + respuesta.getComidas().size());
            List<Comida> comidas = respuesta.getComidas();
            ArrayList<Comida> lista = new ArrayList<Comida>();
            Integer i = 1;
            for (Comida comida : comidas) {
                lista.add(new Comida(i, comida.getNombre().toString(), comida.getPrecio().toString(), comida.getContenido().toString(),comida.getUrlC().toString()));
                i = i + 1;
            }

            if (arregloMain != null)
                arregloMain.clear();
            arregloMain = lista;
            listAdapter = new MyLocalAdapter(this, arregloMain);
            recyclerView.setAdapter(listAdapter);
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailure(Call<UResponse> call, Throwable t) {

    }

    class MyLocalAdapter extends RecyclerView.Adapter<MyLocalAdapter.LocalViewHolder> {

        private Context context;
        private List<Comida> data;

        public MyLocalAdapter(Context context, ArrayList<Comida> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public MyLocalAdapter.LocalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.row_comida, null);
            MyLocalAdapter.LocalViewHolder customViewHolder = new MyLocalAdapter.LocalViewHolder(view);
            return customViewHolder;
        }

        @Override
        public void onBindViewHolder(MyLocalAdapter.LocalViewHolder holder, int position) {

            Comida fila = data.get(position);

            Glide.with(context)
                    .load(fila.getUrlC())
                    .into(holder.imageMain);

            holder.labelNombre.setText(fila.getNombre());
            holder.labelPrecio.setText(fila.getPrecio());
            holder.labelContenido.setText(fila.getContenido());

        }

        @Override
        public int getItemCount() {
            return data == null ? 0 : data.size();
        }

        class LocalViewHolder extends RecyclerView.ViewHolder
                implements View.OnClickListener, View.OnLongClickListener {
            protected ImageView imageMain;
            protected View rowView;
            protected TextView labelNombre;
            protected TextView labelPrecio, labelContenido;
            protected ImageView iconoTelefono;
            protected Button btn1;

            public LocalViewHolder(View itemView) {
                super(itemView);
                this.imageMain = (ImageView) itemView.findViewById(R.id.logotipo);
                this.labelNombre = (TextView) itemView.findViewById(R.id.nombre);
                this.labelPrecio = (TextView) itemView.findViewById(R.id.precio);
                this.labelContenido = (TextView) itemView.findViewById(R.id.contenido);
                this.iconoTelefono = (ImageView) itemView.findViewById(R.id.iconoprecio);
                itemView.setOnClickListener(this);
                this.iconoTelefono.setOnLongClickListener(this);
                this.rowView = itemView;
            }

            @Override
            public void onClick(View v) {
                currentRow = getAdapterPosition();
                if (currentRow < 0)
                    currentRow = 0;
                Comida objE = data.get(currentRow);
                Toast.makeText(getApplicationContext(), objE.getNombre(), Toast.LENGTH_SHORT).show();
            }


            @Override
            public boolean onLongClick(View v) {
                currentRow = getAdapterPosition();
                if (currentRow < 0)
                    currentRow = 0;
                Comida objE = data.get(currentRow);

                /// Llamar por telefono
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", objE.getContenido(), null));
                startActivity(intent);

                return false;
            }
        }
    }
}
