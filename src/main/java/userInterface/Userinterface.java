package userInterface;

import comparatorer.AldersGruppeComparator;
import comparatorer.RegionComparator;
import covid19Data.Covid19Data;
import fileHandler.Filehandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Userinterface {
    private final Scanner scanner = new Scanner(System.in);
    private final Filehandler filehandler = new Filehandler();
    private final ArrayList<Covid19Data> arrayList = filehandler.loadData();
    private boolean userValgFalse;

    public Userinterface() throws IOException {
    }


    public void menu() {
        int menuValg = 0;

        while (menuValg != 9) {
            System.out.println(
                    """
                    \n
                    DATA OMKRING COVID19
                    1. Vis liste af data
                    2. Vis liste af data sorteret efter region
                    3. vis liste af data sorteret efter aldersgruppe
                    4. Liste med region (primære) aldersgruppe (sekundære)
                    5. Liste med aldersgruppe (primære) region (sekundære)
                    9. Exit program""");
            do {
                String valg = scanner.nextLine().trim();
                try {
                    menuValg = Integer.parseInt(valg);
                    userValgFalse = true;
                } catch (NumberFormatException e) {
                    System.out.print("Der skete en fejl! - Indtast venligst et gyldigt nummer: ");
                    scanner.nextLine();
                }

            } while (!userValgFalse);

            startProgram(menuValg);
        }
    }


    public void startProgram(int menuvalg) {
        if (menuvalg == 1) {
            showListOfData();
        } else if (menuvalg == 2) {
            showRegionSortedList();
        } else if (menuvalg == 3) {
            showAldersGruppeSortedList();
        } else if (menuvalg == 4) {
            regionPrimaryAlderSekundary();
        } else if (menuvalg == 5) {
            alderPrimaryRegionSekundary();
        } else if (menuvalg == 9) {
            System.exit(0);
        }

    }

    public void showListOfData() {
        for (Covid19Data covid19Data : arrayList) {
            System.out.println("------------------\n"
                    + "Region: " + covid19Data.getRegion() + "\n"
                    + "Aldersgruppe: " + covid19Data.getAldersGruppe() + "\n"
                    + "Bekræftede tilfælde i alt: " + covid19Data.getBekræftedeTilfældeIAlt() + "\n"
                    + "Døde: " + covid19Data.getDøde() + "\n"
                    + "Indlagte på intensiv afdeling: " + covid19Data.getIndlagtePåIntensivAfdeling() + "\n"
                    + "Indlagte: " + covid19Data.getIndlagte() + "\n"
                    + "Dato: " + covid19Data.getDato());
        }

    }

    public void showRegionSortedList() {

        arrayList.sort(new RegionComparator());
        for (Covid19Data covid19Data : arrayList) {
            System.out.println("------------------\n"
                    + "Region: " + covid19Data.getRegion() + "\n"
                    + "Aldersgruppe: " + covid19Data.getAldersGruppe() + "\n"
                    + "Bekræftede tilfælde i alt: " + covid19Data.getBekræftedeTilfældeIAlt() + "\n"
                    + "Døde: " + covid19Data.getDøde() + "\n"
                    + "Indlagte på intensiv afdeling: " + covid19Data.getIndlagtePåIntensivAfdeling() + "\n"
                    + "Indlagte: " + covid19Data.getIndlagte() + "\n"
                    + "Dato: " + covid19Data.getDato());
        }


    }

    public void showAldersGruppeSortedList() {
        arrayList.sort(new AldersGruppeComparator());
        for (Covid19Data covid19Data : arrayList) {
            System.out.println("------------------\n"
                    + "Region: " + covid19Data.getRegion() + "\n"
                    + "Aldersgruppe: " + covid19Data.getAldersGruppe() + "\n"
                    + "Bekræftede tilfælde i alt: " + covid19Data.getBekræftedeTilfældeIAlt() + "\n"
                    + "Døde: " + covid19Data.getDøde() + "\n"
                    + "Indlagte på intensiv afdeling: " + covid19Data.getIndlagtePåIntensivAfdeling() + "\n"
                    + "Indlagte: " + covid19Data.getIndlagte() + "\n"
                    + "Dato: " + covid19Data.getDato());
        }

    }

    public void regionPrimaryAlderSekundary(){
        arrayList.sort(new RegionComparator().thenComparing(new AldersGruppeComparator()));
        for (Covid19Data covid19Data : arrayList) {
            System.out.println("------------------\n"
                    + "Region: " + covid19Data.getRegion() + "\n"
                    + "Aldersgruppe: " + covid19Data.getAldersGruppe() + "\n"
                    + "Bekræftede tilfælde i alt: " + covid19Data.getBekræftedeTilfældeIAlt() + "\n"
                    + "Døde: " + covid19Data.getDøde() + "\n"
                    + "Indlagte på intensiv afdeling: " + covid19Data.getIndlagtePåIntensivAfdeling() + "\n"
                    + "Indlagte: " + covid19Data.getIndlagte() + "\n"
                    + "Dato: " + covid19Data.getDato());
        }

    }

    public void alderPrimaryRegionSekundary(){
        arrayList.sort(new AldersGruppeComparator().thenComparing(new RegionComparator())); //.reversed ændre på vist rækkefølge hvis man vil have fra størst til mindst.
        for (Covid19Data covid19Data : arrayList) {
            System.out.println("------------------\n"
                    + "Region: " + covid19Data.getRegion() + "\n"
                    + "Aldersgruppe: " + covid19Data.getAldersGruppe() + "\n"
                    + "Bekræftede tilfælde i alt: " + covid19Data.getBekræftedeTilfældeIAlt() + "\n"
                    + "Døde: " + covid19Data.getDøde() + "\n"
                    + "Indlagte på intensiv afdeling: " + covid19Data.getIndlagtePåIntensivAfdeling() + "\n"
                    + "Indlagte: " + covid19Data.getIndlagte() + "\n"
                    + "Dato: " + covid19Data.getDato());
        }

    }


}
