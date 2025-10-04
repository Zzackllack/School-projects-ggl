# Schreibe als Vorbereitung für meine Informatik Klausur mir einen Notion Lernzettel basierend auf den Informationen des Transparenzpapiers, der PDFS und der Java Klassen/Code, orientiere dich stark an den Materialien beim Schreiben des Lernzettels, das heißt Lösungen von den Materialien übernehmen/wiedergeben, gleicher Aufbau Struktur etc. schreibe in Markdown mit vollen Beispielen, Erklärungen basierend auf dem Material etc. - Angehängte Java Klassen sind gelöste Aufgaben und müssen nicht verändert werden.

### Transparenzpapier:

```markdown
# Informatik-LK: Vorbereitung für die 1. Klausur am 08.10.25

## Themen für die 1. LK-Klausur:

1. Skript Leitprogramm_Bäume.pdf

- Kapitel 3: 3.2 Definition von Binärbäumen, 3.3 Durchlaufordnungen (Traversierungsarten - Beschreibungen ohne Pseudocode), 3.3.1 Pseudocode (auch für inorder und postorder), Aufgaben 3.2, 3.4 und 3.7
- 3.4 Lernkontrolle: Aufgaben 3.8, 3.9.
- Kapitel 4: 4.2 Definition von binären Suchbäumen, Aufgaben 4.1 und 4.2
- 4.3.2 Pseudocode insert(v,k)
- 4.3.3 Drei Fälle beschreiben, Aufgaben 4.9 und 4.10.
- 4.4 Lernkontrolle: Aufgaben 4.14, 4.15 und 4.17.
- Kapitel 5: 5.2 Laufzeitbetrachtungen, 5.3 AVL-Bäume Definition, bal(v), ausgeglichen, Aufgabe 5.1.

2. Klassen aus dem folgenden Projekt:

- Projekt binarySearchTree: Klassen Benutzerprofil und Benutzerverwaltung, Testklasse

3. Graphen:

- Begriffe: Graph, Knoten, Kante, gerichtet, ungerichtet, gewichtet,
- Adjazenzmatrix, Tiefensuche und Breitensuche (Pseudocode und kurze Beschreibung)
- Arbeitsaufträge im Ordner Graphen: Graph_2D_Stadt und Graph_Klassen_Ohne_Generics

**Hinweis**: Auch Testklassen (wenn vorhanden) sind klausurrelevant!
```

### Materialien:

- Leitprogramm_Bäume.pdf (siehe Anhang)
- Projekt binarySearchTree:

```java
//Klasse Benutzerprofil.java
public class Benutzerprofil implements ComparableContent<Benutzerprofil>
{
 private String benutzername, pw;
 /**
  * Konstruktor für Objekte der Klasse Benutzerprofil
  */
 public Benutzerprofil(String pBenutzername, String pPw)
 {
  benutzername = pBenutzername;
  pw = pPw;
 }

 public String getBenutzername()
 {
  return benutzername;
 }
 

    public boolean isGreater(Benutzerprofil pProfil) { 
  return this.getBenutzername().compareTo(pProfil.getBenutzername())>0; }

 public boolean isLess(Benutzerprofil pProfil) { 
  return this.getBenutzername().compareTo(pProfil.getBenutzername())<0; }

 public boolean isEqual(Benutzerprofil pProfil) { 
  return this.getBenutzername().compareTo(pProfil.getBenutzername())==0; }


}
```

```java
//Klasse Benutzerverwaltung.java
public class Benutzerverwaltung
{
 private BinarySearchTree<Benutzerprofil> benutzerBaum = new BinarySearchTree<Benutzerprofil>();

 public void neuenNutzerAnlegen(String pBenutzername, String pPw)
 {
  Benutzerprofil b = new Benutzerprofil(pBenutzername, pPw);
  benutzerBaum.insert(b);
  //Alternative:
  //benutzerBaum.insert(new Benutzerprofil(pBenutzername, pPw));
 }

 public void nutzerLoeschen(String pBenutzername, String pPw)
 {
  Benutzerprofil b = new Benutzerprofil(pBenutzername, pPw);
  benutzerBaum.remove(b);
 }

 public boolean profilVorhanden(String pBenutzername) 
 {
  Benutzerprofil found = benutzerBaum.search(new Benutzerprofil(pBenutzername, ""));
  return found != null;
  //Alternative
  /*
   * if(found != null) { return true; } else return false;
   */
  
 }
}
```

