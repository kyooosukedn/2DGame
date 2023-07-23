import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {

  Random r = new Random();

  public Player(int x, int y, ID id) {
    super(x, y, id);

  }

  public void tick() {
    x += velX;
    y += velY;

    x = FirstGame.clamp(x, 0, FirstGame.WIDTH - 32);
    y = FirstGame.clamp(y, 0, FirstGame.HEIGHT - 32);
  }

  public void render(Graphics g) {
      g.setColor(Color.white);

    g.fillOval(x, y, 32, 32);
  }

}
