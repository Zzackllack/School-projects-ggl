public class Queue<Auto> {
    
  private class QueueNode {

    private Auto auto = null;
    private QueueNode nextNode = null;

   
    public QueueNode(Auto pAuto) {
      auto = pAuto;
      nextNode = null;
    }

  
    public void setNext(QueueNode pNext) {
      nextNode = pNext;
    }
    

    public QueueNode getNext() {
      return nextNode;
    }


    public Auto getAuto() {
      return auto;
    }
    
  }
    
  private QueueNode head;
  private QueueNode tail;

 
  public Queue() {
    head = null;
    tail = null;
  }

  
  public boolean isEmpty() {
    return head == null;
  }

  
  public void enqueue(Auto pAuto) {
    if (pAuto != null) {
      QueueNode newNode = new QueueNode(pAuto);
      if (this.isEmpty()) {
        head = newNode;
        tail = newNode;
      } else {
        tail.setNext(newNode);
        tail = newNode;
      }
    }
  }

  public void dequeue() {
    if (!this.isEmpty()) {
      head = head.getNext();
      if (this.isEmpty()) {
        head = null;
        tail = null;
      }
    }
  }

  public Auto front() {
    if (this.isEmpty()) {
      return null;
    } else {
      return head.getAuto();
    }
  }
}
