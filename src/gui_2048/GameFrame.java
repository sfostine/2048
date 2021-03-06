package gui_2048;

import java.awt.BorderLayout;
import javax.swing.JFrame;


import controller.GameController;



public class GameFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GameFrame frame;
	protected GameController control;
	
	
	private GameFrame(int x, int y)
	{
		// controller
		control = new GameController(x,y);
		
		// some functionalities of frame
		this.setTitle("2048");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// add panels to the frame
		this.getContentPane().add(control.getScorePanel(), BorderLayout.EAST);
		this.getContentPane().add(control.getPanel(), BorderLayout.CENTER);

		
		// pack the frame to fit the panels
		this.pack();
		
		// some other functionalities of frame
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	
	public  static GameFrame getFrame(int x, int y)
	{
		if(frame == null)
			frame = new GameFrame(x, y);
		return frame;
	}
	
	public static GameFrame frame()
	{
		return frame;
	}
}
