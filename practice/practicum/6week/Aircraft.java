public class Aircraft{
  private String name;
  private double weight;
  private double speed;
  private int numSeats;
  private double range;

  public Aircraft(String n, double w, double s, int seats, double r){
    this.name = n;
    this.weight = w;
    this.speed = s;
    this.numSeats = seats;
    this.range = r;
  }

  public String getName(){
    return this.name;
  }

  public double getWeight(){
    return this.weight;
  }

  public double getSpeed(){
    return this.speed;
  }

  public int getSeats(){
    return this.numSeats;
  }

  public double getRange(){
    return this.range;
  }

  public String toString(){
    return this.name + ": " + (int)this.weight + " lbs, " + (int)this.speed + " knots, " + this.numSeats + " seats, "
      + (int)this.range + " nm";
  }

}
