package com.example.francorosi.finalandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private ImageView foto;
    private TextView titulo;
    private TextView detalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        foto = (ImageView) findViewById(R.id.imgFoto);
        titulo = (TextView) findViewById(R.id.textTitulo);
        detalle = (TextView) findViewById(R.id.textDetalle);

        Datos obj = (Datos) getIntent().getExtras().getSerializable("objeto");

        titulo.setText(obj.getTitulo());
        detalle.setText(obj.getDetalle());
        foto.setImageResource(obj.getImagen());
    }
}
