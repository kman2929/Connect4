package siva.keeran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PickChipColourPanel extends JPanel {

	final int FONT_SIZE = 24;
	
	JButton yellowChip;
	JButton redChip;
	
	public PickChipColourPanel(){

		setLayout(null);
		setPreferredSize(new Dimension(500, 700));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
	}
}
