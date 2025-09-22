public class Graph {

  private Stadt[] knotenliste;
  private boolean[][] kantenmatrix;
  private int maxKnoten;
  private int anzahl;

  public Graph(int m) {
    maxKnoten = m;
    anzahl = 0;
    knotenliste = new Stadt[m];
    kantenmatrix = new boolean[m][m];
  }

  /**
   * Falls anzahl kleiner maxKnoten, wird das Objekt s in das Array gespeichert,
   * andernfalls wird eine Fehlermeldung ausgegeben, dass die maximale Anzahl an Knoten
   * schon erreicht ist.
   */
  public void einfügenKnoten(Stadt s) {
    // TODO: Implementieren: prüfen, ob anzahl < maxKnoten und s nicht null,
    // dann knotenliste[anzahl++] = s; sonst Fehlermeldung/Exception
  }

  /** Prüft, ob die gesuchte Stadt identisch ist mit der Stadt ausListe. */
  public boolean vergleiche(Stadt gesucht, Stadt ausListe) {
    // TODO: Implementieren: ggf. null-Checks und Vergleichslogik
    return gesucht != null && gesucht.equals(ausListe);
  }

  /**
   * Erzeugt eine bidirektionale Kante zwischen den Städten s1 und s2 in diesem
   * Graphen, sofern beide Städte in der Knotenliste des Graphen enthalten sind.
   */
  public void kanteEinfuegen(Stadt s1, Stadt s2) {
    // TODO: Implementieren: indexOf(s1), indexOf(s2) verwenden,
    // falls beide >= 0: kantenmatrix[i][j] = kantenmatrix[j][i] = true
  }

  // Die Hilfsmethode indexOf ist in der Methode kanteEinfuegen zu verwenden.
  private int indexOf(Stadt s) {
    if (s == null) throw new IllegalArgumentException("s ist null");
    for (int i = 0; i < knotenliste.length; i++) {
      if (s.equals(knotenliste[i])) {
        return i;
      }
    }
    return -1;
  }
}
