import java.util.*;
public class ProbEvent extends Event{
  private double prob;
  private Random rand;

  public ProbEvent(int f, MyDate s, String n, String freqType, double prob, Random rand){
    super(f, s, n, freqType);
    this.rand = rand;
    this.prob = prob;
  }

  public static ProbEvent read(String line, Random rand){
    String[] arr = line.split(" ");
    int f = Integer.parseInt(arr[1]);
    MyDate s = getDate(arr[4]);
    String n = getName(arr, 8);
    String type = "year";
    if(arr[2].contains("day"))
      type = "days";
    else if(arr[2].contains("month"))
      type = "months";

    double p = Double.parseDouble(arr[6]);
    return new ProbEvent(f,s,n,type,p,rand);
  }

  public boolean today(MyDate currDate){
    if(super.today(currDate)){
      double guess = rand.nextDouble();
      return guess < prob;
    }
    return false;
  }


  public static void main(String[] args){
    String[] lines = {"every 1 days start 1/1/2017 prob 0.01 expense Car Repair",
                      "every 4 days start 1/1/2017 prob 0.5 expense Gas",
                      "every 1 days start 1/1/2017 prob 0.143 expense Groceries"};
    ProbEvent[] events = new ProbEvent[lines.length];
    Random r = new Random(System.currentTimeMillis());
    for(int i=0;i<lines.length;i++){
      events[i] = ProbEvent.read(lines[i], r);
      System.out.println(events[i]);
    }
  }
}
