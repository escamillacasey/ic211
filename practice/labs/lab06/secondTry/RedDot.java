import java.util.*;
public class RedDot extends MovingDot{
  
  public RedDot(int r, int c){
    super(r,c);
  }

  public void step(){
    randomDirection();
    super.step();
  }

  public String toString(){
    return super.toString() + " r";
  }
}
