import java.awt.*;

public class Paddle {
  private int x;
  private int y;
  private int width;
  private int height;
  private int dy;
  private Color color;

  public Paddle(int x, int y, int width, int height, int dy, Color color) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.dy = dy;
    this.color = color;
  }

  public void update() {
    y += dy;
  }

  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(x, y, width, height);
  }

  public void moveUp() {
    dy = -5;
  }

  public void moveDown() {
    dy = 5;
  }

  public void stopMoving() {
    dy = 0;
  }

  // Getters and setters

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void setY(int y) {
    this.y = y;
  }
}
