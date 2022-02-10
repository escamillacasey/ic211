import java.util.*;

public class RedDot extends MovingDot{
  private Random rand;

  public RedDot(int r, int c){
    super(r,c);
    rand = new Random();
  }
  
  // Randomly changes the direction of the dot
  public void changeDirections(){
    int choice = this.rand.nextInt(3);
    super.changeDirections(choice);
  }

  public void step(){
    this.changeDirections();
    super.step();
  }

  public String toString(){
    return super.toString() + " r";
  }
}
