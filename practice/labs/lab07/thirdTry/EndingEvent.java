public class EndingEvent extends Event{
  private MyDate endDate;

  private MyDate calcEndDate(int numOcc, String freqType, MyDate startDate){
    MyDate end = startDate.clone();

    if(freqType.contains("day"))
      end.incDay(numOcc);
    else if(freqType.contains("month"))
      end.incMonth(numOcc);
    else if(freqType.contains("year"))
      end.incYear(numOcc);
    return end;
  }

  public EndingEvent(int f, MyDate s, String n, String freqType, int numOcc){
    super(f,s,n,freqType);
    endDate = calcEndDate(numOcc, freqType,s);
  }
  
  public static EndingEvent read(String line){
    String[] arr = line.split(" ");
    int f = Integer.parseInt(arr[1]);
    MyDate s = getDate(arr[6]);
    int numOcc = Integer.parseInt(arr[4]);
    String n = getName(arr, 8);
    String freqType = arr[2];
    return new EndingEvent(f, s, n, freqType, numOcc);
  }

  public boolean today(MyDate currDate){
    return (currDate.daysUntil(endDate) >= 0) && super.today(currDate);
  }

  public static void main(String[] args){
    String[] lines = {"every 1 months for 12 start 1/16/2017 expense Lazy Boy Layaway Payment Due"};

    EndingEvent[] events = new EndingEvent[lines.length];

    for(int i=0;i<lines.length;i++){
      events[i] = EndingEvent.read(lines[i]);
      System.out.println(events[i]);
    }
  }
}
