import java.util.*;
import java.io.*;

public class Lab08 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);;
    boolean verbose = false;
    boolean stdin = true;
    String fname = "";
    
    // check all args (order) for -v
    for(int i =0;i<args.length;i++){
      if(args[i].equals("-v"))
        verbose = true;
      else
        fname = args[i];
    }

    if(!fname.equals("")){
      try{
        sc = new Scanner(new FileReader(fname));
        stdin = false;
      } catch(IOException e){
        System.out.println("File '" + fname + "' could not be opened; switching input to standard in.");
        sc = new Scanner(System.in);
        stdin = true;
      }
    }

    ModQueue Q  = new ModQueue();

    do {
      if(stdin)
        System.out.print("> ");
      String cmd = sc.next();
      

      if( cmd.equals("quit") ) {
        break;
      } 
      else if( cmd.equals("clearto") ) {
        String nextWord = "";
        try{
          nextWord = sc.next();
        }catch(Exception e){
          if(verbose)
            System.out.println("Unexpected end of input.");
        }
        try{
          Q.dequeue(nextWord);
        }catch(Exception e){
          if(verbose)
            System.out.println("String '" + nextWord + "' not found!");
        }
      }
      else if( cmd.equals("add") )   {
        try{
          Q.enqueue(sc.next());
        }catch(Exception e){
          if(verbose)
            System.out.println("Unexpected end of input.");
        }
      } 
      else if( cmd.equals("dump") )   {
        try{
          System.out.println(Q.dump());
        }catch(Exception e){
        }
      }
      else if(verbose){
        System.out.println("Unknown comand '" + cmd + "'.");
      }
    } while( sc.hasNext() );
  }
}
