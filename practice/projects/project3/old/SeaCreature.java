import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

public class SeaCreature extends JComponent implements Runnable{
  private int size;
  private Location loc;
  private int moveAmount;
  private Location destination;
  private BufferedImage image;
  private Thread t;
  private AquariumPanel p;

  public class Location{
    private double x;
    private double y;
    public Location(double x, double y){
      this.x = x;
      this.y = y;
    }

    public double getX(){ return x;}
    public double getY(){ return y;}

    public void moveX(double deltaX){
      x += deltaX;
    }

    public void moveY(double deltaY){
      y += deltaY;
    }
  }

  public SeaCreature(double x, double y, String fname, AquariumPanel p){
    this.loc = new Location(x,y);
    this.p = p;
    this.moveAmount = 1;

    try{
      this.image = ImageIO.read(new File(fname));
    }catch(IOException e){
      e.printStackTrace();
    }

    this.destination = getNewDestination();

    System.out.println(p.getWidth() + " " + p.getHeight());
    t = new Thread(this);
    t.start();
  }

  private Location getNewDestination(){
    Random r = new Random();
    return new Location(r.nextDouble()*1000., r.nextDouble()*1000.);
  }


  public void moveToward(Location newLoc){
    double deltaX = newLoc.getX() - loc.getX();
    double deltaY = newLoc.getX() - loc.getY();
    double c = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));

    loc.moveX(deltaX/c);
    loc.moveY(deltaY/c);

  }

  protected double distanceToDestination(){
    return Math.sqrt(Math.pow(loc.getY()-destination.getY(),2)+Math.pow(loc.getX()-destination.getX(),2));
  }

  public void run(){
    while(true){
      if(distanceToDestination() > 1)
        moveToward(this.destination);
    
      try{
        t.sleep(20);
      }catch(Exception e){}
    
      repaint();
    }
  }

  protected void setDestination(Location newDest){
    this.destination = newDest;
  }

  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    //System.out.println("Height: " + this.getHeight() + "\tWidth: " + this.getWidth());
    Graphics2D g2 = (Graphics2D)g;
        // This voodoo makes the output prettier
    
    g2.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(
      RenderingHints.KEY_RENDERING,
      RenderingHints.VALUE_RENDER_QUALITY);
    
    //g2.drawImage(image,(int)loc.getX(), (int)loc.getY(),null); 
    g2.drawImage(image,(int)loc.getX(),(int)loc.getY(),40,40, null);
  }
}
