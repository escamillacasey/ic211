import java.util.*;
import java.io.*;
public class Lab07{
  public static void main(String[] args){
    Random rand;
    int daysToSimulate = Integer.parseInt(args[1]);
    if(args.length == 3)
      rand = new Random(Long.parseLong(args[2]));
    else if(args.length != 2){
      System.out.println("usage: ....");
      return;
    }
    else
      rand = new Random(System.currentTimeMillis());
    
    Scanner in;
    
    try{
      in = new Scanner(new FileReader(args[0]));
    }catch(Exception e){
      e.printStackTrace();
      in = new Scanner(System.in);
    }

    ArrayList<Event> eventList = new ArrayList<Event>();
    while(in.hasNextLine()){
      String line = in.nextLine();
      // determine what type of event
      if(line.contains("prob"))
        eventList.add(RandomEvent.read(line, rand));
      else if(line.contains("for"))
        eventList.add(EndingEvent.read(line));
      else if(line.contains("every"))
        eventList.add(Event.read(line));
    }
  
    //for(int i=0;i<100;i++){
    //  System.out.println("Random " + i%5 + " : " + rand.nextFloat());
    //}

    MyDate today = MyDate.makeDate(2017,01,01);
    boolean multiple = false;
    for(int i=0;i<daysToSimulate;i++){
      // something today?
      multiple = false;
      for(Event e : eventList){
        if(e.today(today)){
          if(multiple)
            System.out.print(", ");
          else
            System.out.print(today + ": ");
          System.out.print(e);
          multiple = true;
        }
      }
      if(multiple)
        System.out.print("\n");

      // increment today
      today.incDay(1);
    }


  }
}
