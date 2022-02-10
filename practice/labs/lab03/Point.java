import java.util.*;
import java.io.*;

public class Point{

	private double x;
	private double y;

	// initializes the point object
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	// reads an x and a y value from the scanner and
	// returns the associated point
	public static Point read(Scanner sc){
		double newX = sc.nextDouble();
		double newY = sc.nextDouble();
		return new Point(newX, newY);
	}

	// returns a String consisting of the x-coordinate
	// a space and the y-coordinate
	public String toString(){
		return x + " " + y;
	}
	
	public double getX(){
		return this.x;
	}
	
	public Double getY(){
		return this.y;
	}

	public static void main(String[] args){
		Point aPoint = new Point(5., 2.);
		System.out.println("A point is: " + aPoint.toString());
		Scanner aScanner = new Scanner(System.in);
		Point aNewPoint = read(aScanner);
		System.out.println("A new point is: " + aNewPoint);
	}


}
