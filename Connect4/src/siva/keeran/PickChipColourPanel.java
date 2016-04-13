package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PickChipColourPanel extends JPanel {

	final int FONT_SIZE = 24;
	
	Color redCol = new Color(255,235,59);
	Color yellowCol = new Color(244,67,54);
	
	static Color firstCol;
	static Color secondCol;
	
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
		yellowChip.setBackground(redCol);
		
		redChip = new JButton();
		redChip.addActionListener(new ButtonListener());
		redChip.setBounds(310, 100, 75, 75);
		redChip.setBackground(yellowCol);
		
		add(lblMsg);
		add(yellowChip);
		add(redChip);
		
	}
	
	public void setFirstPlayerColour(Color col){
		this.firstCol = col;
	}
	
	public static Color getFirstPlayerColour(){
		return firstCol;
	}
	
	public void setSecondPlayerColour(Color col){
		this.secondCol = col;
	}
	
	public static Color getSecondPlayerColour(){
		return secondCol;
	}
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == yellowChip){
				setFirstPlayerColour(yellowCol);
				setSecondPlayerColour(redCol);
				MainMenuPanel.closePickChipColourFrame();
			}
			if(event.getSource() == redChip){
				setFirstPlayerColour(redCol);
				setSecondPlayerColour(yellowCol);
				MainMenuPanel.closePickChipColourFrame();
			}
			
		}
		

	}
}
