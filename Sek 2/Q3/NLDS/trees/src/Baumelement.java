/**
 * 
 */

public abstract class Baumelement {
   
  public abstract void naechsterLinksSetzen(Baumelement nl);
  public abstract void naechsterRechtsSetzen(Baumelement nr);
  public abstract Baumelement naechsterLinksGeben();
  public abstract Baumelement naechsterRechtsGeben();
  public abstract Datenelement inhaltGeben();
  public abstract int anzahlDatenknotenGeben();
  public abstract int gesamtwertGeben();
  public abstract void datenPreorderAusgeben();
  public abstract void datenInorderAusgeben();
  public abstract void datenPostorderAusgeben();
   
}