```java
/**
* <p>
* Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2017.
* </p>
* <p>
* Generische Klasse BinarySearchTree<ContentType>
* </p>
* <p>
* Mithilfe der generischen Klasse BinarySearchTree koennen beliebig viele
* Objekte in einem Binaerbaum (binaerer Suchbaum) entsprechend einer
* Ordnungsrelation verwaltet werden. <br />
* Ein Objekt der Klasse stellt entweder einen leeren binaeren Suchbaum dar oder
* verwaltet ein Inhaltsobjekt sowie einen linken und einen rechten Teilbaum,
* die ebenfalls Objekte der Klasse BinarySearchTree sind.<br />
* Die Klasse der Objekte, die in dem Suchbaum verwaltet werden sollen, muss
* das generische Interface ComparableContent implementieren. Dabei muss durch
* Ueberschreiben der drei Vergleichsmethoden isLess, isEqual, isGreater (s.
* Dokumentation des Interfaces) eine eindeutige Ordnungsrelation festgelegt
* sein. <br />
* Alle Objekte im linken Teilbaum sind kleiner als das Inhaltsobjekt des
* binaeren Suchbaums. Alle Objekte im rechten Teilbaum sind groesser als das
* Inhaltsobjekt des binaeren Suchbaums. Diese Bedingung gilt (rekursiv) auch in
* beiden Teilbaeumen. <br />
* Hinweis: In dieser Version wird die Klasse BinaryTree nicht benutzt.
* </p>
* 
* @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
* @version Generisch_02 2014-02-21
*/
public class BinarySearchTree<ContentType extends ComparableContent<ContentType>> { //ContentType ist auch ein Interface, das hier die Methoden von ComparableContent erben soll.

 /* --------- Anfang der privaten inneren Klasse -------------- */

 /**
  * Durch diese innere Klasse kann man dafuer sorgen, dass ein leerer Baum
  * null ist, ein nicht-leerer Baum jedoch immer eine nicht-null-Wurzel sowie
  * nicht-null-Teilbaeume hat.
  */
 private class BSTNode<CT extends ComparableContent<CT>> {
   
  private CT content;
  private BinarySearchTree<CT> left, right;

  public BSTNode(CT pContent) {
   // Der Knoten hat einen linken und rechten Teilbaum, die 
   // beide von null verschieden sind. Also hat ein Blatt immer zwei 
   // leere Teilbaeume unter sich.
   this.content = pContent;
   left = new BinarySearchTree<CT>();
   right = new BinarySearchTree<CT>();
  }
  
 }

 /* ----------- Ende der privaten inneren Klasse -------------- */

 private BSTNode<ContentType> node;

 /**
  * Der Konstruktor erzeugt einen leeren Suchbaum.
  */
 public BinarySearchTree() {
  this.node = null;
 }

 /**
  * Diese Anfrage liefert den Wahrheitswert true, wenn der Suchbaum leer ist,
  * sonst liefert sie den Wert false.
  * 
  * @return true, wenn der binaere Suchbaum leer ist, sonst false
  * 
  */
 public boolean isEmpty() {
  return this.node == null;
 }

 /**
  * Falls der Parameter null ist, geschieht nichts.<br />
  * Falls ein bezueglich der verwendeten Vergleichsmethode isEqual mit
  * pContent uebereinstimmendes Objekt im geordneten binaeren Suchbau
  * enthalten ist, passiert nichts. <br />
  * Achtung: hier wird davon ausgegangen, dass isEqual genau dann true
  * liefert, wenn isLess und isGreater false liefern. <br />
  * Andernfalls (isLess oder isGreater) wird das Objekt pContent entsprechend
  * der vorgegebenen Ordnungsrelation in den BinarySearchTree eingeordnet.
  * 
  * @param pContent
  *            einzufuegendes Objekt vom Typ ContentType
  *            
  */
 public void insert(ContentType pContent) {
  if (pContent != null) {
   if (isEmpty()) {
    this.node = new BSTNode<ContentType>(pContent);
   } else if (pContent.isLess(this.node.content)) {
    this.node.left.insert(pContent);
   } else if(pContent.isGreater(this.node.content)) {
    this.node.right.insert(pContent);
   }
  }
 }

 /**
  * Diese Anfrage liefert den linken Teilbaum des binaeren Suchbaumes. <br />
  * Wenn er leer ist, wird null zurueckgegeben.
  * 
  * @return den linken Teilbaum (Objekt vom Typ BinarySearchTree<ContentType>) 
  *         bzw. null, wenn der Suchbaum leer ist
  *         
  */
 public BinarySearchTree<ContentType> getLeftTree() {
  if (this.isEmpty()) {
   return null;
  } else {
   return this.node.left;
  }
 }

 /**
  * Diese Anfrage liefert das Inhaltsobjekt des Suchbaumes. Wenn der Suchbaum
  * leer ist, wird null zurueckgegeben.
  * 
  * @return das Inhaltsobjekt vom Typ ContentType bzw. null, wenn der aktuelle
  *         Suchbaum leer ist
  *         
  */
 public ContentType getContent() {
  if (this.isEmpty()) {
   return null;
  } else {
   return this.node.content;
  }
 }

 /**
  * Diese Anfrage liefert den rechten Teilbaum des binaeren Suchbaumes. <br />
  * Wenn er leer ist, wird null zurueckgegeben.
  * 
  * @return den rechten Teilbaum (Objekt vom Typ BinarySearchTree<ContentType>) 
  *         bzw. null, wenn der aktuelle Suchbaum leer ist
  *         
  */
 public BinarySearchTree<ContentType> getRightTree() {
  if (this.isEmpty()) {
   return null;
  } else {
   return this.node.right;
  }
 }

 /**
  * Falls ein bezueglich der verwendeten Vergleichsmethode mit
  * pContent uebereinstimmendes Objekt im binaeren Suchbaum enthalten
  * ist, wird dieses entfernt. Falls der Parameter null ist, aendert sich
  * nichts.
  * 
  * @param pContent
  *            zu entfernendes Objekt vom Typ ContentType
  *            
  */
 public void remove(ContentType pContent) {
  if (isEmpty()) {
   // Abbrechen, da kein Element zum entfernen vorhanden ist.
    return;
  }
  
  if (pContent.isLess(node.content)) {
   // Element ist im linken Teilbaum zu loeschen.
   node.left.remove(pContent);
  } else if (pContent.isGreater(node.content)) {
   // Element ist im rechten Teilbaum zu loeschen.
   node.right.remove(pContent);
  } else {
   // Element ist gefunden.
   if (node.left.isEmpty()) {
    if (node.right.isEmpty()) {
     // Es gibt keinen Nachfolger.
     node = null;
    } else {
     // Es gibt nur rechts einen Nachfolger.
     node = getNodeOfRightSuccessor();
    }
   } else if (node.right.isEmpty()) {
    // Es gibt nur links einen Nachfolger.
    node = getNodeOfLeftSuccessor();
   } else {
    // Es gibt links und rechts einen Nachfolger.
    if (getNodeOfRightSuccessor().left.isEmpty()) {
     // Der rechte Nachfolger hat keinen linken Nachfolger.
     node.content = getNodeOfRightSuccessor().content;
     node.right = getNodeOfRightSuccessor().right;
    } else {
     BinarySearchTree<ContentType> previous = node.right
       .ancestorOfSmallRight();
     BinarySearchTree<ContentType> smallest = previous.node.left;
     this.node.content = smallest.node.content;
     previous.remove(smallest.node.content);
    }
   }
  }  
 }

 /**
  * Falls ein bezueglich der verwendeten Vergleichsmethode isEqual mit
  * pContent uebereinstimmendes Objekt im binaeren Suchbaum enthalten ist,
  * liefert die Anfrage dieses, ansonsten wird null zurueckgegeben. <br />
  * Falls der Parameter null ist, wird null zurueckgegeben.
  * 
  * @param pContent
  *            zu suchendes Objekt vom Typ ContentType
  * @return das gefundene Objekt vom Typ ContentType, bei erfolgloser Suche null
  * 
  */
 public ContentType search(ContentType pContent) {
  if (this.isEmpty() || pContent == null) {
   // Abbrechen, da es kein Element zu suchen gibt.
   return null;
  } else {
   ContentType content = this.getContent();
   if (pContent.isLess(content)) {
    // Element wird im linken Teilbaum gesucht.
    return this.getLeftTree().search(pContent);
   } else if (pContent.isGreater(content)) {
    // Element wird im rechten Teilbaum gesucht.
    return this.getRightTree().search(pContent);
   } else if (pContent.isEqual(content)) {
    // Element wurde gefunden.
     return content;    
   } else { 
     // Dieser Fall sollte nicht auftreten.
    return null;
   }
  }
 }

 /* ----------- Weitere private Methoden -------------- */

 /**
  * Die Methode liefert denjenigen Baum, dessen linker Nachfolger keinen linken
  * Nachfolger mehr hat. Es ist also spaeter moeglich, in einem Baum im
  * rechten Nachfolger den Vorgaenger des linkesten Nachfolgers zu finden.
  * 
  */
 private BinarySearchTree<ContentType> ancestorOfSmallRight() {  
  if (getNodeOfLeftSuccessor().left.isEmpty()) {
   return this;
  } else {
   return node.left.ancestorOfSmallRight();
  }
 }

 private BSTNode<ContentType> getNodeOfLeftSuccessor() {
  return node.left.node;
 }

 private BSTNode<ContentType> getNodeOfRightSuccessor() {
  return node.right.node;
 }

}
```

