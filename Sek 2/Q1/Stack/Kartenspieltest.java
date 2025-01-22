public class Kartenspieltest {
    public static void main(String[] args) {
        Kartenspiel spielderkarten = new Kartenspiel();
        
        Karte karte1 = new Karte();
        Karte karte2 = new Karte();
        
        karte1.setKartenaufgedeckt(true);
        karte1.setMuster("Karo");
        karte2.setKartenaufgedeckt(false);
        karte2.setMuster("Pik");
        
        System.out.println("Test 1: Karten auf Stapel legen");
        spielderkarten.karteAufStapelLegen(karte1);
        spielderkarten.karteAufStapelLegen(karte2);
        spielderkarten.obersteKarteAusgeben();
        
        System.out.println("\nTest 2: Karte vom Stapel nehmen");
        spielderkarten.karteVomStapelNehmen();
        spielderkarten.obersteKarteAusgeben();
        
        System.out.println("\nTest 3: Letzte Karte vom Stapel nehmen");
        spielderkarten.karteVomStapelNehmen();
        spielderkarten.obersteKarteAusgeben();
    }
}