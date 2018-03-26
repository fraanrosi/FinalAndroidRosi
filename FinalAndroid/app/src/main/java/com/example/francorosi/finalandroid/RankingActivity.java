package com.example.francorosi.finalandroid;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        ListView listUsuarios = (ListView) findViewById(R.id.listPelis);
        ArrayList<Usuario> listaU = new ArrayList<Usuario>();  //Debe ser final porque es usado en otro contexto (Thread) asyncronicamente.

        final ProgressDialog progressDialog = ProgressDialog.show(this, "Pizzeria",
                "Obteniendo el menu...", true, false); //Instancio el progress dialog
        PeliculasApiClient.getClient().getRanking().enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                //Lo que se debe hacer con la respuesta del servidor
                ListView rankingLV = (ListView) findViewById(R.id.listUsuarios); //El listview
                //Le asigno el adapter, al cual le paso el contexto y la lista de pizzas que vino
                rankingLV.setAdapter(new RankingAdapter(getBaseContext(), (List<Usuario>) response.body()));
                //Saco el Progress Dialog de la pantalla
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable throwable) {

            }
        });
    }
}
