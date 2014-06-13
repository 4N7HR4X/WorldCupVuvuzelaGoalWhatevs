package com.binaryeclipse.worldcup.app.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Andras on 2014/06/12.
 */
public class Utils {
    private static List<String> listA;
    private static List<String> listB;
    private static List<String> listC;
    private static List<String> listD;
    private static List<String> listE;
    private static List<String> listF;
    private static List<String> listG;
    private static List<String> listH;

    public static List<List<String>> generateGroups() {
        List<List<String>> groups = new ArrayList<List<String>>();
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

    private static List<String> getListA() {
        if (listA == null) {
            listA = new ArrayList<String>();
            listA.add("Brazil");
            listA.add("Croatia");
            listA.add("Mexico");
            listA.add("Cameroon");
        }
        return listA;
    }

    private static List<String> getListB() {
        if (listB == null) {
            listB = new ArrayList<String>();
            listB.add("Spain");
            listB.add("Netherlands");
            listB.add("Chile");
            listB.add("Australia");
        }
        return listB;
    }

    public static List<String> getListC() {
        if (listC == null) {
            listC = new ArrayList<String>();
            listC.add("Colombia");
            listC.add("Greece");
            listC.add("Côte d'Ivoire");
            listC.add("Japan");
        }
        return listC;
    }

    public static List<String> getListD() {
        if (listD == null) {
            listD = new ArrayList<String>();
            listD.add("Uruguay");
            listD.add("Costa Rica");
            listD.add("England");
            listD.add("Italy");
        }
        return listD;
    }

    public static List<String> getListE() {
        if (listE == null) {
            listE = new ArrayList<String>();
            listE.add("Switzerland");
            listE.add("Ecuador");
            listE.add("France");
            listE.add("Honduras");
        }
        return listE;
    }

    public static List<String> getListF() {
        if (listF == null) {
            listF = new ArrayList<String>();
            listF.add("Argentina");
            listF.add("Bosnia and Herzegovina");
            listF.add("Iran");
            listF.add("Nigeria");
        }
        return listF;
    }

    public static List<String> getListG() {
        if (listG == null) {
            listG = new ArrayList<String>();
            listG.add("Germany");
            listG.add("Portugal");
            listG.add("Ghana");
            listG.add("United States");
        }
        return listG;
    }

    public static List<String> getListH() {
        if (listH == null) {
            listH = new ArrayList<String>();
            listH.add("Belgium");
            listH.add("Algeria");
            listH.add("Russia");
            listH.add("South Korea");
        }
        return listH;
    }
}
