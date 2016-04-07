package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class InstructionsPanel extends JPanel{
	
	final int FONT_SIZE = 48;
	JButton btnback;
	ImageIcon backgroundicon;
	JLabel backgroundimg;
	
	public InstructionsPanel(){
		
		setLayout(null);
		setPreferredSize(new Dimension(500, 200));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));

		
		backgroundicon = new ImageIcon(getClass().getResource("/resources/Connect4Instructions.jpg"));
		backgroundimg = new JLabel(backgroundicon);
		backgroundimg.setBounds(0,0,500,200);
		
		btnback = new JButton("Back");
		btnback.addActionListener(new ButtonListener());
		btnback.setBounds(250, 170, 150, 30);
		
		this.add(btnback);
		this.add(backgroundimg);
		
		
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnback){
				MainMenuPanel.hideInstructionFrame();
				GameDriver.appearFrame();
			}
		}

}
}
