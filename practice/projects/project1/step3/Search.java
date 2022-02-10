/** @author Capt Casey Escamilla
 * This class is used for Project 1 of IC211 AY21 Spring Semester
 * Search provides the interface to search through tweets and output them
 * to standard out
 */
import java.util.*;
import java.io.*;

public class Search{
  /** This function reads in a file with a known amount of lines (33)
   * and returns an array of Tweets 
   * @param path The file path to be read in
   * @return An array of Tweet class objects
   */
  public Queue readFile(String path){
    Scanner sc = null;
    try{
      sc = new Scanner(new FileReader(path));
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }
    Queue tweetQueue = new Queue();
    while(sc.hasNext()){
      String tweetText = sc.nextLine();
      String[] splitString = tweetText.split("\t");
      tweetQueue.enqueue(new Tweet(splitString[0], splitString[1], splitString[2]));
    }
    return tweetQueue;
  }
  
  // get the file path from the command line, and then call another method
  public static void main(String[] args){
    if(args.length != 1){
      System.out.println("usage: java Search <tweets-file>");
      System.exit(0);
    }
    Search aSearch = new Search();
    Queue aQueue = aSearch.readFile(args[0]);
    Scanner in = new Scanner(System.in);
    String inputString = "";
    do{
      System.out.println("Queue size: " + aQueue.length());
      System.out.print("? ");
      inputString = in.nextLine();
      if(inputString.equals("!dump"))
        aQueue.printAll();
      else
        aQueue = aQueue.filterForKeyword(inputString);
    }while(!inputString.equals("!quit"));
    System.out.println("Goodbye!");
  }
}
