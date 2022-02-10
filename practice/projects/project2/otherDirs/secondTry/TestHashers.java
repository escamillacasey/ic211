import java.util.*;
public class TestHashers{
  // clear

  // shift+caesar

  // shift+vigenere

  // shift+clear
  
  public static void main(String[] args){
    ArrayList<Hash> H = new ArrayList<Hash>();
    H.add(new Clear());
    H.add(new ShiftClear());
    H.add(new ShiftCaesar());
    //H.add(new ShiftVigenere());

    System.out.print("algorithm: ");
    String hashAlg = System.console().readLine();
    System.out.print("password : ");
    String password = new String(System.console().readPassword());
    
    int i = -1;
    try{
      while(!H.get(++i).getAlgName().equals(hashAlg));
    } catch(IndexOutOfBoundsException e){
      throw new NoSuchElementException("Unknown algorithm '" + hashAlg + "'.");
    }
    H.get(i).init(password);
    System.out.println("password read : " + new String(password)); 
    System.out.println("hash computed : " + H.get(i).hash(password));
  }
}
