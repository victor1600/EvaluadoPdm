package com.example.p2ga13016;

public class dueño {

    String coddueño;
    String nombre;
    String apellido;
    float  patrimonio;
    int numequipos;

    public dueño() {
    }

    public dueño(String coddueño, String nombre, String apellido, float patrimonio, int numequipos) {
        this.coddueño = coddueño;
        this.nombre = nombre;
        this.apellido = apellido;
        this.patrimonio = patrimonio;
        this.numequipos = numequipos;
    }

    public String getCoddueño() {
        return coddueño;
    }

    public void setCoddueño(String coddueño) {
        this.coddueño = coddueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(float patrimonio) {
        this.patrimonio = patrimonio;
    }

    public int getNumequipos() {
        return numequipos;
    }

    public void setNumequipos(int numequipos) {
        this.numequipos = numequipos;
    }
}
