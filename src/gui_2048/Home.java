package gui_2048;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;


public class Home extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	JFrame homeFrame;
	JButton start;
	JLabel welcome;
	private int size = 600;
	
	public Home(){
		// frame for the home
		homeFrame = new JFrame("Welcome to my 2048 game");
		homeFrame.setSize(size, size);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.setResizable(false);
		homeFrame.setLocationRelativeTo(null);
		
		// load image of 2048 as background for home using JLabel
		try {
			welcome = new JLabel(new ImageIcon(ImageIO.read(GameFrame.class.getResource("/logo/logo.png"))
					.getScaledInstance(size, size, Image.SCALE_SMOOTH)));
			welcome.setSize(size, size);
			welcome.setBounds(0, 0, size, size);
			this.add(welcome, new Integer(1));
		} catch (IOException e) {}
		
		// the start button with action action to perform when the start button is pressed
		start = new JButton("START");
		ActionListener startButton = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				homeFrame.setVisible(false);
				homeFrame.dispose();
				startGame();
				
			}
		};
		
	
		start.addActionListener(startButton);
		start.setBounds(230, 500, 150, 50);
		this.add(start, new Integer(2));
		homeFrame.add(this);
		homeFrame.setVisible(true);
	}
	
	public void startGame()
	{
		
		int XValue = 0, YValue = 0;
		boolean fail = true;
		String input = "";
		
		// get number of columns from user
		// force the user to enter a value within the correct range
			while(fail)
			{
			
				try {
					input = JOptionPane
									.showInputDialog("Please, enter the number of columns for the game\n"
											+ "It has to be between 1 and 11");
					XValue = Integer.parseInt(input);
					
					if(XValue >= 1 && XValue <= 11)
					{
						fail = false;
					}
					
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Please, make sure you enter a valid integer");
				}
				
			}
			
		
			// get number of rows from user
			// force the user to enter a value within the correct range
			fail = true;
			while(fail)
			{
			
				try {
					input = JOptionPane
									.showInputDialog("Please, enter the number of rows for the game\n"
											+ "It has to be between 1 and 7");
					YValue = Integer.parseInt(input);
					
					if(YValue >= 1 && YValue <= 7)
					{
						fail = false;
					}
					
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Please, make sure you enter a valid integer");
				}
				
			}
				
				new GameFrame(XValue, YValue);
	}
	
	
}

