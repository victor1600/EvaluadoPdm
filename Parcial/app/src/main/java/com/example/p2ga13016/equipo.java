package com.example.p2ga13016;

public class equipo {

    String coddueño;
    String codpais;
    String correequipo;
    float taquilla2019;

    public equipo() {
    }

    public equipo(String coddueño) {
        this.coddueño = coddueño;
    }



    public equipo(String coddueño, String codpais, String correequipo, float taquilla2019) {
        this.coddueño = coddueño;
        this.codpais = codpais;
        this.correequipo = correequipo;
        this.taquilla2019 = taquilla2019;
    }

    public String getCoddueño() {
        return coddueño;
    }

    public void setCoddueño(String coddueño) {
        this.coddueño = coddueño;
    }

    public String getCodpais() {
        return codpais;
    }

    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }

    public String getCorreequipo() {
        return correequipo;
    }

    public void setCorreequipo(String correequipo) {
        this.correequipo = correequipo;
    }

    public float getTaquilla2019() {
        return taquilla2019;
    }

    public void setTaquilla2019(float taquilla2019) {
        this.taquilla2019 = taquilla2019;
    }
}
