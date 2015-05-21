/**
 * 
 */
package game_2048;

import java.util.Random;

/**
 * @author Samuel
 *
 */
public class Board {

	/**
	 * 
	 */
	private Cell[] cell;

	public Cell[] getCells() {
		return cell;
	}

	private static Board b;

	private Board(int sizeX, int sizeY) {
		this.cell = new Cell[sizeX * sizeY];
		initBoard(sizeX, sizeY);
	}

	// instantiate the board class
	private void initBoard(int x, int y) {
		Random ran = new Random();
		int val = ran.nextInt(x * y);
		Cell cel;

		for (int i = 0; i < x * y; i++) {

			if (i == val)
				cel = new Cell(i, random2_or_4(), false);
			else
				cel = new Cell(i, 0, true);

			this.cell[i] = cel;
		}
	}

	// get the instance of the board
	public static Board getInstanceOfBoard(int x, int y) {
		if (b == null)
			b = new Board(x, y);
		return b;
	}

	// generate 2 or 4
	public int random2_or_4() {
		double percent = Math.random();
		if (percent <= 0.08)
			return 4;
		return 2;
	}
	
	// set the value of the board
	public void setBoard(int [] ar)
	{
		for (int i = 0; i < cell.length; i++) 
			this.cell[i].setValue(ar[i]);
		System.out.println();
	}

	// print the board with the values of the cells
	public void printBoard(Cell[] board, int sizeX) {
		for (int i = 0; i < board.length; i++) {
			if (((i + 1) % sizeX) == 0)
				System.out.println(board[i].getValue());
			else
				System.out.print(board[i].getValue() + "  ");
		}
	}

}
