package ehu.isad.controller;

import ehu.isad.model.Herrialdea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Ui1kud implements Initializable {

    @FXML
    private ComboBox<Herrialdea> herrialdeak;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

         ArrayList<Herrialdea> herriak = HerrialdeKud.getInstantzia().lortuHerriak();


    }
}
