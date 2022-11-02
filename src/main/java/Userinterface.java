import java.io.IOException;

public class Userinterface {

    public static void main(String[] args) throws IOException {
        Filehandler filehandler = new Filehandler();

            for (Covid19Data covid19Data : filehandler.loadData()) {
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
