package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PickChipColourPanel extends JPanel {

	final int FONT_SIZE = 24;
	
	JButton yellowChip;
	JButton redChip;
	JLabel lblMsg;
	
	public PickChipColourPanel(){

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
		yellowChip.setBackground(new Color(255,235,59));
		
		redChip = new JButton();
		redChip.addActionListener(new ButtonListener());
		redChip.setBounds(310, 100, 75, 75);
		redChip.setBackground(new Color(244,67,54));
		
		this.add(lblMsg);
		this.add(yellowChip);
		this.add(redChip);
		
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == yellowChip){
				MainMenuPanel.closePickChipColourFrame();
			}
			if(event.getSource() == redChip){
				MainMenuPanel.closePickChipColourFrame();
			}
			
		}
		

	}
}
