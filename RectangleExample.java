import javax.swing.*;
import java.awt.*;

public class RectangleExample extends JPanel {
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int x = 50;
    int y = 50;
    int width = 100;
    int height = 50;

    g.setColor(Color.RED);
    g.fillRect(x, y, width, height);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Rectangles Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      RectangleExample panel = new RectangleExample();
      frame.add(panel);

      frame.setSize(400, 300);
      frame.setVisible(true);
    });
  }
}
