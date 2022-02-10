/**
ListStuff.java
@author Wyrick, Radford
*/

public class ListStuff {

  public static StringNode addToFront(String s, StringNode Nold) {
    StringNode N = new StringNode();
    N.data = s;
    N.next = Nold;
    return N;
  }
  
  public static String[] listToArray(StringNode N) {
    int count = 0;
    int size = 0;
    StringNode temp = N;
    while(temp != null) {
      temp = temp.next;
      ++size;
    }
    
    String [] array = new String[size];
    while(N != null) {
      array[size - 1 - count] = N.data;
      
      N = N.next;
      ++count;
    }
    return array;
  }
  
  public static void main(String[] args) {
    StringNode List = new StringNode();
    List = null;

    List = addToFront("rat", List);
    List = addToFront("dog", List);
    List = addToFront("pig", List);
    String[] A = listToArray(List);
    for(int i=0; i < A.length; ++i) {
      System.out.println(A[i]);
    }
    
    return;
  }

}

