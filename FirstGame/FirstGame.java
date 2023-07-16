import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.awt.Color;

import javax.swing.*;

public class FirstGame extends Canvas implements Runnable {
  public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
  private Thread thread;
  public boolean running = false;
  public WindowFrame window;
  public Handler handler;

  public FirstGame() {
    window = new WindowFrame(WIDTH, HEIGHT, "First Game", this);
    handler = new Handler();

    Random r = new Random();

    for (int i = 0; i < 50; i++) {
      handler.addObject(new Player(r.nextInt(10), r.nextInt(10), ID.Player));
    }

    handler.addObject(new Player(100, 100, ID.Player));
    handler.addObject(new Player(200, 200, ID.Player));
  }

  public synchronized void start() {
    thread = new Thread(this);
    thread.start();
    running = true;
  }

  public synchronized void stop() {
    try {
      thread.join();
      running = false;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }

  public void run() {
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    while (running) {
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;
      while (delta > 1) {
        tick();
        delta--;
      }
      if (running)
        render();
      frames++;

      if (System.currentTimeMillis() - timer > 1000) {
        timer += 1000;
        System.out.println("FPS: " + frames);
        frames = 0;
      }
    }
    stop();
  }

  private void tick() {
    handler.tick();
  }

  private void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
      this.createBufferStrategy(3);
      return;
    }

    Graphics g = bs.getDrawGraphics();
    g.setColor(Color.green);
    g.fillRect(0, 0, WIDTH, HEIGHT);

    handler.render(g);

    g.dispose();
    bs.show();
  }

  public static void main(String[] args) {
    new FirstGame();
  }
}
