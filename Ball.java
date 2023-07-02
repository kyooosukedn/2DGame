import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ball {
  public static final int SIZE = 20;
  private static final int SPEED = 3;

  private int x;
  private int y;
  private int dx;
  private int dy;

  public Ball(int x, int y) {
    this.x = x;
    this.y = y;
    this.dx = SPEED;
    this.dy = SPEED;
  }

  public void update(Paddle leftPaddle, Paddle rightPaddle) {
    x += dx;
    y += dy;

    if (y < 0 || y + SIZE > PongGame.HEIGHT) {
      dy *= -1;
    }

    if (x < Paddle.WIDTH && y + SIZE >= leftPaddle.getY() && y <= leftPaddle.getY() + Paddle.HEIGHT) {
      dx *= -1;
    }

    if (x + SIZE > PongGame.WIDTH - Paddle.WIDTH && y + SIZE >= rightPaddle.getY()
        && y <= rightPaddle.getY() + Paddle.HEIGHT) {
      dx *= -1;
    }

    if (x < 0 || x + SIZE > PongGame.WIDTH) {
      reset();
    }
  }

  public void reset() {
    x = PongGame.WIDTH / 2 - SIZE / 2;
    y = PongGame.HEIGHT / 2 - SIZE / 2;
    dx = SPEED;
    dy = SPEED;
  }

  public void paint(Graphics2D g2d) {
    g2d.setColor(Color.WHITE);
    g2d.fillRect(x, y, SIZE, SIZE);
  }
}
