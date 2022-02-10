import java.util.*;
public class Data{
  private String encAlg;
  private Encryptor enc;
  private String data;
  private String userName;

  private static ArrayList<Encryptor> encryptors = new ArrayList<Encryptor>();

  public Data(String encAlg, String data, String un){
    this.encAlg = encAlg;
    this.data = data;
    this.userName = un;
     
    if(encryptors.isEmpty()){
      encryptors.add(new Clear());
      encryptors.add(new Caesar());
      encryptors.add(new Vigenere());
    }
  }

  private void setEncryptor(){
    for(Encryptor e : encryptors){
      if(e.getAlgName().equals(encAlg))
        enc = e;
    }
  }

  public static Data readLine(String line){
    String[] splitLine = line.split(" ");
    try{
      return new Data(splitLine[2], splitLine[3],splitLine[1]);
    }catch(ArrayIndexOutOfBoundsException e){
      e.printStackTrace();
      System.exit(0);
    }
    throw new RuntimeException();
  }
}
