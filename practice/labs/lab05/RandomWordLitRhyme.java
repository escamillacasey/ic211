public class RandomWordLitRhyme extends RandomWordLit{
  private String lastTwo = "  ";

  public RandomWordLitRhyme(long seed){
    super(seed);
  }

  public String next(){  
    String retval = super.next();
    if(lastTwo.equals("  "))
      lastTwo = retval.substring(retval.length()-2);
    while(!lastTwo.equals(retval.substring(retval.length()-2))){
        retval = super.next();
        if(retval.length() == 1)
          retval = super.next();
    }
    return retval;
  }
}
