import java.util.*;

public class Lab1c{
	public static void main(String[] args){
		Random rand = new Random(42);
		Scanner in = new Scanner(System.in);
		int randomNumber = rand.nextInt(11);
		int guess = -1;
		System.out.print("Guess a number between 0 and 10: ");
		guess = in.nextInt();
		int numGuesses = 1;
		while(guess != randomNumber){
			System.out.println("WRONG! Guess again: ");
			guess = in.nextInt();
			numGuesses++;
		}
		System.out.println("Right after " + numGuesses + " guesses!");

		
	}
}
