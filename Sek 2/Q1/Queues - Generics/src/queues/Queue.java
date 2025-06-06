package queues;

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2017.
 * </p>
 * <p>
 * Generische Klasse Queue<ContentType>
 * </p>
 * <p>
 * Objekte der generischen Klasse Queue (Warteschlange) verwalten beliebige
 * Objekte vom Typ ContentType nach dem First-In-First-Out-Prinzip, d.h., das
 * zuerst abgelegte Objekt wird als erstes wieder entnommen. Alle Methoden haben
 * eine konstante Laufzeit, unabhaengig von der Anzahl der verwalteten Objekte.
 * </p>
 * 
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version Generisch_02 2014-02-21
 */
public class Queue<ContentType> {
  
  /* --------- Anfang der privaten inneren Klasse -------------- */
  
  private class QueueNode {

    private ContentType content = null;
    private QueueNode nextNode = null;

    /**
     * Ein neues Objekt vom Typ QueueNode<ContentType> wird erschaffen. 
     * Der Inhalt wird per Parameter gesetzt. Der Verweis ist leer.
     * 
     * @param pContent das Inhaltselement des Knotens vom Typ ContentType
     */
    public QueueNode(ContentType pContent) {
      content = pContent;
      nextNode = null;
    }

    /**
     * Der Verweis wird auf das Objekt, das als Parameter uebergeben wird,
     * gesetzt.
     * 
     * @param pNext der Nachfolger des Knotens
     */
    public void setNext(QueueNode pNext) {
      nextNode = pNext;
    }
    
    /**
     * Liefert das naechste Element des aktuellen Knotens.
     * 
     * @return das Objekt vom Typ QueueNode, auf das der aktuelle Verweis zeigt
     */
    public QueueNode getNext() {
      return nextNode;
    }

    /**
     * Liefert das Inhaltsobjekt des Knotens vom Typ ContentType.
     * 
     * @return das Inhaltsobjekt des Knotens
     */
    public ContentType getContent() {
      return content;
    }
    
  }
  
  /* ----------- Ende der privaten inneren Klasse -------------- */
  
  private QueueNode head;
  private QueueNode tail;

 
  public Queue() {
    head = null;
    tail = null;
  }

  
  public boolean isEmpty() {
    return head == null;
  }

  
  public void enqueue(ContentType pContent) {
    if (pContent != null) {
      QueueNode newNode = new QueueNode(pContent);
      if (this.isEmpty()) {
        head = newNode;
        tail = newNode;
      } else {
        tail.setNext(newNode);
        tail = newNode;
      }
    }
  }

  /**
   * Das erste Objekt wird aus der Schlange entfernt. 
   * Falls die Schlange leer ist, wird sie nicht veraendert.
   */
  public void dequeue() {
    if (!this.isEmpty()) {
      head = head.getNext();
      if (this.isEmpty()) {
        head = null;
        tail = null;
      }
    }
  }

  /**
   * Die Anfrage liefert das erste Objekt der Schlange. 
   * Die Schlange bleibt unveraendert. 
   * Falls die Schlange leer ist, wird null zurueckgegeben.
   *
   * @return das erste Objekt der Schlange vom Typ ContentType oder null,
   *         falls die Schlange leer ist
   */
  public ContentType front() {
    if (this.isEmpty()) {
      return null;
    } else {
      return head.getContent();
    }
  }
}
