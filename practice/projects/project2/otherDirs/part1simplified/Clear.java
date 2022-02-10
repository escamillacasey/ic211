public class Clear implements Encryptor, Hash {
  public String getAlgName() { return "clear"; }
  
  public void init(char[] key) throws ASCIIOutOfRangeException {
    validString(new String(key), "key");
  }

  public void init(String key) throws ASCIIOutOfRangeException{
    validString(key, "key");
  }
  
  public String encrypt(String plain) throws ASCIIOutOfRangeException { 
    validString(plain, "plaintext");
    return plain; 
  }
  
  public String decrypt(String cipher) throws ASCIIOutOfRangeException {
    validString(cipher, "cipher");
    return cipher; 
  }

  private static boolean validChar(char aChar){
    return !((int)aChar > 122 || (int)aChar < 42);
  }

  private String pad(String validPassword){
    return (validPassword + "xxxxxxxxxxxxxxxx").substring(0,16);
  }

  protected void validString(String password, String type) throws ASCIIOutOfRangeException{
    for(int i=0;i<password.length();i++){
      if(!validChar(password.charAt(i)))
        throw new ASCIIOutOfRangeException(password.charAt(i), type);
    }
  }

  public String hash(String password){
    validString(password, "hash");
    return pad(password);
  }
}
