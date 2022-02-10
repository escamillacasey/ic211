public class Income extends Event{
  
  public Income(String line){
    super(line);
  }


  public static void main(String[] args){
    Income a = new Income("every 14 days start 1/6/2017 income Paycheck");
    System.out.println(a);
  }
}
