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

	private int sizeX, sizeY;

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public Game_2048(int sizeX, int sizeY) {
		super(sizeX, sizeY);
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}

	// set the value of the chosen cell to 2 or 4 to an empty cell
	public void setCell(int choice) {
		
		// cell is set to 2 or 4 and is set automatically to not empty
		this.getBoard().getCells()[choice].setValue(this.getBoard()
				.random2_or_4());
	}

	// pick randomly an empty cell to set the value to 2 or 4
	public int getCellId() {
		// push all the empty cells to the list
		for (int i = 0; i < this.getBoard().getCells().length; i++) {
			if (this.getBoard().getCells()[i].isEmpty()) {
				listCell.add(this.getBoard().getCells()[i]);
			}
		}
		
		if(listCell.isEmpty())
			return -1;
		// randomly choosing one empty cell
		Random rand = new Random();
		// the id of the chosen cell
		int choice = listCell.get(rand.nextInt(listCell.size())).getId();

		// refactor
		listCell.clear();
		return choice;
	}
	
	// retrieve the values of the board
	public int[] retrieve()
	{
		int [] arr = new int [sizeX*sizeY];
		for(int i=0, l = arr.length; i < l; i++)
			arr[i] = this.getBoard().getCells()[i].getValue();
		return arr;
	}
	
	// move all the tile to the left
	public void moveLeft(int [] bigA){
		int[] partArray = new int[this.sizeX];
		int track_1 = 0, track_2 = 0;
		
		for(int i = 0, n = sizeY; i < n; i++ )
		{
			for(int j = 0, m = partArray.length; j < m; j++ )
			{
				partArray[j] = bigA[track_1++];
			}
			
			merge(partArray);
			
			for(int j = 0, m = partArray.length; j < m; j++ )
			{
				bigA[track_2++] = partArray[j];
			}
		}
	}
	
	// move all the tile to the right
	public void moveRight(int [] bigA){
		int[] partArray = new int[this.sizeX];
		int track_1 = 0, track_2 = 0;
		
		for(int i = 0, n = sizeY; i < n; i++ )
		{
			for(int j = partArray.length-1; j >= 0; j-- )
			{
				partArray[j] = bigA[track_1++];
				//0 0 2 2 = 0 0 2 2
			}
			
			merge(partArray);
			// 4 0 0 0
			
			for(int j = partArray.length-1; j >= 0 ; j--)
			{
				bigA[track_2++] = partArray[j];
				// 0 0 0 4
			}
		}
	}
	
	// move all the tile up
	public void moveUp(int [] bigA){
		int[] partArray = new int[this.sizeY];
		
		
		for(int i = 0, n = sizeX; i < n; i++ )
		{
			int track_1 = i, track_2 = i;
			for(int j = 0, m = partArray.length; j < m; j++ )
			{
				partArray[j] = bigA[track_1];
				track_1 += sizeX; 
			}
			
			merge(partArray);
			
			for(int j = 0, m = partArray.length; j < m; j++ )
			{
				bigA[track_2] = partArray[j];
				track_2 += sizeX;
			}
		}
	}
	
	// move all the tile down
		public void moveDown(int [] bigA){
			int[] partArray = new int[this.sizeY];
			
			for(int i = 0, n = sizeX; i < n; i++ )
			{
				int track_1 = i, track_2 = i;
				for(int j = partArray.length-1; j >= 0; j-- )
				{
					partArray[j] = bigA[track_1];
					track_1 += sizeX; 
				}
				
				merge(partArray);
				
				for(int j =  partArray.length-1; j >= 0 ; j-- )
				{
					bigA[track_2] = partArray[j];
					track_2 += sizeX;
				}
			}
		}


	// merge the array
	private void mergeHelper(int[] ar) {
		int i = 1;
		while(i < ar.length) {
			if (ar[i] != 0 && ar[i - 1] == ar[i]) {
				ar[i - 1] *= 2;
				ar[i] = 0;
			}
			else
				i++;
		}
	}

	// move every non zero to the left of the array
	private void toLeft(int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 1; j < ar.length; j++) {
				if (ar[j - 1] == 0 && ar[j] != 0) {
					ar[j - 1] = ar[j];
					ar[j] = 0;
				}
			}
		}
	}

	// merge the whole array together
	private void merge(int[] ar) {
		toLeft(ar);
		mergeHelper(ar);
		toLeft(ar);
	}

	/******************** Testing methods ************/
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
