import java.util.*;
/** 
 * IC211 - Lab 2 - Part 2 - Partner 2
 * Used to print an array of Strings in a certain amount of
 * columns.
 * @author Capt Casey Escamilla
*/
public class Formatter{
	/** Outputs to standard out the input strings with a restriction of a certain
   * number of characters per line.
   * @param A strings to be printed
   * @param cols Number of characters per line
   */
  public static void writeInColumns(String[] A, int cols){
    int curr = 0;

    for(int i=0;i<A.length;i++){
      if(curr+1+A[i].length() <= cols){
        if(curr > 0){
          System.out.print(" ");
          curr++;
        }
        System.out.print(A[i]);
        curr = curr + A[i].length();
      }
      else{
        System.out.println();
        System.out.print(A[i]);
        curr = A[i].length();
      }
    }
    System.out.println();
  }
	public static void main(String[] args){
		String[] test = {"These","are","the","times","that","try","men's","souls"};
		writeInColumns(test,20);
	}
}
