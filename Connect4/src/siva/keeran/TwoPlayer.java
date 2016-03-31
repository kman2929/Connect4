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

public class TwoPlayer extends JPanel{
	
	final int FONT_SIZE = 24;
	int ROWS = 2, COLS = 2;
	
	JButton btnone;
	JButton btntwo;
	JButton btnthree;
	JButton btnfour;
	JButton btnfive;
	JButton btnsix;
	JButton btnseven;
	
	public TwoPlayer(){
		
		setBackground(Color.white);
		setLayout(new GridLayout(ROWS, COLS, 0, 0));
		setPreferredSize(new Dimension(700, 500));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		
		
	}

}
