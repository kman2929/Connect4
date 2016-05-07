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
public class PickChipColPanel extends JPanel {
	
	final int FONT_SIZE = 24;
	
	JButton yellowChip;
	JButton redChip;
	JLabel lblMsg;
	
	Color yellow;
	Color red;
	
	int panelNum;
	
	/**
	 * Constructor Panel
	 *       -creates the JPanel object
	 *       -creates and adds the JButtons and JLabels  
	 * 
	 * @param num
	 *     -the panel number of type int, which indicates the mode the user chose
	 *      to play in(two player or one player) 
	 */
	public PickChipColPanel(int num){

		panelNum = num;
		
		red = new Color(225,235,59);
		yellow = new Color(244, 67, 57);
		
		
		setLayout(null);
		setPreferredSize(new Dimension(500, 200));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		setBackground(new Color(2,119,189));
		
		lblMsg = new JLabel("First player, pick your chip colour?");
	    lblMsg.setFont(new Font("Arial", Font.BOLD, 22));
	    lblMsg.setForeground(Color.WHITE);
		lblMsg.setBounds(80, 40, 500, 50);
		
		yellowChip = new JButton();
		yellowChip.addActionListener(new ButtonListener());
		yellowChip.setBounds(100, 100, 75, 75);
		yellowChip.setBackground(yellow);
		
		redChip = new JButton();
		redChip.addActionListener(new ButtonListener());
		redChip.setBounds(310, 100, 75, 75);
		redChip.setBackground(red);
		
		add(lblMsg);
		add(yellowChip);
		add(redChip);
	}
	
	/**
	 * This class allows the user to choose and then assigns the colour(red or yellow)
	 * of the chip of the first player. 
	 * 
	 * @author Aaisha Eid and Keeran Siva
	 * @version 1.0
	 */
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){

			if(event.getSource() == yellowChip){
				if(panelNum == 1){
					MainMenuPanel.createOnePlayerPanel(yellow, red);
				} else {
					
					MainMenuPanel.createTwoPlayerPanel(yellow, red);
				}
			}
			else if(event.getSource() == redChip){
				if(panelNum == 1){
					MainMenuPanel.createOnePlayerPanel(red, yellow);
				} else {
					MainMenuPanel.createTwoPlayerPanel(red, yellow);
				} 
			}
			
			MainMenuPanel.closePickChipColourFrame();
		}
	}
}
