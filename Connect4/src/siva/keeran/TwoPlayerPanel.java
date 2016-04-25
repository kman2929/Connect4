package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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

	public void setCurrentChipCol(){
		
		if(currentChipCol == firstPlayerChipCol){
			currentChipCol = secondPlayerChipCol;
		} else {
			currentChipCol = firstPlayerChipCol;
		}
	}
	
	public void setCurrentPlayer(){
		
		if(currentPlayer.equals(Player.PLAYERA)){
			currentPlayer = Player.PLAYERB;
		} 
		else {
			currentPlayer = Player.PLAYERA;
		}
	}
	
	public boolean checkForVerticalCombo(int x, int y, Player player) {

		for (int i = 0; i < 4; i++) {
			if (!(board[x - i][y].getPlayer().equals(player))) {
				return false;
			}
		} return true;
	}
	
	public boolean checkForHoizontalCombo(int x, int y, Player player){
		for (int i = 0; i < 4; i++) {
			if (!board[x][y+i].getPlayer().equals(player)) {
				return false;
			}
		} return true;
	}
	
	
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
	
	public void createWinningPanel(){
		
		winningFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		winningFrame.getContentPane().add(new WinningPanel(winner, 2));
		winningFrame.pack();
		winningFrame.setLocationRelativeTo(null);
		winningFrame.setFocusable(true);
		winningFrame.setResizable(true);
		winningFrame.setVisible(true);
		
	}
	public void disableButtons(){
		for(int x = 0; x < 7; x++){
			btns[x].setEnabled(false);
		}
		quitbtn.setEnabled(false);
	}
	
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
	public static void closeOptionFrame() {
		optionFrame.dispose();
		optionFrame.getContentPane().removeAll();
	}
	public static void closeWinningFrame() {
		winningFrame.dispose();
		winningFrame.getContentPane().removeAll();
	}
}
