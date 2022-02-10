public class Rotor{
	private static final String[] rotorList = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
						   "#EJOTYCHMRWAFKPUZDINSXBGLQV",
						   "#BDFHJLNPRTVXZACEGIKMOQSUWY",
						   "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
						   "#TGOWHLIFMCSZYRVXQABUPEJKND"};
	
	private String rotor;
	private char topSymbol;

	public Rotor(String rotorString, char top){
		this.rotor = rotorString;
		this.topSymbol = top;
		while(this.rotor.charAt(0) != this.topSymbol)
			this.rotateClockwise();

	}
	
	public int getIndex(char aChar){
		//System.out.println("Get Index Rotor: " + this.rotor);
		return rotor.indexOf(aChar);
	}

	public char getChar(int anInt){
		//System.out.println("Get Char Rotor:  " + this.rotor);
		return rotor.charAt(anInt);
	}

  public char getTop(){
    return topSymbol;
  }

	public void rotateClockwise(){
		rotor = rotor.charAt(rotor.length()-1) + rotor.substring(0,rotor.length()-1);
	}

	public void rotateCounterClockwise(){
		rotor = rotor.substring(1,rotor.length()) + rotor.charAt(0);
	}

	public static void main(String[] args){
		Rotor a = new Rotor(rotorList[0],'A');
		System.out.println("Initial: " + a.rotor);
		a.rotateClockwise();
		System.out.println("One rotation: " + a.rotor);
		a.rotateCounterClockwise();
		System.out.println("Rotation back: " + a.rotor);
	}
}
