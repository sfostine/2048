/**
 * 
 */
package game_2048;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

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

	private Color getColor()

	{
		switch (value) {
		case 2:
			return new Color(0xeee4da);
		case 4:
			return new Color(0xede0c8);
		case 8:
			return new Color(0xf2b179);
		case 16:
			return new Color(0xf59563);
		case 32:
			return new Color(0xf67c5f);
		case 64:
			return new Color(0xf65e3b);
		case 128:
			return new Color(0xedcf72);
		case 256:
			return new Color(0xedcc61);
		case 512:
			return new Color(0xedc850);
		case 1024:
			return new Color(0xedc53f);
		case 2048:
			return new Color(0xedc22e);
		}
		return new Color(0xcdc1b4);
	}

	public void drawCell(Graphics g, int x, int y, int width, int height) {
		
	}

}
