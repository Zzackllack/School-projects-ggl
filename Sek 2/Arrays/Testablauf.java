public class Testablauf {

    // Deklaration der Taxi-Objekte
    Taxi taxiA, taxiB, taxiC, taxiD;
    // Erstellen einer Instanz von TaxiWarteschlange
    TaxiWarteschlange warteschlange = new TaxiWarteschlange();

    /**
     * Initialisiert und setzt Attribute für jedes Taxi.
     */
    public void taxiAttributeSetzen() {
        // Erstellen neuer Taxi-Objekte
        taxiA = new Taxi();
        taxiB = new Taxi();
        taxiC = new Taxi();
        taxiD = new Taxi();

        // Setzen der Attribute für taxiA
        taxiA.setFahrerNachname("Müller");
        taxiA.setKennzeichen("ABC-123");

        // Setzen der Attribute für taxiB
        taxiB.setFahrerNachname("Fischer");
        taxiB.setKennzeichen("DEF-456");

        // Setzen der Attribute für taxiC
        taxiC.setFahrerNachname("Schmidt");
        taxiC.setKennzeichen("GHI-789");

        // Setzen der Attribute für taxiD
        taxiD.setFahrerNachname("Meyer");
        taxiD.setKennzeichen("GHG-787");
    }

    /**
     * Simuliert die Operationen der Taxi-Warteschlange.
     */
    public void ablaufen() {
        // Hinzufügen von Taxis zur Warteschlange
        warteschlange.hintenAnstellen(taxiA);
        warteschlange.hintenAnstellen(taxiC);
        warteschlange.hintenAnstellen(taxiB);

        // Entfernen des ersten Taxis aus der Warteschlange
        warteschlange.vorneAbfahren();

        // Ausgeben der Namen der Fahrer in der Warteschlange
        warteschlange.fahrernamenAusgeben();
    }

    /**
     * Hauptmethode zum Starten des Programms.
     * @param args
     */
    public static void main(String[] args) {
        // Erstellen einer Instanz von Testablauf
        Testablauf test = new Testablauf();
        // Setzen der Attribute für die Taxis
        test.taxiAttributeSetzen();
        // Simulieren der Operationen der Taxi-Warteschlange
        test.ablaufen();
    }
}
