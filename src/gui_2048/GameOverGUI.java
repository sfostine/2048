package gui_2048;

import game_2048.Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameOverGUI extends JPanel {
	JFrame gameOverFrame;
	JLabel gameOver;
	int size = 300;

	public GameOverGUI(int width, int height) {
		
		// set the frame properties
		gameOverFrame = new JFrame("GAME OVER");
		gameOverFrame.setSize(width, height);
		gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOverFrame.setResizable(false);
		gameOverFrame.setLocationRelativeTo(null);
		
		
		
		// set the label properties
		gameOver = new JLabel("GAME OVER", JLabel.CENTER);
		gameOver.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 16*Game.getSizeX()));
		gameOver.setBackground(Color.CYAN);
		
		
		this.setLayout(new BorderLayout());
		this.add(gameOver, BorderLayout.CENTER);
		this.setBackground(Color.CYAN);
		gameOverFrame.getContentPane().add(this);
		gameOverFrame.setVisible(true);
		
		
	}

}
