
public class ShiftClear extends Clear implements Hasher {
  String init = "GO_NAVY_2018^mid";
  
  public String getAlgName() { return "shift+clear"; }
  
  private String shift(String str, int k) {
    for( int i = 0; i < k; i++ )
      str = str.substring(1) + str.charAt(0);
    return str;
  }
  
  public String hash(String msg) {
    init(msg.toCharArray());
    String x = new String(init);
    for( int i = 0; i < init.length(); i++ ) {
      char c = x.charAt(i);
      int k = (int)c % 16;
      x = shift(x, k);
      //      x = encrypt(x);
    }
    return x;
  }
}
