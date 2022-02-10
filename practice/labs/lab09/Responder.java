import java.awt.event.*;

public class Responder implements ActionListener{
  private CalcFrame f;
  public Responder(CalcFrame f){
    this.f = f;
  }

  public void actionPerformed(ActionEvent e){
    f.recalculate();
  }
}
