import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.*;

public class ClownFish extends Fish{
  private static String defaultClown = "images/clownfish.png";
  public ClownFish(AquariumPanel p){
    super(10.,10., defaultClown, p);
    //setPreferredSize(new Dimension(p.getWidth(), p.getHeight()));
  }

}
