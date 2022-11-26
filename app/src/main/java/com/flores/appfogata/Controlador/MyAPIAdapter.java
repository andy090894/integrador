package com.flores.appfogata.Controlador;

import com.flores.appfogata.Controlador.MyAPIService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyAPIAdapter {

    private static MyAPIService API_SERVICE;

    public static MyAPIService getApiService(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl ="http://192.168.1.70/";
        if (API_SERVICE == null){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            API_SERVICE = retrofit.create(MyAPIService.class);
        }
            return API_SERVICE;
    }
}
