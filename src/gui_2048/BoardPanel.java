package gui_2048;


import game_2048.Board;
import game_2048.Game_2048;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class BoardPanel extends JPanel{
	Color backG = new Color(0xbbada0);
	private static BoardPanel panel;
	protected Board b;
	protected ScorePanel score;
	
	

	private BoardPanel(KeyListener key, int width, int height) {
		// Board of the game
		b = Board.getInstanceOfBoard();
		
		this.setPreferredSize(new Dimension(width, height));
		
		// set the dimension of the score panel
		
		// some extra functionalities of Panel
		this.setBackground(backG);
		this.addKeyListener(key);
		this.setFocusable(true);
		this.setVisible(true);
	}
	
	// instance of game panel
	public static BoardPanel getBoardPanel(KeyListener k, int wid, int hei)
	{
		if(panel == null)
			panel = new BoardPanel(k, wid, hei);
		return panel;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		b.paintRectangles(g);
		
	}
	
	public void drawScore(Graphics g){
		g.drawString("Score: " + Game_2048.getScore() , 400, 200);
	}
	
	public void Draw()
	{
		repaint();	
	}
}
