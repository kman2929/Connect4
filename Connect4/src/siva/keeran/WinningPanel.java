package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class creates a JPanel and creates and adds its components such as 
 * the JButtons and JLabels. It also responds to the users actions when they 
 * click on a button. 
 * 
 * @author Aaisha Eid and Keeran Siva
 * @version 1.0
 */
public class WinningPanel extends JPanel {

	static JFrame pickChipColourFrame = new JFrame("Connect4-Choose Chip Colour");
	
	JButton btnquit;
	JButton btnrematch;
	JLabel lblmsg1;
	JLabel lblmsg2;
	
	int panelNum;
	final int FONT_SIZE = 24;
	
	Color firstPlayerColor, secondPlayerColor;
	
	/**
	 * Constructor method
	 *       -creates the JPanel object
	 *       -creates and adds the JButtons and JLabels  
	 * 
	 * @param player
	 *      -the winning player of type Player
	 * @param panel
	 *      -the panel number of type int, which indicates the mode the user chose
	 *      to play in(two player or one player) 
	 * @param first
	 *      -the colour of the first player
	 * @param second
	 *      -the colour of the second player
	 */
	public WinningPanel(Player player, int panel, Color first, Color second){

		firstPlayerColor = first;
		secondPlayerColor = second;
		panelNum = panel;
		
		String winner = "";
		
		switch (player) {
		case PLAYERA:
			winner = "Player 1";
			break;
		case PLAYERB:
			winner = "Player 2";
			break;
		case COMPUTER:
			winner = "The Computer";
			break;
		case HUMAN:
			winner = "You";
		}
		
		setLayout(null);
		setPreferredSize(new Dimension(500, 200));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		setBackground(new Color(2,119,189));
		
		lblmsg1 = new JLabel(winner + " won, Congradulations!");
	    lblmsg1.setFont(new Font("Arial", Font.BOLD, 22));
	    lblmsg1.setForeground(Color.WHITE);
		lblmsg1.setBounds(125, 60, 500, 50);
		
		lblmsg2 = new JLabel("Do you want to quit or play again?");
	    lblmsg2.setFont(new Font("Arial", Font.BOLD, 22));
	    lblmsg2.setForeground(Color.WHITE);
		lblmsg2.setBounds(75, 80, 500, 50);
		
		btnquit = new JButton("Yes, I want to Quit");
		btnquit.addActionListener(new ButtonListener());
		btnquit.setBounds(40, 160, 160, 30);
		
		btnrematch = new JButton("No, I want a Rematch");
		btnrematch.addActionListener(new ButtonListener());
		btnrematch.setBounds(300, 160, 160, 30);
		
		this.add(lblmsg1);
		this.add(lblmsg2);
		this.add(btnquit);
		this.add(btnrematch);
	
	}
	
	/**
	 * Responds to the user's clicks on the buttons. This class either 
	 * quits the game and returns to the main menu panel, or allows the user to
	 * replay the same mode (two player or one player) depending on the button
	 * the user chooses to click.
	 *   
	 * @author Aaisha Eid and Keeran Siva
	 * @version 1.0
	 */
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnquit){
				OnePlayerPanel.closeWinningFrame();
				TwoPlayerPanel.closeWinningFrame();
				MainMenuPanel.closeOneplayerFrame();
				MainMenuPanel.closeTwoplayerFrame();
				GameDriver.appearFrame();
			}
			else if(event.getSource() == btnrematch){
				if(panelNum==1){
					MainMenuPanel.closeOneplayerFrame();
					OnePlayerPanel.closeWinningFrame();
					
					MainMenuPanel.createOnePlayerPanel(firstPlayerColor, secondPlayerColor);
				} else {
					MainMenuPanel.closeTwoplayerFrame();
					TwoPlayerPanel.closeWinningFrame();
					
					MainMenuPanel.createTwoPlayerPanel(firstPlayerColor, secondPlayerColor);
				}
				
			}
			
		}
		

	}
}

