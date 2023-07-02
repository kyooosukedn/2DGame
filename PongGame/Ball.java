import java.awt.*;

public class Ball {
  private int x;
  private int y;
  private int diameter;
  private int dx;
  private int dy;
  private Color color;

  public Ball(int x, int y, int diameter, int dx, int dy, Color color) {
    this.x = x;
    this.y = y;
    this.diameter = diameter;
    this.dx = dx;
    this.dy = dy;
    this.color = color;
  }

  public void update() {
    x += dx;
    y += dy;
  }

  public void draw(Graphics g) {
    g.setColor(color);
    g.fillOval(x, y, diameter, diameter);
  }

  public void changeDirectionX() {
    dx = -dx;
  }

  public void changeDirectionY() {
    dy = -dy;
  }

  // Getters and setters

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getDiameter() {
    return diameter;
  }
}
