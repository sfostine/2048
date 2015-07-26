package controller;

import game_2048.Cell;
import game_2048.Game_2048;
import gui_2048.BoardPanel;
import gui_2048.GameFrame;
import gui_2048.GameOverGUI;
import gui_2048.ScorePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.Timer;

public class GameController implements ActionListener{
	protected Game_2048 game;
	protected BoardPanel boardPanel;
	protected ScorePanel scorePanel;
	protected boolean gameOver = false;
	


	private final int SIZECELL = 100;
	private int widthBoard,widthScore, height;

	private Timer timer;

	public GameController(int x, int y) {
		game = new Game_2048(x,y);
		
		//dimension of the Panel
		this.widthBoard = x * SIZECELL;
		this.widthScore = 200;
		this.height = y * SIZECELL;
		
		//initialising the panels
		boardPanel = BoardPanel.getBoardPanel(new KeyInfo(), widthBoard, height);
		scorePanel = new ScorePanel(widthScore, height);

		// running the thread
		timer = new Timer(100, this);
		timer.start();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(gameOver)
		{
			GameFrame.frame().setVisible(false);
			GameFrame.frame().dispose();
			timer.stop();
			new GameOverGUI(this.widthBoard,this.height);
		}
		boardPanel.Draw();
		scorePanel.Draw();
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
	public BoardPanel getPanel(){
		return boardPanel;
	}
	
	/**
	 * @return the scorePanel
	 */
	public ScorePanel getScorePanel() {
		return scorePanel;
	}
	

	private boolean isGameOver(Cell[] cel)
	{
	    int firstLines = cel.length - game.getSizeX();
	    
	    int sizeX_1 = game.getSizeX()-1;
	    
		for(int i = 0; i < cel.length; i++)
		{
			// if there is an empty spot, we still can move
			if(cel[i].getValue() == 0) return false;
			
			// check the right value of each cell to see if they are the same
			// note that we have to check only for the cells that are not in the right corner
			if((i % game.getSizeX()) != (sizeX_1)){
				if(cel[i].getValue() == cel[i+1].getValue())
					return false;
			}
			
			// check the value that is at the bottom of the cel[i] value
			if(i < firstLines){
				if(cel[i].getValue() == cel[i+game.getSizeX()].getValue())
					return false;
			}
		}
		return true;
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
			// retrieve a big array from the whole board to process an action
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
			
			int [] ar2 = game.retrieve().clone();
			// if they were no deplacement, don't update the board
			if (!Arrays.equals(ar, ar2)){
				game.getBoard().setBoard(ar);
				update();
			}
			
			
			if(isGameOver(game.getBoard().getCells()))
			{
				gameOver = true;
			}
		}
	}
}
