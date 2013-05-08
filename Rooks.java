package chessproblem;

import javax.swing.JOptionPane;


    public class Rooks extends ChessPiece {
    	static int rowSize;
        static int columnSize;
        static int boardSize;
        static int count = 0;
        static boolean successful = false;
        static int maxMoves = columnSize;
        static int numInPlay;
        static String type = "r";
        static boolean[][] board = new boolean[8][8];  

        public Rooks() {
        	super();
        }
         public  Rooks (boolean[][] board, String type, int numInPlay, int rowSize, int columnSize)  {  
        	 this.rowSize = rowSize;
             this.columnSize = columnSize;
             boardSize = rowSize * columnSize;
             this.board = board;  
             this.type = type;
             maxMoves = columnSize;
             this.numInPlay = numInPlay;
             /*         
             if (numInPlay > maxMoves) {
             	JOptionPane.showMessageDialog(null, "The number of Rooks in play exceeds the maximum possible of independent pieces of this type.");
             } */
         } 
         
       @Override
        public boolean placePiece (boolean[][] board, int row, int column) {
         if (count >= numInPlay) {
            return true;
         }
         else {
            boolean successful = false;
            row = 0;
            while ((row < rowSize) && !successful) {
               if (threat (board, row, column)) {
                  row++;
               } else {
            	   if (board[row][column]) {
            		   count --;
            	   } else {

                // Place Rook and try to place Rook in next column.
            //	   System.out.println(row + " " +column);
            	   board[row][column] = true;
                  count ++;
                  
                  successful = placePiece (board, row, column + 1);
               
                  if (!successful && (row == rowSize -1)) {
                	  board[row][column] = false;
                	  row++;
                  }
                  else if (!successful && (column == columnSize -1)) {
                	  board[row][column] = false;
                	  row++;
                	  count --;
                  }
                  else if (!successful) {
                     // Remove the Rook placed in the column.
            //         board[row][column] = false;
                     row++;
                  }
               }
               }
               if (row == rowSize) {
                   row=0;
               }
            }
                
            return successful;
         }
      } 
       @Override
       public boolean threat (boolean[][] board, int row, int column) {
  /*  	// Column cannot be outside board
    	   if (column >= columnSize) {
    		   return true;
    	   }
    	// Column cannot be outside board
    	   if (row >= columnSize) {
    		   return true;
    	   } */
    	   
    	   if (board[row][column]) {
    		   System.out.println("testing for piece in the same space");
               return true;
            }  
    	   
        // Test for a Rook on the same row.
         for (int c = 0; c < column; c++) {
            if (board[row][c]) {
               return true;
            }
         }
         return false;
      }
       
       public boolean solve(boolean[][] board, int row, int col) {
     	   
	   	 if (board[row][col]) {
	   		 return true;
	   	 } else {
           return false;
	   	 }
       }
       
    }