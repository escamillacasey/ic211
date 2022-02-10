public class ShiftCaesar extends ShiftClear{
  private int offset;
  private Caesar encalg;

  public String getAlgName(){
    return "shift+caesar";
  }

  public String hash(String password){
    password = pad(password);
    System.out.println("Password: " + password);
    return shift(password);
  }

  private String shift(String password){    
    for(int i=0;i<password.length();i++){
       password = shiftLeft(password,password.charAt(i));
       password = encalg.encrypt(password);
    }
    return password;
  }

  public void init(String password){
    offset = 42+18;
    for(int i=0;i<password.length();i++){
      offset += (int)password.charAt(i) - 42;
    }
    offset = offset % 81;

    encalg = new Caesar();
    encalg.init(password.toCharArray());
  }
}

