public class MovingDot extends Dot{
  private int row;
  private int col;
  /* the direction in which the dot is moving
   * 0 = North, 1 = NE, 2 = E, 3 = SE, 4 = S, 5 = SW, 6 = W, 7 = NW
   * */
  private int dir;

  /* a constructor that takes row and column positions as integers
   * @param r Row of the dot
   * @param c Column of the dot
   */
  public MovingDot(int r, int c){
    super(r,c);
    this.dir = 0;
  }

  /* a step method that moves the Dot in the direction that it is facing
   */
  public void step(){
    switch(this.dir){
      case 0:
        this.incCol();
        break;
      case 1:
        this.incCol();
        this.incRow();
        break;
      case 2:
        this.incRow();
        break;
      case 3:
        this.incRow();
        this.decCol();
        break;
      case 4:
        this.decCol();
        break;
      case 5:
        this.decCol();
        this.decRow();
        break;
      case 6:
        this.decRow();
        break;
      case 7:
        this.decRow();
        this.incCol();
    }
  }
  /* reassigns the direction based off of the inputted new direction
   * @param newDirection -1 for left, 0 for straight, 1 for right
   */
  protected void turnLeft(){
    dir = (dir-2) % 8;
  }

  protected void turnRight(){
    dir = (dir+2) % 8;
  }

  protected void turnHalfLeft(){
    dir = (dir-1) % 8;
  }
  
  protected void turnHalfRight(){
    dir = (dir+1) % 8;
  }

  /* turns the dot left, right, or straight
   * @param 0 == left, 1 == straight, 2 == right
   * */
  protected void changeDirections(int turn){
    if(turn == 0)
      this.turnLeft();
    else if(turn == 2)
      this.turnRight();
  }

  /* turns the dot and includes half turns with the options
   * @param 0 == left 1 == half left 2 == straight 3 == half right 4 == right
   */
  protected void changeDirectionsFine(int turn){
    switch(turn){
      case 0:
        this.turnLeft();
        break;
      case 1:
        this.turnHalfLeft();
        break;
      case 3:
        this.turnHalfRight();
        break;
      case 4:
        this.turnRight();
        break;
    }
  }

  
  public static void main(String[] args){
    MovingDot a = new MovingDot(100,100);
    MovingDot b = new MovingDot(0,0);
    MovingDot c = new MovingDot(50,50);
    
    a.turnLeft();
    b.turnRight();
    c.turnRight();
    c.turnRight();

    while(true){
      a.step();
      b.step();
      c.step();
      
      System.out.println(a + " b");
      System.out.println(b + " p");
      System.out.println(c + " g");
      System.out.println("done");
    }
  }

}

