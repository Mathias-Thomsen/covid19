package covid19Data;


public class Covid19Data {
    private String region;
    private String aldersGruppe;
    private int bekræftedeTilfældeIAlt;
    private int døde;
    private int indlagtePåIntensivAfdeling;
    private int indlagte;
    private String dato; //TODO: lav måske om til localdate

    public Covid19Data(){

    }
    public Covid19Data(String region, String aldersGruppe, int bekræftedeTilfældeIAlt, int døde, int indlagtePåIntensivAfdeling, int indlagte, String dato) {
        this.region = region;
        this.aldersGruppe = aldersGruppe;
        this.bekræftedeTilfældeIAlt = bekræftedeTilfældeIAlt;
        this.døde = døde;
        this.indlagtePåIntensivAfdeling = indlagtePåIntensivAfdeling;
        this.indlagte = indlagte;
        this.dato = dato;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAldersGruppe() {
        return aldersGruppe;
    }

    public void setAldersGruppe(String aldersGruppe) {
        this.aldersGruppe = aldersGruppe;
    }

    public int getBekræftedeTilfældeIAlt() {
        return bekræftedeTilfældeIAlt;
    }

    public void setBekræftedeTilfældeIAlt(int bekræftedeTilfældeIAlt) {
        this.bekræftedeTilfældeIAlt = bekræftedeTilfældeIAlt;
    }

    public int getDøde() {
        return døde;
    }

    public void setDøde(int døde) {
        this.døde = døde;
    }

    public int getIndlagtePåIntensivAfdeling() {
        return indlagtePåIntensivAfdeling;
    }

    public void setIndlagtePåIntensivAfdeling(int indlagtePåIntensivAfdeling) {
        this.indlagtePåIntensivAfdeling = indlagtePåIntensivAfdeling;
    }

    public int getIndlagte() {
        return indlagte;
    }

    public void setIndlagte(int indlagte) {
        this.indlagte = indlagte;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }












    }

