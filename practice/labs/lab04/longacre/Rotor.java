public class Rotor{
  private String alpha;
  private final String initialTop;

  public Rotor(String alphaSet){
    this.alpha = alphaSet;
    this.initialTop = alphaSet.substring(0,1);
  }

  public String getAlpha(){
    return this.alpha;
  }

  public void setAlpha(String alphaSet){
    this.alpha = alphaSet;
  }

  public String getInitialTop(){
    return this.initialTop;
  }

  public void rotateRight(){
    String answer = (this.alpha.substring(this.alpha.length() - 1) + this.alpha.substring(0, this.alpha.length()-1));
    this.alpha = answer;
  }

  public void rotateLeft(){
    String answer = (this.alpha.substring(1) + this.alpha.substring(0,1));
    this.alpha = answer;
  }

  public int returnLoc(String s){
    return this.alpha.indexOf(s);
  }

  public String charAt(int i){
    if(i == this.alpha.length()){
      return this.alpha.substring(i-1);
    }
    else{
      return this.alpha.substring(i,i+1);
    }
  }


  public static void main(String[] args){

    Rotor testy = new Rotor("ABCDEF");
    testy.rotateRight();
    System.out.println(testy.alpha + " " + testy.initialTop + " " + testy.returnLoc("D") + " " + testy.charAt(0));
    testy.rotateLeft();
    System.out.print(testy.alpha + " " + testy.initialTop + " " + testy.returnLoc("D") + " " + testy.charAt(0));

  }
}

