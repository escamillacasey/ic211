public class Vigenere implements Encryptor {
  private char[] key;
  
  public String getAlgName() { return "vigenere"; }

  public void   init(char[] key) {
    for( int i = 0; i < key.length; i++ ) {
      if( key[i] < 42 || key[i] > 122 )
        throw new InvalidCharException("error " + key[i] + " not allowed in key");
    }
    this.key = key;
  }

  public String encrypt(String plain) {
    String en = "";
    for( int i = 0; i < plain.length(); i++ ) {
      // char check
      if( plain.charAt(i) < 42 || plain.charAt(i) > 122 )
        throw new InvalidCharException("error " + plain.charAt(i) + " not allowed in plaintext");

      int k = key[i%key.length] - 42;
      int p = plain.charAt(i) - 42;
      int c = (p+k) % 81;
      en += (char)(42+c);
    }
    return en;
  }

  public String decrypt(String cipher){
    String plain = "";
    for( int i = 0; i < cipher.length(); i++ ) {
      int k = key[i%key.length] - 42;
      int c = cipher.charAt(i)-42;
      int p = (c+(81-k)) % 81;
      plain += (char)(42 + p);
    }
    return plain;
  }
}
