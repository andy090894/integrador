package com.flores.appfogata;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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

public class PrincipalActivity extends AppCompatActivity implements Callback<UResponse> {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        recyclerView = (RecyclerView) findViewById(R.id.recicler_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // falta declarar el botton en el app_bar_principal_ widget

    }
    @Override
    public void onResponse(Call<UResponse> call, Response<UResponse> response) {

    }

    @Override
    public void onFailure(Call<UResponse> call, Throwable t) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_principal_drawer,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         if (item.getItemId()==R.id.nav_carrito){
             ActivityCarrito();
         }

        if (item.getItemId()==R.id.nav_categorias){
            ActivityCategoria();
        }
        if (item.getItemId()==R.id.nav_buscar){
            ActivityBuscar();
        }
        if (item.getItemId()==R.id.nav_perfil){
            ActivityPerfil();
        }
        if (item.getItemId()==R.id.nav_salir){
            //codigo para salir
        }
        return true;
    }

    private void ActivityPerfil() {
        Toast.makeText(this,"Perfil",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(PrincipalActivity.this,PerfilActivity.class);
        startActivity(intent);
    }

    private void ActivityBuscar() {
        Toast.makeText(this,"Buscar",Toast.LENGTH_SHORT).show();
    }

    private void ActivityCategoria() {
        Toast.makeText(this,"Categoria",Toast.LENGTH_SHORT).show();
    }

    private void ActivityCarrito() {
        Toast.makeText(this,"Carrito",Toast.LENGTH_SHORT).show();
    }
}
