package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OptionPanel extends JPanel{
	JButton btnquit;
	JButton btnresume;
	JLabel lblmsg;
	final int FONT_SIZE = 24;
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
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == btnquit){
				OnePlayerPanel.closeOptionFrame();
				TwoPlayerPanel.closeOptionFrame();
				MainMenuPanel.closeOneplayerFrame();
				MainMenuPanel.closeTwoplayerFrame();
				GameDriver.appearFrame();
			}
			if(event.getSource() == btnresume){
				OnePlayerPanel.closeOptionFrame();
				TwoPlayerPanel.closeOptionFrame();
			}
			
		}
		

	}
	

}
