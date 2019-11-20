package ehu.isad.model;

import javafx.scene.image.Image;

public class Erabiltzailea {

    private static Erabiltzailea erabiltzailea = new Erabiltzailea();
    private String izena;
    private Image bandera;

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getIzena() {
        return izena;
    }

    public static Erabiltzailea getInstantzia(){
        return erabiltzailea;
    }
}
