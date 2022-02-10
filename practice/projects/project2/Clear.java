public class Clear implements Encryptor, Hasher {
  public String getAlgName() { return "clear"; }

  public void   init(char[] key) {
    for( int i = 0; i < key.length; i++ ) {
      if( key[i] < 42 || key[i] > 122 )
        throw new InvalidCharException("error " + key[i] + " not allowed in key");
    }
  }

  public String encrypt(String plain) {
    for( int i = 0; i < plain.length(); i++ ) {
      // char check
      if( plain.charAt(i) < 42 || plain.charAt(i) > 122 )
        throw new InvalidCharException("error " + plain.charAt(i) + " not allowed in plaintext");
    }
    return plain;
  }

  public String decrypt(String cipher){ return cipher; }

  public String hash(String plain) {
    // char check
    for( int i = 0; i < plain.length(); i++ )
      if( plain.charAt(i) < 42 || plain.charAt(i) > 122 )
        throw new InvalidCharException("error " + plain.charAt(i) + " not allowed in key");

    while( plain.length() < 16 )
      plain += "x";
    return plain;
  }
}
