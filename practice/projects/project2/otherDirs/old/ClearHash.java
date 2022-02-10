public class ClearHash implements Hash{
  public String getAlgName(){
    return "clear";
  }
  public String hash(char[] password){
    if(checkForIllegalChars(password) != '')
      throw new ASCIIOutOfRangeException(
    return hash(new String(password));
  }

  public String hash(String password){
    return (password + "xxxxxxxxxxxxxxxx").substring(0,16);
  }
   
  public static void main(String[] args){
    ClearHash a = new ClearHash();
    System.out.println(a.hash("hello".toCharArray()));
    System.out.println(a.hash("goodbye".toCharArray()));
  }
}
