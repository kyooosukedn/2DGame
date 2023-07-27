import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{

    Handler handler;

    public BasicEnemy (int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX += 5;
        velY += 5;
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= FirstGame.HEIGHT) velY *= -1;
        if (x <= 0 || x >= FirstGame.WIDTH) velX *= -1;

        collision();
    }

    private void collision() {
        for (GameObject tempObject : handler.object) {
            if (tempObject.getID() == ID.Player) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // collision code
                    HeadsUpDisplay.HEALTH -= 2;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.red);

        g.fillOval(x, y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,16,16);
    }

}
