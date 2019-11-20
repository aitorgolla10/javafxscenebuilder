package ehu.isad.controller;

import ehu.isad.Main;
import ehu.isad.model.Erabiltzailea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ErroreKud implements Initializable {

    // singleton
    private static ErroreKud instantzia = new ErroreKud();

    public static ErroreKud getInstantzia(){
        return instantzia;
    };

    // Reference to the main application.
    private Main mainApp;
    private String izena;

    @FXML
    private Label herrialdea;
    @FXML
    private ImageView bandera;
    @FXML
    private ImageView argazkia;



    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClick(){
        System.exit(0);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String izena = Erabiltzailea.getInstantzia().getIzena();
        herrialdea.setText(izena + "k jada banatu ditu bere puntuak.");
        String izenaLow = izena.toLowerCase();
        Image image = new Image(getClass().getResourceAsStream("/banderak/"+izenaLow+".png"));
        bandera.setImage(image);

        Image ikonoa = new Image(getClass().getResourceAsStream("/banderak/eurobisioa.png"));
        argazkia.setImage(ikonoa);
    }
}