```java
//Klasse BinSearchBaumTest.java
public class BinSearchBaumTest {

 public static void main(String[] args) {
  
  Benutzerverwaltung bev = new Benutzerverwaltung();
  bev.neuenNutzerAnlegen("jan11", "x11");
  bev.neuenNutzerAnlegen("jon22", "x22");
  System.out.println(bev.profilVorhanden("gerd44"));
  System.out.println(bev.profilVorhanden("jan11"));
  System.out.println(bev.profilVorhanden("jun22"));
 }

}
```

```java
//Klasse ComparableContent.java
/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2017.
 * </p>
 * <p>
 * Generisches Interface (Schnittstelle) ComparableContent<ContentType>
 * </p>
 * <p>
 * <p>Das generische Interface ComparableContent<ContentType> legt die Methoden
 * fest, ueber die Objekte verfuegen muessen, die in einen binaeren Suchbaum
 * (BinarySearchTree) eingefuegt werden sollen. Die Ordnungsrelation wird in
 * Klassen, die ComparableContent implementieren durch Ueberschreiben der drei
 * implizit abstrakten Methoden isGreater, isEqual und isLess festgelegt. 
 * </p>
 * </p>
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version Generisch_02 2014-03-01
 */ 
public interface ComparableContent<ContentType> {

  /**
   * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
   * wird, bzgl. der gewuenschten Ordnungsrelation groesser als das Objekt
   * pContent ist, wird true geliefert. Sonst wird false geliefert.
   *
   * @param pContent
   *          das mit dem aufrufenden Objekt zu vergleichende Objekt vom
   *          Typ ContentType
   * @return true, wenn das aufrufende Objekt groesser ist als das Objekt
   *         pContent, sonst false
   */
  public boolean isGreater(ContentType pContent);

  /**
   * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
   * wird, bzgl. der gewuenschten Ordnungsrelation gleich gross wie das Objekt
   * pContent ist, wird true geliefert. Sonst wird false geliefert.
   *
   * @param pContent
   *          das mit dem aufrufenden Objekt zu vergleichende Objekt vom
   *          Typ ContentType
   * @return true, wenn das aufrufende Objekt gleich gross ist wie das Objekt
   *         pContent, sonst false
   */
  public boolean isEqual(ContentType pContent);

  /**
   * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
   * wird, bzgl. der gewuenschten Ordnungsrelation kleiner als das Objekt
   * pContent ist, wird true geliefert. Sonst wird false geliefert.
   *
   * @param pContent
   *          das mit dem aufrufenden Objekt zu vergleichende Objekt vom
   *          Typ ContentType
   * @return true, wenn das aufrufende Objekt kleiner ist als das Objekt
   *         pContent, sonst false   
   */     
  public boolean isLess(ContentType pContent);

}
```

