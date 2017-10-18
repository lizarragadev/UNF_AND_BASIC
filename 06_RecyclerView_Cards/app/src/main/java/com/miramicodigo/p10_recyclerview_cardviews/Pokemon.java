package com.miramicodigo.p10_recyclerview_cardviews;

import java.io.Serializable;

/**
 *
 * @author Gustavo Lizarraga
 * @date 17/10/2017
 *
 * */

public class Pokemon implements Serializable {
    private String Nombre;
    private String Tipo;
    private int Imagen;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}
