package com.flores.appfogata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import Vista.LoginRequest;

public class Login extends AppCompatActivity {
     EditText usuarioT,claveT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView registro= (TextView)findViewById(R.id.registroLogin);
        Button btnLogin=(Button)findViewById(R.id.btnLogin);
        usuarioT=(EditText)findViewById(R.id.usuarioLogin);
        claveT=(EditText)findViewById(R.id.claveLogin);
        registro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent registro= new Intent(Login.this,Registro.class);
                Login.this.startActivity(registro);
                finish();
            }
        });
        btnLogin.setOnClickListener(new  View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (validar()==true){
                    final String usuario = usuarioT.getText().toString();
                final String clave = claveT.getText().toString();

                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if (ok == true) {
                                String nombre = jsonRespuesta.getString("nombre");
                                int edad = jsonRespuesta.getInt("edad");
                                Intent bienvenido = new Intent(Login.this, PrincipalActivity.class);
                                bienvenido.putExtra("nombre", nombre);
                                bienvenido.putExtra("edad", edad);
                                Login.this.startActivity(bienvenido);
                            } else {
                                AlertDialog.Builder alerta = new AlertDialog.Builder(Login.this);
                                alerta.setMessage("Usuario o Contraseña Incorrecto").setNegativeButton("Reintentar", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.getMessage();
                        }
                    }

                };
                LoginRequest r = new LoginRequest(usuario, clave, respuesta);
                RequestQueue cola = Volley.newRequestQueue(Login.this);
                cola.add(r);
            }
        }
            });
    }
    private boolean validar() {
        boolean retorno = true;
        String usuario,  password;
        usuario = usuarioT.getText().toString();
        password = claveT.getText().toString();
        if (usuario.isEmpty()) {
            usuarioT.setError("Ingrese su usuario");
            retorno = false;
        }
        if (password.isEmpty()) {
            claveT.setError("Ingrese su contraseña");
            retorno = false;
        }
        return retorno;
    }

}
