public class ASCIIOutOfRangeException extends RuntimeException{
  char illegalChar;
  public ASCIIOutOfRangeException(char illegalChar, String source){
    super("error " + illegalChar + " not allowed in " + source);
    this.illegalChar = illegalChar;
  }

  public char getChar(){
    return illegalChar;
  }
}
