public class Event{
  private String name;
  private MyDate startDate;
  private String interval; // days or months
  private int intervalAmount;
  private MyDate nextOcc; //next occurrence of this event
  
  public Event(String n, MyDate start, String interval, int intervalAmount){
    name = n;
    startDate = start;
    this.interval = interval;
    this.intervalAmount = intervalAmount;
    nextOcc = start.clone();
  }

  public String getInterval(){
    return interval;
  }

  public String toString(){
    return name;
  }

  private void updateNextOcc(){
    if(interval.equals("months"))
      nextOcc.incMonth(intervalAmount);
    else if(interval.equals("days"))
      nextOcc.incDay(intervalAmount);
  }

  public void stopEvent(){
    intervalAmount = 0;
  }

  public MyDate getNextOcc(){
    return nextOcc;
  }

  public int daysUntilNextOcc(MyDate today){
    return today.daysUntil(nextOcc);
  }

  public boolean today(MyDate date){
    if(date.daysUntil(nextOcc) == 0){
      updateNextOcc();
      return true;
    }
    return false;
  }

  public static String parseName(String line){
    String[] splitLine = line.split(" ");
    String retval = "";
    boolean getRest = false;
    for(int i=0;i<splitLine.length;i++){
      if(getRest)
        retval += splitLine[i] + " ";
      if(splitLine[i].equals("income") || splitLine[i].equals("expense"))
        getRest = true;
    }
    return retval.substring(0,retval.length()-1);
  }

  public static MyDate parseStartDate(String date){
    return MyDate.makeDate(Integer.parseInt(date.split("/")[2]),Integer.parseInt(date.split("/")[0]),Integer.parseInt(date.split("/")[1]));
  }

  public static Event read(String line){
    String[] stringArr = line.split(" ");
    int intAmount = Integer.parseInt(stringArr[1]);
    String inter = stringArr[2];
    MyDate start = parseStartDate(stringArr[4]); 
    String name = parseName(line); 
    Event retval = new Event(name, start, inter, intAmount);
    return retval;
  }
  
  public String printAll(){
    return "name: " + name + "\tstartDate: " + startDate + "\tinterval: " + interval + "\tintervalAmount: " + intervalAmount + "\tnextOcc: " + nextOcc;
  }
}
