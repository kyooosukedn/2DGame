import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JFrame {
	
	private static final int window_width = 800;
	private static final int window_height = 800;

	public PongGame () {

		setSize(window_width, window_height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("PongPong");
		
		setLocationRelativeTo(null);
		setVisible(true);

		Ball ball = new Ball(300,200,3,3,3,Color.YELLOW,10);

		GamePanel gamePanel = new GamePanel();
		add(panel);
		setFocusable(true);
	}

	public static void main(String[] args) {
	

	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0, window_width, window_height);

		gameBall.paint(g)
	}
}
