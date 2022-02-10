public class Box {

	private double xmin, xmax, ymin, ymax;

	public Box(Point p) {
		xmin = p.getX();
		xmax = p.getX();
		ymin = p.getY();
		ymax = p.getY();	
	}

	public Box(Point a, Point b) {


	}

	public static void main(String[] args) {
		Point p1 = new Point(1, 2);
		Box b1 = new Box(p1);
		System.out.println(b1.xmin + " " + b1.ymax);
	}
}

