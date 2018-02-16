package com.example.francorosi.finalandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Franco Rosi on 13/02/2018.
 */
public class PeliculaAdapter extends BaseAdapter {

    Context contexto;
    List<Pelicula> listaObjetos;

    public PeliculaAdapter(Context contexto, List<Pelicula> listaObjetos) {
        this.contexto = contexto;
        this.listaObjetos = listaObjetos;
    }

    @Override
    public int getCount() {
        return listaObjetos.size();//retorna la cantidad de elemento de la lista
    }

    @Override
    public Object getItem(int position) {
        return listaObjetos.get(position);//retorna el objeto en esa posición
    }

    @Override
    public long getItemId(int position) {
        return listaObjetos.get(position).getId();//retorna el id del objeto en esa posición

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate=LayoutInflater.from(contexto);
        vista= inflate.inflate(R.layout.listado_pelis,null);

        ImageView imagen=(ImageView) vista.findViewById(R.id.imgItem);
        TextView titulo=(TextView) vista.findViewById(R.id.textTitulo);
        TextView detalle=(TextView) vista.findViewById(R.id.textDetalle);

        titulo.setText(listaObjetos.get(position).getTitulo().toString());
        detalle.setText(listaObjetos.get(position).getDetalle().toString());
        imagen.setImageResource(listaObjetos.get(position).getImagen());

        return vista;
    }
}
