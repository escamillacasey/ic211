import java.util.*;
public class ModQueue extends Queue{
  public void dequeue(String s){
    String tmp = this.dequeue();
    while(!tmp.equals(s))
      tmp = this.dequeue();
  }

  public void enqueue(String s){
    String[] arr;
    try{
      arr = this.toArray();
    }catch(QueueException e){
      super.enqueue(s);
      return;
    }
    boolean inQ = false;
    for(String tmp : arr){
      if(tmp.equals(s))
        inQ = true;
    }
    if(!inQ)
      super.enqueue(s);
  }

  public String dump(){
    if(empty())
      return "";
    return String.join(",",this.toArray());
  }
}
