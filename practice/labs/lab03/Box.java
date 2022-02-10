import java.util.*;

public class Box {
  	private double xmin;
	private double xmax;
	private double ymin;
	private double ymax;

	// constructor for Box that consists of a single point
	public Box(Point p) {
		xmin = p.getX();
		xmax = p.getX();
		ymin = p.getY();
		ymax = p.getY();
	}

    	// constructor for the Box containing two initial points
  /*  	
  public Box(Point a, Point b) {
		double ax = a.getX();
		double ay = a.getY();
		double bx = b.getX();
		double by = b.getY();

		if(ax < bx){
			xmin = ax;
			xmax = bx;
		}
		else{
			xmin = bx;
			xmax = ax;
		}

		if(ay < by){
			ymin = ay;
			ymax = by;
		}
		else{
			ymin = by;
			ymax = ay;
		}
	}
  */
  public Box(Point a, Point b){
    this.xmin = a.getX();
    this.ymin = a.getY();
    this.xmax = a.getX();
    this.ymax = a.getY();
    this.growBy(b);
  }

    	// growBy(p) expands the bounding box (if needed) to include point p
	public void growBy(Point p) { 
		double px = p.getX();
		double py = p.getY();

		if(px < xmin)
			xmin = px;
		if(px > xmax)
			xmax = px;
		if(py < ymin)
			ymin = py;
		if(py > ymax)
			ymax = py;
	}

        // given point p in the bounding box, returns associated point in the
        // unit square (see notes); returns null if p is not inside the bounding box.
	public Point mapIntoUnitSquare(Point p) { 
		double px = p.getX();
		double py = p.getY();
		if(px > xmax || px < xmin || py > ymax || py < ymin)
			return null;
		double newX = (px-xmin)/(xmax-xmin);
		double newY = (py-ymin)/(ymax-ymin);
		return new Point(newX,newY);

	}

	// returns string representation like: 2.0 < x < 9.0, 3.0 < y < 7.0
	public String toString() { 
		return xmin + " < x < " + xmax + ", " + ymin + " < y < " + ymax;
	}

	public static void main(String[] args){
		Point a = new Point(1.,2.);
		Point b = new Point(3.,4.);
		Point c = new Point(100.,1000.);
		
		Box box1 = new Box(a);
		Box box2 = new Box(b,c);

		System.out.println("Box1: " + box1);
		System.out.println("Box2: " + box2);

	}
}
