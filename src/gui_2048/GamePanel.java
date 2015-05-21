package gui_2048;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private int rows, columns;
	Color backG = new Color(0xbbada0);
	private static GamePanel panel;

	private GamePanel(int r, int c, KeyListener key) {
		rows = r;
		columns = c;
		this.setPreferredSize(GameFrame.dim);
		this.setBackground(backG);
		this.addKeyListener(key);
		this.setFocusable(true);
	}
	
	// instance of game panel
	public static GamePanel getGamePanel(int row, int column, KeyListener k)
	{
		if(panel == null)
			panel = new GamePanel(row, column,k);
		return panel;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		paintRectangles(g);
	}
	
	
	private void paintRectangles(Graphics g)
	{	
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				g.setColor(Color.BLUE);
				g.fillRect(j*50 + 10, i*50 + 10, 40, 40);
				g.drawString("5", j*50 + 20, i*50+20);
				
				
			}
		}
	}
	
	public void Draw()
	{
		repaint();
		
	}
}
