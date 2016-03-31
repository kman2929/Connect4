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

public class Instructions extends JPanel{
	
	final int FONT_SIZE = 24;
	int ROWS = 2, COLS = 1;
	
	JLabel lblinstructions;
	JButton btnback;
	
	public Instructions(){
		
		setBackground(Color.white);
		setLayout(new GridLayout(ROWS, COLS, 0, 0));
		setPreferredSize(new Dimension(700, 500));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		
		btnback = new JButton("Back");
		btnback.addActionListener(new ButtonListener());
		
		lblinstructions = new JLabel();
		lblinstructions.setText("Donkey");
		
		
		add(lblinstructions);
		add(btnback);
		
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnback){
				
			}
		}

}
}
