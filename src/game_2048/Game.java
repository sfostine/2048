/**
 * 
 */
package game_2048;

/**
 * @author Samuel
 *
 */
public class Game {

	/**
	 * 
	 */
	// game board
	private Board board;
	public static int sizeX, sizeY;
	public Game(int X, int Y) {
		sizeX = X;
		sizeY = Y;
		this.board = Board.getInstanceOfBoard();
	}
	
	public static int getSizeX() {
		return sizeX;
	}

	public static int getSizeY() {
		return sizeY;
	}
	
	public Board getBoard()
	{
		return this.board;
	}
}
