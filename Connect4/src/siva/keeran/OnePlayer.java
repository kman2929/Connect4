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
	
	//JButton btnone;
	//JButton btntwo;
	//JButton btnthree;
	//JButton btnfour;
	//JButton btnfive;
	//JButton btnsix;
	//JButton btnseven;
	JButton[] btns = new JButton[7];
	JLabel[][] lblboard = new JLabel[7][7];
	
	public OnePlayer(){
		
		/*setBackground(Color.white);
		setLayout(new GridLayout(ROWS, COLS, 0, 0));
		setPreferredSize(new Dimension(700, 500));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		
		btnone = new JButton("");
		btnone.addActionListener(new ButtonListener());
		
		btntwo = new JButton("");
		btntwo.addActionListener(new ButtonListener());
		
		btnthree = new JButton("");
		btnthree.addActionListener(new ButtonListener());
		
		btnfour = new JButton("");
		btnfour.addActionListener(new ButtonListener());
		
		btnfive = new JButton("");
		btnfive.addActionListener(new ButtonListener());
		
		btnsix = new JButton("");
		btnsix.addActionListener(new ButtonListener());
		
		btnseven = new JButton("");
		btnseven.addActionListener(new ButtonListener());
		
		add(btnone);
		add(btntwo);
		add(btnthree);
		add(btnfour);
		add(btnfive);
		add(btnsix);
		add(btnseven);
		*/
		
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			/*if(event.getSource() == btnone){

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

			}*/
			
		}
		

	}

}
