package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PickChipColPanel extends JPanel {
	
	final int FONT_SIZE = 24;
	
	JButton yellowChip;
	JButton redChip;
	JLabel lblMsg;
	
	Color yellow;
	Color red;
	
	int panelNum;
	
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
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			MainMenuPanel p = new MainMenuPanel();
			if(event.getSource() == yellowChip){
				if(panelNum == 1){
					MainMenuPanel.createOnePlayerPanel(yellow, red);
				} else {
					
					
					p.createTwoPlayerPanel(yellow, red);
				} 
				MainMenuPanel.closePickChipColourFrame();
			}
	
			else if(event.getSource() == redChip){
				if(panelNum == 1){
					MainMenuPanel.createOnePlayerPanel(red, yellow);
				} else {
					p.createTwoPlayerPanel(red, yellow);
				} 
				MainMenuPanel.closePickChipColourFrame();
			}
			
		}
		

	}
}
