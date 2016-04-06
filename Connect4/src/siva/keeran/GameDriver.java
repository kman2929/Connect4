package siva.keeran;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.*;


public class GameDriver {

	static JFrame frame = new JFrame("Connect4");
	
	public static void main(String[] args) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MainMenuPanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setResizable(true);
		frame.setVisible(true);

	}
	
	public static void hideFrame() {
		frame.setVisible(false);
	}
	//doesn't work
	public static void appearFrame(){
		frame.setVisible(true);
	}
	public static void closeFrame(){
		frame.dispose();
	}

}
