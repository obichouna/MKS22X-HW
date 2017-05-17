import java.util.*;

public class StackFrontier implements Frontier{
    public Stack<Location> Locations;

    public StackFrontier(){
        Locations = new Stack<Location>();
    }


    public void add(Location x){
	Locations.push(x);
    }

    public Location next(){
	return Locations.peek();
    }

    public int size(){
	return Locations.size();
    }

}
