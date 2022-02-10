import java.util.*;
import javax.swing.*;

public class TimeThread extends Thread{
  private int timeRemaining;
  private TimerPanel tp;
  public TimeThread(int time, TimerPanel tp){
    timeRemaining = time;
    this.tp = tp;
  }

  public void run(){
    System.out.println("Running...");
    while(this.timeRemaining > 1){
      try{
          Thread.sleep(1000);
          timeRemaining--;
          tp.setTextPanel(Integer.toString(timeRemaining));
      }catch(Exception e){
      }
    }
    tp.setTextPanel("DONE");
  }
}
