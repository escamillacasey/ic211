public abstract class Event{
  private MyDate startDate;
  private int frequency;
  private String frequencyUnit; //days, months, years
  private String name;
  private MyDate nextOccurrence;

  public Event(String eventString){
    startDate = this.parseStartDate(eventString);
    nextOccurrence = startDate.clone();
    frequency = this.parseFrequency(eventString);
    frequencyUnit = this.parseFrequencyUnit(eventString);
    name = this.parseName(eventString);
  }

  private String parseName(String eventString){
    String searchFor = "";
    if(eventString.contains("income"))
      searchFor = "income";
    else
      searchFor = "expense";
    int indexTmp = eventString.indexOf(searchFor);
    return eventString.substring(indexTmp+searchFor.length()+1);
  }

  private MyDate parseStartDate(String eventString){
    String[] split = eventString.split(" ");
    for(int i = 0; i<split.length; i++){
      if(split[i].equals("start")){
        String[] splitDate = split[i+1].split("/");
        return MyDate.makeDate(Integer.parseInt(splitDate[2]),
                               Integer.parseInt(splitDate[0]),
                               Integer.parseInt(splitDate[1]));
      }
    }
    return MyDate.makeDate(-1,-1,-1);
  }

  private int parseFrequency(String eventString){
    String[] split = eventString.split(" ");
    for(int i = 0; i<split.length; i++){
      if(split[i].equals("every"))
          return Integer.parseInt(split[i+1]);
    }
    return 0;
  }

  private String parseFrequencyUnit(String eventString){
    String[] split = eventString.split(" ");
    for(int i = 0; i<split.length; i++){
      if(split[i].equals("every"))
          return split[i+2];
    }
    return "";

  }


  public boolean isToday(MyDate compareDate){
    if((this.nextOccurrence.daysUntil(compareDate) == 0)){
      if(this.frequencyUnit.equals("days"))
        this.nextOccurrence.incDay(frequency);
      else if(this.frequencyUnit.equals("months"))
        this.nextOccurrence.incMonth(frequency);
      return true;
    }
    return false;
  }

  public String toString(){
    return name;
  }

  public MyDate getStartDate(){
    return startDate;
  }

  public int getFrequency(){
    return frequency;
  }

  public String getFrequencyUnit(){
    return frequencyUnit;
  }

  public String getName(){
    return name;
  }
}
