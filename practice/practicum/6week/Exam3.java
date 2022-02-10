import java.util.*;
public class Exam3{
  public static void main(String[] args){
    Queue acQueue = new Queue();

    Scanner in = new Scanner(System.in);

    String cmd = in.next();

    while(!cmd.equals("quit")){
      if(cmd.equals("add")){
        String name = in.next();
        double weight = in.nextDouble();
        double speed = in.nextDouble();
        int seats = in.nextInt();
        double range = in.nextDouble();
        acQueue.enqueue(new Aircraft(name, weight, speed, seats, range));
      }
      else if(cmd.equals("search")){
        Queue searchQueue = acQueue.searchForMinRange(in.nextDouble());
        System.out.println(searchQueue);
      }
      else if(cmd.equals("remove")){
        String rem = in.next();
        acQueue.remove(rem);
      }

      cmd = in.next();
    }
    System.out.println("Goodbye!");

    // complete 5 minutes
  }
}
