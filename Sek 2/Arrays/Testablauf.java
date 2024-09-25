public class Testablauf {

    Taxi taxiA, taxiB, taxiC, taxiD;
    TaxiWarteschlange warteschlange = new TaxiWarteschlange();

    public void taxiAttributeSetzen() {
        taxiA = new Taxi();
        taxiB = new Taxi();
        taxiC = new Taxi();
        taxiD = new Taxi();

        taxiA.setFahrerNachname("Müller");
        taxiA.setKennzeichen("ABC-123");

        taxiB.setFahrerNachname("Fischer");
        taxiB.setKennzeichen("DEF-456");

        taxiC.setFahrerNachname("Schmidt");
        taxiC.setKennzeichen("GHI-789");

        taxiD.setFahrerNachname("Meyer");
        taxiD.setKennzeichen("GHG-787");
    }

    public void ablaufen() {
        warteschlange.hintenAnstellen(taxiA);
        warteschlange.hintenAnstellen(taxiC);
        warteschlange.hintenAnstellen(taxiB);

        warteschlange.vorneAbfahren();

        warteschlange.fahrernamenAusgeben();
    }

    public static void main(String[] args) {
        Testablauf test = new Testablauf();
        test.taxiAttributeSetzen();
        test.ablaufen();
    }
}
