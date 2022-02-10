import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Aquarium extends JComponent{
  //  private AquariumController controller;
  //  private AquariumViewer viewer;
  
  BufferedImage background;

  public Aquarium(){
    super();
    //setPreferredSize(new Dimension(400,400));
    //this.setTitle("Aquarium");
    //this.setLocation(100,100);
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setBackground(Color.BLUE);
    //this.setVisible(true);
  }
  
  protected void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D)g;
    g2.drawImage(this.background,0,0,null);
  }

  public void setBackground(String fname) throws IOException{
    BufferedImage img = null;
    img = ImageIO.read(new File(fname));
    background = img;
    setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
    
  }

  public static void main(String[] args){
    Aquarium a = new Aquarium();
    
    JFrame f = new JFrame();
    
    f.add(a);
    
    f.setTitle("Aquarium");
    f.setLocation(100,100);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setBackground(Color.BLUE);
    f.setVisible(true);
    try{
    a.setBackground(args[0]);
    }catch(Exception e){
    }
    f.pack();
  }
}
