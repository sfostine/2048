/**
 * 
 */
package game_2048;

/**
 * @author Samuel
 *
 */
public class Cell {

	/**
	 * 
	 */
	private int id, value;
	
	private boolean empty;
	
	public Cell(int ID, int val, boolean empt) {
		this.id = ID;
		this.value = val;
		this.empty = empt;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		setNotEmpty();
		this.value = value;
	}

	public boolean isEmpty() {
		return empty;
	}

	private void setNotEmpty() {
		this.empty = false;
	}


}
