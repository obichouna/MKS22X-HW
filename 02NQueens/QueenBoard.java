public class QueenBoard{
    public int[][] board;
    public int solutionCount = -10;
    public int boardSize;

    public QueenBoard(int size){
	     board = new int[size][size];
	     boardSize = size;
	       for (int row = 0; row < size; row++){
	          for (int col = 0; col < size; col++){
		            board[row][col] = 0;
	             }
	            }
            }
    public void clear(){
      board = new int[boardSize][boardSize];
      for (int row = 0; row < boardSize; row++){
         for (int col = 0; col < boardSize; col++){
             board[row][col] = 0;
            }
           }
    }
    public void countSolutions(){
      clear();
      solutionCount = 0;
      solutionHelper(0);
    }

    private boolean solutionHelper(int col){
      if (col >= boardSize){
        solutionCount += 1;
        return true;
      }
      for (int i = 0; i < boardSize; i++){
        if (addQueen(i, col)){
          addQueen(i, col);
          solutionHelper(col + 1);
          removeQueen(i, col);
        }
      }
      return false;
    }

    public int getSolutionCount(){
      if (solutionCount == -10){
        return -1;
      }
      return solutionCount;
    }


    public void solve(){
	     solveH(0);
    }

    public boolean solveH(int col){
  // vvvvvv Realized was unneccesary
  //int queenCount;
	//for (int row = 0, row < boardSize, row++){
	//    for (int col = 0, col < boardSize, col++){
	//	if (board[row][col] == 0){
	//	    queenCount++;
	//	}
	//    }
	//}
	//if (queenCount == boardSize){
	//    return true;
	//}
  // I can see my house from here!

      if (col >= boardSize){
        return true;
      }
      for (int row = 0; row < boardSize; row++){
        if (addQueen(row, col)){
          addQueen(row, col);
          if (solveH(col + 1)){
            return true;
          }else{
            removeQueen(row, col);
          }
        }
      }
      return false;
  }



    private boolean addQueen(int row, int col){
      if (board[row][col] != 0){
        return false;
      }
      for (int i = 0; i < boardSize; i++){
        board[row][i] += 1;
        board[i][col] += 1;
        if (row + i < boardSize && col + i < boardSize){
          board[row + i][col + i] += 1;
        }
        if (row + i < boardSize && col - i >= 0){
          board[row + i][col - i] += 1;
        }
        if (row - i >= 0 && col + i < boardSize){
          board[row - i][col + i] += 1;
        }
        if (row - i >= 0 && col - i >= boardSize){
          board[row - i][col - i] += 1;
        }
      }
      board[row][col] = -1;
      return true;
    }

    private void removeQueen(int row, int col){
      for (int i = 0; i < boardSize; i++){
        board[row][i] += -1;
        board[i][col] += -1;
        if (row + i < boardSize && col + i < boardSize){
          board[row + i][col + i] += -1;
        }
        if (row + i < boardSize && col - i >= 0){
          board[row + i][col - i] += -1;
        }
        if (row - i >= 0 && col + i < boardSize){
          board[row - i][col + i] += -1;
        }
        if (row - i >= 0 && col - i >= boardSize){
          board[row - i][col - i] += -1;
        }
      }
      board[row][col] = 0;
    }

    public String toString(){
      String x = "";
      for (int row = 0; row < boardSize; row++){
        for (int col = 0; col < boardSize; col++){
          if (board[row][col] == -1){
            x += "Q";
          }else{
            x += "_";
          }
        }
        x += "\n";
      }
      return x;
    }

//    public static void main(String[]args) {
//	     QueenBoard x = new QueenBoard(7);
//      x.solve();
//        System.out.println(x);
//  }
}
