public class ShiftClear implements Hash{
  private Encryptor encalg;

  public String getAlgName(){
    return "shift+clear";
  }

  public void init(String password) throws ASCIIOutOfRangeException{
    encalg = new Clear();
    encalg.init(password.toCharArray());
  }

  public String hash(String password){
    validString(password);
    password = pad(password);
    password = shift(password);
    return password;
  }

  private String shift(String password) throws ASCIIOutOfRangeException{
    String retval = "";
    for(int i=0;i<password.length();i++){
      retval = shiftLeft(password, password.charAt(i));
      retval = encalg.encrypt(retval);
    }
    return retval;
  }

  protected String shiftLeft(String password, char c){
    int numShifts = (int) c % 16;
    return password.substring(numShifts, password.length()) + password.substring(0,numShifts);
  }

  private void validString(String password) throws ASCIIOutOfRangeException{
    for(int i=0;i<password.length();i++){
      if(!validChar(password.charAt(i)))
        throw new ASCIIOutOfRangeException(password.charAt(i), "hash");
    }
  }

  protected String pad(String validPassword){
    return (validPassword + "xxxxxxxxxxxxxxxx").substring(0,16);
  }

  private boolean validChar(char aChar){
    return !((int)aChar < 42 || (int)aChar > 122);
  }
}
