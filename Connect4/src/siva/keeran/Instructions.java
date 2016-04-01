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
	
	final int FONT_SIZE = 48;
	int ROWS = 2, COLS = 1;
	
	JLabel lblinstructions;
	JButton btnback;
	
	public Instructions(){
		
		setBackground(Color.white);
		//setLayout(new GridLayout(ROWS, COLS, 0, 0));
		setPreferredSize(new Dimension(500, 200));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		lblinstructions = new JLabel();
		lblinstructions.setText("<Insert Instructions>");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(lblinstructions, c);
		
		btnback = new JButton("Back");
		btnback.addActionListener(new ButtonListener());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 1.0;
		c.ipady = 10;
		c.ipadx = 200;
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridwidth = 2;
		add(btnback,c);
		
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnback){
				
			}
		}

}
}
