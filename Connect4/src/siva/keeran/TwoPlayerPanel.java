package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class creates a JPanel and creates and adds its components such as 
 * the JButtons and JLabels. When one of the top 7 columns is clicked, the chip
 * of the corresponding player is added to it occupying the first available space 
 * from the bottom-up. The class also checks for a winning combining, a row 
 * of 4, a column of 4 or a diagonal of 4 of the same chip colour and then displays
 * the winner of the game. In this class, the user is playing against another 
 * human player.
 * 
 * @author Aaisha Eid and Keeran Siva
 * @version 1.0
 */
public class TwoPlayerPanel extends JPanel{
	
	static JFrame optionFrame = new JFrame("Connect4-End Game?");
	static JFrame winningFrame = new JFrame ("Connect4-Game Over");
	
	final int FONT_SIZE = 30;
	int ROWS = 8, COLS = 7;

	Player winner;
	
	private static Chip[][] board = new Chip[6][7];
	
	static JLabel[][] lbls = new JLabel[6][7];
	static JButton[] btns = new JButton[7];
	JLabel[] fillerlbls = new JLabel[6];
	static JButton quitbtn;
	
	static Color background;
	Color firstPlayerChipCol;
	Color secondPlayerChipCol;
	Color currentChipCol;
	Player currentPlayer;
	
