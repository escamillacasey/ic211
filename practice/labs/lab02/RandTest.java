import java.util.*;

public class RandTest{
  public static void main(String[] args){
    Random rand = new Random(890);
    System.out.println("9:" + rand.nextInt(9));
    rand = new Random(890);
    System.out.println("10-1:" + rand.nextInt(10));
    System.out.println("10-2:" + rand.nextInt(9));
    System.out.println("10-3:" + rand.nextInt(10));
    rand = new Random(890);
    System.out.println("11:" + rand.nextInt(11));
    rand = new Random(890);
    System.out.println("12:" + rand.nextInt(12));
  }
}
