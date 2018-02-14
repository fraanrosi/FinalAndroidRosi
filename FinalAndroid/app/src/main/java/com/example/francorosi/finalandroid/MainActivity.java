package com.example.francorosi.finalandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<Datos> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDatos = (ListView) findViewById(R.id.listDatos);

        lista = new ArrayList<Datos>();

        //Creamos aquí los items de las pelis
        lista.add(new Datos(R.drawable.saw8,1,"SAW 8","jigsaw 8, terror"));
        lista.add(new Datos(R.drawable.ghost_in_the_shell,2,"Ghost in the shell",""));
        lista.add(new Datos(R.drawable.loving_vincent,3,"Loving Vincent",""));
        lista.add(new Datos(R.drawable.annabelle,4,"Annabelle",""));
        lista.add(new Datos(R.drawable.lights_out,5,"Lights out",""));

        Adaptador miAdaptador = new Adaptador(getApplicationContext(),lista);

        listaDatos.setAdapter(miAdaptador);

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Datos obj = (Datos) parent.getItemAtPosition(position);

                Intent paso = new Intent(getApplicationContext(),DetalleActivity.class);
                paso.putExtra("objeto",(Serializable) obj);
                startActivity(paso);
            }
        });
    }
}
