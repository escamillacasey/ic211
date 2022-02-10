import java.util.*;

public class Exam3{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String name;
    int lbs, knots, seats, nm;

    Queue allPlanes = new Queue();

    String command;
    command = in.next();
    while(!command.equals("quit")){
      if(command.equals("add")){
        name = in.next();
        lbs = Integer.parseInt(in.next());
        knots = Integer.parseInt(in.next());
        seats = Integer.parseInt(in.next());
        nm = Integer.parseInt(in.next());
        Aircraft plane = new Aircraft (name, lbs, knots, seats, nm);
        allPlanes.enqueue(plane);
      }
      if(command.equals("search")){
        int miles = Integer.parseInt(in.next());
        Queue filtered = allPlanes.filter(miles);
        filtered.printAll();
      }
      if(command.equals("remove")){
        String nameToDelete = in.next();
        allPlanes.removeAircraft(nameToDelete);
      }
      command = in.next();
    }
    System.out.println("Goodbye!");
  }
}
