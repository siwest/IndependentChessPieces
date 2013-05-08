package chessproblem;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.text.*;
/**
 *
 * @author sarah.west1
 */
public class ChessProblem extends JFrame {
    static int boardSize;
    boolean myBoard[][];
    
    public ChessProblem() {
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Board myGame = new Board();
		java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    myGame.initFrame(8, 8, 8, 0, 0, 0);
                }
	});
    } 
}
