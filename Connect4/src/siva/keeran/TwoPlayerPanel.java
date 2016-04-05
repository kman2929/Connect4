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
				board[h][q] = new Chip(false, -1);
			}
		} 
		
	}

	public void drawBoard(int chosencol){
		for(int x = 5 ; x >= 0 ; x--){
			if(false == board[x][chosencol].isOccupied()){
				board[x][chosencol].setOccupied();
				ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4RedButton.png"));
				lbls[x][chosencol].setIcon(chip);
				//JOptionPane.showMessageDialog(null, "This column is full");
			}
			else if((x == 0) && true == board[x][chosencol].isOccupied()){
				JOptionPane.showMessageDialog(null, "This column is full");
			}
			else if(board[x][chosencol].isOccupied()){
				board[x][chosencol].setOccupied();
				ImageIcon chip = new ImageIcon(getClass().getResource("/resources/Connect4RedButton.png"));
				lbls[x][chosencol].setIcon(chip);
				
				//lbls[x][chosencol].setText("Yes"+x);
				break;
			}
		}
	}
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			int inputtedcol;
			if(event.getSource() == btns[0]){
				
				inputtedcol = 0;
				drawBoard(inputtedcol);
				
			}
			else if(event.getSource() == btns[1]){
				
				inputtedcol = 1;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == btns[2]){
				
				inputtedcol = 2;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == btns[3]){
				
				inputtedcol = 3;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == btns[4]){
				
				inputtedcol = 4;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == btns[5]){
				
				inputtedcol = 5;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == btns[6]){
				
				inputtedcol = 6;
				drawBoard(inputtedcol);
			}
			else if(event.getSource() == quitbtn){
				JFrame Rematchframe = new JFrame("Connect4");
				Rematchframe.getContentPane().add(new MainMenuPanel());
				Rematchframe.pack();
				Rematchframe.setLocationRelativeTo(null);
				Rematchframe.setFocusable(true);
				Rematchframe.setResizable(true);
				Rematchframe.setVisible(true);
				
			}
			
		}
		

	}

}
