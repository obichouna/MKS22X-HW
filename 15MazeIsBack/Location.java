public class Location{
    public int row, col;
    public Location previous;
    public int distanceS;
    public int distanceG;
    public boolean algo;


    public Location(int r, int c, Location prev, int distToS, int distToEnd){
	row = r;
	col = c;
	previous = prev;
	distanceS = distToS;
	distanceG = distToEnd;
    }

    public Location(int r, int c, Location prev, int distToS, int distToEnd, boolean astar){
	row = r;
	col = c;
	previous = prev;
	distanceS = distToS;
	distanceG = distToEnd;
	algo = astar;
    }

    public int compareTo(Location other){
	if (algo){
	    return (distanceS + distanceG) - (other.distanceS + other.distanceG);
	}else{
	    return (distanceG - other.distanceG);
	}
    }


}
