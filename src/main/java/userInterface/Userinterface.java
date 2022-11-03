package userInterface;
import comparatorer.*;
import covid19Data.Covid19Data;
import fileHandler.Filehandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Userinterface {
    private final Scanner SCANNER = new Scanner(System.in);
    private final Filehandler FILEHANDLER = new Filehandler();
    private final ArrayList<Covid19Data> ARRAYLIST = FILEHANDLER.loadData();
    private boolean userValgFalse;
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_CYAN = "\u001B[36m";

    public Userinterface() throws IOException {
    }
    public void menu() {
        int menuValg = 0;

        while (menuValg != 9) {
            System.out.println(
                    """
                    \n
                    DATA OMKRING COVID19
                    1. \u001B[32mSorteret\u001B[0m efter region
                    2. \u001B[34mSorteret\u001B[0m efter aldersgruppe
                    3. \u001B[35mSorteret\u001B[0m efter bekræftede tilfælde i alt
                    4. \u001B[31mSorteret\u001B[0m efter antal døde
                    5. \u001B[36mSorteret\u001B[0m efter índlagte på intensiv afdeling
                    6. \u001B[36mSorteret\u001B[0m efter indlagte i alt 
                    7. Sorteret efter region \u001B[32m(primære)\u001B[0m aldersgruppe \u001B[34m(sekundære)\u001B[0m
                    8. Sorteret efter aldersgruppe \u001B[34m(primære)\u001B[0m region \u001B[32m(sekundære)\u001B[0m
                    9. Exit program""");

            do {
                String valg = SCANNER.nextLine().trim();
                try {
                    menuValg = Integer.parseInt(valg);
                    userValgFalse = true;
                } catch (NumberFormatException e) {
                    System.out.print("Der skete en fejl! - Indtast venligst et gyldigt nummer: ");
                    SCANNER.nextLine();
                }

            } while (!userValgFalse);

            startProgram(menuValg);
        }
    }
    public void startProgram(int menuvalg) {
        if (menuvalg == 1) {
            showRegionSortedList();
        } else if (menuvalg == 2) {
            showAldersGruppeSortedList();
        } else if (menuvalg == 3) {
            bekræftedeTilfældeIAlt();
        } else if (menuvalg == 4) {
            showDødeShortedList();
        } else if (menuvalg == 5){
            indlagtePåIntensiv();
        } else if (menuvalg == 6) {
            inlagteIAlt();
        } else if (menuvalg == 7) {
            regionPrimaryAlderSekundary();
        } else if (menuvalg == 8 ) {
            alderPrimaryRegionSekundary();
        } else if (menuvalg == 9) {
            System.exit(0);
        }
    }
    public void showListOfData() {
        for (Covid19Data covid19Data : ARRAYLIST) {
            System.out.println("¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n"
                    + "Region......................... " + ANSI_GREEN + covid19Data.getRegion() + ANSI_RESET + "\n"
                    + "Aldersgruppe................... " + ANSI_BLUE + covid19Data.getAldersGruppe() + ANSI_RESET + "\n"
                    + "Bekræftede tilfælde i alt...... " + ANSI_PURPLE +  covid19Data.getBekræftedeTilfældeIAlt() + ANSI_RESET + "\n"
                    + "Døde........................... " + ANSI_RED + covid19Data.getDøde() + ANSI_RESET + "\n"
                    + "Indlagte på intensiv afdeling.. " + ANSI_CYAN + covid19Data.getIndlagtePåIntensivAfdeling() + ANSI_RESET + "\n"
                    + "Indlagte....................... " + ANSI_CYAN + covid19Data.getIndlagte() + ANSI_RESET + "\n"
                    + "Dato........................... " + covid19Data.getDato());
        }

    }
    public void showRegionSortedList() {
        ARRAYLIST.sort(new RegionComparator());
        showListOfData();
    }
    public void showAldersGruppeSortedList() {
        ARRAYLIST.sort(new AldersGruppeComparator());
        showListOfData();

    }
    public void bekræftedeTilfældeIAlt() {
        ARRAYLIST.sort(new BekræftedeTilfældeIAlt());
        showListOfData();

    }
    public void showDødeShortedList(){
        ARRAYLIST.sort(new DødeComparator());
        showListOfData();
    }
    public void indlagtePåIntensiv(){
        ARRAYLIST.sort(new IndlagtePåIntensivAfdeling());
        showListOfData();
    }
    public void inlagteIAlt(){
        ARRAYLIST.sort(new InlagteIAlt());
        showListOfData();
    }
    public void regionPrimaryAlderSekundary(){
        ARRAYLIST.sort(new RegionComparator().thenComparing(new AldersGruppeComparator()));
        showListOfData();

    }
    public void alderPrimaryRegionSekundary(){
        ARRAYLIST.sort(new AldersGruppeComparator().thenComparing(new RegionComparator())); //.reversed ændre på vist rækkefølge hvis man vil have fra størst til mindst.
        showListOfData();

    }




}
