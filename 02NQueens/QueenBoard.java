public class QueenBoard{
    public int[][] board;
    public int solutionCount;
    public int boardSize;

    public QueenBoard(int size){
	board = new int[size][size];
	boardSize = size;
	for (int row = 0, row < size, row++){
	    for (int col = 0, col < size, col++){
		board[row][col] = 0;
	    }
	}
    }
    public boolean solve(){
	return solveH(0);
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

	if (col == boardSize){
	    return true;
	}
	
    }
}
