import java.util.*;
public class BlueDot extends MovingDot{
  
  private int counter;
  private Random rand;

  public BlueDot(int r, int c){
    super(r, c);
    counter = 0;
    rand = new Random();
  }

  public void changeDirections(){
    super.changeDirections(rand.nextInt(3));
  }

  public void step(){
    if(counter%10 == 0)
      this.changeDirections();
    super.step();
    counter++;
  }

  public String toString(){
    return super.toString() + " b";
  }
  
}
