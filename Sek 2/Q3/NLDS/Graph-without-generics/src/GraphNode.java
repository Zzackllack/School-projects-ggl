/**
 * <p>Materialien zu den zentralen
 * Abiturpruefungen im Fach Informatik ab 2012 in 
 * Nordrhein-Westfalen.</p>
 * <p>Klasse GraphNode</p>
 * <p>Ein ungerichteter Graph besteht aus einer Menge 
 * von Knoten und einer Menge von Kanten. Die Kanten 
 * verbinden jeweils zwei Knoten und koennen ein Gewicht haben.
 * Objekte der Klasse GraphNode sind Knoten eines Graphen. 
 * Ein Knoten hat einen Namen und kann markiert werden.
</p>
 * 
 * <p>NW-Arbeitsgruppe: Materialentwicklung zum Zentralabitur 
 * im Fach Informatik</p>
 * 
 * 
 */

public class GraphNode {

  private final String name; //Can be final but does not need to be
  private final List<Edge> edges; //Can be final but does not need to be
  private boolean marked;

  /**
   *Ein Knoten mit dem Namen pName wird erzeugt.
   *Der Knoten ist nicht markiert.
   *@param pName Bezeichnung des Knotens
   */
  @SuppressWarnings("Convert2Diamond")
  public GraphNode(String pName) {
    name = pName;
    edges = new List<Edge>();
    marked = false;
  }

  /**
   * Der Knoten wird markiert. Falls er
   * nicht markiert ist, sonst bleibt er unveraendert.
   */
  public void mark() {
    marked = true;
  }

  /**
   * Die Markierung des Knotens wird entfernt, falls er markiert ist,
   * sonst bleibt er unveraendert.
   */
  public void unmark() {
    marked = false;
  }

  /**
   * Die Anfrage liefert den Wert true, wenn der Knoten markiert ist,
   * sonst liefert sie den Wert false.
   * @return true falls markiert, sonst false
   */
  public boolean isMarked() {
    return marked;
  }

  /**
   * Die Anfrage liefert den Namen des Knotens.
   * @return Bezeichnung des Knotens
   */
  public String getName() {
    return name;
  }

  // Hilfsmethoden
  /**
   * Interne Methode
   */
  void addEdge_(GraphNode pNode, double pWeight) {
    Edge lEdge = new Edge(pNode, pWeight);
    if (lEdge != null) edges.append(lEdge);
  }

  /**
   * Interne Methode
   */
  double getEdgeWeight_(GraphNode pNode) {
    boolean ok = false;
    Edge e = null;
    edges.toFirst();
    while (!ok && edges.hasAccess()) {
      e = edges.getContent();
      if (e.getNeighbour() == pNode) ok = true;
      edges.next();
    }
    if (e == null) return Double.NaN;
    // Not a Number
    else return e.getWeight();
  }

  /**
   * Interne Methode
   */
  void removeEdge_(GraphNode pNode) {
    if (pNode != null) {
      Edge e;
      edges.toFirst();
      while (edges.hasAccess()) {
        e = edges.getContent();
        if (e.getNeighbour() == pNode) edges.remove();
        edges.next();
      }
    }
  }

  /**
   * Interne Methode
   */
  List<GraphNode> getNeighbours_() {
    // liefert eine Liste mit den Nachbarknoten
    @SuppressWarnings("Convert2Diamond")
    List<GraphNode> lList = new List<GraphNode>();
    edges.toFirst();
    while (edges.hasAccess()) {
      Edge lEdge = edges.getContent();
      lList.append(lEdge.getNeighbour());
      edges.next();
    }
    return lList;
  }
}
