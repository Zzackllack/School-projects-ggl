public class KartenspielTest {
    public static void main(String[] args) {
        Kartenspiel kartenspiel = new Kartenspiel();

        Karte karte1 = new Karte("Herz", 10);
        Karte karte2 = new Karte("Karo", 7);
        Karte karte3 = new Karte("Pik", 5);

        kartenspiel.karteAufStapelLegen(karte1);
        kartenspiel.karteAufStapelLegen(karte2);
        kartenspiel.karteAufStapelLegen(karte3);

        kartenspiel.obersteKarteAusgeben();

        kartenspiel.karteVomStapelNehmen();
        kartenspiel.obersteKarteAusgeben();

        kartenspiel.karteVomStapelNehmen();
        kartenspiel.obersteKarteAusgeben();

        kartenspiel.karteVomStapelNehmen();
        kartenspiel.obersteKarteAusgeben();
    }    
}
