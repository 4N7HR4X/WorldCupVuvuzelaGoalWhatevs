package com.binaryeclipse.worldcup.app.utils;

import com.binaryeclipse.worldcup.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andras on 2014/06/12.
 */
public class Utils {
    private static List<Country> listA;
    private static List<Country> listB;
    private static List<Country> listC;
    private static List<Country> listD;
    private static List<Country> listE;
    private static List<Country> listF;
    private static List<Country> listG;
    private static List<Country> listH;

    public static List<List<Country>> generateGroups() {
        List<List<Country>> groups = new ArrayList<List<Country>>();
        groups.add(getListA());
        groups.add(getListB());
        groups.add(getListC());
        groups.add(getListD());
        groups.add(getListE());
        groups.add(getListF());
        groups.add(getListG());
        groups.add(getListH());
        return groups;
    }

    private static List<Country> getListA() {
        if (listA == null) {
            listA = new ArrayList<Country>();
            listA.add(new Country("Brazil", R.drawable.bra,R.drawable.br));
            listA.add(new Country("Croatia", R.drawable.cro,R.drawable.cr));
            listA.add(new Country("Mexico", R.drawable.bra,R.drawable.br));
            listA.add(new Country("Cameroon", R.drawable.bra,R.drawable.br));
        }
        return listA;
    }

    private static List<Country> getListB() {
        if (listB == null) {
            listB = new ArrayList<Country>();
            listB.add(new Country("Spain", R.drawable.bra,R.drawable.br));
            listB.add(new Country("Netherlands", R.drawable.bra,R.drawable.br));
            listB.add(new Country("Chile", R.drawable.bra,R.drawable.br));
            listB.add(new Country("Australia", R.drawable.bra,R.drawable.br));
        }
        return listB;
    }

    public static List<Country> getListC() {
        if (listC == null) {
            listC = new ArrayList<Country>();
            listC.add(new Country("Colombia", R.drawable.bra,R.drawable.br));
            listC.add(new Country("Greece", R.drawable.bra,R.drawable.br));
            listC.add(new Country("Côte d'Ivoire", R.drawable.bra,R.drawable.br));
            listC.add(new Country("Japan", R.drawable.bra,R.drawable.br));
        }
        return listC;
    }

    public static List<Country> getListD() {
        if (listD == null) {
            listD = new ArrayList<Country>();
            listD.add(new Country("Uruguay", R.drawable.bra,R.drawable.br));
            listD.add(new Country("Costa Rica", R.drawable.bra,R.drawable.br));
            listD.add(new Country("England", R.drawable.bra,R.drawable.br));
            listD.add(new Country("Italy", R.drawable.bra,R.drawable.br));
        }
        return listD;
    }

    public static List<Country> getListE() {
        if (listE == null) {
            listE = new ArrayList<Country>();
            listE.add(new Country("Switzerland", R.drawable.bra,R.drawable.br));
            listE.add(new Country("Ecuador", R.drawable.bra,R.drawable.br));
            listE.add(new Country("France", R.drawable.bra,R.drawable.br));
            listE.add(new Country("Honduras", R.drawable.bra,R.drawable.br));
        }
        return listE;
    }

    public static List<Country> getListF() {
        if (listF == null) {
            listF = new ArrayList<Country>();
            listF.add(new Country("Argentina", R.drawable.bra,R.drawable.br));
            listF.add(new Country("Bosnia and Herzegovina", R.drawable.bra,R.drawable.br));
            listF.add(new Country("Iran", R.drawable.bra,R.drawable.br));
            listF.add(new Country("Nigeria", R.drawable.bra,R.drawable.br));
        }
        return listF;
    }

    public static List<Country> getListG() {
        if (listG == null) {
            listG = new ArrayList<Country>();
            listG.add(new Country("Germany", R.drawable.bra,R.drawable.br));
            listG.add(new Country("Portugal", R.drawable.bra,R.drawable.br));
            listG.add(new Country("Ghana", R.drawable.bra,R.drawable.br));
            listG.add(new Country("United States", R.drawable.bra,R.drawable.br));
        }
        return listG;
    }

    public static List<Country> getListH() {
        if (listH == null) {
            listH = new ArrayList<Country>();
            listH.add(new Country("Belgium", R.drawable.bra,R.drawable.br));
            listH.add(new Country("Algeria", R.drawable.bra,R.drawable.br));
            listH.add(new Country("Russia", R.drawable.bra,R.drawable.br));
            listH.add(new Country("South Korea", R.drawable.bra,R.drawable.br));
        }
        return listH;
    }
}
