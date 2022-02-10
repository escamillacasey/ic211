/**
 * A simple Queue for storing Strings
*/
public class Queue {

  private Node front;
  private Node back;

  public Queue(){
    Node n = new Node(null, null);
    this.front = n;
    this.back = n;
  }

  /**
   * adds s to the back of the queue
   */
  public void enqueue(Aircraft s) {
    Node newNode = new Node(s, null);
    this.back.next = newNode;
    this.back = this.back.next;
    if(this.front.data == null)
      this.front = this.back;
  }

  /**
   * removes and returns string from the front of the queue
   */
  public Aircraft dequeue() {
    if( empty() )
      return null;
    Aircraft str = front.data;
    front = front.next;

    // Cleanup if we just removed the only remaining Node.
    if( front == null )
      back = null;
    return str;
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
    public Node(Aircraft d, Node n) {
      data = d;
      next = n;
    }
  }

  public Aircraft getFrontData(){
    return this.front.data;
  }

  public Queue filter(int miles){
    Queue filtered = new Queue();
    Node head = this.front;
    while(this.front!=null){
      if(this.front.data.getMiles()>=miles){
        filtered.enqueue(this.front.data);
      }
      this.front = this.front.next;
    }
    this.front = head;
    return filtered;
  }

  public void removeAircraft(String s){
    Node head = this.front;
    while(!this.front.data.getName().equals(s)){
      this.front = this.front.next;
    }
    Aircraft a = new Aircraft(null, 0, 0, 0, 0);
    this.front.data = a;
    this.front = head;
  }

  public void printAll(){
    while(this.front!=null){
      System.out.println(this.front.data);
      this.front = this.front.next;
    }
  }
}
