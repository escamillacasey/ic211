
public class ShiftVigenere extends Vigenere implements Hasher {
  String init = "GO_NAVY_2018^mid";
  
  public String getAlgName() { return "shift+vigenere"; }
  
  private String shift(String str, int k) {
    for( int i = 0; i < k; i++ )
      str = str.substring(1) + str.charAt(0);
    return str;
  }
  
  public String hash(String msg) {
    // char check
    for( int i = 0; i < msg.length(); i++ )
      if( msg.charAt(i) < 42 || msg.charAt(i) > 122 )
        throw new InvalidCharException("error " + msg.charAt(i) + " not allowed in key");
    
    init(msg.toCharArray());
    String x = new String(init);
    for( int i = 0; i < init.length(); i++ ) {
      char c = x.charAt(i);
      int k = (int)c % 16;
      x = shift(x, k);
      x = encrypt(x);
    }
    return x;
  }
}
