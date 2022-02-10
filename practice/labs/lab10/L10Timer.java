import java.util.*;
import javax.swing.*;
import java.awt.*;

public class L10Timer{
  public static void main(String[] args){
    //TimerFrame tf = new TimerFrame();
    JFrame frame = new JFrame();
    TimerPanel[] tpArr = new TimerPanel[5];
    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
    for(TimerPanel tp : tpArr){
      tp = new TimerPanel();
      frame.add(tp);
    }
    
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
