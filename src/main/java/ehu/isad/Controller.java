package ehu.isad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

  // Reference to the main application.
  private Main mainApp;

  @FXML
  private CheckBox ikasleMarka;

  @FXML
  private TextField txtErabiltzaile;

  @FXML
  private TextField txtPasahitza;

  public void setMainApp(Main main) {
    this.mainApp = mainApp;
  }

  @FXML
  public void onClick(ActionEvent actionEvent) {
    if (ikasleMarka.isSelected()){
      System.out.println("Ikaslea zara");
    }
    else{
      System.out.println("Ez zara ikaslea");
    }
  }

  public void irtenSakatu(ActionEvent actionEvent) {
    System.exit(0);
  }
}
