/**
 * This is the HW05.java class that will contain the interface for a queue of
 * data
 * @author : Huizenga, Michael J
 * */
import java.util.*;

public class Queue{

  /**
   * this is an inner class to make the queue
   * */
  private class Node{
    public String data;
    public Node next;
    public Node(String d, Node n){
      data = d;
      next = n;
    }
  }

  private Node head = new Node("head",null);
  private Node tail = new Node("tail",null);

  /**
   * Add s to the back of the queue
   * @param s : String to add to the end of the queue
   * */
  public void enqueue(String s){
    //add s to the back of the queue
    if(this.empty()){
      Node temp = new Node(s,null);
      tail.next = temp;
      head.next = temp;
    }else{
      Node temp = new Node(s,null);
      tail.next.next = temp;
      tail.next = temp;
    }
  }

  /**
   * remove and return the front of the queue
   * @return : gives back a String containg the first Node data.
   * */
  public String dequeue(){
    //remove and return front
    if(this.empty()){
      return "";
    }

    String tmp = head.next.data;
    head.next = head.next.next;
    return tmp;
  }

  /**
   * return true if the queue is empty
   * @return : boolean for if the queue is empty or not.
   * */
  public boolean empty(){
    if(tail.next == null | head.next == null){
      return true;
    }else{
      return false;
    }
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
  }
}
