package ehu.isad.model;

import javafx.scene.image.Image;

public class Ordezkaritza {

    private Image bandera;
    private String herrialdea;
    private String artista;
    private String abestia;
    private String puntuak;



    public Ordezkaritza(String herrialdea, String artista, String abestia, String puntuak, String path) {

        this.bandera = new Image(getClass().getResourceAsStream("/banderak/"+path));
        this.herrialdea = herrialdea;
        this.artista = artista;
        this.abestia = abestia;
        this.puntuak = puntuak;
    }

    public String getArtista() {
        return artista;
    }

    public String getAbestia() {
        return abestia;
    }

    public String getPuntuak() {
        return puntuak;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setAbestia(String abestia) {
        this.abestia = abestia;
    }

    public void setPuntuak(String puntuak) {
        this.puntuak = puntuak;
    }

    public Image getBandera() {
        return bandera;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
    }
}
