package gui_2048;


import game_2048.Game_2048;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width, height;
	public ScorePanel(int wid, int hei) {
		this.width = wid;
		this.height = hei;
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.WHITE);
		this.setVisible(true);
	}
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawScore(g);
	}
	
	private Font font1 = new Font("Score", Font.BOLD, 40);
	
	private Font font2 = new Font("Score", Font.BOLD, 20);
	
	public void drawScore(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, this.width,100);
		g.setFont(font1);
		g.setColor(Color.ORANGE);
		g.drawString("Score", (this.width*3)/14, 40);
		g.setFont(font2);
		g.setColor(Color.WHITE);
		g.drawString(""+ Game_2048.getScore(), (this.width-20)/2, 70);
				
	}
	
	public void Draw()
	{
		repaint();	
	}
}
