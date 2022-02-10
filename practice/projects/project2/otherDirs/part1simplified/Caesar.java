public class Caesar extends Clear implements Encryptor{
  private int offset;

  public String getAlgName(){
    return "caesar";
  }

  public void init(char[] key) throws ASCIIOutOfRangeException{
    validString(new String(key), "key");
    offset = 42+18;
    for(int i=0;i<key.length;i++){
      offset += (int)key[i] - 42;
    }
    offset = offset % 81;
  }

  public String encrypt(String plain) throws ASCIIOutOfRangeException{
    validString(plain, "plaintext");
    
    String retval = "";
    int k,p,c,cc=0;
    for(int i=0;i<plain.length();i++)
      retval += encrypt(plain.charAt(i),i);
    return retval;
  }


  public String decrypt(String cipher) throws ASCIIOutOfRangeException{
    validString(cipher,"cipher");

    int k,c,p,pc=0;
    String retval = "";
    for(int i=0;i<cipher.length();i++)
      retval += decrypt(cipher.charAt(i),i);
    return retval;
  }

  private char decrypt(char aChar, int index){
    int k,c,p = 0;
    k = offset - 42;
    c = (int)aChar - 42;
    p = (c + (81 - k)) % 81;
    return (char)(42 + p);
  }

  private char encrypt(char aChar, int index){
    int k,c,p = 0;
    k = offset - 42;
    p = (int)aChar - 42;
    c = (p+k) % 81;
    return (char)(42 + c);
  }
}
