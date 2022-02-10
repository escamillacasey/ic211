public class Event{
  private int frequency;
  private String frequencyType;
  private MyDate start;
  private String name;
  private MyDate nextOcc;

  public Event(int f, MyDate s, String n, String freqType){
    frequency = f;
    start = s;
    nextOcc = start.clone();
    name = n;
    frequencyType = freqType;
  }

  protected static MyDate getDate(String date){
    String[] splitDate = date.split("/");
    int y = Integer.parseInt(splitDate[2]);
    int m = Integer.parseInt(splitDate[0]);
    int d = Integer.parseInt(splitDate[1]);
    return MyDate.makeDate(y,m,d);
  }

  protected static String getName(String[] splitLine, int startIndex){
    String retval = "";
    for(int i = startIndex;i<splitLine.length;i++)
      retval += splitLine[i] + " ";
    return retval;
  }


  /* every (freq) days start (start) expense/income (name) */
  public static Event read(String line){
    String[] arr = line.split(" ");
    int f = Integer.parseInt(arr[1]);
    MyDate s = getDate(arr[4]);
    String n = getName(arr, 6);
    String type = "year";
    if(arr[2].contains("day"))
      type = "days";
    else if(arr[2].contains("month"))
      type = "month";      

    return new Event(f, s, n, type);
  }

  private void updateNextOcc(){
    if(frequencyType.equals("days"))
      nextOcc.incDay(frequency);
    else if(frequencyType.equals("months"))
      nextOcc.incMonth(frequency);
    else if(frequencyType.equals("years"))
      nextOcc.incYear(frequency);
  }

  public boolean today(MyDate currDate){
    if(currDate.daysUntil(nextOcc) == 0){
      // increment nextOcc
      updateNextOcc();
      return true;
    }
    return false;
  }

  public String toString(){
    return name;
  }

  public static void main(String[] args){
    String[] lines = {"every 2 days start 1/7/2017 expense Ta",
                      "every 1 days start 1/6/2017 income Dum"};
    Event[] events = new Event[lines.length];
    
    for(int i=0;i<events.length;i++){
      events[i] = Event.read(lines[i]);
      System.out.println(events[i]);
    }
  }
}
