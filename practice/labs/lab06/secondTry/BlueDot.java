import java.util.*;
public class BlueDot extends MovingRandomDot{
  public BlueDot(int r, int c){
    super(r,c, 10);
  }
  
  public String toString(){
    return super.toString() + " b";
  }
}
