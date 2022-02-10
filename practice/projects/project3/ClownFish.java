import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ClownFish extends Creature{
  public static BufferedImage clownImage;
  public static void setImage(String fname) throws IOException{
    clownImage = ImageIO.read(new File(fname));
  }

  public ClownFish(double x, double y){
    super(x, y, 50, 50, clownImage);
    setSpeed(.25);
  }
}
