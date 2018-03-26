package com.example.francorosi.finalandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Franco Rosi on 02/03/2018.
 */
public class RankingAdapter extends BaseAdapter {

    Context contextoR;
    List<Usuario> rankingLV;

    public RankingAdapter(Context contextoR, List<Usuario> rankingLV) {
        this.contextoR = contextoR;
        this.rankingLV = rankingLV;
    }

    @Override
    public int getCount() {
        return rankingLV.size();
    }

    @Override
    public Object getItem(int position) {
        return rankingLV.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rankingLV.get(position).getId();//retorna el id del objeto en esa posición

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate=LayoutInflater.from(contextoR);
        vista= inflate.inflate(R.layout.activity_ranking,null);

        Usuario user = rankingLV.get(position);

        TextView nombre=(TextView) vista.findViewById(R.id.textTitulo);
        TextView apellido=(TextView) vista.findViewById(R.id.textDetalle);

        nombre.setText(user.getNombre().toString());
        apellido.setText(user.getApellido().toString());


        return vista;
    }
}
