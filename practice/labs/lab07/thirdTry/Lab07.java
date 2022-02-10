import java.util.*;
import java.io.*;

// usage: java Lab07 infilename numDays <randomSeed>
public class Lab07{

  private static ArrayList<Event> makeEvents(Scanner sc, Random rand){
    String line = "";
    ArrayList<Event> retval = new ArrayList<Event>();
    while(sc.hasNext()){
      line = sc.nextLine();
      if(line.contains("prob"))
        retval.add(ProbEvent.read(line, rand));
      else if(line.contains("for"))
        retval.add(EndingEvent.read(line));
      else
        retval.add(Event.read(line));
    }
    return retval;
  }

  public static void main(String[] args){
    Random rand;
    if(args.length == 3)
      rand = new Random(Long.parseLong(args[2]));
    else
      rand = new Random(System.currentTimeMillis());

    // read in file and parse events
    Scanner sc = null;
    try{
      sc = new Scanner(new FileReader(args[0]));
    }catch(FileNotFoundException e){
    }

    ArrayList<Event> eventList = makeEvents(sc, rand);

    // increment through days
    MyDate today = MyDate.makeDate(2017,1,1);
    boolean first = true;
    for(int i=0;i<Integer.parseInt(args[1]);i++){
      for(Event e: eventList){
        if(e.today(today)){
          if(first){
            System.out.print(today + ": " + e);
            first = false;
          }
          else
            System.out.print(", " + e);
        }
      }
      if(!first){
        System.out.print("\n");
        first = true;
      }
      today.incDay(1);

    }
  }
}
