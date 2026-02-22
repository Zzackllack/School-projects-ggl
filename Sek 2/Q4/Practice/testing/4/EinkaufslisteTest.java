public class EinkaufslisteTest {

    public static void main(String[] args) {
        Artikel A1 = new Artikel("Artikel 1");
        Artikel A2 = new Artikel("Artikel 2");
        Artikel A3 = new Artikel("Artikel 3");
        Artikel A4 = new Artikel("Artikel 4");
        Artikel A5 = new Artikel("Artikel 5");
        Artikel A6 = new Artikel("Artikel 6");

        Einkaufsliste Ekl = new Einkaufsliste();

        Ekl.neuerArtikel(A1);
        Ekl.neuerArtikel(A2);
        Ekl.neuerArtikel(A3);
        Ekl.neuerArtikel(A4);
        Ekl.neuerArtikel(A5);
        Ekl.neuerArtikel(A6);
        Ekl.listeAusgeben();
        Ekl.sucheArtikel("Artikel 1");
        Ekl.loeschen("Artikel 1");
        Ekl.sucheArtikel("Artikel 1");
        Ekl.listeAusgeben();
    }
}
