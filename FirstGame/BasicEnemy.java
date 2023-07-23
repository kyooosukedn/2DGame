import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject{

    public BasicEnemy (int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= FirstGame.HEIGHT) velY *= -1;
        if (x <= 0 || x >= FirstGame.WIDTH) velX *= -1;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);

        g.fillOval(x, y, 16, 16);
    }

}
