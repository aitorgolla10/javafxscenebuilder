package ehu.isad.model;

import javafx.scene.image.Image;

public class Herrialdea {

    private String izena;
    private String bandera;
    private String tv;

    public Herrialdea(String izena, String bandera, String tv) {
        this.izena = izena;
        this.bandera = bandera;
        this.tv = tv;
    }

    @Override
    public String toString() {
        return izena;
    }

    public String getBandera() {
        return bandera;
    }

    public String getIzena() {
        return izena;
    }
}
