package controller;

import game_2048.Game_2048;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class GameController implements ActionListener {
	Game_2048 game;
	private Timer time;

	public GameController(int x, int y) {
		game = new Game_2048(x,y);
		
		time = new Timer(30, this);
		time.start();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		while(true)
		{
		
		}
	}


	// action key
	private class KeyInfo extends KeyAdapter{
		
		public void keyPressed(KeyEvent e)
		{
			int key = e.getKeyCode();
			if(key == e.VK_UP)
			{
				System.out.println("UP");
			}
			else if(key == e.VK_DOWN)
			{
				System.out.println("DOWN");
			}
			else if(key == e.VK_LEFT)
			{
				System.out.println("LEFT");
			}
			
			else if(key ==e.VK_RIGHT)
			{
				System.out.println("RIGHT");
			}
		}
		
	}
}
