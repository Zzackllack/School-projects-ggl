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
    if (s == null) {
      throw new IllegalArgumentException("Stadt darf nicht null sein");
    }
    if (anzahl < maxKnoten) {
      knotenliste[anzahl++] = s;
    } else {
      System.err.println("Maximale Anzahl an Knoten bereits erreicht: " + maxKnoten);
    }
  }

  /** Prüft, ob die gesuchte Stadt identisch ist mit der Stadt ausListe. */
  public boolean vergleiche(Stadt gesucht, Stadt ausListe) {
    if (gesucht == null || ausListe == null) return false;
    // If the objects are the same or equals() was overridden, accept that
    if (gesucht.equals(ausListe)) return true;
    // Otherwise try a logical comparison by name (+ province) when available
    String n1 = gesucht.getName();
    String n2 = ausListe.getName();
    if (n1 != null && n2 != null && n1.equals(n2)) {
      String p1 = gesucht.getProvinz();
      String p2 = ausListe.getProvinz();
      if (p1 == null && p2 == null) return true;
      if (p1 != null && p1.equals(p2)) return true;
    }
    return false;
  }

  /**
   * Erzeugt eine bidirektionale Kante zwischen den Städten s1 und s2 in diesem
   * Graphen, sofern beide Städte in der Knotenliste des Graphen enthalten sind.
   */
  public void kanteEinfuegen(Stadt s1, Stadt s2) {
    if (s1 == null || s2 == null) {
      throw new IllegalArgumentException("Stadt ist null");
    }
    int i = indexOf(s1);
    int j = indexOf(s2);
    if (i >= 0 && j >= 0) {
      kantenmatrix[i][j] = true;
      kantenmatrix[j][i] = true;
    } else {
      System.err.println("Kante nicht eingefügt: eine oder beide Städte nicht in der Liste (" + i + ", " + j + ")");
    }
  }

  // Die Hilfsmethode indexOf ist in der Methode kanteEinfuegen zu verwenden.
  private int indexOf(Stadt s) {
    /**
     * Sucht den Index einer Stadt in der Knotenliste.
     *
     * @param s die zu suchende Stadt; darf nicht null sein
     * @return der Index der Stadt in der Knotenliste oder -1, falls nicht vorhanden
     * @throws IllegalArgumentException wenn s null ist
     */
    if (s == null) throw new IllegalArgumentException("s ist null");
    for (int i = 0; i < knotenliste.length; i++) {
      if (s.equals(knotenliste[i])) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Gibt die Adjazenzmatrix und die aktuelle Knotenliste auf der Konsole aus.
   * Zeigt nur die ersten {@code anzahl} Knoten an.
   */
  public void matrixAusgeben() {
    System.out.println("Knotenliste (anzahl=" + anzahl + "):");
    for (int i = 0; i < anzahl; i++) {
      System.out.print((knotenliste[i] != null ? knotenliste[i].getName() : "null") + "\t");
    }
    System.out.println();

    System.out.println("Adjazenzmatrix:");
    // Header
    System.out.print("\t");
    for (int i = 0; i < anzahl; i++) {
      System.out.print((knotenliste[i] != null ? knotenliste[i].getName() : "null") + "\t");
    }
    System.out.println();

    for (int i = 0; i < anzahl; i++) {
      System.out.print((knotenliste[i] != null ? knotenliste[i].getName() : "null") + "\t");
      for (int j = 0; j < anzahl; j++) {
        System.out.print((kantenmatrix[i][j] ? "1" : "0") + "\t");
      }
      System.out.println();
    }
  }
}
