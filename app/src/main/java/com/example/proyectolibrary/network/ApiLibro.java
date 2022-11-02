package com.example.proyectolibrary.network;

import com.example.proyectolibrary.model.Libros;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiLibro {
    @GET("movies/list.php")
    Call<List<Libros>> getMovies();
}
