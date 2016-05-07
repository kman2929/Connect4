package siva.keeran;

import javax.swing.*;

/**
 * This package utilizes classes, objects, graphical user interfaces, and 
 * artificial intelligence to create a Connect 4 game where the user has 
 * the option to choose whether they would like to play against another player
 * or against the computer.  The user first chooses a color and then take 
 * turns(with the computer or another player) dropping a red or yellow chip
 * into a seven-column, six-row grid. The first player to form a row of 4, 
 * column of 4 or diagonal of 4 of their chip colour wins.
 * 
 * @author Aaisha Eid and Keeran Siva
 * @version 1.0
 */
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
	
	/**
	 * The purpose of this method is to hide the main menu JFrame.
	 * 
	 */
	public static void hideFrame() {
		frame.setVisible(false);
	}
	
	/**
	 * The purpose of this method is to make the main menu once again 
	 * visible to the user.
	 * 
	 */
	public static void appearFrame(){
		frame.setVisible(true);
	}
	
	/**
	 * The purpose of this method is to dispose of the main menu JFrame.
	 * 
	 */
	public static void closeFrame(){
		frame.dispose();
	}

}
