public class Binaerbaum {
  
  private Baumelement wurzel;
  
  public Binaerbaum() {
    wurzel = new Abschluss();
  }
  
  public void wurzelSetzen(Baumelement w) {
    wurzel = w;
  }
  public Baumelement wurzelGeben() {
    return wurzel;
  }
  
  public int anzahlKnotenGeben() {
    return wurzel.anzahlDatenknotenGeben(); 
  }
  
  public double gesamtwertGeben() {
    return wurzel.gesamtwertGeben();  
  }
  
  public void datenPreorderAusgeben() {
    wurzel.datenPreorderAusgeben();
  }
  
  public void datenInorderAusgeben() {
    wurzel.datenInorderAusgeben();
  }
  
  public void datenPostorderAusgeben() {
    wurzel.datenPostorderAusgeben();
  }

}
