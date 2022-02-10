public class EndingEvent extends Event{
  private MyDate endDate;
  private int numIntervals;

  public EndingEvent(String n, MyDate start, String interval, int intervalAmount, int numIntervals){
    super(n, start, interval, intervalAmount);
    this.numIntervals = numIntervals;
    calcEndDate();
  }

  private void calcEndDate(){
    this.endDate = this.getNextOcc().clone();
    if(this.getInterval().equals("months"))
      this.endDate.incMonth(numIntervals);
    else if(this.getInterval().equals("days"))
      this.endDate.incDay(numIntervals);
  }

  public boolean today(MyDate date){
    if(numIntervals <= 0)
      return false;
    else if(super.today(date)){
      numIntervals--;
      return true;
    }
    return false;
  }
  
  public String printAll(){
    return super.printAll() + "\tEnd date: " + endDate + "\tNumIntervals: " + numIntervals;
  }

  public static EndingEvent read(String line){
    String[] stringArr = line.split(" ");
    int intervalAmount = Integer.parseInt(stringArr[1]);
    String interval = stringArr[2];
    MyDate start = parseStartDate(stringArr[6]);
    int numIntervals = Integer.parseInt(stringArr[4]);
    String name = parseName(line);
    return new EndingEvent(name, start, interval, intervalAmount, numIntervals);
  }
}
