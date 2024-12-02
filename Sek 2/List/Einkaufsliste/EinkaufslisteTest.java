public class EinkaufslisteTest {
    public static void main(String[] args) {
        Einkaufsliste liste = new Einkaufsliste();

        liste.neuerArtikel(new Artikel("Apfel"));
        liste.neuerArtikel(new Artikel("Birne"));
        liste.neuerArtikel(new Artikel("Banane"));
        liste.neuerArtikel(new Artikel("Kiwi"));

        System.out.println("Die Liste:");
        liste.listeAusgeben();

        System.out.println("Suche nach Banane: " + liste.sucheArtikel("Banane"));
        System.out.println("Suche nach Orange: " + liste.sucheArtikel("Orange"));

        liste.loescheArtikel("Banane");
        liste.loescheArtikel("Orange");

        System.out.println("Die Liste (nach dem sie gelöscht wurde):");
        liste.listeAusgeben();
    }
}
