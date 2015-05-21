package controller;

import game_2048.Game_2048;
import gui_2048.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class GameController implements Runnable {
	protected Game_2048 game;

	protected GamePanel panel;
	private Thread time;

	public GameController(int x, int y) {
		game = new Game_2048(x,y);
		panel = GamePanel.getGamePanel(y, x, new KeyInfo());
		
		time = new Thread();
		time.start();
	}
	
	private void update()
	{
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		panel.Draw();
		System.out.println("Hello");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return the game
	 */
	public Game_2048 getGame() {
		return game;
	}

	/**
	 * @return the panel
	 */
	public GamePanel getPanel() {
		return panel;
	}

	
	
	private class KeyInfo extends KeyAdapter{
		
		private void update()
		{
			int emptyCell = game.getCellId();
			// if the getCellId returns -1, that means there is no empty cell anymore
			if(emptyCell == -1)
			{
				System.out.println("I am -1");
				return;
			}
			game.setCell(emptyCell);
		}
		
		@Override	
		public void keyPressed(KeyEvent e)
		{
			int [] ar = game.retrieve().clone();
			
			int key = e.getKeyCode();
			if(key == e.VK_UP)
				game.moveUp(ar);
			else if(key == e.VK_DOWN)
				game.moveDown(ar);
			else if(key == e.VK_LEFT)
				game.moveLeft(ar);
			else if(key == e.VK_RIGHT)
				game.moveRight(ar);
				
			game.getBoard().setBoard(ar);
			update();
			game.getBoard().printBoard(game.getBoard().getCells(), game.getSizeX());
				
			
		}
	}

		
	
}
