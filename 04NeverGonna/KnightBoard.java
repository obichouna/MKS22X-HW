public class KnightBoard{
  public int[][] board;
  public int rows, cols;

  public KnightBoard(int startingRows, int startingCols){
    rows = startingRows;
    cols = startingCols;
    board = new int[startingRows][startingCols];
    for (int row = 0; row < startingRows; row++){
      for (int col = 0; col < startingCols; col++){
        board[row][col] = 0;
      }
    }
  }

  public void solve(){
    solveH(0, 0, 1);
  }

  private boolean solveH(int row, int col, int level){
    // checking if the knight completed the board
    if (rows * cols < level){
      return true;
    }
    // checking if the move goes off the board
    if (row < 0 || col < 0 || row >= rows || col >= cols){
      return false;
    }
    if (board[row][col] == 0){
	    board[row][col] = level;
      //set the level first, next check if there is any solution
      if (solveH(row + 2, col + 1, level + 1) || solveH(row + 2, col - 1, level + 1) ||
          solveH(row + 1, col - 2, level + 1) || solveH(row - 1, col - 2, level + 1) ||
          solveH(row - 2, col - 1, level + 1) || solveH(row - 2, col + 1, level + 1) ||
          solveH(row + 1, col + 2, level + 1) || solveH(row - 1, col + 2, level + 1)){
            return true;
      }
      // no solution that move? Turn the spot back to 0
      board[row][col] = 0;
    }
    return false;
  }

  public String toString(){
    String display = "";
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++){
        display += board[r][c] + " ";
      }
      display += "\n";
    }
    return display;
  }
//  public static void main (String[]args) {
//    KnightBoard x = new KnightBoard(8, 8);
//    x.solve();
//    System.out.println(x);
//  }
}
