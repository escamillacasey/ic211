import javax.swing.*;
import java.awt.event.*;

public class Mystery implements ActionListener, Runnable {
  private JLabel label;
  private Thread t;
  public Mystery(JLabel label) {
    this.label = label;
  }

  public void actionPerformed(ActionEvent e) {
    if(t == null || !t.isAlive()){
      t = new Thread(this);
      t.start();
    }
  }

  public void run(){
    CChange.changeColor(label);
  }
}
