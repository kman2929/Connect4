package siva.keeran;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainMenuPanel extends JPanel {
	
	final int FONT_SIZE = 24;

	JButton btnoneplayer;
	JButton btntwoplayer;
	JButton btninstructions;
	JButton btnquit;
	
	ImageIcon backgroundicon;
	JLabel backgroundimg;
	
	static JFrame Oneplayerframe = new JFrame("Connect4-OnePlayer");
	static JFrame Twoplayerframe = new JFrame("Connect4-TwoPlayer");
	static JFrame Instructionsframe = new JFrame("Connect4-Instructions");

	public MainMenuPanel(){
		
		setLayout(null);
		setPreferredSize(new Dimension(320, 480));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		
		btnoneplayer = new JButton("One Player");
		btnoneplayer.addActionListener(new ButtonListener());
		btnoneplayer.setBounds(80, 260, 160, 30);
		
		btntwoplayer = new JButton("Two Player");
		btntwoplayer.addActionListener(new ButtonListener());
		btntwoplayer.setBounds(80, 300, 160, 30);
		
		btninstructions = new JButton("Instructions");
		btninstructions.addActionListener(new ButtonListener());
		btninstructions.setBounds(80, 340, 160, 30);
		
		btnquit = new JButton("Quit");
		btnquit.addActionListener(new ButtonListener());
		btnquit.setBounds(130, 440, 60, 30);
		
		backgroundicon = new ImageIcon(getClass().getResource("/resources/backgroundpic.jpg"));
		backgroundimg = new JLabel(backgroundicon);
		
		backgroundimg.setBounds(0,0,320,480);
		
		this.add(btnoneplayer);
		this.add(btninstructions);
		this.add(btntwoplayer);
		this.add(btnquit);
		this.add(backgroundimg);
		
	
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnoneplayer){
				
				Oneplayerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Oneplayerframe.getContentPane().add(new OnePlayerPanel());
				Oneplayerframe.pack();
				Oneplayerframe.setLocationRelativeTo(null);
				Oneplayerframe.setFocusable(true);
				Oneplayerframe.setResizable(true);
				Oneplayerframe.setVisible(true);
				GameDriver.hideFrame();
			}
			else if(event.getSource() == btntwoplayer){
				
				Twoplayerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Twoplayerframe.getContentPane().add(new TwoPlayerPanel());
				Twoplayerframe.pack();
				Twoplayerframe.setLocationRelativeTo(null);
				Twoplayerframe.setFocusable(true);
				Twoplayerframe.setResizable(true);
				Twoplayerframe.setVisible(true);
				GameDriver.hideFrame();
			}
			else if(event.getSource() == btninstructions){
				
				Instructionsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Instructionsframe.getContentPane().add(new InstructionsPanel());
				Instructionsframe.pack();
				Instructionsframe.setLocationRelativeTo(null);
				Instructionsframe.setFocusable(true);
				Instructionsframe.setResizable(true);
				Instructionsframe.setVisible(true);
				GameDriver.hideFrame();
			}
			
			else if(event.getSource() == btnquit){
				GameDriver.closeFrame();
			}
		
		}
		
		
	}
	
	public static void hideInstructionFrame() {
		Instructionsframe.setVisible(false);
	}
	public static void closeTwoPlayerFrame(){
		Twoplayerframe.dispose();
	}
	public static void closeOnePlayerFrame(){
		Oneplayerframe.dispose();
	}
	
}
