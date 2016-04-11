package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TwoPlayerPanel extends JPanel{
	
	static JFrame Optionframe = new JFrame("Connect4");
	
	final int FONT_SIZE = 24;
	int ROWS = 8, COLS = 7;
	
	private JLabel[][] lbls = new JLabel[6][7];
	private Chip[][] board = new Chip[6][7];
	
	JButton[] btns = new JButton[7];
	JLabel[] fillerlbls = new JLabel[6];
	JButton quitbtn;
	
	public TwoPlayerPanel(){

		setLayout(new GridLayout(ROWS, COLS, 0, 0));
		setPreferredSize(new Dimension(500, 700));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		
		quitbtn = new JButton("Quit");
		quitbtn.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		quitbtn.addActionListener(new ButtonListener());
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
				lbls[row][col].setBackground(new Color(13,71,161));
				add(lbls[row][col]);
			}
		}
	
		for(int t=0;t<6;t++){
			fillerlbls[t] = new JLabel();
			add(fillerlbls[t]);
		}
		
		add(quitbtn);
		
		for(int h = 0 ; h < 6 ; h++){
			for(int q = 0 ; q < 7 ; q++){
				board[h][q] = new Chip(false, ChipColour.NONE);
			}
		} 
		
		
		
		//will fill these in, fixed the methods too but not sure if they work until drawBoard works
		//i think there will be some errors tho
		/*
		for(int col = 0 ; col < 7 ; col++){
			for(int row = 5 ; row >= 3 ; row--){
				
				if(checkForVerticalCombo(row, col, ChipColour.RED)){
				
				}
				else if(checkForVerticalCombo(row, col, ChipColour.YELLOW)){
					
				}
			} 
		}
		
		for(int row = 5 ; row >= 0 ; row--){
			for(int col = 0 ; col <= 3 ; col++){
				
				if(checkForHoizontalCombo(row, col, ChipColour.RED)){
					
				} else if(checkForHoizontalCombo(row, col, ChipColour.YELLOW)){
					
				}
			}
		}
		
		for(int row = 5 ; row >= 0 ; row--){
			for(int col = 0; col <=3 ; col++){
				
				if(checkForDiagonalCombo(row, col, ChipColour.RED, 1)){
					
				} else if(checkForDiagonalCombo(row, col, ChipColour.YELLOW, -1)){
					
				}
			}
		}
		*/
	}
	
	public void drawBoard(int chosencol) {
		
		int row = 5;
		if(board[row][chosencol].isOccupied()){
			while(row>0 && board[row][chosencol].isOccupied()){
				row--;
			}
			board[row][chosencol].setOccupied();
			lbls[row][chosencol].setText("Yes" + row);
		}
		else {
			board[row][chosencol].setOccupied();
			lbls[row][chosencol].setText("Yes" + row);
		}
		
	}

	public boolean checkForVerticalCombo(int x, int y, ChipColour col) {

		for (int i = 0; i < 4; i++) {
			if (!board[x + i][y].getColour().equals(col)) {
				return false;
			}
		} return true;
	}
	
	public boolean checkForHoizontalCombo(int x, int y, ChipColour col){
		for (int i = 0; i < 4; i++) {
			if (!board[x][y+i].getColour().equals(col)) {
				return false;
			}
		} return true;
	}
	
	public boolean checkForDiagonalCombo(int x, int y, ChipColour col, int direction){
	       for(int i = 0; i<4; i++) {
	           if(!board[x+i][y + direction].getClass().equals(col)) {
	               return false;
	           }
	       } return true;
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btns[0]){
				
				int inputtedcol = 0;
				drawBoard(inputtedcol);
				
			}
			else if(event.getSource() == btns[1]){
				
				int inputtedcol = 1;
				drawBoard(inputtedcol);
				
			}
			else if(event.getSource() == btns[2]){
				
				int inputtedcol = 2;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == btns[3]){
				
				int inputtedcol = 3;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == btns[4]){
				
				int inputtedcol = 4;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == btns[5]){
				
				int inputtedcol = 5;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == btns[6]){
				
				int inputtedcol = 6;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == quitbtn){
				Optionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Optionframe.getContentPane().add(new OptionPanel());
				Optionframe.pack();
				Optionframe.setLocationRelativeTo(null);
				Optionframe.setFocusable(true);
				Optionframe.setResizable(true);
				Optionframe.setVisible(true);
				
			}
			
		}
		

	}
	public static void closeOptionFrame() {
		Optionframe.dispose();
	}

}
