import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private boolean animate;
    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
        //COMPLETE CONSTRUCTOR
        int rows = 0;
        int cols = 0;
        int startCoordx, startCoordy;
        int s;
        int e;
        int line = 0;
        try {
          Scanner scan = new Scanner(new File(filename));
          while(scan.hasNextLine()){
            String x = scan.nextLine();
            rows++;
            cols = line.length();
            for (int i; i < x.length(); i++){
              if (x.charAt(i) == "E"){
                e += 1;
              }
              if (x.charAt(i) == "S"){
                s += 1;
                startCoordx = i;
                startCoordy = line;
              }
              maze[line][i] = x.charAt()
            }
            line++;
          }
          if (e != 1 || s != 1){
            System.out.println("No start or exit.");
            System.exit(0);
          }
        }
        catch(FileNotFoundException e){
          System.out.println("File not located.");
          System.exit(0);
        }
        animate = false;
    }


    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;

            //Initialize starting row and startint col with the location of the S.
            startr = startCoordy;
            startc = startCoordx;
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
        if(maze[row][col] == "E"){
          return true;
        }
        if(maze[row][col] == " "){
          maze[row][col] = "@";
          if (solveH(row, col)){
            return true;
          }else{
            maze[row][col] = " ";
          }
        }
        //COMPLETE SOLVE

        return false; //so it compiles
    }

    private boolean solveH(int row, int col){
      return ((row - 1 >= && solve(row - 1))
    }

}
