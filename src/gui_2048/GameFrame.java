package gui_2048;

import java.awt.Dimension;

import game_2048.Game;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameController;



public class GameFrame extends JFrame{
	private final int SIZECELL = 100;
	protected GameController control;
	public static int width, height;
	
	//JPanel main;
	public static Dimension dim;

	public GameFrame(int x, int y)  {
		// controller
		control = new GameController(x,y);
		
		// main panel
		
		this.add(control.getPanel());
		
		
		// dimension and frame info
		this.width = Game.getSizeX()*SIZECELL;
		height = Game.getSizeY()*SIZECELL+20;
		this.setTitle("Welcome to 2048 game!");
		dim = new Dimension(width, height);
		
		this.setPreferredSize(dim);
		this.setTitle("2048");
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
