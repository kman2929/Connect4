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
public class InstructionsPanel extends JPanel{
	
	final int FONT_SIZE = 48;
	JButton btnback;
	ImageIcon backgroundicon;
	JLabel backgroundimg;
	
	/**
	 * Constructor Method
	 *       -creates the JPanel object
	 *       -creates and adds the JButtons and JLabels 
	 */
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
	
	/**
	 * This class allows the user to return back to the main menu panel.
	 * 
	 * @author Aaisha Eid and Keeran Siva
	 * @version 1.0
	 */
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnback){
				MainMenuPanel.hideInstructionFrame();
				GameDriver.appearFrame();
			}
		}

}
}
