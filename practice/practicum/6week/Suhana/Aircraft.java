public class Aircraft{
  private String name;
  private int lbs;
  private int knots;
  private int seats;
  private int nm;

  public Aircraft(String n, int lbs, int knots, int seats, int nm){
    this.name = n;
    this.lbs =lbs;
    this.knots = knots;
    this.seats = seats;
    this.nm = nm;
  }

  public String toString(){
    return this.name + ": " + lbs + " lbs, " + this.knots + " knots, " + this.seats + " seats, " + this.nm + " nm";
  }

  public int getMiles(){
    return this.nm;
  }

  public String getName(){
    return this.name;
  }


}
