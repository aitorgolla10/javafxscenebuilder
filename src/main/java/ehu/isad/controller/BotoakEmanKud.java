package ehu.isad.controller;

import ehu.isad.Main;
import ehu.isad.model.Herrialdea;
import ehu.isad.model.Ordezkaritza;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BotoakEmanKud {

    // Reference to the main application.
    private Main mainApp;

    private static BotoakEmanKud instantzia = new BotoakEmanKud();

    public static BotoakEmanKud getInstantzia(){
        return instantzia;
    }

    public void botoakEguneratu(ObservableList<Ordezkaritza> ordezkaritzak, String bozkatzailea){

        for (int i=0; i<ordezkaritzak.size(); i++){
            Ordezkaritza o = ordezkaritzak.get(i);
            if (!o.getPuntuak().equals("---")){
                Integer puntuak = Integer.parseInt(o.getPuntuak());
                System.out.println(puntuak);
                String bozkatua = o.getHerrialdea();
                if (puntuak>0) {
                    DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
                    String query = "INSERT INTO Bozkaketa (bozkatuaIzanDa, bozkatuDu, urtea, puntuak) VALUES ('"+bozkatua+"','"+bozkatzailea+"','2019','"+puntuak+"')";
                    dbkud.execSQL(query);
                    String query2 = "UPDATE Ordezkaritza SET puntuak=puntuak+'" + puntuak + "' where herrialdea='" + bozkatua + "' and urtea='2019' ";
                    dbkud.execSQL(query2);
                }
            }
        }
    }



}
