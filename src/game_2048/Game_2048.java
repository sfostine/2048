package game_2048;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Samuel
 *
 */
public class Game_2048 extends Game {
	// arraylist to choose an empty cell
	private ArrayList<Cell> listCell = new ArrayList<Cell>();

	public Game_2048(int sizeX, int sizeY) {
		super(sizeX, sizeY);
	}

	// set the value of the chosen cell to 2 or 4 to an empty cell
	private void setCell() {
		int choice = getCellId();
		// cell is set to 2 or 4 and is set automatically to not empty
		this.getBoard().getCells()[choice].setValue(this.getBoard()
				.random2_or_4());
	}

	// pick randomly an empty cell to set the value to 2 or 4
	private int getCellId() {
		// push all the empty cells to the list
		for (int i = 0; i < this.getBoard().getCells().length; i++) {
			if (this.getBoard().getCells()[i].isEmpty()) {
				listCell.add(this.getBoard().getCells()[i]);
			}

		}

		// randomly choosing one empty cell
		Random rand = new Random();
		// the id of the chosen cell
		int choice = listCell.get(rand.nextInt(listCell.size())).getId();

		// refactor
		listCell.clear();
		return choice;
	}

	// merge the array
	private void mergeHelper(int[] ar) {

		for (int i = 1; i < ar.length; i += 2) {
			if (ar[i] != 0 && ar[i - 1] == ar[i]) {
				ar[i - 1] *= 2;
				ar[i] = 0;
			}
		}
	}

	// move every non zero to the left of the array
	private void toLeft(int[] ar) {
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = 1; j < ar.length; j++) {
				if (ar[j - 1] == 0 && ar[j] != 0) {
					ar[j - 1] = ar[j];
					ar[j] = 0;
				}
			}
		}
	}

	// merge the whole array together
	public void merge(int[] ar) {
		toLeft(ar);
		mergeHelper(ar);
		toLeft(ar);
	}

	/********************Testing methods************/
	// for JUnit testing of toLeft method
	public int[] toLeftUnitTest(int[] ar) {
		toLeft(ar);
		return ar;
	}

	// for unit testing
	public int[] mergeHelperTest(int[] ar) {
		mergeHelper(ar);
		return ar;
	}

	// testing purpose of the merge method
	public int[] mergeTest(int[] ar) {
		merge(ar);
		return ar;
	}

}
