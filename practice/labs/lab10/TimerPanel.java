import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TimerPanel extends JPanel implements ActionListener{
  private JLabel timeLabel;
  private JTextField timeRemain;
  private JButton startButton;
  private TimeThread tt;

  public TimerPanel(){
    timeLabel = new JLabel("DONE");
    timeLabel.setPreferredSize(new Dimension(60,15));
    timeRemain = new JTextField("10", 10);
    startButton = new JButton("countdown");

    add(timeLabel);
    add(timeRemain);
    add(startButton);

    startButton.addActionListener(this);
    timeRemain.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e){
    int time = 0;
    try{
      time = Integer.parseInt(timeRemain.getText());
    }catch(Exception ex){
      timeLabel.setText("ERROR");
    }

    if(tt == null || !tt.isAlive()){
      tt = new TimeThread(time, this);
      tt.start();
    }
  }

  public void setTextPanel(String txt){
    timeLabel.setText(txt);
  }
}
