package com.flores.appfogata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import Vista.RegistroRequest;

public class PerfilActivity extends AppCompatActivity {
    EditText usuarioT,nombreT,apellidoT,claveT,edadT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        usuarioT= (EditText) findViewById(R.id.usuarioModificar);
        nombreT= (EditText) findViewById(R.id.nombreModificar);
        apellidoT= (EditText) findViewById(R.id.apellidoModificar);
        claveT= (EditText) findViewById(R.id.claveCambiar);
        edadT= (EditText) findViewById(R.id.edadCambiar);
        final Button btnRegistro= (Button) findViewById(R.id.btnContinuar);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valida() == true) {
                    String usuario = usuarioT.getText().toString();
                    String nombre = nombreT.getText().toString();
                    String apellido = apellidoT.getText().toString();
                    String clave = claveT.getText().toString();
                    int edad = Integer.parseInt(edadT.getText().toString());
                    Response.Listener<String> respuesta = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonRespuesta = new JSONObject(response);
                                boolean ok = jsonRespuesta.getBoolean("success");


                                if (ok == true) {
                                    Intent i = new Intent(PerfilActivity.this, PrincipalActivity.class);
                                    PerfilActivity.this.startActivity(i);
                                    PerfilActivity.this.finish();
                                } else {
                                    AlertDialog.Builder alerta = new AlertDialog.Builder(PerfilActivity.this);
                                    alerta.setMessage("Falló en el registro").setNegativeButton("Reintentar", null).create().show();
                                }

                            } catch (JSONException e) {
                                e.getMessage();
                            }
                        }
                    };
                    RegistroRequest r = new RegistroRequest(usuario, nombre, apellido, clave, edad, respuesta);
                    RequestQueue cola = Volley.newRequestQueue(PerfilActivity.this);
                    cola.add(r);
                }
            }
        });
    }
    private boolean valida() {
        boolean retorna = true;
        String usuario,nombre,apellido,password,edad;

        usuario = usuarioT.getText().toString();
        nombre = nombreT.getText().toString();
        apellido = apellidoT.getText().toString();
        password = claveT.getText().toString();
        edad = edadT.getText().toString();
        if (usuario.isEmpty()) {
            usuarioT.setError("Ingrese su usuario");
            retorna = false;
        }
        if (password.isEmpty()) {
            claveT.setError("Ingrese su contraseña");
            retorna = false;
        }
        if(nombre.isEmpty()){
            nombreT.setError("Ingrese su nombre");
            retorna =false;
        }
        if(apellido.isEmpty()){
            apellidoT.setError("Ingrese su apellido");
            retorna =false;
        }
        if(edad.isEmpty()){
            edadT.setError("Ingrese su edad");
            retorna =false;
        }
        return retorna;
    }

}