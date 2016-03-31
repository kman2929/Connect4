package siva.keeran;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.*;


public class Connect4Driver {

	public static void main(String[] args) {
		
		JFrame Menuframe = new JFrame("Connect4");
		Menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menuframe.getContentPane().add(new MainPanel());
		Menuframe.pack();
		Menuframe.setFocusable(true);
		Menuframe.setResizable(true);
		Menuframe.setVisible(true);

	}

}
