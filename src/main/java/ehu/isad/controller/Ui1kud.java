package ehu.isad.controller;

import ehu.isad.Main;
import ehu.isad.model.Herrialdea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Ui1kud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private ComboBox<Herrialdea> herrialdeak;

    @FXML
    private ImageView argazkia;


    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void onClick(){
        mainApp.ui2erakutsi();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image image = new Image(getClass().getResourceAsStream("/banderak/eurobisioa.png"));
        argazkia.setImage(image);




    }
}
