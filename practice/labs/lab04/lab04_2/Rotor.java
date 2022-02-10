public class Rotor{
  private String rotorString;
  private char top;
  private boolean initialPos = true;

  public Rotor(String rotor, char top){
    this.rotorString = rotor;
    this.top = top;
    while(this.rotorString.charAt(0) != this.top)
      this.rotate();
  }

  public boolean rotate(){
    String newRotorString = "" + this.rotorString.charAt(this.rotorString.length()-1);
    newRotorString += this.rotorString.substring(0,this.rotorString.length()-1);
    this.rotorString = newRotorString;

    return this.top == rotorString.charAt(0);
  }

  public int indexOf(char aChar){
    return rotorString.indexOf(aChar);
  }

  public char charAt(int index){
    return rotorString.charAt(index);  
  }
}
