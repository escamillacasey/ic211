public class RandomWordLit extends RandomWord{
  private boolean first; // flag for whether this is the first call to next
  private char firstLetter;

  public RandomWordLit(long seed){
    super(seed);
    first = true;
  }

  public String next(){
    String retval = super.next();
    if(this.first){
      firstLetter = retval.charAt(0);
      first = false;
      return retval;
    }
    while(retval.charAt(0) != this.firstLetter)
      retval = super.next();
    return retval;
  }
}
