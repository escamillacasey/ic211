import java.util.*;
public class GreenDot extends MovingRandomDot{

  public GreenDot(int r, int c){
    super(r,c,10);
    setDir(1); // northeast
  }

  public String toString(){
    return super.toString() + " g";
  }
}
