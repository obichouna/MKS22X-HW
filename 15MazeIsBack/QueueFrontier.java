import java.util.*;

public class QueueFrontier implements Frontier{
    public LinkedList<Location> deck;

    public QueueFrontier(){
	deck = new LinkedList<Location>();
    }

    public void add(Location x){
	deck.addFirst(x);
    }

    public Location next(){
	return deck.getLast();
    }

    public int size(){
	return deck.size();
    }

}
