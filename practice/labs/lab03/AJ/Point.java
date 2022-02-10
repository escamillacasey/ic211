import java.util.*;

/**
 *
 *
 *
 **/
public class Point {
	private double x, y;

	public Point(double x, double y) {
			this.x= x;
			this.y = y;
	}

	public static Point read(Scanner sc) {
			System.out.print("enter: ");
			String cmd = sc.next();
			Point temp = new Point(sc.nextDouble(), sc.nextDouble());
			return temp;
	}

	public String toString() {
		return (x + " " + y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}	

	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			Point p1 = read(in);
			System.out.println(p1.toString());
	}

}


