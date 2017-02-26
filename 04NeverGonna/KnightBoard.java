public KnightBoard{
  public int[][] board;
  public int x, y;
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

  public boolean solveH(int row, int col, int level){
    if (board[row][col] != 0){
      return false;
    }
    board[row][col] = level;
    if ()
  }


}
