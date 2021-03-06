package com.example.francorosi.finalandroid;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Franco Rosi on 16/02/2018.
 */
public interface PeliculasApi {
    @GET("peliculas")
    Call<List<Pelicula>> getPeliculas(); //El return type define como sera parseado automaticamente el response

    @GET("ranking")
    Call<List<Usuario>> getRanking(); //El return type define como sera parseado automaticamente el response



}
