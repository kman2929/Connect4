package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TwoPlayerPanel extends JPanel{
	
	final int FONT_SIZE = 24;
	int ROWS = 8, COLS = 7;
	static JFrame Optionframe = new JFrame("Connect4");
	JButton[] btns = new JButton[7];
	JLabel[][] lbls = new JLabel[6][7];
	Chip[][] board = new Chip[6][7];
	JLabel[] fillerlbls = new JLabel[6];
	JButton quitbtn;
	
	//111,11
	
	public TwoPlayerPanel(){

		setLayout(new GridLayout(ROWS, COLS, 0, 0));
		setPreferredSize(new Dimension(700, 500));
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
				lbls[row][col].setBackground(new Color(100,149,237));
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
		
		ChipColour firstcolchip = setFir
		
	}

	
	public ChipColour setFirstcolchipPlayer(){
		
		boolean validAnswerProvided = false;
		
		while(!validAnswerProvided){
			try{
				String colour = JOptionPane.showInputDialog(null, "Please enter Please enter -1 for the yellow chip and 0 for the red chip.");
			
				if(colour == null){
					break; 
				}
				
				return
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "You did not enter a valid integer. Please enter -1 for the yellow chip and 0 for the red chip.");
			}
		}	
	}
	
	
	public void drawBoard(int chosencol){
		for(int x = 5 ; x >= 0 ; x--){
			if(x==0 && board[x][chosencol].isOccupied()){
				JOptionPane.showMessageDialog(null, "This row is full");
			}
			else if(x==5 && !board[x][chosencol].isOccupied()){
				board[x][chosencol].setOccupied();
				//board[x-1][chosencol].setColour();
				//ImageIcon chip = new ImageIcon(getClass().getResource("/resources/backgroundpic.jpg"));
				//lbls[x][chosencol].setIcon(chip);
				
				lbls[x][chosencol].setText("Yes"+x);
			}
			else if(board[x][chosencol].isOccupied()){
				board[x-1][chosencol].setOccupied();
				//board[x-1][chosencol].setColour();
				//ImageIcon chip = new ImageIcon(getClass().getResource("/resources/backgroundpic.jpg"));
				//lbls[x-1][chosencol].setIcon(chip);
				
				lbls[x-1][chosencol].setText("Yes"+x);
				break;
			}
		}
	}
	
	public boolean checkForVerticalCombo(){
		for(int col = 0 ; col < 7 ; col++){
			for(int row = 5 ; row >= 3 ; row--){
				if(board[row][col].isOccupied()&&board[row+1][col].isOccupied()&&board[row+2][col].isOccupied()&&board[row+3][col].isOccupied()){
					if(board[row][col].getColour()==board[row+1][col].getColour()&&board[row+1][col].getColour()==board[row+2][col].getColour()
							&&board[row+2][col].getColour()==board[row+3][col].getColour()){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkForHoizontalCombo(){
		for(int row = 5 ; row >= 0 ; row--){
			for(int col = 0 ; col <= 3 ; col++){
				if(board[row][col].isOccupied()&&board[row][col+1].isOccupied()&&board[row][col+2].isOccupied()&&board[row][col+3].isOccupied()){
					if(board[row][col].getColour()==board[row][col+1].getColour()&&board[row][col+1].getColour()==board[row][col+2].getColour()
							&&board[row][col+2].getColour()==board[row][col+3].getColour()){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkForDiagonalCombo(){
		for(int row = 5 ; row >= 0 ; row--){
			for(int col = 0 ; col <= 3 ; col++){
				if(board[row][col].isOccupied()&&board[row][col+1].isOccupied()&&board[row][col+2].isOccupied()&&board[row][col+3].isOccupied()){
					if(board[row][col].getColour()==board[row][col+1].getColour()&&board[row][col+1].getColour()==board[row][col+2].getColour()
							&&board[row][col+2].getColour()==board[row][col+3].getColour()){
						return true;
					}
				}
			}
		}
		return false;	
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
