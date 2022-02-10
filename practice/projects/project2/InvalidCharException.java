public class InvalidCharException extends RuntimeException {
  public InvalidCharException(String msg, char iChar) { 
    super(msg);
    invalidChar = iChar;
  }

  public InvalidCharException(String msg) { 
    super(msg);
    invalidChar = 'a';
  }
  private char invalidChar;
  
  public char getInvalidChar(){
    return invalidChar;
  }
}
