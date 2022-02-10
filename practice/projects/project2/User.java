import java.util.*;
public class User{
  private String username;
  private String password;
  private String type;
  private Hasher hash;
  private static ArrayList<Hasher> hashers = new ArrayList<Hasher>();

  public User(String un, String pw, String ty){
    username = un;
    password = pw;
    type = ty;
    
    if(hashers.isEmpty()){
      hashers.add(new Clear());
      hashers.add(new ShiftClear());
      hashers.add(new ShiftCaesar());
      hashers.add(new ShiftVigenere());
    }
    hash = this.getHasher(type);
  }

  
  public String getUserName(){
    return username;
  }

  public String getPassword(){
    return password;
  }
  
  public void hashPassword() throws Exception{
    try{
      this.password = hash.hash(password);
    }catch(InvalidCharException e){
      System.out.println("Error! Invalid symbol '" + e.getInvalidChar() + "' in password."); 
      System.exit(0);
    }catch(NullPointerException npe){
      throw new UnsupportedHashException(type);
    }
  }

  public boolean checkPassword(String pw) throws Exception{
    try{
      return password.equals(hash.hash(pw));
    }catch(InvalidCharException e){
      return false;
    }catch(NullPointerException npe){
      throw new UnsupportedHashException(type);
    }
  }

  public String toString(){
    return "user " + username + " " + type + " " + password;
  }

  public static User read(String line) throws Exception {
    String[] lineSplit = line.split(" ");
    try{
      return new User(lineSplit[1], lineSplit[3], lineSplit[2]);
    }catch(ArrayIndexOutOfBoundsException e){
      throw new FileFormatException("Improper format");
    }
  }

  private static Hasher getHasher(String type){
    for(Hasher hash : hashers){
      if(hash.getAlgName().equals(type))
        return hash;
    }
    //throw new Exception("Error! Hash algorithm '" + type + "' not supported.");
    return null;
  }

  public static User createUser(String un, String pw, String ty) throws Exception{
    User a = new User(un, pw, ty);
    Hasher theHash = getHasher(ty);
    pw = theHash.hash(pw);
    return a;
  }
  
}
