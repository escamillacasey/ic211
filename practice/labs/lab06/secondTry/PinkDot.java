public class PinkDot extends MovingDot{
  private int intervalCounter;
  private int counter;
  //spirals
  public PinkDot(int r, int c){
   super(r,c);
   counter = 0;
   intervalCounter = 1;
  }

  public String toString(){
    return super.toString() + " m";
  }

  public void step(){
    counter++;
    if(counter % intervalCounter == 0){
      counter = 0;
      intervalCounter++;
      changeDirection(2); // turn right
    }
    super.step();
  }
}
