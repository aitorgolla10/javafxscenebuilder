package ehu.isad.controller;

import ehu.isad.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Ui2kud implements Initializable {

    @FXML
    private ComboBox comboboxa;

    // singleton
    private static Ui2kud instantzia = new Ui2kud();

    public static Ui2kud getInstantzia(){
        return instantzia;
    };
    // Reference to the main application.
    private Main mainApp;
    private HerrialdeKud herrialdeKud;
    private ErroreKud erroreKud;
    private String izena;

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void onClick(ActionEvent actionEvent) throws SQLException {

        String aukeratutakoHerrialdea = (String) comboboxa.getValue();
        System.out.println(aukeratutakoHerrialdea);
        Boolean bozkatuDu = herrialdeKud.getInstantzia().bozkatuDu(aukeratutakoHerrialdea);
        if (bozkatuDu.equals(true)){

        }
        else{
            mainApp.ui3erakutsi();
        }
    }

    public String emanIzena(){
        return this.izena;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            comboboxa.setItems((ObservableList) herrialdeKud.getInstantzia().lortuHerrialdeak());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
