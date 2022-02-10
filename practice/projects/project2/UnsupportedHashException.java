public class UnsupportedHashException extends Exception{
  public UnsupportedHashException(String type){
    super("Error! Hash algorithm '" + type + "' not supported.");
  }
}
