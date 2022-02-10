import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Aquarium extends JFrame{
  private AquariumPanel panel;
  
  public Aquarium(String fname){
    this();
    //panel = new AquariumPanel();
    AquariumPanel tmpPanel = new AquariumPanel(this);
    try{
      tmpPanel.setBackground(ImageIO.read(new File(fname)));
    }catch(Exception e){
      System.out.println("Failed to open file, switching to baby shark...");
    }
    this.panel = tmpPanel;
  }

  public Aquarium(){
    panel = new AquariumPanel(this);
    add(panel);
    setTitle("Aquarium");
    setLocation(100,100);
    try{
      panel.setBackground(ImageIO.read(new File("baby_shark.jpg")));
    }catch(Exception e){
      System.out.println("Failed to opens stock file...");
      return;
    }
    setPreferredSize(new Dimension(1000,1000));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
    Thread creatureThread = new Thread(panel);
    creatureThread.start();
  }  


  public static void main(String[] args){
    Aquarium a = null;
    if(args.length == 0)
      a = new Aquarium();
    else
      a = new Aquarium(args[0]);


    a.pack();
  }
}
