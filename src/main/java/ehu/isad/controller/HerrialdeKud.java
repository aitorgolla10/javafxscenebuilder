package ehu.isad.controller;

import ehu.isad.model.Herrialdea;

import java.util.ArrayList;

public class HerrialdeKud {

    private static DBKudeatzaile instantzia = new DBKudeatzaile();

    public static DBKudeatzaile getInstantzia() {
        return instantzia;
    }

    public ArrayList<Herrialdea> lortuHerriak(){
        DBKudeatzaile.getInstantzia().lortuHerriak();
    }
}
