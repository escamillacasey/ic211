import java.util.*;
import java.io.*;

public class Vault{
  private ArrayList<User> users;
  private ArrayList<Data> datas;
  private String fname;
  private String userCredUN;
  private String userCredPW;

  public Vault(ArrayList<User> users, ArrayList<Data> datas, String fname){
    this.users = users;
    this.datas = datas;
    this.fname = fname;
  }

  private static Vault readFile(String fname){
    Scanner inFile = null;
    try{
      inFile = new Scanner(new FileReader(fname));
    }catch(IOException e){
      System.out.println("Error! File '"+fname+"' could not be opened.");
      System.exit(0);
    }
    Vault aVault = null;
    try{
      ArrayList<ArrayList> al = readFile(inFile);
      aVault = new Vault(al.get(0), al.get(1), fname);
    }catch(FileFormatException e){
      System.out.println("Error! File '" + fname + "' improperly formatted.");
      System.exit(0);
    }catch(Exception e){
      System.out.println(e.getMessage());
      System.exit(0);
    }
    return aVault;
  }    


  private void promptUserCredentials(){
    // query user for un and pw
    System.out.print("username: ");
    this.userCredUN = System.console().readLine();
    System.out.print("password: ");
    this.userCredPW = new String(System.console().readPassword());
    //  access granted or denied
  }

  private boolean checkCredentials(String un, String pw){
    for(User aUser : users){
      try{
        if(un.equals(aUser.getUserName()) && aUser.checkPassword(pw))
          return true;
      }catch(Exception e){
        System.out.println(e.getMessage());
        System.exit(0);
      }
    }
    return false;
  }

  private static ArrayList<ArrayList> readFile(Scanner inFile) throws Exception{
    ArrayList<ArrayList> retval = new ArrayList<ArrayList>();
    ArrayList<User> users = new ArrayList<User>(); 
    ArrayList<Data> datas = new ArrayList<Data>();
    retval.add(users);
    retval.add(datas);
    String line = "";
    while(inFile.hasNext()){
      line = inFile.nextLine();
      if(line.split(" ")[0].equals("user"))
        users.add(User.read(line));
      else if(line.split(" ")[0].equals("data"))
        datas.add(Data.readLine(line));
      else{
        throw new FileFormatException("bad file type"); 
      }
    }
    return retval;
  }


  private void addUser(){
    PrintWriter pw = null;
    try{
      //pw = new PrintWriter(new File(fname));
      pw = new PrintWriter(new BufferedWriter(new FileWriter(this.fname, true)));  
    }catch(FileNotFoundException e){
      System.out.println("Error! '" + fname + "' could not be opened.");
      System.exit(0);
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
    
    System.out.print("Hash algorithm: ");
    String type = new Scanner(System.in).next();
    User tmp = new User(this.userCredUN, this.userCredPW, type);
    for(User a: this.users){
      if(a.getUserName().equals(this.userCredUN)){
        System.out.println("Error! Username '" + this.userCredUN + "' already in use.");
        System.exit(0);
      }
    }
    try{
      tmp.hashPassword(); 
    }catch(Exception e){
      System.out.println(e.getMessage());
      System.exit(0);
    }
    pw.println(tmp);
    if(pw != null) pw.close();
  }
  

  public static void main(String[] args){
    // take in vault file
    Vault aVault = null;
    try{
      if(args[0].equals("-au"))
        aVault = readFile(args[1]);
      else{
        aVault = readFile(args[0]);
      }
    }catch(ArrayIndexOutOfBoundsException e){
      System.out.println("usage: java Vault [-au] <filename>");
      System.exit(0);
    }
    
    // now you have a Vault with a file reader and list of users

    // prompt username/password from std in
    aVault.promptUserCredentials();
    //this.userCredPW = 
    // if -au
    if(args[0].equals("-au")){
      aVault.addUser();      
    }
    //    hash password
    //    add to users
    //    save to file
    // else
    else{
      boolean checkCred = aVault.checkCredentials(aVault.userCredUN, aVault.userCredPW);
      if(!checkCred){
        System.out.println("Access denied!");
        System.exit(0);
      }

      System.out.println("Access granted!");
    
      //    hash password
      //    output denied|granted
      //      begin terminal
      Scanner in = new Scanner(System.in);
      String cmd = "";
      do{
        System.out.print("> ");
        cmd = in.next();
      }while(!cmd.equals("quit"));
    }
  }
}
