import java.util.*;

public class TestHashers {
  public static void main(String[] args) throws Throwable {
    // Create ArrayList of all supported encryptors
    ArrayList<Hasher> E = new ArrayList<Hasher>();
    E.add(new Clear());
    E.add(new ShiftClear());
    E.add(new ShiftCaesar());
    E.add(new ShiftVigenere());

    // Get alg,psw,msg from user
    System.out.print("algorithm: ");
    String encalg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();

    // Find index of encryptor (throw exception if not found)
    int i = -1;
    try { while(!E.get(++i).getAlgName().equals(encalg)); }
    catch(Exception e) { throw new Exception("Unknown algorithm '" + encalg +"'."); }

    // Hash the password and print summary of results
    String hash = E.get(i).hash(new String(password));
    System.out.println("password read : " + (new String(password)));
    System.out.println("hash computed : " + hash);
  }
}
