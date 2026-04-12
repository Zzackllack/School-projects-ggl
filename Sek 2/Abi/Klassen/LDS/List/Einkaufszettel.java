//List

public class Einkaufszettel {

    List <Artikel> einkaufsliste = new List<Artikel>();

    public void neuerArtikel(Artikel pArtikel) {
        if (pArtikel == null) {
            System.err.println("cannot be null");
            return;
        }
        einkaufsliste.append(pArtikel);
    }

    public boolean sucheArtikel(String pName) {
        einkaufsliste.toFirst();
        while(einkaufsliste.hasAccess()) {
            if(pName.equals(einkaufsliste.getContent().getName())) {
                return true;
            }
        }
        return false;
    }

    public void loeschen (String pName) {
        if (pName.equals("")) {
            System.err.println("Needs to be a string");
        }
        if (sucheArtikel(pName)) {
            einkaufsliste.remove();
        }
        else {
            System.err.println("Not found");
        }
    }

    public void listeAusgeben() {
        while(einkaufsliste.hasAccess()) {
            System.out.println(einkaufsliste.getContent().getName());
            einkaufsliste.next();
        }
    }

    public static void main(String[] args) {
        Einkaufszettel z = new Einkaufszettel();
        Artikel a = new Artikel("Auto", 3000);
        z.neuerArtikel(a);
        boolean gefunden = z.sucheArtikel("Auto"); // z.sucheArtikel(a.getName())
        System.out.println("Gefunden " + gefunden);
        z.listeAusgeben();
    }
}
