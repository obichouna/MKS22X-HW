public class Location{
    public int row, col;
    public Location previous;
    public int distanceS;
    public boolean algo;
    

    public Location(int r, int c, int prev, int distToS, int distToEnd){
	row = r;
	col = c;
	previous = prev;
	distanceS = disToS;
    }

    public Location(int r, int c, int prev, int distToS, int distToEnd, boolean astar){
	row = r;
	col = c;
	previous = prev;
	distanceS = disToS;
	algo = astar;
    }

    public int compareTo(Location other){
	



    }
    
    
}
