package ehu.isad.controller;

import ehu.isad.model.Herrialdea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HerrialdeKud {

    // singleton
    private static HerrialdeKud instantzia = new HerrialdeKud();

    public static HerrialdeKud getInstantzia(){
        return instantzia;
    };

    public List<String> lortuHerrialdeak() throws SQLException {

        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
        ObservableList<String> herriak = FXCollections.observableArrayList();
        String query = "SELECT izena FROM ParteHartzea where etorrikoDa='Bai' and urtea=strftime('%Y','now')";
        ResultSet rs = dbkud.execSQL(query);


        while (rs.next()){

            String izena = rs.getString("izena");
            herriak.add(izena);
        }

        return herriak;
    }

    public boolean bozkatuDu(String aukeratutakoHerrialdea) throws SQLException {

        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
        ObservableList<String> herriak = FXCollections.observableArrayList();
        String query = "SELECT * FROM Bozkaketa where bozkatuDu='"+aukeratutakoHerrialdea+"' and urtea=strftime('%Y','now')";
        ResultSet rs = dbkud.execSQL(query);
        if (rs.next()){
            return true;
        }
        else{
            return false;
        }
    }
}
