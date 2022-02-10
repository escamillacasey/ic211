public class Tweet{
  private String tweet;
  private String username;
  private int year;
  private int month;
  private int day;

  /* Returns the date in integers of year, month, day
   * @param date : date format is expected YYYY-MM-DD
   * @return : Integer array 0 : Year, 1: Month, 2: Day
   */
  public int[] parseDate(String date){
    String[] splitDate = date.split("-");
    int[] retval = new int[3];
    if(splitDate.length == 3){
      for(int i = 0; i < retval.length; i++){
        retval[i] = Integer.parseInt(splitDate[i]);
      }
    }
    return retval;
  }
  
  /** This function returns true if the Tweet's text contains the keyword
   * @param keyword keyword being checked for within the tweet text 
   */
  public boolean containsKeyword(String keyword){
    String lowerTweet = tweet.toLowerCase();
    String lowerKey = keyword.toLowerCase();
    return lowerTweet.contains(lowerKey);
  }

  /** This function returns true if the Tweet occurred on the inputted date
   * @param date Expected format year-month-day i.e. 2014-1-28
   */
  public boolean onDate(String date){
    String[] splitDate = date.split("-");
    if(this.year == Integer.parseInt(splitDate[0]) &&
       this.month == Integer.parseInt(splitDate[1]) &&
       this.day == Integer.parseInt(splitDate[2]))
       return true;
    return false;
  }

  public Tweet(String newtext, String newuser, String newdate){
    this.tweet = newtext;
    this.username = newuser;
    int[] dateVals = this.parseDate(newdate);
    this.year = dateVals[0];
    this.month = dateVals[1];
    this.day = dateVals[2];
  }

  public String toString(){
    return this.tweet + "\t[" + this.username + "]\t" + 
      this.month + "/" + this.day + "/" + this.year;
  }

  public static void main(String[] args){
    Tweet a = new Tweet("Hello World", "aUser", "2020-05-23");
    System.out.println(a);
  }
}
