public class Exam1{
  
  public static void main(String[] args){
    Badger[] badgerList = new Badger[args.length / 4]; 
    for(int i=0;i<args.length/4;i++){
      Badger aBadger = new Badger(Double.parseDouble(args[i*4]),
                                  Double.parseDouble(args[i*4+1]),
                                  Double.parseDouble(args[i*4+2]),
                                  Double.parseDouble(args[i*4+3]));
      badgerList[i] = aBadger;
    }

    System.out.println("Best Badger: " + findBestBadger(badgerList));
    printBadgers(badgerList);
  }

  public static void printBadgers(Badger[] listOfBadgers){
    System.out.println("All Badgers:");
    for(int i=0;i<listOfBadgers.length;i++){
      System.out.println(listOfBadgers[i]);
    }
  }

  public static Badger findBestBadger(Badger[] listOfBadgers){
    Badger bestBadger = listOfBadgers[0];
    for(int i=1;i<listOfBadgers.length;i++){
      if(listOfBadgers[i].isMoreFitThan(bestBadger))
        bestBadger = listOfBadgers[i];
    }
    return bestBadger;
  }

  //step 1 complete 15 minutes...
}
