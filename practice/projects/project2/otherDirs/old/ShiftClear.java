public class ShiftClear implements Hash{
  public String getAlgName(){
    return "shift+clear";
  }

  public String hash(char[] password){
    // check for valid char
    char invalidChar = validString(password);
    if(invalidChar != '0')
      throw new ASCIIOutOfRangeException(invalidChar, "hash");
    // pad hash
    password = pad(password).toCharArray();
    password = shift(password).toCharArray();
    return new String(password);
  }

  private String shift(char[] password){
    return shift(new String(password));
  }

  private String shift(String password){
    String retval = "";
    for(int i=0;i<password.length();i++){
      retval = shiftLeft(password, password.charAt(i));
    }
    return retval;
  }

  private String pad(String validPassword){
    return pad(validPassword.toCharArray());
  }

  private String pad(char[] validPassword){
    return (new String(validPassword) + "xxxxxxxxxxxxxxxx").substring(0,16);
  }

  private boolean validChar(char aChar){
    return !((int)aChar < 42 || (int)aChar > 122);
  }

  private char validString(char[] password){
    for(int i=0;i<password.length;i++)
      if(!validChar(password[i]))
        return password[i];
    return '0';
  }

  protected String shiftLeft(String password, char c){
    int numShifts = (int) c % 16;
    String retval = password.substring(numShifts, password.length()) + password.substring(0,numShifts);
    return retval;
  }

  public void init(char[] password){
  }
  
}
  

