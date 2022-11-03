package comparatorer;

import covid19Data.Covid19Data;

import java.util.Comparator;

public class InlagteIAlt implements Comparator<Covid19Data> {
    public int compare(Covid19Data c1, Covid19Data c2){
        return c1.getIndlagte() - c2.getIndlagte();
    }
}
