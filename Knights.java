package chessproblem;

import javax.swing.JOptionPane;

class Knights extends ChessPiece {

	 static int rowSize;
	 static int columnSize;
	 static int boardSize;
	 static boolean[][] board;
	 static int count = 0;
	 static boolean successful = false;
	 static int maxMoves = 2*boardSize -2;
	 static int numInPlay;
	 String type = "b";

   public Knights() {
	   super();
   }
    	
    
    	
    public Knights (boolean [][]board, String type, int numInPlay, int rowSize, int columnSize)  {  
    	this.rowSize = rowSize;
        this.columnSize = columnSize;
        boardSize = rowSize * columnSize;
        this.board = board;  
        this.type = type;
        maxMoves = boardSize / 2;
        this.numInPlay = numInPlay;
                 
     /*   if (numInPlay > maxMoves) {
        	JOptionPane.showMessageDialog(null, "The number of Knights in play exceeds the maximum possible of independent pieces of this type.");
       }   */   
    }
     @Override   
    public boolean placePiece (boolean[][] board, int row, int column) {
        if (count == numInPlay) {
           return true;
        } else {
       	 
             while ((row < rowSize) && !successful) {
               if (threat (board, row, column)) {
                  row++;
               } else {
            	
                // Place knight.
                  board[row][column] = true;
                  count++;
                  successful = placePiece (board, row, column + 2);
                 
                  if (!successful && (column >= columnSize -2)) {
                      if (column == columnSize -2) {
                          row ++;
                          column = 1;
                      } else if (column == columnSize -1) {
                          column = 0;
                          row++;
                      }
                  }
                  if (!successful && (column >= columnSize)) {
                //	  System.err.println("not successful, row " + row + " " + column);
                	  board[row][column] = false;
                	  column = 0;
                	  row++;
                	  count --;
                  }
                  else if (!successful && (row >= rowSize)) {
                //	  System.err.println("not successful, column " + row + " " + column);
                      board[row][column] = false;
                      column++;
                      row = 0;
                      count--;
                   }   
               }
            }
               
           return successful;
        }
     } 
     @Override
      public boolean threat (boolean[][] board, int row, int column) {

         
          if (row < 0 || row > (rowSize - 1) || column < 0 || column > (columnSize - 1)) { 
        	  return true;
          }
    	 
          int newrow = row + 1;
          int newcolumn = column - 2;
          if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
           //  break;
          }
          else if (board[newrow][newcolumn]) {
              return true;
          }
      
          newrow = row + 1;
          newcolumn = column + 2;
          if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
          //   break;
          }
          else if (board[newrow][newcolumn]) {
              return true;
          }
         
      
          newrow = row - 1;
          newcolumn = column + 2;
          if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
          //   break;
          }
          else if (board[newrow][newcolumn]) {
              return true;
          }

          newrow = row - 1;
          newcolumn = column - 2;
          if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
          //   break;
          }
          else if (board[newrow][newcolumn]) {
              return true;
          }
      
          newrow = row - 2;
          newcolumn = column + 1;
          if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
           //  break;
          }
          else if (board[newrow][newcolumn]) {
              return true;
          }          
      
          newrow = row + 2;
          newcolumn = column + 1;
          if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
           //  break;
          }
          else if (board[newrow][newcolumn]) {
              return true;
          }

          newrow = row + 2;
          newcolumn = column - 1;
          if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
           //  break;
          }
          else if (board[newrow][newcolumn]) {
              return true;
          }
          
          newrow = row - 2;
          newcolumn = column - 1;
          if (newrow < 0 || newrow > (rowSize - 1) || newcolumn < 0 || newcolumn > (columnSize - 1)) {
            // break;
          }
          else if (board[newrow][newcolumn]) {
              return true;
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

