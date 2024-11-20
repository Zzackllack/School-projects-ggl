public class Kartenspiel {
    private Stack<Karte> kartenstapel;
    private int zaehler;  // Fixed typo
    
    public Kartenspiel() {
        kartenstapel = new Stack<Karte>();
        zaehler = 0;  // Fixed initialization
    }

    public void karteAufStapelLegen(Karte pKarte) {
        kartenstapel.push(pKarte);
        zaehler++;
    }
    
    public void karteVomStapelNehmen() {  // Removed unnecessary parameter
        if (!kartenstapel.isEmpty()) {
            kartenstapel.pop();
            zaehler--;
        }
    }
    
    public void obersteKarteAusgeben() {
        Karte obersteKarte = kartenstapel.top();
        if (obersteKarte != null) {
            System.out.println("Oberste Karte:");
            System.out.println("Muster: " + obersteKarte.getMuster());
            System.out.println("Aufgedeckt: " + obersteKarte.isKartenaufgedeckt());
        } else {
            System.out.println("Der Kartenstapel ist leer.");
        }
    }
}