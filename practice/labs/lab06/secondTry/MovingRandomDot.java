public class MovingRandomDot extends MovingDot{
  private int interval;
  private int counter = 0;

  public MovingRandomDot(int r, int c, int interval){
    super(r,c);
    this.interval = interval;
  }

  public void step(){
    counter++;
    if(counter % interval == 0){
      counter = 0;
      randomDirection(); 
    }
    super.step();
  }
} 