- Graphen Materialien (siehe Anhang)
- Gelöste Aufgabe Graph_2D_Stadt:

```java
//Klasse Graph.java
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
 /** Falls anzahl kleiner maxKnoten, wird das Objekt s in das Array gespeichert,
  * andernfalls wird eine Fehlermeldung ausgegeben, dass die maximale Anzahl an Knoten
  * schon erreicht
  * ist. */
 public void einfügenKnoten(Stadt s) {
  if (anzahl < maxKnoten) {
   knotenliste[anzahl]=s;
   anzahl++;
  }
  
  

 }
 /** Prueft, ob die gesuchte Stadt identisch ist mit der Stadt ausListe. */
 public boolean vergleiche(Stadt gesucht, Stadt ausListe) {
  return gesucht.equals(ausListe);
 }
 /** Erzeugt eine bidirektionale Kante zwischen den Städten s1 und s2 in diesem
  * Graphen, sofern beide Städte in der Knotenliste des Graphen enthalten sind. */
 public void kanteEinfuegen(Stadt s1, Stadt s2) {
  final int i1 = indexOf(s1);
  final int i2 = indexOf(s2);
  if (i1 >= 0 && i2 >= 0) {
   //System.out.println("i1   " + i1);
   // System.out.println("i2   " + i2);
   kantenmatrix[i1][i2] = true;
   kantenmatrix[i2][i1] = true;
  }
 }
 
 
 //Die Hilfsmethode indexOf ist in der Methode kanteEinfuegen zu verwenden.
 private int indexOf(Stadt s) {
  if (s == null) throw new IllegalArgumentException("s ist null");
  for (int i = 0; i < knotenliste.length; i++) {
   if (s.equals(knotenliste[i])) {
    return i;
   }
  }
  return -1;
 }
 
 public void matrixAusgeben() {

  System.out.print("  ");
        //Spaltenindizes ausgeben
  for (int i = 0; i < kantenmatrix.length; i++) {
   System.out.print(i + "      ");
  }
  System.out.println();
  //Matrixausgabe
  for (int i = 0; i < kantenmatrix.length; i++) 
  {
   //Zeilenindex ausgeben
   System.out.print(i + " ");
   //Zeileninhalt ausgeben
   for (int j = 0; j <kantenmatrix[i].length; j++) {
    System.out.print(kantenmatrix[i][j] + " ");
   }
   System.out.println();
  }

 }

}
```

```java
//Klasse GraphTest.java
public class GraphTest {

  public static void main(String[] args) {

      Stadt zadar = new Stadt();
      zadar.setName("Zadar");
      Stadt rijeka = new Stadt();
      rijeka.setName("Rijeka"); 
      
      Stadt zagreb = new Stadt();
      zagreb.setName("Zagreb");
      Stadt sibenik = new Stadt();
      sibenik.setName("Sibenik");
      
      Graph graph = new Graph(4);
      graph.einfügenKnoten(rijeka);
      graph.einfügenKnoten(zadar);
      graph.einfügenKnoten(zagreb);
      graph.einfügenKnoten(sibenik);
      
      //boolean isTrue = graph.vergleiche(zadar, zadar);
      graph.kanteEinfuegen(rijeka, zadar);
      graph.kanteEinfuegen(zadar, sibenik);
      graph.matrixAusgeben();

    }

  }
```

```java
//Klasse Stadt.java
public class Stadt {
 
 private boolean markiert;
 private String provinz;
 private String name;


 public boolean isMarkiert() {
  return markiert;
 }
 /**
  * @param markiert the markiert to set
  */
 public void setMarkiert(boolean markiert) {
  this.markiert = markiert;
 }

 /**
  * @return the name
  */
 public String getName() {
  return name;
 }
 /**
  * @param name the name to set
  */
 public void setName(String name) {
  this.name = name;
 }
 /**
  * @return the provinz
  */
 public String getProvinz() {
  return provinz;
 }
 /**
  * @param provinz the provinz to set
  */
 public void setProvinz(String provinz) {
  this.provinz = provinz;
 }

}
```

- Gelöste Aufgabe Graph_Klassen_Ohne_Generics, Aufgabe war es die gegebene Klassen so anzupassen, dass sie generics nutzen, also die Klasse List:

