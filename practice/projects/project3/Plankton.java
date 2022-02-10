import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Plankton extends Creature{
  public static BufferedImage planktonImage;
  public static void setImage(String fname) throws IOException{
    planktonImage = ImageIO.read(new File(fname));
  }

  public Plankton(double x, double y){
    super(x,y, 10, 10, planktonImage);
  }
}
