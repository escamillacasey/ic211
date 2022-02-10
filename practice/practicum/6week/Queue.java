/**
 * A simple Queue for storing Strings
*/
public class Queue {

  private Node front, back;

  /**
   * adds s to the back of the queue
   */
  public void enqueue(Aircraft ac) {
    Node n = new Node(ac, null);
    if( empty() )
      front = back = n;
    else
      back = back.next = n;
  }

  /**
   * removes and returns string from the front of the queue
   */
  public Aircraft dequeue() {
    if( empty() ) 
      return null;

    Aircraft ac = front.data;
    front = front.next;

    // Cleanup if we just removed the only remaining Node.
    if( front == null )
      back = null;
    return ac;
  }

  /**
   * returns true if the queue is empty
   */
  public boolean empty() {
    return front == null;
  }

  private class Node {
    public Aircraft data;
    public Node next;
    public Node(Aircraft ac, Node n) {
      data = ac;
      next = n;
    }
  }

  public Queue searchForMinRange(double range){
    Node tmp = this.front;
    Queue retval = new Queue();
    while(tmp != null){
      if(tmp.data.getRange() >= range)
        retval.enqueue(tmp.data);
      tmp = tmp.next;
    }
    return retval;
  }

  public String toString(){
    Node tmp = this.front;
    String retval = "";
    boolean first = true;
    while(tmp != null){
      if(first){
        retval += tmp.data;
        first = false;
      }
      else
        retval += "\n" + tmp.data;
      tmp = tmp.next;
    }
    return retval;
  }

  public void remove(String name){
    Node tmp = this.front.next;
    Node previous = this.front;
    if(previous.data.getName().equals(name)){
      this.dequeue();
      return;
    }
    while(tmp != null){
      if(tmp.data.getName().equals(name)){
        previous.next = tmp.next;
        return;
      }
      previous = previous.next;
      tmp = tmp.next;
    }
  }
}