```java
//Klasse Graph.java
/**
 * <p>Materialien zu den zentralen
 * Abiturpruefungen im Fach Informatik ab 2012 in 
 * Nordrhein-Westfalen.</p>
 * <p>Klasse Graph</p>
 * <p>Objekte der Klasse Graph sind ungerichtete, gewichtete Graphen. 
 * Der Graph besteht aus Knoten, die Obj ekte der Klasse GraphNode sind, 
 * und Kanten, die Knoten miteinander verbinden. 
 * Die Knoten werden ueber ihren Namen eindeutig identifiziert. 
</p>
 * 
 * <p>NW-Arbeitsgruppe: Materialentwicklung zum Zentralabitur 
 * im Fach Informatik</p>
 * 
 * 
 */

public class Graph {

  private final List<GraphNode> nodeList;

  /**
   * Ein neuer Graph wird erzeugt.
   * Er enthaelt noch keine Knoten.
   */
  @SuppressWarnings("Convert2Diamond")
  public Graph() {
    nodeList = new List<GraphNode>();
  }

  /**
   * Die Anfrage liefert true, wenn der Graph keine Knoten
   * enthaelt, andernfalls liefert die Anfrage false.
   * @return true, falls leer, sonst false
   */
  public boolean isEmpty() {
    return nodeList.isEmpty();
  }

  /**
   * Der Knoten pNode wird dem Graphen hinzugefuegt.
   * Falls bereits ein Knoten mit gleichem Namen im
   * Graphen existiert, wird dieser Knoten nicht eingefuegt.
   * Falls pNode null ist, veraendert sich der Graph nicht.
   * @param pNode neuer Knoten
   */
  public void addNode(GraphNode pNode) {
    if (pNode != null && !this.hasNode(pNode.getName())) nodeList.append(pNode);
  }

  /**
   * Die Anfrage liefert true, wenn ein Knoten mit dem Namen
   * pName im Graphen existiert.
   * Sonst wird false zurueck gegeben.
   * @param pNode Knotenbezeichnung
   * @return true, falls es Knoten gibt, sonst false
   */
  public boolean hasNode(String pNode) {
    boolean lGefunden = false;
    nodeList.toFirst();
    while (nodeList.hasAccess() && !lGefunden) {
      GraphNode lKnoten = nodeList.getContent();
      lGefunden = lKnoten.getName().equals(pNode);
      nodeList.next();
    }
    return lGefunden;
  }

  /**
   * Die Anfrage liefert den Knoten mit dem Namen pName zurueck.
   * Falls es keinen Knoten mit dem Namen im Graphen gibt,
   * wird null zurueck gegeben.
   * @param pName Knotenbezeichnung
   * @return Objekt der Klasse GraphNode
   */
  public GraphNode getNode(String pName) {
    GraphNode lNode0 = null;
    nodeList.toFirst();
    boolean lStop = false;
    while (nodeList.hasAccess() && !lStop) {
      GraphNode lNode = nodeList.getContent();
      if (lNode.getName().equals(pName)) {
        lNode0 = lNode;
        lStop = true;
      }
      nodeList.next();
    }
    return lNode0;
  }

  /**
   * Falls pNode ein Knoten des Graphen ist, so werden er und alle
   * mit ihm verbundenen Kanten aus dem Graphen entfernt.
   * Sonst wird der Graph nicht veraendert.
   * @param pNode Knoten
   */
  public void removeNode(GraphNode pNode) {
    if (pNode != null) {
      nodeList.toFirst();
      while (nodeList.hasAccess()) {
        GraphNode lNode = nodeList.getContent();
        if (lNode.getName().equals(pNode.getName())) {
          List<GraphNode> lListe = this.getNeighbours(lNode);
          lListe.toFirst();
          while (lListe.hasAccess()) {
            GraphNode lNode1 = lListe.getContent();
            this.removeEdge(lNode, lNode1);
            this.removeEdge(lNode1, lNode);
            lListe.next();
          }
          nodeList.remove();
        }
        nodeList.next();
      }
    }
  }

  /**
   * Falls eine Kante zwischen pNode1 und pNode2 noch nicht existiert,
   * werden die Knoten pNode1 und pNode2 durch eine Kante verbunden,
   * die das Gewicht pWeight hat. pNode1 ist also Nachbarknoten
   * von pNode2 und umgekehrt. Falls eine Kante zwischen pNode1 und pNode2
   * bereits existiert, erhaelt sie das Gewicht pWeight.
   * Falls einer der Knoten pNode1 oder pNode2 im Graphen nicht existiert oder null ist,
   * veraendert sich der Graph nicht.
   * @param pNode1 Knoten
   * @param pNode2 Knoten
   * @param pWeight Kantengewicht
   */
  public void addEdge(GraphNode pNode1, GraphNode pNode2, double pWeight) {
    if (pNode1 != null && pNode2 != null) {
      if (this.hasEdge(pNode1, pNode2)) this.removeEdge(pNode1, pNode2);
      pNode1.addEdge_(pNode2, pWeight);
      pNode2.addEdge_(pNode1, pWeight);
    }
  }

  /**
   * Die Anfrage liefert true, wenn ein Knoten mit
   * dem Namen pName im Graphen existiert.
   * Sonst wird false zurueck gegeben.
   * @param pNode1 Knoten
   * @param pNode2 Knoten
   * @return true, falls Kante existiert, sonst false
   */
  public boolean hasEdge(GraphNode pNode1, GraphNode pNode2) {
    boolean result = false;
    List<GraphNode> lNeighbours;
    GraphNode lNeighbour;
    if ((pNode1 != null) && (pNode2 != null)) {
      lNeighbours = pNode1.getNeighbours_();
      if (!lNeighbours.isEmpty()) {
        lNeighbours.toFirst();
        while (lNeighbours.hasAccess()) {
          lNeighbour = lNeighbours.getContent();
          if (lNeighbour.getName().equals(pNode2.getName())) result = true;
          lNeighbours.next();
        }
      }
    }
    return result;
  }

  /**
   * Falls pNode1 und pNode2 nicht null sind und eine Kante zwischen
   * pNode1 und pNode2 existiert, wird die Kante geloescht. Sonst
   * bleibt der Graph unveraendert.
   * @param pNode1 Knoten
   * @param pNode2 Knoten
   */
  public void removeEdge(GraphNode pNode1, GraphNode pNode2) {
    if (pNode1 != null && pNode2 != null && this.hasEdge(pNode1, pNode2)) {
      pNode1.removeEdge_(pNode2);
      pNode2.removeEdge_(pNode1);
    }
  }

  /**
   * Die Anfrage liefert das Gewicht der Kante zwischen pNode1 und pNode2.
   * Falls die Kante nicht existiert, wird Double.NaN (not a number)
   * zurueck gegeben.
   * @param pNode1 Knoten
   * @param pNode2 Knoten
   * @return Kantengewicht
   */
  public double getEdgeWeight(GraphNode pNode1, GraphNode pNode2) {
    return pNode1.getEdgeWeight_(pNode2);
  }

  /**
   * Alle Knoten des Graphen werden als unmarkiert gekennzeichnet.
   */
  public void resetMarks() {
    if (!nodeList.isEmpty()) {
      nodeList.toFirst();
      while (nodeList.hasAccess()) {
        nodeList.getContent().unmark();
        nodeList.next();
      }
    }
  }

  /**
   * Die Anfrage liefert den Wert true, wenn alle Knoten des Graphen
   * markiert sind, sonst liefert sie den Wert false.
   * @return true, lass alle Knoten markiert, sonst false
   */
  public boolean allNodesMarked() {
    if (!nodeList.isEmpty()) {
      nodeList.toFirst();
      boolean lAllMarked = true;
      while (nodeList.hasAccess() && lAllMarked) {
        if (!nodeList.getContent().isMarked()) lAllMarked = false;
        nodeList.next();
      }
      return lAllMarked;
    } else return true;
  }

  /**
   * Die Anfrage liefert eine Liste, die alle Knoten des Graphen enthaelt.
   * @return Knotenliste
   */
  public List<GraphNode> getNodes() {
    // liefert Knoten als Kopie der Knotenliste
    @SuppressWarnings("Convert2Diamond")
    List<GraphNode> lList = new List<GraphNode>();
    nodeList.toFirst();
    while (nodeList.hasAccess()) {
      GraphNode g = nodeList.getContent();
      lList.append(g);
      nodeList.next();
    }
    return lList;
  }

  /**
   * Die Anfrage liefert eine Liste, die alle Nachbarknoten des
   * Knotens pNode enthaelt.
   * @param pNode Knoten
   * @return Liste mit allen Nachbarknoten
   */
  public List<GraphNode> getNeighbours(GraphNode pNode) {
    return pNode.getNeighbours_();
  }
}
```

