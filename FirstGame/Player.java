import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

  Random r = new Random();
  Handler handler;

  public Player(int x, int y, ID id, Handler handler) {
    super(x, y, id);
    this.handler = handler;

  }

  public Rectangle getBounds() {
    return new Rectangle(x,y,32,32);
  }

  public void tick() {
    x += velX;
    y += velY;

    x = FirstGame.clamp(x, 0, FirstGame.WIDTH - 32);
    y = FirstGame.clamp(y, 0, FirstGame.HEIGHT - 32);

    collision();
  }

  private void collision() {
    for (GameObject tempObject : handler.object) {
      if (tempObject.getID() == ID.BasicEnemy) {
        if (getBounds().intersects(tempObject.getBounds())) {
          // collision code
          HeadsUpDisplay.HEALTH -= 2;
        }
      }
    }
  }

  public void render(Graphics g) {
      g.setColor(Color.white);
      g.fillOval(x, y, 32, 32);
  }

}
