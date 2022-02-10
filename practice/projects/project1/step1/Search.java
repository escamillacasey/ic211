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
  public Tweet[] readFile(String path){
    Scanner sc = null;
    try{
      sc = new Scanner(new FileReader(path));
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }
    Tweet[] retval = new Tweet[33];
    for(int i=0;i<33;i++){
      String tweetText = sc.nextLine();
      System.out.println("Next line: " + tweetText);
      String[] splitString = tweetText.split("\t");
      System.out.println("Split string: " + splitString);
      retval[i] = new Tweet(splitString[0], splitString[1], splitString[2]);
    }
    return retval;
  }
  
  // get the file path from the command line, and then call another method
  public static void main(String[] args){
    if(args.length != 1){
      System.out.println("usage: java Search <tweets-file>");
      System.exit(0);
    }
    Search aSearch = new Search();

    Tweet[] tweetArray = aSearch.readFile(args[0]);
    for(int i=0;i<tweetArray.length;i++){
      System.out.println(tweetArray[i]);
    }
  }
}
