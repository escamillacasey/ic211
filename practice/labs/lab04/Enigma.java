import java.util.*;

public class Enigma{
        private static final String[] rotorList = { "#GNUAHOVBIPWCJQXDKRYELSZFMT",
                                                    "#EJOTYCHMRWAFKPUZDINSXBGLQV",
                                                    "#BDFHJLNPRTVXZACEGIKMOQSUWY",
                                                    "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
                                                    "#TGOWHLIFMCSZYRVXQABUPEJKND"};
	
	
	private Rotor innerRotor;
	private Rotor middleRotor;
	private Rotor outerRotor;

	public Enigma(int id1, int id2, int id3, String pos){
		this.innerRotor = new Rotor(rotorList[id1-1], pos.charAt(0));
		//System.out.println("Inner rotor initialized with: " + rotorList[id1]);
		this.middleRotor = new Rotor(rotorList[id2-1], pos.charAt(1));
		//System.out.println("Middle rotor initialized with: " + rotorList[id2]);
		this.outerRotor = new Rotor(rotorList[id3-1], pos.charAt(2));
		//System.out.println("Outer rotor initialized with: " + rotorList[id3]);
	}

	public String encrypt(String msg){
		String retval = "";
		char tmp = ' ';
		int index = 0;
		for(int i=0;i<msg.length();i++){
			tmp = msg.charAt(i);
			index = this.innerRotor.getIndex(tmp);
			tmp = this.outerRotor.getChar(index);
			index = this.middleRotor.getIndex(tmp);
			tmp = this.outerRotor.getChar(index);
			this.rotateRotors(true);
			retval += tmp;
		}
		/*
		System.out.println("Decrypting: " + tmp);
		// find the character on the inner rotor
		index = this.innerRotor.getIndex(tmp);
		// note the character aligned with it on the outer rotor
		tmp = this.outerRotor.getChar(index);
		System.out.println("Aligned with outer rotor: " + tmp);
		// find that character on the middle rotor
		index = this.middleRotor.getIndex(tmp);
		// output the one aligned with it on the outer rotor
		tmp = this.outerRotor.getChar(index);
		System.out.println("Aligned with outer rotor: " + tmp);
		// turn the inner rotor clockwise
		this.innerRotor.rotateClockwise();
		System.out.println("MSG: " + msg);
		return "" + tmp;
		
    System.out.println("Msg: " + msg);
		System.out.println("Encrypted msg: " + retval);
		*/
    return retval;
	}

	private void rotateRotors(boolean clockwise){
		if(clockwise){
      this.innerRotor.rotateClockwise();
      if(this.innerRotor.getTop() == this.innerRotor.getChar(0)){
        this.middleRotor.rotateClockwise();
        if(this.middleRotor.getTop() == this.middleRotor.getChar(0))
          this.outerRotor.rotateClockwise();
      }
    }
    else{
      this.innerRotor.rotateCounterClockwise();
      if(this.innerRotor.getTop() == this.innerRotor.getChar(0)){
        this.middleRotor.rotateCounterClockwise();
        if(this.middleRotor.getTop() == this.middleRotor.getChar(0))
          this.outerRotor.rotateCounterClockwise();
      }
    }
	}

	public String decrypt(String msg){
		String retval = "";
		char tmp = ' ';
		int index = 0;
		for(int i=0;i<msg.length();i++){
			tmp = msg.charAt(i);
			// find the character on the outer rotor
			index = outerRotor.getIndex(tmp);
      // note the character aligned on the middle rotor
      tmp = middleRotor.getChar(index);
			// find that character on the outer rotor
      index = outerRotor.getIndex(tmp);
			// output the character aligned on the inner rotor
      tmp =innerRotor.getChar(index);
      // rotate the rotors
      this.rotateRotors(true);
      retval += tmp;
    }
    //System.out.println("Decrypted msg: " + retval);
    return retval;
	}

	public static void main(String[] args){
		Enigma e = new Enigma(1,2,3,"###");
		e.encrypt("AAA");
		e = new Enigma(3,1,2,"SAT");
    String msg = "DO#YOUR#BEST#AND#KEEP#ON#KEEPIN#ON";
		String encryptedMsg = e.encrypt(msg);
	  e = new Enigma(3,1,2,"SAT");
    String decryptedMsg = e.decrypt(encryptedMsg);
    
    System.out.println("Test for match: " + decryptedMsg.equals(msg));

  }
}
