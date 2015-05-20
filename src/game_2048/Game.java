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
	public Game(int sizeX, int sizeY) {
		board = Board.getInstanceOfBoard(sizeX, sizeY);
	}
	
	public Board getBoard()
	{
		return this.board;
	}
}
