package ehu.isad.controller;

import ehu.isad.Main;
import ehu.isad.model.Herrialdea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ErroreKud implements Initializable {

    // singleton
    private static ErroreKud instantzia = new ErroreKud();

    public static ErroreKud getInstantzia(){
        return instantzia;
    };

    // Reference to the main application.
    private Main mainApp;
    private Ui2kud ui2kud = Ui2kud.getInstantzia();
    private String izena;

    @FXML
    private Label herrialdea;
    @FXML
    private ImageView bandera;



    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClick(){

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}