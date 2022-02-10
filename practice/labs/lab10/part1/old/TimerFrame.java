import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimerFrame extends JFrame implements ActionListener{
  private JPanel panel;
  private JLabel timeLabel;
  private JTextField timeRemain;
  private JButton startButton;
  private TimeThread tt;

  public TimerFrame(){
    panel = new JPanel(new FlowLayout());
    timeLabel = new JLabel("DONE");
    timeRemain = new JTextField("10", 10);
    startButton = new JButton("countdown");
  
    panel.add(timeLabel);
    panel.add(timeRemain);
    panel.add(startButton);

    this.add(panel, BorderLayout.CENTER);
    startButton.addActionListener(this);
    timeRemain.addActionListener(this);
    this.pack();
    this.setVisible(true);
  }


  public void actionPerformed(ActionEvent e){
    
    // check for correct format of text
    int time = 0;
    try{
      time = Integer.parseInt(timeRemain.getText());
    }catch(Exception ex){
      timeLabel.setText("ERROR");
    }
    // start countdown
    if(tt == null || !tt.isAlive()){
      tt = new TimeThread(time, this);
      tt.start();
    }
  }

  public void setTextPanel(String txt){
    timeLabel.setText(txt);
  }

}
