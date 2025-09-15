public class Datenknoten extends Baumelement{

  private Baumelement naechsterLinks, naechsterRechts;
  private Datenelement inhalt;
  
  public Datenknoten (Baumelement nl, Baumelement nr, Datenelement i) {

    naechsterLinks = nl;
    naechsterRechts = nr;
    inhalt = i;
  }

  public void naechsterLinksSetzen(Baumelement nl) {
    naechsterLinks = nl;
  }

  public void naechsterRechtsSetzen(Baumelement nr) {
    naechsterRechts = nr;
  }

  public void inhaltSetzen(Datenelement i) {
    inhalt = i;
  }

  public Baumelement naechsterLinksGeben() {
    return naechsterLinks;
  }


  public Baumelement naechsterRechtsGeben() {
    return naechsterRechts;
  }

  public Datenelement inhaltGeben() {
    return inhalt;
  }

  //rekursive Baummethoden
  public int anzahlDatenknotenGeben() {

    return 1 + naechsterLinks.anzahlDatenknotenGeben() + naechsterRechts.anzahlDatenknotenGeben();
  }

  public int gesamtwertGeben() {

    return inhalt.wertGeben();
  }


  public void datenPreorderAusgeben() {
    inhalt.datenAusgeben();
    naechsterLinks.datenPreorderAusgeben();
    naechsterRechts.datenPreorderAusgeben();  
  }

  public void datenInorderAusgeben() {
    naechsterLinks.datenInorderAusgeben();
    inhalt.datenAusgeben();
    naechsterRechts.datenInorderAusgeben();
  }

  public void datenPostorderAusgeben() {
    naechsterLinks.datenPostorderAusgeben();
    naechsterRechts.datenPostorderAusgeben();
    inhalt.datenAusgeben();
  }
}