	/**
	 * Constructor Method
	 *       -creates the JPanel object
	 *       -creates and adds the JButtons and JLabels  
	 *       
	 * @param firstCol
	 *      -the chip colour of the first player
	 * @param secondCol
	 *      -the chip colour of the second player
	 */
	public TwoPlayerPanel(Color firstCol, Color secondCol){
		
		background = new Color(2,119,189);
		
		firstPlayerChipCol = firstCol;
		secondPlayerChipCol = secondCol;
		
		currentChipCol = firstPlayerChipCol;
		currentPlayer = Player.PLAYERA;
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(ROWS, COLS, 0, 0));
		setPreferredSize(new Dimension(500, 700));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		
		for(int i = 0; i < 7; i++){
			
			btns[i] = new JButton(String.valueOf(i+1));
			btns[i].addActionListener(new ButtonListener());
			btns[i].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
			add(btns[i]);
		}
		
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 7; col++){
			
				lbls[row][col] = new JLabel();
				lbls[row][col].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
				lbls[row][col].setOpaque(true);
				lbls[row][col].setBackground(background); 
				add(lbls[row][col]);
			}
		}

		for(int t=0;t<6;t++){
			fillerlbls[t] = new JLabel();
			add(fillerlbls[t]);
		}
		
		quitbtn = new JButton("Quit");
		quitbtn.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		quitbtn.addActionListener(new ButtonListener());
		add(quitbtn);
		
		for(int h = 0 ; h < 6 ; h++){
			for(int q = 0 ; q < 7 ; q++){
				board[h][q] = new Chip(false, Player.NA);
			}
		} 
	}
	
	/**
	 * Draws the board by filling the first available occupied space from the bottom-up
	 * in the column clicked by the user. 
	 * 
	 * @param chosencol
	 *      -the button column clicked by the user
	 */
	public void drawBoard(int chosencol) {
		
		int row = 5;
		if(board[0][chosencol].isOccupied()){
			btns[chosencol].setBackground(new Color(170, 170, 170));
			btns[chosencol].setForeground(new Color(221, 221, 221));
			btns[chosencol].setText("Full");
		}
		else if(board[row][chosencol].isOccupied()){
			while(row>0 && board[row][chosencol].isOccupied()){
				row--;
			}
			board[row][chosencol].setOccupied();
			board[row][chosencol].setPlayer(currentPlayer);
			lbls[row][chosencol].setBackground(currentChipCol);
			
			setCurrentPlayer();
			setCurrentChipCol();
			
			if(row==0){
				btns[chosencol].setText("Full");
				btns[chosencol].setEnabled(false);
			}
		}
		else {
			board[row][chosencol].setOccupied();
			board[row][chosencol].setPlayer(currentPlayer);
			lbls[row][chosencol].setOpaque(true);
			lbls[row][chosencol].setBackground(currentChipCol);
			
			setCurrentPlayer();
			setCurrentChipCol();
		}
		
	}

	/**
	 * This method sets the current chip colour.
	 * 
	 */
	public void setCurrentChipCol(){
		
		if(currentChipCol == firstPlayerChipCol){
			currentChipCol = secondPlayerChipCol;
		} else {
			currentChipCol = firstPlayerChipCol;
		}
	}
	
	/**
	 * This method sets the current player(the computer or the user).
	 * 
	 */
	public void setCurrentPlayer(){
		
		if(currentPlayer.equals(Player.PLAYERA)){
			currentPlayer = Player.PLAYERB;
		} 
		else {
			currentPlayer = Player.PLAYERA;
		}
	}
	
	/**
	 * This method checks for a vertical combination of four of the same 
	 * colour chip that belongs to one player.
	 * 
	 * @param x
	 *      -an integer value of the row
	 * @param y
	 *      -an integer value of the column
	 * @param player
	 * @return true
	 * 		 -if a vertical combination is found
	 * @return false
	 *       -if a vertical combination is not found
	 */
	public boolean checkForVerticalCombo(int x, int y, Player player) {

		for (int i = 0; i < 4; i++) {
			if (!(board[x - i][y].getPlayer().equals(player))) {
				return false;
			}
		} return true;
	}
	
	/**
	 * This method checks for a horizontal combination of four of the same 
	 * colour chip that belongs to one player.
	 * 
	 * @param x
	 *      -an integer value of the row
	 * @param y
	 *      -an integer value of the column
	 * @param player
	 * @return true
	 * 		 -if a horizontal combination of four is found
	 * @return false
	 *       -if a horizontal combination of four is not found
	 */
	public boolean checkForHoizontalCombo(int x, int y, Player player){
		for (int i = 0; i < 4; i++) {
			if (!board[x][y+i].getPlayer().equals(player)) {
				return false;
			}
		} return true;
	}
	
	/**
	 * This method checks for a diagonal combination of four of the same 
	 * colour chip that belongs to one player. 
	 *  
	 * @param x
	 *      -an integer value of the row
	 * @param y
	 *      -an integer value of the column
	 * @param player
	 * @param direction
	 *      -the direction(right or left) which the board is analyzed
	 * @return true 
	 *       -if a diagonal combination of four is found
	 * @return false
	 *       -if a diagonal combination of four is not found
	 */
	public boolean checkForDiagonalCombo(int x, int y, Player player, int direction) {

		int k = 0;
		
		if (direction == 1) {
			for (int i = 0; i < 4; i++) {
				if (!board[x - i][y + k].getPlayer().equals(player)) {
					return false;
				}
				k++;
			}
		} else {
			for (int i = 0; i < 4; i++) {
				if (!board[x - i][y - k].getPlayer().equals(player)) {
					return false;
				}
				k++;
			}
		}
		return true;
	}

	/**
	 * This method checks for winning combinations of 4 of either vertical, 
	 * horizontal or diagonal of the same chip colour(of the same player). 
	 * 
	 * @return true 
	 *      -if a winning combination is found
	 * @return false
	 *      -if a winning combination is not found
	 */
	public boolean checkForWinningCombos() {
		
		for (int col = 0; col < 7; col++) {
			for (int row = 5; row >= 3; row--) {
				if (checkForVerticalCombo(row, col, Player.PLAYERA)) {
					winner = Player.PLAYERA;
					return true;
				} else if (checkForVerticalCombo(row, col, Player.PLAYERB)) {
					winner = Player.PLAYERB;
					return true;
				}
			}
		} 

		for (int row = 5; row >= 0; row--) {
			for (int col = 0; col <= 3; col++) {
				if (checkForHoizontalCombo(row, col, Player.PLAYERA)) {
					winner = Player.PLAYERA;
					return true;
				} else if (checkForHoizontalCombo(row, col, Player.PLAYERB)) {
					winner = Player.PLAYERB;
					return true;
				} 
			}
		}
		for(int col = 0; col<=3; col++){
			for(int row = 5; row>=3; row--){
				if (checkForDiagonalCombo(row, col, Player.PLAYERA, 1)) {
					winner = Player.PLAYERA;
					return true;
				} else if (checkForDiagonalCombo(row, col, Player.PLAYERB, 1)) {
					winner = Player.PLAYERB;
					return true;
				} 
			}
		} 
		for(int col = 6; col >= 3; col--){
			for(int row = 5; row >=3; row--){
				if (checkForDiagonalCombo(row, col, Player.PLAYERA, -1)) {
					winner = Player.PLAYERA;
					return true;
				} else if (checkForDiagonalCombo(row, col, Player.PLAYERB, -1)) {
					winner = Player.PLAYERB;
					return true;
				} 
			}
		}
		return false;
	}
	
	/**
	 * The purpose of this method is to create the winning panel.
	 * 
	 */
	public void createWinningPanel(){
		
		winningFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		winningFrame.getContentPane().add(new WinningPanel(winner, 2, firstPlayerChipCol, secondPlayerChipCol));
		winningFrame.pack();
		winningFrame.setLocationRelativeTo(null);
		winningFrame.setFocusable(true);
		winningFrame.setResizable(true);
		winningFrame.setVisible(true);
		
	}
	
	/**
	 * This method disable all the buttons at the top of the panel and the quit
	 * button. 
	 * 
	 */
	public void disableButtons(){
		for(int x = 0; x < 7; x++){
			btns[x].setEnabled(false);
		}
		quitbtn.setEnabled(false);
	}
	
	/**
	 * Responds to the user's clicks on the buttons at the top of the panel or 
	 * the quit button.For every button clicked, there is a specific set of code 
	 * executed until the user chooses to quit the game.  
	 * 
	 * For every column button clicked, the chip of the colour of the current 
	 * player is placed in the next available space in that column from the 
	 * bottom-up unless there is no space in that column. It also checks to see if
	 * a player has won.
	 * 
	 * @author Aaisha Eid and Keeran Siva
	 * @version 1.0
	 */
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btns[0]){
				int inputtedcol = 0;
				drawBoard(inputtedcol);
				if(checkForWinningCombos()){
					createWinningPanel();
					disableButtons();
				}

			}
			else if(event.getSource() == btns[1]){
				int inputtedcol = 1;
				drawBoard(inputtedcol);
				if(checkForWinningCombos()){
					createWinningPanel();
					disableButtons();
				} 
				
			}
			else if(event.getSource() == btns[2]){
				int inputtedcol = 2;
				drawBoard(inputtedcol);
				if(checkForWinningCombos()){
					createWinningPanel();
					disableButtons();
				} 
				
			}
			else if(event.getSource() == btns[3]){
				int inputtedcol = 3;
				drawBoard(inputtedcol);
				if(checkForWinningCombos()){
					createWinningPanel();
					disableButtons();
				}
				
			}
			else if(event.getSource() == btns[4]){
				int inputtedcol = 4;
				drawBoard(inputtedcol);
				if(checkForWinningCombos()){
					createWinningPanel();
					disableButtons();
				} 
				 
			}
			else if(event.getSource() == btns[5]){
				int inputtedcol = 5;
				drawBoard(inputtedcol);
				if(checkForWinningCombos()){
					createWinningPanel();
					disableButtons();
				} 
				
			}
			else if(event.getSource() == btns[6]){
				int inputtedcol = 6;
				drawBoard(inputtedcol);
				if(checkForWinningCombos()){
					createWinningPanel();
					disableButtons();
				} 
				
			}
			else if(event.getSource() == quitbtn){
				optionFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				optionFrame.getContentPane().add(new OptionPanel());
				optionFrame.pack();
				optionFrame.setLocationRelativeTo(null);
				optionFrame.setFocusable(true);
				optionFrame.setResizable(true);
				optionFrame.setVisible(true);
			}
			
		}
	}
	
	/**
	 * The purpose of this method disposes of the option JFrame.
	 *
	 */
	public static void closeOptionFrame() {
		optionFrame.dispose();
		optionFrame.getContentPane().removeAll();
	}
	
	/**
	 * The purpose of this method disposes of the winning JFrame.
	 * 
	 */
	public static void closeWinningFrame() {
		winningFrame.dispose();
		winningFrame.getContentPane().removeAll();
	}
}
