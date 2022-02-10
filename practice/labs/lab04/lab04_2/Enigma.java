public class Enigma{
  private final String[] rotorStrings = {
    "#GNUAHOVBIPWCJQXDKRYELSZFMT",
    "#EJOTYCHMRWAFKPUZDINSXBGLQV",
    "#BDFHJLNPRTVXZACEGIKMOQSUWY",
    "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
    "#TGOWHLIFMCSZYRVXQABUPEJKND"
  };

  private Rotor inner;
  private Rotor middle;
  private Rotor outer;

  public Enigma(int rotor1, int rotor2, int rotor3, String rotorPos){
    this.inner = new Rotor(rotorStrings[rotor1-1], rotorPos.charAt(0));
    this.middle = new Rotor(rotorStrings[rotor2-1], rotorPos.charAt(1));
    this.outer = new Rotor(rotorStrings[rotor3-1], rotorPos.charAt(2));
  }

  public String encrypt(String message){
    String retval = "";
    for(int i=0;i<message.length();i++){
      retval += encrypt(message.charAt(i));
    }
    return retval;
  }

  private char encrypt(char aChar){   
    // find the index of the character on the inner rotor
    int index = this.inner.indexOf(aChar); 
    // get the character of said index on outer rotor
    aChar = this.outer.charAt(index);
    // get the index of that character on the middle rotor
    index = this.middle.indexOf(aChar);
    // get the character at that index on the outer rotor
    aChar = this.outer.charAt(index);
    // rotate
    this.rotate();
    return aChar;
  }


  private void rotate(){
    if(this.inner.rotate()){
      if(this.middle.rotate()){
        this.outer.rotate();
      }
    }
  }

  public String decrypt(String message){
    String retval = "";
    for(int i=0;i<message.length();i++){
      retval += decrypt(message.charAt(i));
    }
    return retval;
  }

  public char decrypt(char aChar){
    // find the index of the character on the outer rotor
    int index = this.outer.indexOf(aChar);
    // get the character of that index on the middle rotor
    aChar = this.middle.charAt(index);
    // find the index of that character on the outer rotor
    index = this.outer.indexOf(aChar);
    // return the character of that index on the inner rotor
    aChar = this.inner.charAt(index);
    // rotate
    this.rotate();
    return aChar;
  }

  public static void main(String[] args){
    Enigma anEnigma = new Enigma(1,2,3, "###");
    System.out.println(anEnigma.encrypt("AAA"));
    anEnigma = new Enigma(3,1,2, "SAT");
    System.out.println(anEnigma.encrypt("DO#YOUR#BEST#AND#KEEP#ON#KEEPIN#ON"));
    anEnigma = new Enigma(5,2,4, "EST");
    System.out.println(anEnigma.decrypt("CSHIAWDFGDCOE#EZKJHRWAZDDCBCILON#PKUJEXEXSHINZ"));
  }
}
