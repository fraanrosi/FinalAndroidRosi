package com.example.francorosi.finalandroid;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

/**
 *  OnClickListener para las vistas de articulos de Pizza
 */
public class PeliculaOnClickListener implements View.OnClickListener{

    private Context context;
    private Pelicula pelicula;

    /**
     *
     * @param context necesario para inflar el ToastAlert
     * @param pelicula la pizza con los datos a pasarle al Details en onClick
     */
    public PeliculaOnClickListener(Context context, Pelicula pelicula) {
        this.context = context;
        this.pelicula = pelicula;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, pelicula.getTitulo(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, DetalleActivity.class);
        String peliculaSerializada = new Gson().toJson(pelicula);
        intent.putExtra("pelicula", peliculaSerializada);
        context.startActivity(intent);
    }
}
