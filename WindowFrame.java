import java.awt.*;
import java.awt.Dimension;

import javax.swing.JFrame;

public class WindowFrame extends Canvas {

  public WindowFrame(int width, int height, String title, FirstGame game) {

    javax.swing.JFrame frame = new JFrame(title);

    frame.setPreferredSize(new Dimension(width, height));
    frame.setMaximumSize(new Dimension(width, height));
    frame.setMinimumSize(new Dimension(width, height));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.add(game);
    frame.setVisible(true);
    game.start();
  }
}
