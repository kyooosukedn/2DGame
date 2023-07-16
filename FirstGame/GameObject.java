import java.awt.Graphics;

public abstract class GameObject {

  protected int x, y;
  protected ID id;

  protected int velX, velY;

  public GameObject(int x, int y, ID id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }

  public abstract void tick();

  public abstract void render(Graphics g);

  public void setX(int x) {
    this.x = x;
  }

  public int getX() {
    return this.x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getY() {
    return this.y;
  }

  public void setVelocityX(int velX) {
    this.velX = velX;
  }

}