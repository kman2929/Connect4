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
public class OptionPanel extends JPanel{
	
	JButton btnquit;
	JButton btnresume;
	JLabel lblmsg;
	final int FONT_SIZE = 24;
	
	/**
	 * Constructor Method
	 *       -creates the JPanel object
	 *       -creates and adds the JButtons and JLabels
	 */
	public OptionPanel(){
		
		setLayout(null);
		setPreferredSize(new Dimension(500, 200));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		setBackground(new Color(2,119,189));
		
		lblmsg = new JLabel("Are you sure you want to quit?");
	    lblmsg.setFont(new Font("Arial", Font.BOLD, 22));
	    lblmsg.setForeground(Color.WHITE);
		lblmsg.setBounds(90, 60, 500, 50);
		
		
		btnquit = new JButton("Yes, I want to Quit");
		btnquit.addActionListener(new ButtonListener());
		btnquit.setBounds(40, 160, 160, 30);
		
		btnresume = new JButton("No, I want to Resume");
		btnresume.addActionListener(new ButtonListener());
		btnresume.setBounds(300, 160, 160, 30);
		this.add(lblmsg);
		this.add(btnquit);
		this.add(btnresume);
		
	}
	
	/**
	 * Responds to the user's clicks on the buttons.
	 * This class either quits the game and returns to the main menu panel, or 
	 * allows the user to resume the current game they are playing depending on
	 * the button the user chooses to click.
	 * 
	 * @author Aaisha Eid and Keeran Siva
	 * @version 1.0
	 */
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == btnquit){
				MainMenuPanel.closeTwoplayerFrame();
				MainMenuPanel.closeOneplayerFrame();
				OnePlayerPanel.closeOptionFrame();
				TwoPlayerPanel.closeOptionFrame();
				GameDriver.appearFrame();
			}
			if(event.getSource() == btnresume){
				OnePlayerPanel.closeOptionFrame();
				TwoPlayerPanel.closeOptionFrame();
			}
			
		}
		

	}
	

}
