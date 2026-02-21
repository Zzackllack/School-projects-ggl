public class Fahrzeug {
    private String Modell;
    private String Farbe;
    private String Kennzeichen;
    private String Verkehrstauglichkeit;

    public Fahrzeug(String pModell, String pFarbe, String pKennzeichen, String pVerkehrstauglichkeit) {
        Modell = pModell;
        Farbe = pFarbe;
        Kennzeichen = pKennzeichen;
        Verkehrstauglichkeit = pVerkehrstauglichkeit;
    }

    public String getModell() {
        return Modell;
    }

    public String getFarbe() {
        return Farbe;
    }

    public String getKennzeichen() {
        return Kennzeichen;
    }

    public String getVerkehrstauglichkeit() {
        return Verkehrstauglichkeit;
    }
}
