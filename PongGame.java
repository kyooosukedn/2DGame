import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JFrame {
  public static final int WIDTH = 800;
  public static final int HEIGHT = 600;

  Paddle leftPaddle;
  Paddle rightPaddle;
  Ball ball;

  public PongGame() {
    setTitle("Pong Game");
    setSize(WIDTH, HEIGHT);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    leftPaddle = new Paddle(20, HEIGHT / 2 - Paddle.HEIGHT / 2);
    rightPaddle = new Paddle(WIDTH - Paddle.WIDTH - 20, HEIGHT / 2 - Paddle.HEIGHT / 2);
    ball = new Ball(WIDTH / 2 - Ball.SIZE / 2, HEIGHT / 2 - Ball.SIZE / 2);

    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        handleKeyPress(e);
      }

      @Override
      public void keyReleased(KeyEvent e) {
        handleKeyRelease(e);
      }
    });

    setFocusable(true);
  }

  public void handleKeyPress(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_W) {
      leftPaddle.setDy(-3);
    }
    if (keyCode == KeyEvent.VK_S) {
      leftPaddle.setDy(3);
    }
    if (keyCode == KeyEvent.VK_UP) {
      rightPaddle.setDy(-3);
    }
    if (keyCode == KeyEvent.VK_DOWN) {
      rightPaddle.setDy(3);
    }
  }

  public void handleKeyRelease(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_S) {
      leftPaddle.setDy(0);
    }
    if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
      rightPaddle.setDy(0);
    }

  }

  public void startGame() {
    while (true) {
      update();
      repaint();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void update() {
    leftPaddle.update();
    rightPaddle.update();
    ball.update(leftPaddle, rightPaddle);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(Color.BLACK);
    g2d.fillRect(0, 0, WIDTH, HEIGHT);

    leftPaddle.paint(g2d);
    rightPaddle.paint(g2d);
    ball.paint(g2d);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      PongGame game = new PongGame();
      game.setVisible(true);
      game.startGame();
    });
  }
}
