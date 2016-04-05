package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class RematchPanel extends JPanel{
	JButton btnquit;
	JButton btnrematch;
	JLabel lblmsg;
	final int FONT_SIZE = 24;
	public RematchPanel(){
		
		setLayout(null);
		setPreferredSize(new Dimension(300, 200));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		
		lblmsg = new JLabel("Are you sure you want to quit?");
		lblmsg.setBounds(80, 60, 160, 30);
		
		btnquit = new JButton("Yes, I want to Quit");
		btnquit.addActionListener(new ButtonListener());
		btnquit.setBounds(80, 160, 160, 30);
		
		btnrematch = new JButton("No, I want a Rematch");
		btnrematch.addActionListener(new ButtonListener());
		btnrematch.setBounds(80, 260, 160, 30);
		
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == btnquit){
				
			}
			if(event.getSource() == btnrematch){
				
			}
			
		}
		

	}
	

}
