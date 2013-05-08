package chessproblem;

import javax.swing.JOptionPane;


    public class Bishops extends ChessPiece {
      static int rowSize;
      static int columnSize;
      static int boardSize;
      static int count = 0;
      static boolean successful = false;
      static int maxMoves = 2*boardSize -2;
      static int numInPlay;
      String type = "b";

	   public Bishops() {
		   super();
	   }
       public  Bishops (boolean[][] board, String type, int numInPlay, int rowSize, int columnSize)  {  
    	   this.rowSize = rowSize;
           this.columnSize = columnSize;
           boardSize = rowSize * columnSize;
           this.board = board;  
           this.type = type;
           maxMoves = 2*columnSize - 2;;
           this.numInPlay = numInPlay;
                    
         /*  if (numInPlay > maxMoves) {
           	JOptionPane.showMessageDialog(null, "The number of Bishops in play exceeds the maximum possible of independent pieces of this type.");
          }       */     
      } 
       
       @Override
         boolean placePiece (boolean[][] board, int row, int column) {

         if (count >= numInPlay) { 
        	 return true;
         }
         else {
            successful = false;
            row = 0;
            while ((row < rowSize) && !successful) {
               if (threat (board, row, column)) {
                  row++;
               } else {
            	   if (board[row][column]) {
            		   count --;
            	   }
            	   // Place Bishop and try to place Bishop in next column.
                   board[row][column] = true;
                   count ++;
                   successful = placePiece (board, row, column + 1);
                   
                   if (!successful && (column == columnSize -1)) {
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
            return successful;
         }
      } 
        public boolean threat (boolean[][] board, int row, int column) {
           
              
    	   // Column cannot be outside board
    	   if (column >= columnSize) {
    		   return true;
    	   }

          for(int i = 1; i < columnSize; i++) {
            int newrow = row - i;
            int newcolumn = column - i;
            if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
               break;
            }
            if (board[newrow][newcolumn]) {
                return true;
            }
           }
          
          for(int i = 1; i < columnSize; i++) {
            int newrow = row + i;
            int newcolumn = column + i;
            if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
               break;
            }
            if (board[newrow][newcolumn]) {
                return true;
            }
           }
          
          for(int i = 1; i < columnSize; i++) {
            int newrow = row + i;
            int newcolumn = column - i;
            if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
               break;
            }
            if (board[newrow][newcolumn]) {
                return true;
            }
           }
          
          for(int i = 1; i < 8; i++) {
            int newrow = row - i;
            int newcolumn = column + i;
            
            if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
               break;
            }
            if (board[newrow][newcolumn]) {
                return true;
            }
           }
          return false;
      } 
       
        public boolean solve(boolean[][] board, int row, int col) {

         	 if (board[row][col]) {
         	//	 System.out.println("Should be returning true " + row + " " + col);
         		 return true;
         	 } 
   	        else {
   	     //      System.out.println("No solution found "  + row + " " + col);
   	           return false;
   	        }
          }
       
    }