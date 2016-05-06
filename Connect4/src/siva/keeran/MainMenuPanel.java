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
	
	static JFrame twoplayerFrame = new JFrame("Connect4-TwoPlayer");
	static JFrame oneplayerFrame = new JFrame("Connect4-OnePlayer");
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
				
				pickChipColourFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				pickChipColourFrame.getContentPane().add(new PickChipColPanel(1));
				pickChipColourFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
				pickChipColourFrame.pack();
				pickChipColourFrame.setLocationRelativeTo(null);
				pickChipColourFrame.setFocusable(true);
				pickChipColourFrame.setResizable(true);
				pickChipColourFrame.setVisible(true);
				GameDriver.hideFrame();
			}
			else if(event.getSource() == btntwoplayer){
				
				pickChipColourFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				pickChipColourFrame.getContentPane().add(new PickChipColPanel(2));
				pickChipColourFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
				pickChipColourFrame.pack();
				pickChipColourFrame.setLocationRelativeTo(null);
				pickChipColourFrame.setFocusable(true);
				pickChipColourFrame.setResizable(true);
				pickChipColourFrame.setVisible(true);
				GameDriver.hideFrame();
				
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
	
	public static void createTwoPlayerPanel(Color firstCol, Color secondCol){
		twoplayerFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JPanel twoplayer = new TwoPlayerPanel(firstCol, secondCol);
		twoplayerFrame.getContentPane().add(twoplayer);
		twoplayerFrame.pack();
		twoplayerFrame.setLocationRelativeTo(null);
		twoplayerFrame.setFocusable(true);
		twoplayerFrame.setResizable(true);
		twoplayerFrame.setVisible(true);
		
		closePickChipColourFrame();
	}
	
	public static void createOnePlayerPanel(Color firstCol, Color secondCol){
		oneplayerFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		oneplayerFrame.getContentPane().add(new OnePlayerPanel(firstCol, secondCol));
		oneplayerFrame.pack();
		oneplayerFrame.setLocationRelativeTo(null);
		oneplayerFrame.setFocusable(true);
		oneplayerFrame.setResizable(true);
		oneplayerFrame.setVisible(true);
		
		closePickChipColourFrame();
	}
	
	public static void hideInstructionFrame() {
		instructionsFrame.setVisible(false);
	}
	
	public static void closeTwoplayerFrame(){
		twoplayerFrame.dispose();
		twoplayerFrame.getContentPane().removeAll();

	}
	public static void closeOneplayerFrame(){
		oneplayerFrame.dispose();
		oneplayerFrame.getContentPane().removeAll();
	}
	public static void closePickChipColourFrame(){
		pickChipColourFrame.dispose();
		pickChipColourFrame.getContentPane().removeAll();
	}
}