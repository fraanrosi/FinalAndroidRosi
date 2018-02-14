package com.example.francorosi.finalandroid;

import java.io.Serializable;

/**
 * Created by Franco Rosi on 13/02/2018.
 */
public class Datos implements Serializable {
    private int id;
    private String titulo;
    private String detalle;
    private int imagen;

    public Datos(int imagen, int id, String titulo, String detalle) {
        this.imagen = imagen;
        this.id = id;
        this.titulo = titulo;
        this.detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
