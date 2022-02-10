import java.util.*;
import java.io.*;

public class Lab03{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String next = in.nextLine();
		String[] splitStr = next.split(" ");
		Box theBox = null;
		while(!next.equals("done")){
			switch(splitStr[0]){	
				case "map":
					if(theBox != null && splitStr.length == 3){
						Point a = new Point(Double.valueOf(splitStr[1]), Double.valueOf(splitStr[2]));
						a = theBox.mapIntoUnitSquare(a);
						if(a == null)
							System.out.println("error");
						else
							System.out.println(a);
					}
					break;
				
				case "box":
					if(theBox != null){
						System.out.println(theBox);
					}
					break;
				
				case "add":
					if(splitStr.length != 3){
						break;
					}
					Point a = new Point(Double.valueOf(splitStr[1]), Double.valueOf(splitStr[2]));

					if(theBox == null)
						theBox = new Box(a);
					else
						theBox.growBy(a);
					break;
				default:
					System.out.println("Error! Unknown command " + "\""+ next + "\"!");
			}
			next = in.nextLine();
			splitStr = next.split(" ");
		}
		

	}
}

