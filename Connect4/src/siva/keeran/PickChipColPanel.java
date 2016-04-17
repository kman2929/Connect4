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
	
	static Color firstCol;
	static Color secondCol;
	
	public PickChipColPanel(){

		this.red = new Color(225,235,59);
		this.yellow = new Color(244, 67, 57);
		
		
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
	
	public void setFirstColour(Color col){
		this.firstCol = col;
	}
	
	public void setSecondColour(Color col){
		this.secondCol = col;
	}
	
	public Color getFirstColour(){
		return firstCol;
	} 
	
	public Color getSecondColour(){
		return secondCol;
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == yellowChip){
				setFirstColour(yellow);
				setSecondColour(red);
				MainMenuPanel.closePickChipColourFrame();
			}
			if(event.getSource() == redChip){
				setFirstColour(red);
				setSecondColour(yellow);
				MainMenuPanel.closePickChipColourFrame();
			}
			
		}
		

	}
}