```java
//Klasse Edge.java
public class Edge {

  protected GraphNode neighbour;
  protected double weight;
  protected boolean marked;

  public Edge(GraphNode pNeighbour, double pWeight) {
    neighbour = pNeighbour;
    weight = pWeight;
    marked = false;
  }

  public GraphNode getNeighbour() {
    return neighbour;
  }

  public double getWeight() {
    return weight;
  }

  public boolean isMarked() {
    return marked;
  }
}
```

```java
//Klasse GraphNode.java
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
```

```java
//Klasse GraphTest.java
public class GraphTest {

  public static void main(String[] args) {
    Graph g = new Graph();

    GraphNode a = new GraphNode("A");
    GraphNode b = new GraphNode("B");
    GraphNode c = new GraphNode("C");

    g.addNode(a);
    g.addNode(b);
    g.addNode(c);

    g.addEdge(a, b, 1.5);
    g.addEdge(b, c, 2.5);
    g.addEdge(a, c, 3.0);

    System.out.println("Nodes in graph:");
    List<GraphNode> nodes = g.getNodes();
    nodes.toFirst();
    while (nodes.hasAccess()) {
      GraphNode n = nodes.getContent();
      System.out.println("- " + n.getName());
      nodes.next();
    }

    System.out.println("Edge weights:");
    System.out.println("A-B: " + g.getEdgeWeight(a, b));
    System.out.println("B-C: " + g.getEdgeWeight(b, c));
    System.out.println("A-C: " + g.getEdgeWeight(a, c));

    System.out.println("Has edge A-B? " + g.hasEdge(a, b));
    System.out.println("Has node 'B'? " + g.hasNode("B"));

    System.out.println("Removing node B (and its edges)");
    g.removeNode(b);

    System.out.println("Has node 'B'? " + g.hasNode("B"));
    System.out.println("Has edge A-C? " + g.hasEdge(a, c));
  }
}
```

