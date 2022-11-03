package fileHandler;
import covid19Data.Covid19Data;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
public class Filehandler {

    public ArrayList<Covid19Data> loadData() throws IOException {
        ArrayList<Covid19Data> covid19DataArrayList = new ArrayList<>();
        Scanner reader = new Scanner(new File("data\\11_noegletal_pr_region_pr_aldersgruppe.csv"), StandardCharsets.ISO_8859_1);

        while(reader.hasNextLine()){
            String line = reader.nextLine();
            covid19DataArrayList.add(parseCsvLine(line));

        }
        return covid19DataArrayList;

    }

    private Covid19Data parseCsvLine(String line) {
        String[] parts = line.split(";");

        Covid19Data dataObjekt = new Covid19Data();
        dataObjekt.setRegion(parts[0]);

        dataObjekt.setAldersGruppe(parts[1]);
        dataObjekt.setBekræftedeTilfældeIAlt(Integer.parseInt(parts[2]));
        dataObjekt.setDøde(Integer.parseInt(parts[3]));
        dataObjekt.setIndlagtePåIntensivAfdeling(Integer.parseInt(parts[4]));
        dataObjekt.setIndlagte(Integer.parseInt(parts[5]));
        dataObjekt.setDato(parts[6]);

        return dataObjekt;
    }



}
