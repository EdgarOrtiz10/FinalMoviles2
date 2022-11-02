package com.example.proyectolibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.proyectolibrary.adapter.LibrosAdapter;
import com.example.proyectolibrary.model.Libros;
import com.example.proyectolibrary.network.ApiClient;
import com.example.proyectolibrary.network.ApiLibro;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Libros> libros;
    private RecyclerView recyclerView;
    private LibrosAdapter librosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewLibros);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        showLibros();
    }

    public void showLibros(){
        Call<List<Libros>> call = ApiClient.getClient().create(ApiLibro.class).getMovies();
        call.enqueue(new Callback<List<Libros>>() {
            @Override
            public void onResponse(Call<List<Libros>> call, Response<List<Libros>> response) {
                if(response.isSuccessful()){
                    libros = response.body();
                    librosAdapter = new LibrosAdapter(libros,getApplicationContext());
                    recyclerView.setAdapter(librosAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Libros>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR DE CONEXIÓN", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Regresar_Main(View view){
        finish();
        startActivity(new Intent(MainActivity.this , Login.class));
    }
}