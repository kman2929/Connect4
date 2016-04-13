package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WinningPanel extends JPanel {

	JButton btnquit;
	JButton btnrematch;
	JLabel lblmsg1;
	JLabel lblmsg2;
	
	final int FONT_SIZE = 24;
	public WinningPanel(){
		
		setLayout(null);
		setPreferredSize(new Dimension(500, 200));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		setBackground(new Color(2,119,189));
		int player = 1;
		
		lblmsg1 = new JLabel("Congratulations Player" + player + " !");
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
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == btnquit){
				OnePlayerPanel.closeWinningFrame();
				TwoPlayerPanel.closeWinningFrame();
				MainMenuPanel.closeOneplayerFrame();
				MainMenuPanel.closeTwoplayerFrame();
				GameDriver.appearFrame();
			}
			if(event.getSource() == btnrematch){
				OnePlayerPanel.closeWinningFrame();
				TwoPlayerPanel.closeWinningFrame();
			}
			
		}
		

	}
}

