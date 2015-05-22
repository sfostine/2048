package gui_2048;

import java.awt.Dimension;

import game_2048.Game;

import javax.swing.JFrame;

import controller.GameController;



public class GameFrame extends JFrame{
	private final int SIZECELL = 100;
	protected GameController control;
	
	public static Dimension dim;

	public GameFrame(int x, int y)  {
		control = new GameController(x,y);
		dim = new Dimension(Game.getSizeX()*SIZECELL, Game.getSizeY()*SIZECELL+25);
		this.setPreferredSize(dim);
		this.setTitle("2048");
		this.pack();
		this.add(control.getPanel());
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
