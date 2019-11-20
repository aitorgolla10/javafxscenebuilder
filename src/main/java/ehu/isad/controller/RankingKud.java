package ehu.isad.controller;

import ehu.isad.Main;
import ehu.isad.model.Ordezkaritza;
import ehu.isad.model.RankingPos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RankingKud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private ImageView argazkia;
    @FXML
    private TableView<RankingPos> tbData2;

    @FXML
    private TableColumn<RankingPos,Image> bandera;

    @FXML
    private TableColumn<RankingPos,String> herrialdea;

    @FXML
    private TableColumn<RankingPos,String> puntuak;

    private ObservableList<RankingPos> posizioak = FXCollections.observableArrayList();

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void onClick(){
        System.exit(0);
    }

    public void rankingaLortu() throws SQLException {

        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
        String query = "SELECT o.herrialdea, o.puntuak, h.bandera FROM Ordezkaritza o, Herrialde h WHERE o.herrialdea=h.izena AND urtea=strftime('%Y','now') ORDER BY puntuak DESC LIMIT 3";
        ResultSet rs = dbkud.execSQL(query);
        System.out.println("aaa");
        while (rs.next()) {
            System.out.println("bbb");
            String izena = rs.getString("herrialdea");
            String path = izena.toLowerCase()+".png";
            String puntuak = rs.getString("puntuak");
            posizioak.add(new RankingPos(izena,path,puntuak));
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(getClass().getResourceAsStream("/banderak/eurobisioa.png"));
        argazkia.setImage(image);
        try {
            rankingaLortu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        herrialdea.setCellValueFactory(new PropertyValueFactory<>("herrialdea"));
        bandera.setCellValueFactory(new PropertyValueFactory<>("bandera"));
        puntuak.setCellValueFactory(new PropertyValueFactory<>("puntuak"));

        bandera.setCellValueFactory(new PropertyValueFactory<RankingPos, Image>("bandera"));

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

        tbData2.setItems(posizioak);



    }
}
