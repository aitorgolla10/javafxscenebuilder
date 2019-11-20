package ehu.isad.controller;

import ehu.isad.Main;
import ehu.isad.model.Erabiltzailea;
import ehu.isad.model.Ordezkaritza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TaulaKud implements Initializable {

    // Reference to the main application.
    private Main mainApp;
    @FXML
    private Label nor;
    @FXML
    private ImageView irudia;
    @FXML
    private ImageView argazkia;
    @FXML
    private TableView<Ordezkaritza> tbData;

    @FXML
    private TableColumn<Ordezkaritza,Image> bandera;

    @FXML
    private TableColumn<Ordezkaritza,String> herrialdea;

    @FXML
    private TableColumn<Ordezkaritza,String> artista;

    @FXML
    private TableColumn<Ordezkaritza,String> abestia;

    @FXML
    private TableColumn<Ordezkaritza,String> puntuak;

    private ObservableList<Ordezkaritza> ordezkaritzak = FXCollections.observableArrayList();

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void ordezkaritzakLortu() throws SQLException {


        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
        String query = "SELECT * FROM Ordezkaritza";
        ResultSet rs = dbkud.execSQL(query);

        while (rs.next()){

            String herrialdea = rs.getString("herrialdea");
            String path = herrialdea.toLowerCase()+".png";
            String artista = rs.getString("artista");
            String abestia = rs.getString("abestia");
            String izena = Erabiltzailea.getInstantzia().getIzena();
            String puntuak;
            if (!izena.equals(herrialdea)) {
                puntuak = "0";
            }
            else{
                puntuak = "---";
            }
            ordezkaritzak.add(new Ordezkaritza(herrialdea,artista,abestia,puntuak,path));
        }
    }
    @FXML
    public void onClick() throws IOException {
        BotoakEmanKud botoKud = BotoakEmanKud.getInstantzia();
        Erabiltzailea erab = Erabiltzailea.getInstantzia();
        botoKud.botoakEguneratu(ordezkaritzak, erab.getIzena());
        mainApp.ui5erakutsi();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image ikonoa = new Image(getClass().getResourceAsStream("/banderak/eurobisioa.png"));
        argazkia.setImage(ikonoa);

        tbData.setEditable(true);
        String izena = Erabiltzailea.getInstantzia().getIzena();
        nor.setText(izena + "k horrela nahi ditu bere puntuak banatu:");
        String izenaLow = izena.toLowerCase();
        Image image = new Image(getClass().getResourceAsStream("/banderak/"+izenaLow+".png"));
        irudia.setImage(image);
        try {
            ordezkaritzakLortu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        herrialdea.setCellValueFactory(new PropertyValueFactory<>("herrialdea"));
        artista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        abestia.setCellValueFactory(new PropertyValueFactory<>("abestia"));
        puntuak.setCellValueFactory(new PropertyValueFactory<>("puntuak"));

        puntuak.setCellFactory(TextFieldTableCell.<Ordezkaritza> forTableColumn());

        Callback<TableColumn<Ordezkaritza, String>, TableCell<Ordezkaritza, String>> defaultTextFieldCellFactory
                = TextFieldTableCell.<Ordezkaritza>forTableColumn();

        puntuak.setCellFactory(col -> {        //ZUTABEA EDITAGARRIA EGITEKO
            TableCell<Ordezkaritza, String> cell = defaultTextFieldCellFactory.call(col);
            cell.itemProperty().addListener((obs, oldValue, newValue) -> {
                TableRow row = cell.getTableRow();
                if (row == null) {
                    cell.setEditable(false);
                } else {
                    Ordezkaritza item = (Ordezkaritza) cell.getTableRow().getItem();
                    if (item == null) {
                        cell.setEditable(false);
                    } else {
                        String herrialdea = item.getHerrialdea();
                        cell.setEditable(!Erabiltzailea.getInstantzia().getIzena().equals(herrialdea));
                    }
                }
            });
            return cell ;
        });

        puntuak.setOnEditCommit((TableColumn.CellEditEvent<Ordezkaritza, String> event) -> {

            TablePosition<Ordezkaritza, String> pos = event.getTablePosition();
            String puntuaketa = event.getNewValue();
            int row = pos.getRow();
            Ordezkaritza ordezkaritza = event.getTableView().getItems().get(row);
            ordezkaritza.setPuntuak(puntuaketa);

        });

        bandera.setCellValueFactory(new PropertyValueFactory<Ordezkaritza, Image>("bandera"));

        bandera.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(20);
                    imageview.setFitWidth(20);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    //tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });



        tbData.setItems(ordezkaritzak);


    }
}