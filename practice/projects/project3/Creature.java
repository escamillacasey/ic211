import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
public class Creature{
  public class Location{
    private double x;
    private double y;
    
    public Location(double x, double y){
      this.x = x;
      this.y = y;
    }

    public double getX(){ return x;}
    public double getY(){ return y;}
    public void moveX(double deltaX){ x += deltaX;}
    public void moveY(double deltaY){ y += deltaY;}

    public String toString(){
      return "x: " + x + "\ty: " + y;
    }

    public double distance(Location loc2){
      return Math.sqrt(Math.pow(getX()-loc2.getX(),2)+Math.pow(getY()-loc2.getY(),2));
    }

    // angle in radians from X-axis
    public double angle(Location loc2){
      return Math.atan2(getY()-loc2.getY(), getX()-loc2.getX());
    }


  }

  private Location pos;
  private Location dest;
  private Rectangle size;
  private boolean living;
  private int hunger;
  private double speed;
  private BufferedImage image;

  public Creature(double x, double y, int w, int h, BufferedImage img){
    pos = new Location(x,y);
    dest = new Location(500,500);
    size = new Rectangle(w,h);
    image = img;
    hunger = 100;
    speed = 5;
  }

  public double getX(){
    return pos.getX();
  }

  public double getY(){
    return pos.getY();
  }

  public Location getDest(){
    return dest;
  }

  public void setDest(Location newDest){
    dest = newDest;
  }

  public void moveX(double delta){
    pos.moveX(delta);
  }

  public void moveY(double delta){
    pos.moveY(delta);
  }

  public int getHunger(){
    return hunger;
  }

  public void decHunger(){
    hunger--;
  }

  public double getSpeed(){
    return speed;
  }

  protected void setSpeed(double speed){
    this.speed = speed;
  }

  public BufferedImage getImage(){
    return image;
  }

  public double getWidth(){
    return size.getWidth();
  }

  public double getHeight(){
    return size.getHeight();
  }

  public void move(){
    double distance = pos.distance(dest);
    double angle = pos.angle(dest);
    moveX(-1.*speed*Math.cos(angle));
    moveY(-1.*speed*Math.sin(angle));
  }
}
