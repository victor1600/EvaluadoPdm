package com.example.p2ga13016;

public class pais {

    String codpais;
    String nompais;
    String esEuropeo;

    public pais() {
    }

    public pais(String codpais, String nommapis, String esEuropeo) {
        this.codpais = codpais;
        this.nompais = nommapis;
        this.esEuropeo = esEuropeo;
    }

    public String getCodpais() {
        return codpais;
    }

    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }

    public String getNommapis() {
        return nompais;
    }

    public void setNommapis(String nommapis) {
        this.nompais = nommapis;
    }

    public String getEsEuropeo() {
        return esEuropeo;
    }

    public void setEsEuropeo(String esEuropeo) {
        this.esEuropeo = esEuropeo;
    }
}

