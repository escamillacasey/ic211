public class GreenDot extends MovingDot{
  /* this class creates a dot that draws a spiral
   */
  int countRights;
  int sideLength;
  int currentStep;

  public GreenDot(int r, int c){
    super(r,c);
    countRights = 0;
    sideLength = 1;
    currentStep = 0;
  }

  public void step(){
    super.step();
    currentStep++;
    if(currentStep == sideLength){
      super.turnRight();
      currentStep = 0;
      countRights += 1;
      if(countRights == 4){
        sideLength++;
        countRights = 0;
      }
    }
  }

  public String toString(){
    return super.toString() + " g";
  }


}
