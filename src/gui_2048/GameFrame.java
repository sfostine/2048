package gui_2048;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import game_2048.Game;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameController;



public class GameFrame extends JFrame{
	protected GameController control;
	
	
	public GameFrame(int x, int y)
	{
		// controller
		control = new GameController(x,y);
		
		// some functionalities of frame
		this.setTitle("2048");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	
		// add panels to the frame
		this.getContentPane().add(control.getScorePanel(), BorderLayout.EAST);
		this.getContentPane().add(control.getPanel(), BorderLayout.CENTER);

		
		// pack the frame to fit the panels
		this.pack();
		
		// some other functionalities of frame
		this.setResizable(false);
		this.setVisible(true);
	}

	
	public GameFrame getFrame()
	{
		return this;
	}
}
