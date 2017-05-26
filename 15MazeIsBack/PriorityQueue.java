import java.util.*;

public class PriorityQueue implements Frontier{
    public MyHeap prio;

    public PriorityQueue(){
      prio = new MyHeap();
    }

    public void add(Location x){
      prio.add(x);
    }

    public Location next(){
      return prio.remove();
    }

    public boolean hasNext(){
      return !(prio.peek() == null);
    }

    public Location peek(){
      return prio.peek();
    }




}
