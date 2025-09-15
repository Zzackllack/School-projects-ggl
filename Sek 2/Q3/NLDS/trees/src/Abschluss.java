/**
 * 
 */
public class Abschluss extends Baumelement {


  public void naechsterLinksSetzen(Baumelement nl) {  

  }

  public void naechsterRechtsSetzen(Baumelement nr) {
  }

  public Baumelement naechsterLinksGeben() {

    System.out.println("Kein linker Nachfolger");
    return this;
  }

  public Baumelement naechsterRechtsGeben() {
    System.out.println("Kein rechter Nachfolger");
    return this;
  }

  public Datenelement inhaltGeben() {   
    return null;
  }

  public int anzahlDatenknotenGeben() {   
    return 0;
  }

  public int gesamtwertGeben() {
    return 0;
  }

  public void datenPreorderAusgeben() {
    //Stopp: enthält keine Daten
  }


  public void datenInorderAusgeben() {
    //Stopp: enthält keine Daten    
  }

  public void datenPostorderAusgeben() {
    //Stopp: enthält keine Daten    
  }
  

}
