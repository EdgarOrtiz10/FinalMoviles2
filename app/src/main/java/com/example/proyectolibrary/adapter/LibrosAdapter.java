package com.example.proyectolibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectolibrary.R;
import com.example.proyectolibrary.model.Libros;

import java.util.List;

public class LibrosAdapter extends RecyclerView.Adapter<LibrosAdapter.ViewHolder> {

    private List<Libros> libros;
    private Context context;

    public LibrosAdapter(List<Libros> movies, Context context) {
        this.libros = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_libros,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewTitulo.setText(libros.get(position).getTitulo());
        Glide.with(context).load(libros.get(position).getPortada()).into(holder.imageViewPortada);
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewPortada;
        private TextView textViewTitulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPortada = itemView.findViewById(R.id.imageViewPortada);
            textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
        }
    }
}
