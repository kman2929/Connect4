package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TwoPlayerPanel extends JPanel{
	
	final int FONT_SIZE = 24;
	int ROWS = 9, COLS = 7;
	
	JButton[] btns = new JButton[7];
	JLabel[][] lbls = new JLabel[7][7];
	Chip[][] board = new Chip[7][7];
	JLabel[] fillerlbls = new JLabel[6];
	JButton quitbtn;
	
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
		for(int row = 0; row < 7; row++){
			
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
		
		
		for(int h = 0 ; h < 7 ; h++){
			for(int q = 0 ; q < 7 ; q++){
				board[h][q] = new Chip(false, -1);
			}
		}
		
	}

	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btns[0]){
				
				int inputtedcol=0;
				for(int x = 1 ; x < 7 ; x++){
					if((x==6) && !board[x][inputtedcol].isOccupied()){
						board[x][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x][inputtedcol].setIcon(chip);
						
						lbls[x][inputtedcol].setText("Yes"+x);
					}
					else if(board[x][inputtedcol].isOccupied()){
						board[x-1][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x-1][inputtedcol].setIcon(chip);
						
						lbls[x-1][inputtedcol].setText("Yes"+x);
						
					}
				}
			}
			else if(event.getSource() == btns[1]){
				
				int inputtedcol=1;
				for(int x = 0 ; x < 7 ; x++){
					if((x==6) && !board[x][inputtedcol].isOccupied()){
						board[x][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x][inputtedcol].setIcon(chip);
						
						lbls[x][inputtedcol].setText("Yes");
					}
					else if(board[x][inputtedcol].isOccupied()){
						board[x-1][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x-1][inputtedcol].setIcon(chip);
						
						lbls[x-1][inputtedcol].setText("Yes");
					}
				}
			}
			else if(event.getSource() == btns[2]){
				
				int inputtedcol=2;
				for(int x = 0 ; x < 7 ; x++){
					if((x==6) && !board[x][inputtedcol].isOccupied()){
						board[x][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x][inputtedcol].setIcon(chip);
						
						lbls[x][inputtedcol].setText("Yes");
					}
					else if(board[x][inputtedcol].isOccupied()){
						board[x-1][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x-1][inputtedcol].setIcon(chip);
						
						lbls[x-1][inputtedcol].setText("Yes");
					}
				}
			}
			else if(event.getSource() == btns[3]){
				
				int inputtedcol=3;
				for(int x = 0 ; x < 7 ; x++){
					
					if((x==6) && !board[x][inputtedcol].isOccupied()){
						board[x][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x][inputtedcol].setIcon(chip);
						
						lbls[x][inputtedcol].setText("Yes");
					} 
					else if(board[x][inputtedcol].isOccupied()){
						board[x-1][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x-1][inputtedcol].setIcon(chip);
						
						lbls[x-1][inputtedcol].setText("Yes");
					}
				}
			}
			else if(event.getSource() == btns[4]){
				
				int inputtedcol=4;
				for(int x = 0 ; x < 6 ; x++){
					if((x==6) && !board[x][inputtedcol].isOccupied()){
						board[x][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x][inputtedcol].setIcon(chip);
						
						lbls[x][inputtedcol].setText("Yes");
					}
					//else if()
					
					else if(board[x][inputtedcol].isOccupied()){
						board[x-1][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x-1][inputtedcol].setIcon(chip);
						
						lbls[x-1][inputtedcol].setText("Yes");
					}
				}
			}
			else if(event.getSource() == btns[5]){
				
				int inputtedcol=5;
				for(int x = 0 ; x < 6 ; x++){
					if((x==6) && !board[x][inputtedcol].isOccupied()){
						board[x][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x][inputtedcol].setIcon(chip);
						
						lbls[x][inputtedcol].setText("Yes");
					}
					else if(board[x][inputtedcol].isOccupied()){
						board[x-1][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x-1][inputtedcol].setIcon(chip);
						
						lbls[x-1][inputtedcol].setText("Yes");
					}
				}
			}
			else if(event.getSource() == btns[6]){
				
				int inputtedcol=6;
				for(int x = 0 ; x < 7 ; x++){
					if((x==6) && !board[x][inputtedcol].isOccupied()){
						board[x][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x][inputtedcol].setIcon(chip);
						
						lbls[x][inputtedcol].setText("Yes");
					}
					else if(board[x][inputtedcol].isOccupied()){
						board[x-1][inputtedcol].setOccupied();
						ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4Bluechip.jpg"));
						lbls[x-1][inputtedcol].setIcon(chip);
						
						lbls[x-1][inputtedcol].setText("Yes");
					}
				}
			}
			else if(event.getSource() == quitbtn){
				//MainMenuPanel.disposeOfTwoPlayerframe();
				
			}
			
		}
		

	}

}

