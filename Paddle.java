import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Paddle {
  public static final int WIDTH = 20;
  public static final int HEIGHT = 100;
  private static final int SPEED = 5;

  private int x;
  private int y;
  private int dy;

  public Paddle(int x, int y) {
    this.x = x;
    this.y = y;
    this.dy = 0;
  }

  public void setDy(int dy) {
    this.dy = dy;
  }

  public void update() {
    y += dy;

    if (y < 0) {
      y = 0;
    } else if (y + HEIGHT > PongGame.HEIGHT) {
      y = PongGame.HEIGHT - HEIGHT;
    }
  }

  public void paint(Graphics2D g2d) {
    g2d.setColor(Color.WHITE);
    g2d.fillRect(x, y, WIDTH, HEIGHT);
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}
