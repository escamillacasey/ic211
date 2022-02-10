public class Vigenere extends Clear implements Encryptor{
  private int[] offsetVals;
  
  public String getAlgName(){
    return "vigenere";
  }

  public void init(char[] key) throws ASCIIOutOfRangeException{
    offsetVals = new int[key.length];
    for(int i=0;i<key.length;i++){
      if(!validChar(key[i]))  
        throw new ASCIIOutOfRangeException(key[i], "key");
      offsetVals[i] = (int)key[i];
    }
  }

  public String encrypt(String plain) throws ASCIIOutOfRangeException{
    String retval = "";
    int k,p,c,cc=0;
    for(int i=0;i<plain.length();i++)
      retval += encrypt(plain.charAt(i),i);
    return retval;
  }


  public String decrypt(String cipher) throws ASCIIOutOfRangeException{
    int k,c,p,pc=0;
    String retval = "";
    for(int i=0;i<cipher.length();i++)
      retval += decrypt(cipher.charAt(i),i);
    return retval;
  }

  private char decrypt(char aChar, int index) throws ASCIIOutOfRangeException{
    if(!validChar(aChar))
      throw new ASCIIOutOfRangeException(aChar,"cipher");
    int k,c,p = 0;
    k = offsetVals[index % offsetVals.length] - 42;
    c = (int)aChar - 42;
    p = (c + (81 - k)) % 81;
    return (char)(42 + p);
  }

  private char encrypt(char aChar, int index) throws ASCIIOutOfRangeException{
    if(!validChar(aChar))
      throw new ASCIIOutOfRangeException(aChar,"cipher");
    int k,c,p = 0;
    k = offsetVals[index%offsetVals.length] - 42;
    p = (int)aChar - 42;
    c = (p+k) % 81;
    return (char)(42 + c);
  }
}
