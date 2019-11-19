package ehu.isad;

import ehu.isad.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

  private Parent ui1;
  private Parent ui2;
  private Parent ui3;
  private Parent ui4;

  private Stage stage;

  private Ui1kud ui1kud;
  private Ui2kud ui2kud;
  private ErroreKud erroreKud;
  private TaulaKud taulaKud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();
    stage.setTitle("EUROBISIOA");
    stage.setScene(new Scene(ui1, 600, 400));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    Locale locale = new Locale("eu","ES");
    ResourceBundle bundle = ResourceBundle.getBundle("UIResources", locale);


    FXMLLoader ui1Loader = new FXMLLoader(getClass().getResource("/ui/ui1.fxml"), bundle);
    ui1 = (Parent) ui1Loader.load();
    ui1kud = ui1Loader.getController();
    ui1kud.setMainApp(this);

    FXMLLoader ui2Loader = new FXMLLoader(getClass().getResource("/ui/ui2.fxml"), bundle);
    ui2 = (Parent) ui2Loader.load();
    ui2kud = ui2Loader.getController();
    ui2kud.setMainApp(this);


  }

  public void ui2erakutsi(){
    stage.setScene(new Scene(ui2, 600, 400));
    stage.show();
  }

  public void ui3erakutsi() throws IOException {

      Locale locale = new Locale("eu","ES");
      ResourceBundle bundle = ResourceBundle.getBundle("UIResources", locale);
    FXMLLoader ui3Loader = new FXMLLoader(getClass().getResource("/ui/ui3.fxml"), bundle);
    ui3 = (Parent) ui3Loader.load();
    erroreKud = ui3Loader.getController();
    erroreKud.setMainApp(this);
    stage.setScene(new Scene(ui3, 650, 400));
    stage.show();
  }

  public void ui4erakutsi() throws IOException {

    Locale locale = new Locale("eu","ES");
    ResourceBundle bundle = ResourceBundle.getBundle("UIResources", locale);
    FXMLLoader ui4Loader = new FXMLLoader(getClass().getResource("/ui/ui4.fxml"), bundle);
    ui4 = (Parent) ui4Loader.load();
    taulaKud = ui4Loader.getController();
    taulaKud.setMainApp(this);
    stage.setScene(new Scene(ui4, 750, 500));
    stage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }

}
