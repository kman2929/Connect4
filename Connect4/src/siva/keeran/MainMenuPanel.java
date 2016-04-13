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
	
	static JFrame oneplayerFrame = new JFrame("Connect4-OnePlayer");
	static JFrame twoplayerFrame = new JFrame("Connect4-TwoPlayer");
	static JFrame instructionsFrame = new JFrame("Connect4-Instructions");
	static JFrame pickChipColourFrame = new JFrame("Connect4-Choose Chip Colour");

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
				
				oneplayerFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				oneplayerFrame.getContentPane().add(new OnePlayerPanel());
				oneplayerFrame.pack();
				oneplayerFrame.setLocationRelativeTo(null);
				oneplayerFrame.setFocusable(true);
				oneplayerFrame.setResizable(true);
				oneplayerFrame.setVisible(true);
				GameDriver.hideFrame();
			}
			else if(event.getSource() == btntwoplayer){
				
				twoplayerFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				twoplayerFrame.getContentPane().add(new TwoPlayerPanel());
				twoplayerFrame.pack();
				twoplayerFrame.setLocationRelativeTo(null);
				twoplayerFrame.setFocusable(true);
				twoplayerFrame.setResizable(true);
				twoplayerFrame.setVisible(true);
				GameDriver.hideFrame();
				
				pickChipColourFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				pickChipColourFrame.getContentPane().add(new PickChipColourPanel());
				pickChipColourFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
				pickChipColourFrame.pack();
				pickChipColourFrame.setLocationRelativeTo(null);
				pickChipColourFrame.setFocusable(true);
				pickChipColourFrame.setResizable(true);
				pickChipColourFrame.setVisible(true);
				
			}
			else if(event.getSource() == btninstructions){
				
				instructionsFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				instructionsFrame.getContentPane().add(new InstructionsPanel());
				instructionsFrame.pack();
				instructionsFrame.setLocationRelativeTo(null);
				instructionsFrame.setFocusable(true);
				instructionsFrame.setResizable(true);
				instructionsFrame.setVisible(true);
				GameDriver.hideFrame();
			}
			
			else if(event.getSource() == btnquit){
				GameDriver.closeFrame();
			}
		
		}
		
		
	}
	
	public static void hideInstructionFrame() {
		instructionsFrame.setVisible(false);
	}
	public static void closeTwoplayerFrame(){
		twoplayerFrame.dispose();
	}
	public static void closeOneplayerFrame(){
		oneplayerFrame.dispose();
	}
	public static void closePickChipColourFrame(){
		pickChipColourFrame.dispose();
	}
	

}