public class Einkaufsliste {
    private List <Artikel> artikelliste;
    
    public Einkaufsliste() {
        artikelliste = new List<>();
    }

    public void neuerArtikel(Artikel pArtikel) {
        artikelliste.append(pArtikel);
    }

    public boolean sucheArtikel(String pName) {
        artikelliste.toFirst();
        while (artikelliste.hasAccess()) {
            if (artikelliste.getContent().getName().equals(pName)) {
                return true;
            }
            artikelliste.next();
        }
        return false;
    }

    public void loescheArtikel(String pName) {
        artikelliste.toFirst();
        while (artikelliste.hasAccess()) {
            if (artikelliste.getContent().getName().equals(pName)) {
                artikelliste.remove();
                System.out.println("Artikel " + pName + " wurde gelöscht.");
                return;
            }
            artikelliste.next();
        }
        System.out.println("Artikel " + pName + " wurde nicht gefunden.");
    }

    public void listeAusgeben() {
        artikelliste.toFirst();
        while (artikelliste.hasAccess()) {
            System.out.println(artikelliste.getContent().getName());
            artikelliste.next();
        }
    }
}
