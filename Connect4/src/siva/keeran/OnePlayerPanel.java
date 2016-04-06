package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OnePlayerPanel extends JPanel{
	
	final int FONT_SIZE = 24;
	int ROWS = 9, COLS = 7;
	static JFrame Optionframe = new JFrame("Connect4");
	JButton[] btns = new JButton[7];
	JLabel[][] lbls = new JLabel[7][7];
	Chip[][] board = new Chip[7][7];
	JLabel[] fillerlbls = new JLabel[6];
	JButton quitbtn;
	
	public OnePlayerPanel(){

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
				lbls[row][col].setBackground(new Color(13,71,161));
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
				
			}
			else if(event.getSource() == btns[1]){
				
			}
			else if(event.getSource() == btns[2]){
				
			}
			else if(event.getSource() == btns[3]){
				
			}
			else if(event.getSource() == btns[4]){
				
			}
			else if(event.getSource() == btns[5]){
				
			}
			else if(event.getSource() == btns[6]){

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

}