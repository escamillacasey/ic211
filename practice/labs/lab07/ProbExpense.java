import java.util.*;

public class ProbExpense extends Expense{
  private float probability;
  private Random rand;
  
  public ProbExpense(String line, int seed){
    super(line);
    this.probability = this.setProbability(line);
    this.rand = new Random(seed);
  }

  public ProbExpense(String line, Random rand){
    super(line);
    this.probability = this.setProbability(line);
    this.rand = rand;
  }

  private float setProbability(String line){
    String[] split = line.split(" ");
    for(int i=0;i<split.length;i++){
      if(split[i].equals("prob"))
        return Float.parseFloat(split[i+1]);
    }
    return 0.f;
  }

  public ProbExpense(String line){
    super(line);
    this.probability = probability;
    rand = new Random();
  }

  public void setRandomSeed(int seed){
    rand = new Random(seed);
  }

  public boolean isToday(MyDate compareDate){
    if(compareDate.daysUntil(this.getStartDate()) > 0)
      return false;
    else if(rand.nextFloat() <= probability)
      return true;
    return false;
  }

}
