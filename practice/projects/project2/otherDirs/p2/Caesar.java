public class Caesar implements Encryptor {
  private int shift;
  
  public String getAlgName() { return "caesar"; }

  public void   init(char[] key) {
    int sum = 18;
    for( int i = 0; i < key.length; i++ ) {
      if( key[i] < 42 || key[i] > 122 )
        throw new InvalidCharException("error " + key[i] + " not allowed in key");
      sum += key[i]-42;
    }
    shift = 42 + (sum % 81);
  }

  public String encrypt(String plain) {
    String en = "";
    for( int i = 0; i < plain.length(); i++ ) {
      // char check
      if( plain.charAt(i) < 42 || plain.charAt(i) > 122 )
        throw new InvalidCharException("error " + plain.charAt(i) + " not allowed in plaintext");
      
      int k = shift-42;
      int p = plain.charAt(i)-42;
      int c = (p+k) % 81;
      en += (char)(42+c);
    }
    return en;
  }

  public String decrypt(String cipher){
    String plain = "";
    for( int i = 0; i < cipher.length(); i++ ) {
      int k = shift-42;
      int c = cipher.charAt(i)-42;
      int p = (c+(81-k)) % 81;
      plain += (char)(42 + p);
    }
    return plain;
  }
}
