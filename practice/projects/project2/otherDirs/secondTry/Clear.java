public class Clear implements Encryptor {
  public String getAlgName() { return "clear"; }
  
  public void   init(char[] key) throws ASCIIOutOfRangeException {
    for(int i=0;i<key.length;i++)
      if(!validChar(key[i]))
        throw new ASCIIOutOfRangeException(key[i],"key");
  }
  
  public String encrypt(String plain) throws ASCIIOutOfRangeException { 
    char[] plainArray = plain.toCharArray();
    for(int i=0;i<plainArray.length;i++)
      encrypt(plainArray[i]);
    return plain; 
  }
  
  public String decrypt(String cipher) throws ASCIIOutOfRangeException {
    char[] cipherArray = cipher.toCharArray();
    for(int i=0;i<cipherArray.length;i++)
      decrypt(cipherArray[i]);
    return cipher; 
  }

  private char encrypt(char aChar) throws ASCIIOutOfRangeException {
    if(!validChar(aChar))
      throw new ASCIIOutOfRangeException(aChar, "plaintext");
    return aChar;
  }

  private char decrypt(char aChar) throws ASCIIOutOfRangeException {
    if(!validChar(aChar))
      throw new ASCIIOutOfRangeException(aChar, "plaintext");
    return aChar;
  }

  protected static boolean validChar(char aChar){
    return !((int)aChar > 122 || (int)aChar < 42);
  }
}
