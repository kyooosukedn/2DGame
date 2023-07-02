import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PongGame extends JPanel implements Runnable {
  public static final int WIDTH = 800;
  public static final int HEIGHT = 400;

  private boolean running;
  private Thread gameThread;
  private Paddle paddleLeft;
  private Paddle paddleRight;
  private Ball ball;

  public PongGame() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
    requestFocus();

    paddleLeft = new Paddle(10, HEIGHT / 2 - 80 / 2, 20, 80, 5, Color.BLUE);
    paddleRight = new Paddle(WIDTH - 80 - 10, HEIGHT / 2 - 80 / 2, 20, 80, 5, Color.RED);
    ball = new Ball(WIDTH / 2 - 40 / 2, HEIGHT / 2 - 40 / 2, 20, 8, 5, Color.WHITE);

    running = false;
  }

  public void startGame() {
    if (!running) {
      running = true;
      gameThread = new Thread(this);
      gameThread.start();
    }
  }

  public void stopGame() {
    if (running) {
      running = false;
      try {
        gameThread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void run() {
    while (running) {
      update();
      repaint();

      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void update() {
    paddleLeft.update();
    paddleRight.update();
    ball.update();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, WIDTH, HEIGHT);

    paddleLeft.draw(g);
    paddleRight.draw(g);
    ball.draw(g);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Pong Game");
      PongGame pongGame = new PongGame();
      frame.add(pongGame);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setVisible(true);
      pongGame.startGame();
    });
  }
}
