public class QueenBoard{
    public int[][] board;
    public int solutionCount;
    public int boardSize;

    public QueenBoard(int size){
	     board = new int[size][size];
	     boardSize = size;
       solutionCount == -1;
	       for (int row = 0; row < size; row++){
	          for (int col = 0; col < size; col++){
		            board[row][col] = 0;
	             }
	            }
            }
    public void solve(){
	     solveH(0);
    }

    public boolean solveH(int col){
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
    }

    private boolean removeQueen(int row, int col){
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
    }
}
