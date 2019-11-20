package ehu.isad.model;

import javafx.scene.image.Image;

public class RankingPos {

    private String herrialdea;
    private Image bandera;
    private String puntuak;

    public RankingPos(String herrialdea, String bandera, String puntuak) {
        this.herrialdea = herrialdea;
        this.bandera = new Image(getClass().getResourceAsStream("/banderak/"+bandera));;
        this.puntuak = puntuak;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
    }

    public void setPuntuak(String puntuak) {
        this.puntuak = puntuak;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public Image getBandera() {
        return bandera;
    }

    public String getPuntuak() {
        return puntuak;
    }


}
