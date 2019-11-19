package ehu.isad.controller;

import ehu.isad.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Ui2kud implements Initializable {

    @FXML
    private ComboBox comboboxa;

    @FXML
    private ImageView argazkia;

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

    public void onClick(ActionEvent actionEvent) throws SQLException, IOException {

        String aukeratutakoHerrialdea = (String) comboboxa.getValue();
        Erabiltzailea.getInstantzia().setIzena(aukeratutakoHerrialdea);
        Boolean bozkatuDu = herrialdeKud.getInstantzia().bozkatuDu(aukeratutakoHerrialdea);
        if (bozkatuDu.equals(true)){
            mainApp.ui3erakutsi();
        }
        else{
            mainApp.ui4erakutsi();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image image = new Image(getClass().getResourceAsStream("/banderak/eurobisioa.png"));
        argazkia.setImage(image);

        try {
            comboboxa.setItems((ObservableList) herrialdeKud.getInstantzia().lortuHerrialdeak());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
