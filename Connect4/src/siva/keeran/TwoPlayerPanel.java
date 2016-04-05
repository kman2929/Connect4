package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TwoPlayerPanel extends JPanel{
	
	final int FONT_SIZE = 24;
	int ROWS = 8, COLS = 7;
	
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
				board[h][q] = new Chip(false, -1);
			}
		} 
		
	}

	public void drawBoard(int chosencol){
		for(int x = 0 ; x < 6 ; x++){
			if((x==0)&&board[x][chosencol].isOccupied()){
				JOptionPane.showMessageDialog(null, "This row is full");
			}
			else if((x==5) && !board[x][chosencol].isOccupied()){
				board[x][chosencol].setOccupied();
				//ImageIcon chip = new ImageIcon(getClass().getResource("/resources/backgroundpic.jpg"));
				//lbls[x][chosencol].setIcon(chip);
				
				lbls[x][chosencol].setText("Yes"+x);
			}
			else if(board[x][chosencol].isOccupied()){
				board[x-1][chosencol].setOccupied();
				//ImageIcon chip = new ImageIcon(getClass().getResource("/resources/backgroundpic.jpg"));
				//lbls[x-1][chosencol].setIcon(chip);
				
				lbls[x-1][chosencol].setText("Yes"+x);
				break;
			}
		}
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
				//MainMenuPanel.disposeOfTwoPlayerframe();
				
			}
			
		}
		

	}

}
