import java.util.*;
public class MovingDot extends Dot{
  private int dir = 0; // default North == 0, value of 0 through 7
  private Random rand;

  public MovingDot(int r, int c){
    super(r,c);
    //default direction East
    dir = 2;
    rand = new Random();
  }

  public void setDir(int newDir){
    this.dir = newDir;
  }

  protected void changeDirection(int newDir){
    if(newDir == 0) // turn left
      this.dir -= 2;
    else if(newDir == 2) // turn right
      this.dir += 2;
    if(this.dir < 0)
      this.dir += 8;;
    this.dir = this.dir % 8;
  }

  protected void randomDirection(){
    changeDirection(rand.nextInt(3));
  }

  public void step(){
    /*
    if(0 < dir && dir < 4)
      incRow();
    else if(4 < dir && dir < 8)
      decRow();

    if(dir <= 7 || 0 <= dir && dir < 2)
      incCol();
    else if(2 < dir && dir < 6)
      decCol();
      */
    if(dir > 0 && dir < 4)
      incRow();
    else if(dir > 4 && dir < 8)
      decRow();

    if(dir >= 7 || (dir >= 0 && dir < 2))
      incCol();
    else if(dir > 2 && dir < 6)
      decCol();
  }

}
