package chessproblem;

import java.util.ArrayList;

import javax.swing.JOptionPane;

    public class Queens extends ChessPiece{
    	static int rowSize;
        static int columnSize;
        static int boardSize;
        static boolean[][] board;
        static int count = 0;
        static boolean successful = false;
        static int numInPlay;
        static String type = "q";

      public Queens() {
    	  super();
      }

       public Queens (boolean[][] board, String type, int numInPlay, int rowSize, int columnSize)  {  
    	   this.rowSize = rowSize;
           this.columnSize = columnSize;
           boardSize = rowSize * columnSize;
           this.board = board;  
           this.type = type;
           this.numInPlay = numInPlay;
           int maxMoves = columnSize;
                    
    /*       if (numInPlay > maxMoves) {
            	JOptionPane.showMessageDialog(null, "The number of Queens in play exceeds the maximum possible of independent pieces of this type.");
           } */
      } 
       @Override
       public boolean placePiece (boolean[][] board, int row, int column) {
         if (column == numInPlay) {
        //	 System.out.println("Success");
            return true;
         } else {
         //    System.out.println("here " + board[row][column] + " " + row + " " + column);

            boolean successful = false;
            row = 0;
            while ((row < rowSize) && !successful) {
               if (threat (board, row, column)) {
                  row++;
               } else {
                // Place queen and try to place queen in next column.

            	   board[row][column] = true;
                  this.board[row][column] = true;
        //          System.out.println("here " + board[row][column] + " " + row + " " + column);

                  successful = placePiece (board, row, column + 1);
               
                  if (!successful) {
                     // Remove the queen placed in the column.
                     board[row][column] = false;
                     this.board[row][column] = false;
                     row++;
                  }
               }
            }
                
            return successful;
         }
      }
       @Override
       public boolean threat (boolean[][] board, int row, int column) {
           
       if (board[row][column]) {
               System.out.println("testing for piece in the same space");
           return true;
        }  
           
        // Test for a queen on the same row.
         for (int c = 0; c < column; c++) {
            if (board[row][c]) {
               return true;
            }
         }
     
        // Test for queen on up diagonal.
         for (int c = 1; c <= column; c++) {
            if (row < c) {
               break;
            }
         
            if (board[row - c][column - c]) {
               return true;
            }
         }
     
        // Test for queen on down diagonal
         for (int c = 1; c <= column; c++) {
            if (row + c >= rowSize) {
               break;
            }
         
            if (board[row + c][column - c]) {
               return true;
            }
         }
       
         return false;
      }
       
       public boolean solve(boolean[][] board, int row, int col) {
    	   
      	 if (board[row][col]) {
      		// System.out.println("Should be returning true " + row + " " + col);
      		 return true;
      	 } 
	        else {
	       //    System.out.println("No solution found "  + row + " " + col);
	           return false;
	        }
       }

    }