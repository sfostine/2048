package game_2048;
/**
 * @author Samuel
 *
 */
public class Cell {

	/**
	 * 
	 */
	private int id, value, X, Y;

	/**
	 * @return the x
	 */
	public int getX() {
		return X;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		X = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return Y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		Y = y;
	}

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
		if(value == 0)
			setEmpty(true);
		else
			setEmpty(false);
		
		this.value = value;
	}

	public boolean isEmpty() {
		return empty;
	}

	private void setEmpty(boolean bool) {
		this.empty = bool;
	}
}
