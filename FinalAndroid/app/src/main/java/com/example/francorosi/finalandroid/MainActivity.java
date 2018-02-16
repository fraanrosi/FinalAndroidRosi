package com.example.francorosi.finalandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    ListView listaPeliculas;
    ArrayList<Pelicula> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PeliculasApiClient.init(getApplicationContext());


        listaPeliculas = (ListView) findViewById(R.id.listPelis);
        lista = new ArrayList<Pelicula>();

        //Debe ser final porque es usado en otro contexto (Thread) asyncronicamente.
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Pizzeria",
                "Obteniendo el menu...", true, false); //Instancio el progress dialog
        PeliculasApiClient.getPeliculas(new OnSuccessCallback() {
            @Override
            public void execute(Object body) {
                //Lo que se debe hacer con la respuesta del servidor
                ListView peliculasLv = (ListView) findViewById(R.id.listPelis); //El listview
                //Le asigno el adapter, al cual le paso el contexto y la lista de pizzas que vino
                peliculasLv.setAdapter(new PeliculaAdapter(getBaseContext(), (List<Pelicula>) body));
                //Saco el Progress Dialog de la pantalla
                progressDialog.dismiss();
            }
        });



        //Creamos aquí los items de las pelis
        lista.add(new Pelicula(R.drawable.saw8,1,"SAW 8","jigsaw 8, terror"));
        lista.add(new Pelicula(R.drawable.ghost_in_the_shell,2,"Ghost in the shell",""));
        lista.add(new Pelicula(R.drawable.loving_vincent,3,"Loving Vincent",""));
        lista.add(new Pelicula(R.drawable.annabelle,4,"Annabelle",""));
        lista.add(new Pelicula(R.drawable.lights_out,5,"Lights out",""));

        PeliculaAdapter miPeliculaAdapter = new PeliculaAdapter(getApplicationContext(),lista);

        listaPeliculas.setAdapter(miPeliculaAdapter);

        listaPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pelicula obj = (Pelicula) parent.getItemAtPosition(position);

                Intent paso = new Intent(getApplicationContext(), DetalleActivity.class);
                paso.putExtra("objeto", (Serializable) obj);
                startActivity(paso);
            }
        });
    }
}
