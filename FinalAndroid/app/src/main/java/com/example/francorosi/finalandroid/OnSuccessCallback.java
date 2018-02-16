package com.example.francorosi.finalandroid;

/**
 * Created by Franco Rosi on 16/02/2018.
 */
//Interfaz que voy a usar para implementar los callbacks del server
public interface OnSuccessCallback {
    //Este metodo es el unico que se implementara, la idea es que como parametro entre la respuesta
    // del proceso asincronico quwe se realizo (en nuestro caso la llamada a la API)
    public void execute(Object body);
}