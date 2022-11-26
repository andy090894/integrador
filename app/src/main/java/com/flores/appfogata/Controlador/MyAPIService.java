package com.flores.appfogata.Controlador;


import com.flores.appfogata.Modelo.UResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPIService {


    @GET("Obtener_comida.php")
    Call<UResponse> getComidas();



}
