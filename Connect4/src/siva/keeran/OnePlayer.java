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

public class OnePlayer extends JPanel{
	
	final int FONT_SIZE = 24;
	int ROWS = 8, COLS = 7;
	

	JButton[] btns = new JButton[7];
	JButton btnone;
	JButton btntwo;
	JButton btnthree;
	JButton btnfour;
	JButton btnfive;
	JButton btnsix;
	JButton btnseven;

	JLabel[][] lblboard = new JLabel[7][7];
	
	public OnePlayer(){
		
		setBackground(Color.white);
		setLayout(new GridLayout(ROWS, COLS, 0, 0));
		setPreferredSize(new Dimension(700, 500));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		btnone = new JButton("1");
		btns[0] = btnone;
		btnone.addActionListener(new ButtonListener());
		
		btntwo = new JButton("2");
		btns[1] = btntwo;
		btntwo.addActionListener(new ButtonListener());
		
		btnthree = new JButton("3");
		btns[2] = btnthree;
		btnthree.addActionListener(new ButtonListener());
		
		btnfour = new JButton("4");
		btns[3] = btnfour;
		btnfour.addActionListener(new ButtonListener());
		
		btnfive = new JButton("5");
		btns[4] = btnfive;
		btnfive.addActionListener(new ButtonListener());
		
		btnsix = new JButton("6");
		btns[5] = btnsix;
		btnsix.addActionListener(new ButtonListener());
		
		btnseven = new JButton("7");
		btns[6] = btnseven;
		btnseven.addActionListener(new ButtonListener());
		
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
		
		for(int row = 0; row < 7; row++){
			for(int col = 0; col < 7; col++){
				lblboard[row][col] = new JLabel("Yes");
				lblboard[row][col].setOpaque(true);
				lblboard[row][col].setBackground(Color.CYAN);
				lblboard[row][col].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

			}
		}
		
		c.gridx = 0;
		for(int row = 0; row < 7; row++){
			c.gridy = 1;
			for(int col = 0; col < 7; col++){
				add(lblboard[row][col],c);
				c.gridy++;
			}
			c.gridx++;
			c.gridy = 0;
		}
		
		
		
	}
	
	private class ButtonListener implements ActionListener {
		
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
		

	}

}
