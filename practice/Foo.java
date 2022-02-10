public class Foo{
  static double x;
  static String s;
  public static String disp(){
    return "[" + s + "," + x + "]";
  }

  public static void main(String[] args){
    System.out.println(disp());
  }
}
