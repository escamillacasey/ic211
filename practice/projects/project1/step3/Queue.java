/** @author Capt Casey Escamilla
 * This class was created for HW5 in IC211 AY21 Spring
 * This class stores data in a dynamic way
 */
import java.util.*;
public class Queue{
  private Node head;
  private Node tail;

  /** add s to the back of the queue
   */
  public void enqueue(Tweet s){
    Node n = new Node(s, null);
    if(head == null)
      head = tail = n;
    else{
        tail.next = new Node(s, null);
        tail = tail.next;
    }
  }

  /** removes and returns Tweet from the front of the queue
   */
  public Tweet dequeue(){
    Tweet retval = head.data;
    head = head.next;
    return retval;
  }

  /** returns true if the queue is empty
   */
  public boolean empty(){
    if(head == null)
      return true;
    return false;
  }

  /** This methods loops through the entire Queue and outputs them to standard
   * out
   */
  public void printAll(){
    Node temp = this.head;
    while(temp != null){
      System.out.println(temp.data);
      temp = temp.next;
    }
  }
  /** This method returns the length of the Queue
   * @return an int of the length of the Queue
   */
  public int length(){
    Node temp = this.head;
    int retval = 0;
    while(temp != null){
      retval++;
      temp = temp.next;
    }
    return retval;
  }

  /** This method returns a queue containing all matching tweets for the keyword
   * @param keyword The keyword to search for within the individual Tweets
   */
  public Queue filterForKeyword(String keyword){
    Queue retval = new Queue();
    Node temp = this.head;
    do{
      if(temp.data.containsKeyword(keyword))
        retval.enqueue(temp.data);
      temp = temp.next;
    }while(temp != null);
    return retval;
  }

  private class Node{
    public Tweet data;
    public Node next;
    public Node(Tweet d, Node n){
      data = d;
      next = n;
    }
  }

  public static void main(String[] args){
    Queue aQueue = new Queue();

  }
}
