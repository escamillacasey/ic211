import java.util.*;
public class RandomEvent extends Event{
  private double probability;
  private Random rand;

  public RandomEvent(String n, MyDate start, String interval, int intervalAmount, double prob, Random rand){
    super(n, start, interval, intervalAmount);
    this.probability = prob;
    this.rand = rand;
  }

  public boolean today(MyDate date){
    if(super.today(date)){
      double f = rand.nextDouble();
      //System.out.println(date + "\t" + this.toString() + "\tprob: " + f + "\tthreshold: " + probability);
      return (f < probability);
    }
    return false;
  }

  public static RandomEvent read(String line, Random rand){
    String[] stringArr = line.split(" ");
    int intervalAmount = Integer.parseInt(stringArr[1]);
    String interval = stringArr[2];
    MyDate start = parseStartDate(stringArr[4]);
    double probability = Double.parseDouble(stringArr[6]);
    String name = parseName(line);
    return new RandomEvent(name, start, interval, intervalAmount, probability, rand);
  }

  public String printAll(){
    return super.printAll() + "\tprobability: " + probability;
  }
}
