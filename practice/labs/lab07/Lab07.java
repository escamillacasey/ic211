/*
 * @author Capt Casey G. Escamilla
 * IC211 Lab 7
 * Financial OOP
 */

import java.util.*;
import java.io.*;

public class Lab07{

  public static void main(String[] args){
    if(args.length != 2 && args.length != 3){
      System.out.println("usage: java Lab7 <infilename> <numDays> (optional)<randomSeed>");
      System.exit(1);
    }
    Random rand;
    if(args.length == 3)
      rand = new Random(Long.parseLong(args[2]));
    else
      rand = new Random(System.currentTimeMillis());

    MyDate currentDate = MyDate.makeDate(2017,1,1);
    Scanner inFile = null;
    try{
      inFile = new Scanner(new FileReader(args[0]));
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
    int countLines = 0;
    while(inFile.hasNextLine()){
     inFile.nextLine();
      countLines++;
    }
    Event[] eventsList = new Event[countLines];
    try{
      inFile = new Scanner(new FileReader(args[0]));
    }catch(IOException ioe){
      ioe.printStackTrace();  
    }
    
    String line = "";
    for(int i=0;i<countLines;i++){
      line = inFile.nextLine();
      if(line.contains("income"))
        eventsList[i] = new Income(line);
      else if(line.contains("prob")){
        /*
        if(args.length == 3){
          eventsList[i] = new ProbExpense(line, Integer.parseInt(args[2]));
          System.out.println("Using random seed: " + args[2]);
        }
        else
          eventsList[i] = new ProbExpense(line);
        */
        eventsList[i] = new ProbExpense(line, rand);
      } 
      else
        eventsList[i] = new Expense(line);
    }

    boolean multiple = false;
    for(int i=0;i<Integer.parseInt(args[1]);i++){
      //System.out.print(currentDate + ": ");
      
      for(int j=0;j<eventsList.length;j++){
        if(eventsList[j].isToday(currentDate)){
          if(multiple)
            System.out.print(", ");
          else
            System.out.print(currentDate + ": ");
          System.out.print(eventsList[j]);
          multiple = true;
        }
      }
      if(multiple){
        multiple = false;
        System.out.print("\n");
      }
      currentDate.incDay(1);
    }
  }
}
