package ehu.isad.model;

import javafx.scene.image.Image;

public class Herrialdea {

    private String izena;
    private Image bandera;
    private String tv;

    public Herrialdea(String izena, Image bandera, String tv) {
        this.izena = izena;
        this.bandera = bandera;
        this.tv = tv;
    }

    @Override
    public String toString() {
        return izena;
    }

    public Image getBandera() {
        return bandera;
    }

    public String getIzena() {
        return izena;
    }
}