```java
//Klasse List.java
/**
 * Ein lineare (verkettete) Liste für Elemente des Typs ContentType.
 * Dies ist eine moegliche Implementierung des Konzepts der verketteten Liste.
 * Diese kann viele Elemente eines Typs ContentType, der zum Deklarationszeitpunkt
 * festzulegen ist, speichern.
 * Die Liste kennt, wenn sie nicht leer ist, die drei Verweise:
 * first, current und last (logischen Positionen).
 * */
public class List<ContentType> {

  /* --------- Anfang der privaten inneren Klasse -------------- */

  public class ListNode {

    private ContentType contentObject;
    private ListNode next;

    /**
     * Ein neues Objekt wird erschaffen. Der Verweis ist leer.
     *
     * @param pContent das Inhaltsobjekt vom Typ ContentType
     */
    public ListNode(ContentType pContent) {
      contentObject = pContent;
      next = null;
    }

    /**
     * Der Inhalt des Knotens wird zurueckgeliefert.
     *
     * @return das Inhaltsobjekt des Knotens
     */
    public ContentType getContentObject() {
      return contentObject;
    }

    /**
     * Der Inhalt dieses Kontens wird gesetzt.
     *
     * @param pContent das Inhaltsobjekt vom Typ ContentType
     */
    public void setContentObject(ContentType pContent) {
      contentObject = pContent;
    }

    /**
     * Der Nachfolgeknoten wird zurueckgeliefert.
     *
     * @return das Objekt, auf das der aktuelle Verweis zeigt
     */
    public ListNode getNextNode() {
      return this.next;
    }

    /**
     * Der Verweis wird auf das Objekt, das als Parameter uebergeben
     * wird, gesetzt.
     *
     * @param pNext der Nachfolger des Knotens
     */
    public void setNextNode(ListNode pNext) {
      this.next = pNext;
    }
  }

  /* ----------- Ende der privaten inneren Klasse -------------- */

  // erstes Element der Liste
  ListNode first;

  // letztes Element der Liste
  ListNode last;

  // aktuelles Element der Liste
  ListNode current;

  /**
   * Konstruktor für eine leere Liste.
   * Die Verweise first, current und last
   * sind bei einer leeren Liste immer null.
   */
  public List() {
    first = null;
    last = null;
    current = null;
  }

  /**
   * Fragt die Liste, ob sie leer ist (keine Objekte enthaelt).
   *
   * @return true, falls die Liste leer ist, sonst false
   */
  public boolean isEmpty() {
    // Die Liste ist leer, wenn es kein erstes Element gibt.
    return first == null;
  }

  /**
   * Fragt die Liste, ob der Verweis current auf ein Element zeigt.
   *
   * @return true, falls Zugriff moeglich, sonst false.
   *         Immer false bei einer leeren Liste.
   */
  public boolean hasAccess() {
    // Es gibt keinen Zugriff, wenn current auf kein Element verweist.
    return current != null;
  }

  /**
   * Falls die Liste nicht leer ist, es ein aktuelles Objekt gibt und dieses
   * nicht das letzte Objekt der Liste ist, wird das dem aktuellen Objekt in
   * der Liste folgende Objekt zum aktuellen Objekt, andernfalls gibt es nach
   * Ausfuehrung des Auftrags kein aktuelles Objekt, d.h. hasAccess() liefert
   * den Wert false.
   */
  public void next() {
    if (this.hasAccess()) {
      current = current.getNextNode();
    }
  }

  /**
   * Falls die Liste nicht leer ist, wird das erste Objekt der Liste aktuelles
   * Objekt. Ist die Liste leer, geschieht nichts.
   */
  public void toFirst() {
    if (!isEmpty()) {
      current = first;
    }
  }

  /**
   * Falls die Liste nicht leer ist, wird das letzte Objekt der Liste
   * aktuelles Objekt. Ist die Liste leer, geschieht nichts.
   */
  public void toLast() {
    if (!isEmpty()) {
      current = last;
    }
  }

  /**
   * Liefert das aktuelle Objekt, allls es ein solches gibt (hasAccess() == true).
   *
   * @return das aktuelle Objekt (vom Typ ContentType) bzw. null, wenn es
   *         kein aktuelles Objekt gibt
   */
  public ContentType getContent() {
    if (this.hasAccess()) {
      return current.getContentObject();
    } else {
      return null;
    }
  }

  /**
   * Falls es ein aktuelles Objekt gibt (hasAccess() == true) und pContent
   * ungleich null ist, wird das aktuelle Objekt durch pContent ersetzt. Sonst
   * geschieht nichts.
   *
   * @param pContent
   *            das zu schreibende Objekt vom Typ ContentType
   */
  public void setContent(ContentType pContent) {
    // Nichts tun, wenn es keinen Inhalt oder kein aktuelles Element gibt.
    if (pContent != null && this.hasAccess()) {
      current.setContentObject(pContent);
    }
  }

  /**
   * Falls es ein aktuelles Objekt gibt (hasAccess() == true), wird ein neues
   * Objekt vor dem aktuellen Objekt in die Liste eingefuegt. Das aktuelle
   * Objekt bleibt unveraendert. <br />
   * Wenn die Liste leer ist, wird pContent in die Liste eingefuegt und es
   * gibt weiterhin kein aktuelles Objekt (hasAccess() == false). <br />
   * Falls es kein aktuelles Objekt gibt (hasAccess() == false) und die Liste
   * nicht leer ist oder pContent gleich null ist, geschieht nichts.
   *
   * @param pContent
   *            das einzufuegende Objekt vom Typ ContentType
   */
  public void insert(ContentType pContent) {
    if (pContent != null) {
      // Nichts tun, wenn es keinen Inhalt gibt.
      if (this.hasAccess()) {
        // Fall: Es gibt ein aktuelles Element.

        // Neuen Knoten erstellen.
        ListNode newNode = new ListNode(pContent);

        if (current != first) {
          // Fall: Nicht an erster Stelle einfuegen.
          ListNode previous = this.getPrevious(current);
          newNode.setNextNode(previous.getNextNode());
          previous.setNextNode(newNode);
        } else {
          // Fall: An erster Stelle einfuegen.
          newNode.setNextNode(first);
          first = newNode;
        }
      } else {
        //Fall: Es gibt kein aktuelles Element.

        if (this.isEmpty()) {
          // Fall: In leere Liste einfuegen.

          // Neuen Knoten erstellen.
          ListNode newNode = new ListNode(pContent);

          first = newNode;
          last = newNode;
        }
      }
    }
  }

  /**
   * Falls pContent gleich null ist, geschieht nichts.<br />
   * Ansonsten wird das Objekt pContent ans Ende der Liste angehaengt.
   * Das aktuelle Objekt bleibt unveraendert. <br />
   * Wenn die Liste leer ist, wird das Objekt pContent in die Liste eingefuegt
   * und es gibt weiterhin kein aktuelles Objekt (hasAccess() == false).
   *
   * @param pContent
   *            das anzuhaengende Objekt vom Typ ContentType
   */
  public void append(ContentType pContent) {
    if (pContent != null) {
      // Nichts tun, wenn es keine Inhalt gibt.

      if (this.isEmpty()) {
        // Fall: An leere Liste anfuegen.
        this.insert(pContent);
      } else {
        // Fall: An nicht-leere Liste anfuegen.

        // Neuen Knoten erstellen.
        ListNode newNode = new ListNode(pContent);

        last.setNextNode(newNode);
        last = newNode; // Letzten Knoten aktualisieren.
      }
    }
  }

  /**
   * Falls pList null oder eine leere Liste ist, geschieht nichts.<br />
   * Ansonsten wird die Liste pList an die aktuelle Liste angehaengt.
   * pList wird dabei entleert. Das aktuelle Objekt dieser Liste bleibt
   * unveraendert. Insbesondere bleibt hasAccess gleich.
   *
   * @param pList
   *            die am Ende anzuhaengende Liste vom Typ List<ContentType>
   */
  public void concat(List<ContentType> pList) {
    if (pList != null && !pList.isEmpty()) {
      // Nichts tun, wenn pList leer oder nicht existent.

      if (this.isEmpty()) {
        // Fall: An leere Liste anfuegen.
        this.first = pList.first;
        this.last = pList.last;
      } else {
        // Fall: An nicht-leere Liste anfuegen.
        this.last.setNextNode(pList.first);
        this.last = pList.last;
      }

      // Liste pList loeschen.
      pList.first = null;
      pList.last = null;
      pList.current = null;
    }
  }

  /**
   * Wenn die Liste leer ist oder es kein aktuelles Objekt gibt (hasAccess()
   * == false), geschieht nichts.<br />
   * Falls es ein aktuelles Objekt gibt (hasAccess() == true), wird das
   * aktuelle Objekt geloescht und das Objekt hinter dem geloeschten Objekt
   * wird zum aktuellen Objekt. <br />
   * Wird das Objekt, das am Ende der Liste steht, geloescht, gibt es kein
   * aktuelles Objekt mehr.
   */
  public void remove() {
    // Nichts tun, wenn es kein aktuelle Element gibt oder die Liste leer ist.
    if (this.hasAccess() && !this.isEmpty()) {
      if (current == first) {
        first = first.getNextNode();
      } else {
        ListNode previous = this.getPrevious(current);
        if (current == last) {
          last = previous;
        }
        previous.setNextNode(current.getNextNode());
      }

      ListNode temp = current.getNextNode();
      current.setContentObject(null);
      current.setNextNode(null);
      current = temp;

      //Beim loeschen des letzten Elements last auf null setzen.
      if (this.isEmpty()) {
        last = null;
      }
    }
  }

  /**
   * Liefert den Vorgaengerknoten des Knotens pNode. Ist die Liste leer, pNode
   * == null, pNode nicht in der Liste oder pNode der erste Knoten der Liste,
   * wird null zurueckgegeben.
   *
   * @param pNode
   *         der Knoten, dessen Vorgaenger zurueckgegeben werden soll
   * @return der Vorgaenger des Knotens pNode oder null, falls die Liste leer ist,
   *         pNode == null ist, pNode nicht in der Liste ist oder pNode der erste Knoten
   *         der Liste ist
   */
  private ListNode getPrevious(ListNode pNode) {
    if (pNode != null && pNode != first && !this.isEmpty()) {
      ListNode temp = first;
      while (temp != null && temp.getNextNode() != pNode) {
        temp = temp.getNextNode();
      }
      return temp;
    } else {
      return null;
    }
  }
}
```
