import java.util.*;
public class Exam2{
  public static void main(String[] args){
    Queue acQueue = new Queue();

    Scanner in = new Scanner(System.in);

    String cmd = in.next();

    while(!cmd.equals("search")){
      if(cmd.equals("add")){
        String name = in.next();
        double weight = in.nextDouble();
        double speed = in.nextDouble();
        int seats = in.nextInt();
        double range = in.nextDouble();
        acQueue.enqueue(new Aircraft(name, weight, speed, seats, range));
        cmd = in.next();
      }
    }

    Queue searchQueue = acQueue.searchForMinRange(in.nextDouble());
    System.out.println(searchQueue);
  }
  // took 21 minutes
}
