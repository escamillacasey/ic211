import java.util.*;
import java.io.*;
public class Lab08 {

  public static void main(String[] args) {
    Scanner  sc = new Scanner(System.in);
    ModQueue Q  = new ModQueue();
    boolean verbose = false;
    boolean fileIn = false;
    // args[0] == -v => verbose mode
    if(args.length > 0 && args[0].equals("-v"))
      verbose = true;

    int filenameIndex = -1;
    if(args.length == 2)
      filenameIndex = 1;
    else if(!verbose && args.length == 1)
      filenameIndex = 0;

    if(filenameIndex != -1){
      try{
        fileIn = true;
        sc = new Scanner(new FileReader(args[filenameIndex]));
      }catch(IOException e){
        verbose = true;
        fileIn = false;
        System.out.println("File '" + args[filenameIndex] + "' could not be opened; switching input to standard in.");
      }
    }

    String cmd = "";
    do {
      if(!fileIn)
        System.out.print("> ");
      try{
        cmd = sc.next();
      }catch(NoSuchElementException e){
        if(fileIn)
          System.out.println("Unexpected end of input.");
        System.exit(0);
      }
      if( cmd.equals("quit") ) {
        break;
      } else if( cmd.equals("clearto") ) {
        String word = sc.next();
        try{
          Q.dequeue(word);
        }catch(QueueException e){
          if(verbose)
            System.out.println("String '"+word+"' not found!");
          try{
            Q.dump();
          }catch(QueueException qe){}
        }
      } else if( cmd.equals("add") )   {
        try{
          Q.enqueue(sc.next());
        }catch(NoSuchElementException e){
          if(fileIn)
            System.out.println("Unexpected end of input.");
          System.exit(0);
        }
      } else if( cmd.equals("dump") )   {
        try{
          System.out.println(Q.dump());
        }catch(QueueException e){
        }
      }
      else{
        if(verbose)
          System.out.println("Unknown command '" + cmd + "'.");
      }
    } while( true );
  }
}
