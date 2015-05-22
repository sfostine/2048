/**
 * 
 */
package game_2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
		
		int valY = 0;
		
		for (int i = 0; i < x * y; i++) {

			if (i == val)
				cel = new Cell(i, random2_or_4(), false);
			else
				cel = new Cell(i, 0, true);
			
			this.cell[i] = cel;
			cell[i].setX(i%x);
			cell[i].setY(valY);
			
			// increase the value of y
			if(i%x == (x-1)){
				valY++;
			}
		}
	}

	// get the instance of the board
	public static Board getInstanceOfBoard() {
		if (b == null)
			b = new Board(Game.getSizeX(), Game.getSizeY());
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
	public void printBoard( int sizeX) {
		for (int i = 0; i < cell.length; i++) {
			if (((i + 1) % sizeX) == 0)
				System.out.println(cell[i].getValue());
			else
				System.out.print(cell[i].getValue() + "  ");
		}
	}
	
	// get the color of the cell depending on the value inside of it
	private Color getColorCell(int value)
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
	
	// get the color of the string or the Value to be printed
	private Color getColorString(int value)
	{
		switch (value) {
		case 2:
			return Color.MAGENTA;
		case 4:
			return Color.DARK_GRAY;
		case 8:
			return Color.YELLOW;
		case 16:
			return Color.BLUE;
		case 32:
			return Color.BLACK;
		case 64:
			return Color.ORANGE;
		case 128:
			return Color.ORANGE;
		case 256:
			return Color.RED;
		case 512:
			return Color.PINK;
		case 1024:
			return Color.GREEN;
		case 2048:
			return Color.CYAN;
		}
		return new Color(0xcdc1b4);
	}
	
	// draw the whole board whith all the tiles
	public void drawBoard(Graphics2D g)
	{
		for(int i = 0 ; i < cell.length; i++)
		{
			
			int value = cell[i].getValue();
			// x and y coordinates of the board 
			int x = cell[i].getX()*100 + 10;
			int y = cell[i].getY()*100 + 10;
			
			// size of one cell
			int size = 80;
			// clear and redraw the rectangle
			g.clearRect(x, y , size, size);
			g.setColor(getColorCell(value));
			g.fillRect(x,y, size, size);
			
			g.setColor(getColorString(value));
			int fontSize = 24;
			Font font = new Font(Integer.toString(value), Font.BOLD, fontSize);
			
			g.setFont(font);
			
			if(value != 0)
				g.drawString(Integer.toString(value), x + (size/2) - (fontSize/2) , y+ (size/2) + (fontSize/2));
		}
	}
	
	// paint one cell
	public void paintRectangles(Graphics g)
	{	
		Graphics2D g2 = (Graphics2D) g;
		drawBoard(g2);
		
	}
}
