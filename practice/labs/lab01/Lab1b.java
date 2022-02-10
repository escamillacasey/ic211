import java.util.*;

public class Lab1b{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = in.nextLine();	
		System.out.print("Please input an integer: ");
		int n = in.nextInt();
		System.out.print("Please input a second integer: ");
		int k = in.nextInt();
		System.out.println("The two ints were " + n + " and " + k);

		double numerator = 1.;
		double denominator = 1.;

		for(int i = 0; i < k; i++){
			numerator = numerator * (n-i);
		}
		System.out.println("numerator = " + (int)numerator);

		for(int i=k;i>0;i--){
			denominator = i*denominator;
		}
		System.out.println("denominator = " + (int)denominator);

		double odds = numerator / denominator;
		System.out.println("odds = 1 in " + (int)odds + " = " + 1/odds);
		System.out.println("Goodbye " + name + ".");
	}

}

