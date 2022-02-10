import java.util.*;
public class BlackDot extends MovingDot{
  private Random rand;
  private int squareSize;
  private int sideCounter;
  private int counter;
  private boolean leftTurn;

  public BlackDot(int r, int c){
    super(r,c);
    squareSize = 10;
    sideCounter = -1;
    counter = -1;
    rand = new Random();
    leftTurn = true;
  }

  public void step(){
    counter++;
    if(counter % squareSize == 0){
      sideCounter++;
      if(leftTurn)
        changeDirection(0);
      else
        changeDirection(2);
    
      if(sideCounter % 4 == 0){
        sideCounter = 0;
        counter = 0;
        moveToRandomLoc();
      }
    }
    super.step();
    
  }

  public String toString(){
    return super.toString() + " k";
  }

  public void moveToRandomLoc(){
    int deltaX = rand.nextInt(100);
    int deltaY = rand.nextInt(100);

    for(int i=0;i<deltaX;i++)
      incRow();

    for(int i=0;i<deltaY;i++)
      incCol();

    leftTurn = !leftTurn;
  }
}
