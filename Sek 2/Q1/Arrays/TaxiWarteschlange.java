public class TaxiWarteschlange {

  private Taxi [] taxistand;
  private int anzahlTaxis;

  // Konstruktor: Initialisiert eine neue TaxiWarteschlange mit einem Array für 6 Taxis.
  public TaxiWarteschlange() {
    taxistand = new Taxi [6];
    anzahlTaxis = 0;
  }

  // Fügt ein Taxi hinten in die Warteschlange ein.
  public void hintenAnstellen (Taxi t) {
    if (anzahlTaxis == 6) {
      System.out.println("Fehler: kein Platz mehr frei!");
    }else {
      taxistand [anzahlTaxis] = t;
      anzahlTaxis = anzahlTaxis+1;

    }
  }

  // Entfernt das erste Taxi aus der Warteschlange und gibt es zurück.
  public Taxi vorneAbfahren() {
    Taxi erstesTaxi = null;
    if (anzahlTaxis == 0) {
      System.out.println("Fehler: kein Taxi in der Schlange!");     
    }else {
      erstesTaxi = taxistand [0];
      for (int i = 1; i < anzahlTaxis; i++) {
        taxistand[i - 1] = taxistand[i];
      }
      taxistand [anzahlTaxis - 1] = null;
      anzahlTaxis = anzahlTaxis-1;
    }   
    return erstesTaxi;

  }

  // Gibt die Nachnamen aller Fahrer in der Warteschlange aus.
  public void fahrernamenAusgeben() {
    for (int i = 0; i< anzahlTaxis; i++) {
      //System.out.println(i+1 + ". " + taxistand[i].getFahrerNachnahme());
      System.out.println(taxistand[i].getFahrerNachname());
    }

  }

}
