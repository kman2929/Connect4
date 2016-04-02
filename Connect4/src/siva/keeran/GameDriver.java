package siva.keeran;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.*;


public class GameDriver {

	static JFrame frame = new JFrame("Connect4");
	
	public static void main(String[] args) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MainPanel());
		frame.pack();
		frame.setFocusable(true);
		frame.setResizable(true);
		frame.setVisible(true);
		
		// hello 

	}
	
	public static void hideFrame() {
		frame.setVisible(false);
	}

}