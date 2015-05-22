package controller;

import game_2048.Game_2048;
import gui_2048.GamePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class GameController implements ActionListener{
	protected Game_2048 game;

	protected GamePanel panel;
	private Timer timer;

	public GameController(int x, int y) {
		game = new Game_2048(x,y);
		panel = GamePanel.getGamePanel(new KeyInfo());
		
		timer = new Timer(50, this);
		timer.start();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {	
			panel.Draw();
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

	
	
	// allow to use arrow on the keyboard
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
				
			
		}
	}
		
	
}
