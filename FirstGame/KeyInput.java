import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

  private Handler handler;

  public KeyInput(Handler handler) {
    this.handler = handler;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    int key = e.getKeyCode();

    for (int i = 0; i < handler.object.size(); i++) {
      GameObject tempObject = handler.object.get(i);

      // set key event for player 1
      if (tempObject.getID() == ID.Player) {

        if (key == KeyEvent.VK_W) tempObject.setY(tempObject.getY() - 1);
        if (key == KeyEvent.VK_A) tempObject.setX(tempObject.getX() -1);

        if (key == KeyEvent.VK_S) tempObject.setY(tempObject.getY() + 1);
        if (key == KeyEvent.VK_D) tempObject.setX(tempObject.getX() + 1);
      }

      // set key event for player 2
      if (tempObject.getID() == ID.Enemy) {
        if (key == KeyEvent.VK_UP) tempObject.setY(tempObject.getY() - 1);
        if (key == KeyEvent.VK_LEFT) tempObject.setX(tempObject.getX() -1);

        if (key == KeyEvent.VK_DOWN) tempObject.setY(tempObject.getY() + 1);
        if (key == KeyEvent.VK_RIGHT) tempObject.setX(tempObject.getX() + 1);
      }

    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

    for (int i = 0; i < handler.object.size(); i++) {
      GameObject tempObject = handler.object.get(i);

      // set key event for player 1
      if (tempObject.getID() == ID.Player) {

        if (key == KeyEvent.VK_W) tempObject.setY(tempObject.getY() - 1);
        if (key == KeyEvent.VK_A) tempObject.setX(tempObject.getX() -1);

        if (key == KeyEvent.VK_S) tempObject.setY(tempObject.getY() + 1);
        if (key == KeyEvent.VK_D) tempObject.setX(tempObject.getX() + 1);
      }

      // set key event for player 2
      if (tempObject.getID() == ID.Enemy) {
        if (key == KeyEvent.VK_UP) tempObject.setY(tempObject.getY() - 1);
        if (key == KeyEvent.VK_LEFT) tempObject.setX(tempObject.getX() -1);

        if (key == KeyEvent.VK_DOWN) tempObject.setY(tempObject.getY() + 1);
        if (key == KeyEvent.VK_RIGHT) tempObject.setX(tempObject.getX() + 1);
      }

    }
  }

}
