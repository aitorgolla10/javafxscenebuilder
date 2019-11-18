package ehu.isad.controller;

import ehu.isad.Main;
import ehu.isad.model.Herrialdea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Ui1kud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private ComboBox<Herrialdea> herrialdeak;


    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void onClick(){
        mainApp.ui2erakutsi();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




    }
}
