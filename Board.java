/**
 * 
 */
package chessproblem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


/**
 * @author sarahwest
 *
 */
public class Board extends JFrame {
	int rows = 8;
	int columns = 8;
	int numQ = 8;
	int numK = 0;
	int numR = 0;
	int numB = 0;
	JTextField columnsTF;
	JTextField rowsTF;
	Image blackQueen;
	Image blackKnight;
	Image blackRook;
	Image blackBishop;
	JTextField numberQueens;
	JTextField numberRooks;
	JTextField numberKnights;
	JTextField numberBishops;
	static boolean canPlace = false;
	static boolean submitted = false;
	
	public Board() {
		
	}

	public void initFrame(int myRows, int myColumns, int numQ1, int numK1, int numR1, final int numB1) {
		this.rows = myRows;
		this.columns = myColumns;
                this.numQ = numQ1;
                this.numK = numK1;
                this.numR = numR1;
                this.numB = numB1;
		setSize(800, 900);
		final JFrame frame = new JFrame();
		frame.setSize(800, 900);
		frame.setBackground(Color.gray);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setResizable(false);
		
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu();

		JMenuItem solutionStore = new JMenuItem("Other Solutions");
		JMenuItem exit = new JMenuItem("Exit");
		
		menu.add(solutionStore);
		menu.add(exit);
		
		frame.setJMenuBar(menubar);
                frame.setLocationRelativeTo(null);
		
		JPanel backPanel = new JPanel(new BorderLayout());
		backPanel.setSize(800, 800);
		backPanel.setBackground(Color.lightGray);
		
		JPanel outerSidePanel = new JPanel(new BorderLayout());
		JTextArea squareSizeLabel = new JTextArea("  Specify grid size \n" +
                                                          "  and number of \n" +
                                                          "  independent pieces, \n" +
                                                          "  then click Submit.");
		squareSizeLabel.setLineWrap(false);
		squareSizeLabel.setEditable(false);
		squareSizeLabel.setBackground(Color.LIGHT_GRAY);
		outerSidePanel.add(squareSizeLabel, BorderLayout.CENTER);
		
		JPanel innerSidePanel = new JPanel(new GridLayout(7, 2, 2, 2));
		innerSidePanel.setBackground(Color.LIGHT_GRAY);
		JLabel columnsLabel = new JLabel(" Columns  ");
		columnsLabel.setBackground(Color.LIGHT_GRAY);
		columnsTF = new JTextField(myColumns + "");
		columnsTF.setSize(20, 20);
		columnsTF.setEditable(true);
		JLabel rowsLabel = new JLabel(" Rows  ");
		rowsLabel.setBackground(Color.LIGHT_GRAY);
		rowsTF = new JTextField(myRows + "");
		rowsTF.setEditable(true);
		innerSidePanel.add(columnsLabel);
		innerSidePanel.add(columnsTF);
		innerSidePanel.add(rowsLabel);
		innerSidePanel.add(rowsTF);
		
		JLabel queensLabel = new JLabel(" Queens");
		queensLabel.setBackground(Color.LIGHT_GRAY);
		JLabel knightsLabel = new JLabel(" Knights");
		knightsLabel.setBackground(Color.LIGHT_GRAY);
		JLabel rooksLabel = new JLabel(" Rooks");
		rooksLabel.setBackground(Color.LIGHT_GRAY);
		JLabel bishopsLabel = new JLabel(" Bishops");
		bishopsLabel.setBackground(Color.LIGHT_GRAY);
		numberQueens = new JTextField(numQ1 + "");
		numberKnights = new JTextField(numK1 + "");
		numberRooks = new JTextField(numR1 + "");
		numberBishops = new JTextField(numB1 + "");
		numberQueens.setEditable(true);
		numberKnights.setEditable(true);
		numberRooks.setEditable(true);
		numberBishops.setEditable(true);
		innerSidePanel.add(queensLabel);
		innerSidePanel.add(numberQueens);
		innerSidePanel.add(knightsLabel);
		innerSidePanel.add(numberKnights);
		innerSidePanel.add(rooksLabel);
		innerSidePanel.add(numberRooks);
		innerSidePanel.add(bishopsLabel);
		innerSidePanel.add(numberBishops);
		
		final JButton submit = new JButton("Submit");
		outerSidePanel.add(innerSidePanel, BorderLayout.NORTH);
		outerSidePanel.add(submit, BorderLayout.SOUTH);
		outerSidePanel.setBackground(Color.LIGHT_GRAY);
		
		boolean [][] board = new boolean[rows][columns];
		for (int row = 0; row < rows; row++)
                    for (int column = 0; column < columns; column++) {
                        board[row][column] = false;
                }
		
		
		submit.addActionListener(new ActionListener() {
                    
			@Override
			public void actionPerformed(ActionEvent e) {
                            
                            if (e.getSource() == submit) {
				rows = (int)Integer.parseInt(rowsTF.getText());
				columns = (int)Integer.parseInt(columnsTF.getText());
				int q = (int) Integer.parseInt(numberQueens.getText());
                                int k = (int) Integer.parseInt(numberKnights.getText());
				int r = (int) Integer.parseInt(numberRooks.getText());
				int b = (int) Integer.parseInt(numberBishops.getText());
                                int sum = q + k + r + b;
                                
                                
                                if (q > columns) {
                                    q = columns;
                                    JOptionPane.showMessageDialog(null, "The number of Queens in play exceeds the maximum possible of independent pieces of this type. Maximum allowed Queens for a board of this size is " + numQ + ".");
                                }
                                if (k > columns * rows / 2) {
                                    k = columns * rows / 2;
                                    JOptionPane.showMessageDialog(null, "The number of Knights in play exceeds the maximum possible of independent pieces of this type. Maximum allowed Knights for a board of this size is " + numK + ".");
                                }
                                if (r > columns) {
                                    r = columns;
                                    JOptionPane.showMessageDialog(null, "The number of Rooks in play exceeds the maximum possible of independent pieces of this type. Maximum allowed Rooks for a board of this size is " + numR + ".");
                                }
                                if (b > 2 * columns - 2) {
                                    b =  2* columns - 2;
                                    JOptionPane.showMessageDialog(null, "The number of Bishops in play exceeds the maximum possible of independent pieces of this type. Maximum allowed Bishops for a board of this size is " + numB + ".");
                                }
                                
                                if (sum == 0) {
                                    JOptionPane.showMessageDialog(null, "Please place at least one piece to play. Since you did not place a piece this time, one piece has been placed for you.");
                                    q = 1;
                                } 
                               
                                frame.removeAll();
				removeAll();
				frame.hide();
				initFrame(rows, columns, q, k, r, b);
                            }
			}
		});
		
		JPanel gridPanel = new JPanel(new GridLayout(rows, columns, 2, 2));
		int numSquares = rows * columns;
		gridPanel.setSize(600,600);
		JPanel [][] squares = new JPanel[rows][columns];
		
		
                for (int i = 0; i < rows; i ++) {
                    for (int j = 0; j < columns; j++) {
                        squares[i][j] = new JPanel();
                        squares[i][j].setSize(70, 70);
                        JLabel picLabel = new JLabel(" ");
                        squares[i][j].add(picLabel);

                        if (i%2 == 1) {
                            if (j%2 == 1) {
                                squares[i][j].setBackground(Color.decode("#68B1C0"));
                            }
                            if (j%2 == 0) {
                                squares[i][j].setBackground(Color.decode("#AFD6DE"));
                            }
                        }
                        if (i%2 == 0) {
                            if (j%2 == 1) {
                                squares[i][j].setBackground(Color.decode("#AFD6DE"));
                            }
                            if (j%2 == 0) {
                                squares[i][j].setBackground(Color.decode("#68B1C0"));
                            }
                        }
                        gridPanel.add(squares[i][j]);
                    }
                }
                
                
                
                
                ///Control chess pieces on board here
		boolean successfulPlacement = false;
		ChessPiece piece = null;
		Image image = Toolkit.getDefaultToolkit().getImage(Board.class.getResource("black-queen.png"));
		int r = 0;
		int c = 0;
                if (numQ > 0) {
                    image = Toolkit.getDefaultToolkit().getImage(Board.class.getResource("black-queen.png"));
                    piece = new Queens(board, "q", numQ, rows, columns);
                    successfulPlacement = piece.placePiece(board, r, c); 
                    if (successfulPlacement) {
                        for (int i = 0; i < rows; i ++) {
                            for (int j = 0; j < columns; j++) {
                                if (piece.solve(board, i, j)) {
                                    JLabel picLabel = new JLabel(new ImageIcon(image));
                                    picLabel.setSize(70, 70);
                                    squares[i][j].add(picLabel);
                                    board[i][j] = true;
                                }
                            }
                        }
                    }
                    successfulPlacement = false; 
                    
		} 
		if (numK > 0) {
                   r = 0;
		c = 0;
                    image = Toolkit.getDefaultToolkit().getImage(Board.class.getResource("black_knight.png"));
                    piece = new Knights(board, "k", numK, rows, columns);
                    successfulPlacement = piece.placePiece(board, r, c); 
                    
                     if (successfulPlacement) {
                        for (int i = 0; i < rows; i ++) {
                            for (int j = 0; j < columns; j++) {
                                if (piece.solve(board, i, j)) {
                                    System.out.println("here");
                                    JLabel picLabel = new JLabel(new ImageIcon(image));
                                    picLabel.setSize(70, 70);
                                    squares[i][j].add(picLabel);
                                
                              }
                            }
                        }
                    }
                    successfulPlacement = false; 
		}
                
		if (numR > 0) {
                  
              
                    image = Toolkit.getDefaultToolkit().getImage(Board.class.getResource("black-rook.png"));
                    piece = new Rooks(board, "r", numR, rows, columns);
                    successfulPlacement = piece.placePiece(board, r, c); 

                     if (successfulPlacement) {
                        for (int i = 0; i < rows; i ++) {
                            for (int j = 0; j < columns; j++) {
                                if (piece.solve(board, i, j)) {

                                    JLabel picLabel = new JLabel(new ImageIcon(image));
                                    picLabel.setSize(70, 70);                                     
                                     squares[i][j].add(picLabel);

                                }
                            }
                        }
                    }
                    successfulPlacement = false; 
                        
			
		}
		if (numB > 0) {
                    
                    image = Toolkit.getDefaultToolkit().getImage(Board.class.getResource("black-bishop.png"));
                    piece = new Bishops(board, "b", numB, rows, columns);
                    successfulPlacement = piece.placePiece(board, r, c); 
                     if (successfulPlacement) {
                        for (int i = 0; i < rows; i ++) {
                            for (int j = 0; j < columns; j++) {
                                if (piece.solve(board, i, j)) {

                                    JLabel picLabel = new JLabel(new ImageIcon(image));
                                    picLabel.setSize(70, 70);                                     
                                     squares[i][j].add(picLabel);

                                }

                            }
                        }
                    }
                    successfulPlacement = false; 
			
		}
                
 

		JPanel holdGridPanel = new JPanel(new BorderLayout());
		holdGridPanel.setSize(600, 600);
		holdGridPanel.add(gridPanel, BorderLayout.CENTER);
		backPanel.add(holdGridPanel, BorderLayout.CENTER);
		backPanel.add(outerSidePanel, BorderLayout.EAST);
		frame.add(backPanel);
		frame.pack();
	}
	
	public int getColumns() {
		int myColumns = (int) Integer.parseInt(columnsTF.getText());
		return myColumns;
	}
	
	public int getRows() {
		int myRows = (int) Integer.parseInt(rowsTF.getText());
		return myRows;
	}
	
	public int getQueens() {
		int myQueens = (int) Integer.parseInt(numberQueens.getText());
		return myQueens;
	}
	public int getKnights() {
		int myKnights = (int) Integer.parseInt(numberKnights.getText());
		return myKnights;
	}
	public int getRooks() {
		int myRooks = (int) Integer.parseInt(numberRooks.getText());
		return myRooks;
	}
	
	public int getBishops() {
		int myBishops = (int) Integer.parseInt(numberBishops.getText());
		return myBishops;
	}
	/*
	public String lookInSquare(int r, int c) {
		String type;
		if (squares[r][c].getComponent(1).equals(blackQueen)) {
			return "q";
		}
		else if (squares[r][c].getComponent(1).equals(blackBishop)) {
			return "b";
		}
		else if (squares[r][c].getComponent(1).equals(blackRook)) {
			return "r";
		}
		else if (squares[r][c].getComponent(1).equals(blackKnight)) {
			return "k";
		}
		else return "";
	} */
	
	//Global variables
	
}
