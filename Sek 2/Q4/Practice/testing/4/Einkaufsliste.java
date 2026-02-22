public class Einkaufsliste {
    List<Artikel> artikelListe = new List<>();

    public void neuerArtikel(Artikel pArtikel){
        artikelListe.toFirst();
        if (pArtikel == null){
            System.out.println("Leerer Artikel... geht nicht");
        } else {
            artikelListe.insert(pArtikel);
        }
    }

    public boolean sucheArtikel(String pName){
        artikelListe.toFirst();
        while(artikelListe.hasAccess()){
            Artikel temp = artikelListe.getContent();
            if (temp.getName().equals(pName)){
                return true;
            }
            artikelListe.next();
        } 
        return false;
    }

    public void loeschen(String pName){
        artikelListe.toFirst();
        while(artikelListe.hasAccess()){
            Artikel temp2 = artikelListe.getContent();
            if(temp2.getName().equals(pName)){
                artikelListe.remove();
            }
            artikelListe.next();
        }
        System.out.println("Artikel nicht gefunden.");
    }

    public void listeAusgeben(){
        artikelListe.toFirst();
        while(artikelListe.hasAccess()){
            Artikel temp3 = artikelListe.getContent();
            System.out.println("[Artikel Ausgabe]" + temp3.getName());
            artikelListe.next();
        }
    }
}
