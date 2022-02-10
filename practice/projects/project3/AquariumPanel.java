import java.util.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
public class AquariumPanel extends JPanel implements Runnable{
  private Image background;
  private Aquarium aq;
  private ArrayList<Creature> residents = new ArrayList<Creature>();

  public AquariumPanel(Aquarium a){
    this.aq = a;
    String[] imgFiles = { "images/clownfish.png",
                          "images/greenDot.png",
                          "images/shark.png",
                          "images/small-fish.png",
                          "images/tiny-fish.png" };
    try{
      ClownFish.setImage(imgFiles[0]);
      Plankton.setImage(imgFiles[1]);
    }catch(Exception e){
      System.out.println("Unable to load image");
    }

    residents.add(new ClownFish(10., 10.));
    residents.add(new Plankton(500.,500.));
  }

  public void setBackground(Image image){
    this.background = image;
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    g2.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(
      RenderingHints.KEY_RENDERING,
      RenderingHints.VALUE_RENDER_QUALITY);
    
    g2.drawImage(background, 0,0, this.getWidth(), this.getHeight(), null);
    for(Creature c : residents){
      drawCreature(c, g2);
    }
  }

  public void step(){
    moveCreatures();
    
    repaint();
  }

  public void run(){
    System.out.println("Running....");
    while(true){
      step();
      try{
        Thread.sleep(10);
      }catch(Exception e){}
    }
  }

  public void moveCreatures(){
    for(Creature c : residents)
      c.move();
  }

  public void drawCreature(Creature c, Graphics2D G){
    G.drawImage(c.getImage(), (int)c.getX(), (int)c.getY(), (int)c.getWidth(), (int)c.getHeight(), null);
  }
}
