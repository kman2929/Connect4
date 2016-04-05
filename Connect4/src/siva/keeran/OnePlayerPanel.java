package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.io.File;

public class OnePlayerPanel extends JPanel{
	
	final int FONT_SIZE = 24;
	int ROWS = 8, COLS = 7;
	

	JButton[] btns = new JButton[7];

	JLabel  lblyellowchip;


	JLabel[][] lblboard = new JLabel[7][7];
	
	public OnePlayerPanel(){
		
		setBackground(Color.blue);
		setLayout(new GridLayout(ROWS, COLS, 0, 0));
		setPreferredSize(new Dimension(1000, 700));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		

		
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		for(int i = 0; i < 7; i++){
			add(btns[i],c);
			c.gridy = 1;
			for(int z = 0; z < 7; z++){
				
			}
			c.gridx++;
			c.gridy = 0;
		}
		
		
		lblyellowchip = new JLabel(new ImageIcon("Connect4Bluechip.png"));
		for(int row = 0; row < 7; row++){
			for(int col = 0; col < 7; col++){
				lblboard[row][col] = new JLabel("Yes");
				//lblboard[row][col].setOpaque(true);
				//lblboard[row][col].setBackground(Color.CYAN);
				lblboard[row][col].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

			}
		}
		
		c.gridx = 0;
		for(int row = 0; row < 7; row++){
			c.gridy = 1;
			for(int col = 0; col < 7; col++){
				//add(lblboard[row][col],c);
				this.add(lblyellowchip);
				c.gridy++;
			}
			c.gridx++;
			c.gridy = 0;
		}
		
		
		
	}
	
	/*private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnone){

			}
			if(event.getSource() == btntwo){

			}
			if(event.getSource() == btnthree){

			}
			if(event.getSource() == btnfour){

			}
			if(event.getSource() == btnfive){

			}
			if(event.getSource() == btnsix){

			}
			if(event.getSource() == btnseven){

			}
			
		}
		

	}*/
	
	public void paintComponents(Graphics g){
		//yellowchip.paintIcon(this.g,x,y)
	}

}
