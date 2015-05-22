package gui_2048;


import game_2048.Board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	Color backG = new Color(0xbbada0);
	private static GamePanel panel;
	protected Board b;
	

	private GamePanel(KeyListener key) {
		b = Board.getInstanceOfBoard();
		this.setPreferredSize(GameFrame.dim);
		this.setBackground(backG);
		this.addKeyListener(key);
		this.setFocusable(true);
	}
	
	// instance of game panel
	public static GamePanel getGamePanel(KeyListener k)
	{
		if(panel == null)
			panel = new GamePanel(k);
		return panel;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		b.paintRectangles(g);
	}
	
	public void Draw()
	{
		repaint();	
	}
}
