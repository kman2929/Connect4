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
import java.awt.Dimension;
import java.awt.Rectangle;

public class MainPanel extends JPanel {

	final int FONT_SIZE = 24;
	int ROWS = 2, COLS = 2;

	JButton btnoneplayer;
	JButton btntwoplayer;
	JButton btninstructions;
	
	public MainPanel(){
		
		setBackground(Color.white);
	//	setLayout(new GridLayout(ROWS, COLS, 0, 0));
		setPreferredSize(new Dimension(500, 200));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		btnoneplayer = new JButton("One Player");
		btnoneplayer.addActionListener(new ButtonListener());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(btnoneplayer,c);

		
		btntwoplayer = new JButton("Two Player");
		btntwoplayer.addActionListener(new ButtonListener());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		add(btntwoplayer,c);
		
		btninstructions = new JButton("Instructions");
		btninstructions.addActionListener(new ButtonListener());
		
		add(btnoneplayer);
		add(btninstructions);
		add(btntwoplayer);
	
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnoneplayer){
				JFrame Oneplayerframe = new JFrame("Connect4-OnePlayer");
				Oneplayerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Oneplayerframe.getContentPane().add(new OnePlayer());
				Oneplayerframe.pack();
				Oneplayerframe.setFocusable(true);
				Oneplayerframe.setResizable(true);
				Oneplayerframe.setVisible(true);
				GameDriver.hideFrame();
			}
			if(event.getSource() == btntwoplayer){
				JFrame Twoplayerframe = new JFrame("Connect4-TwoPlayer");
				Twoplayerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Twoplayerframe.getContentPane().add(new TwoPlayer());
				Twoplayerframe.pack();
				Twoplayerframe.setFocusable(true);
				Twoplayerframe.setResizable(true);
				Twoplayerframe.setVisible(true);
				GameDriver.hideFrame();
			}
			if(event.getSource() == btninstructions){
				JFrame Instructionsframe = new JFrame("Connect4-Instructions");
				Instructionsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Instructionsframe.getContentPane().add(new Instructions());
				Instructionsframe.pack();
				Instructionsframe.setFocusable(true);
				Instructionsframe.setResizable(true);
				Instructionsframe.setVisible(true);
				GameDriver.hideFrame();
			}
			
		}
		
	}
}
