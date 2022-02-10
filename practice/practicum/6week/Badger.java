public class Badger{
  private double weight;
  private double health;
  private double intelligence;
  private double aggressiveness;

  public Badger(double w, double h, double i, double a){
    this.weight = w;
    this.health = h;
    this.intelligence = i;
    this.aggressiveness = a;
  }

  public double computeFitness(){
    return (.5*this.weight) + this.health + (1.2 * this.intelligence) + (3.0 * this.aggressiveness);
  }

  public boolean isMoreFitThan(Badger b){
    return this.computeFitness() > b.computeFitness();
  }

  public String toString(){
    return "Badger " + this.weight + " " + this.health + " " + this.intelligence + " " + this.aggressiveness
      + " = " + this.computeFitness();
  }
}

