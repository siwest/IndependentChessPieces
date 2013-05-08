package chessproblem;

abstract public class ChessPiece {

	static boolean[][] board;
    static int count;
    static int rowSize;
    static int columnSize;
    static int boardSize;
    static int maxMoves;
    static int numInPlay;
    static String type = "q";
    static boolean canPlace = false;
    
    public ChessPiece() {
    	
	}

	public ChessPiece (boolean [][] board, String type, int numInPlay, int rowSize, int columnSize) {
		 this.rowSize = rowSize;
         this.columnSize = columnSize;
         boardSize = rowSize * columnSize;
         board = new boolean[rowSize][columnSize];  
         this.board = new boolean[rowSize][columnSize];  
         this.type = type;
         maxMoves = 1;
         this.numInPlay = numInPlay;
                  
         if (numInPlay > maxMoves) {
         	System.out.println("Exceeds max number of moves");
         }
     
         for (int row = 0; row < rowSize; row++)
            for (int column = 0; column < columnSize; column++) {
               this.board[row][column] = false;
               board[row][column] = false;
            }         		
	}

	
	abstract boolean placePiece (boolean[][] board, int row, int column);
	abstract boolean threat(boolean[][] board, int row, int column); 
	abstract public boolean solve(boolean[][] board, int row, int col);
 
     

}