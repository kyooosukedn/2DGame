private class GamePanel extends JPanel {
        private static final int PADDLE_WIDTH = 20;
        private static final int PADDLE_HEIGHT = 100;
        private static final int BALL_SIZE = 20;

        private int paddle1Y;
        private int paddle2Y;
        private int ballX;
        private int ballY;

        public GamePanel() {
            paddle1Y = WINDOW_HEIGHT / 2 - PADDLE_HEIGHT / 2;
            paddle2Y = WINDOW_HEIGHT / 2 - PADDLE_HEIGHT / 2;
            ballX = WINDOW_WIDTH / 2 - BALL_SIZE / 2;
            ballY = WINDOW_HEIGHT / 2 - BALL_SIZE / 2;

            // Start the game loop
            Thread gameThread = new Thread(() -> {
                while (true) {
                    updateGameState();
                    repaint();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            gameThread.start();
        }

        private void updateGameState() {
            // Implement game logic here
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw game elements
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

            g2d.setColor(Color.WHITE);
            g2d.fillRect(50, paddle1Y, PADDLE_WIDTH, PADDLE_HEIGHT);
            g2d.fillRect(WINDOW_WIDTH - 50 - PADDLE_WIDTH, paddle2Y, PADDLE_WIDTH, PADDLE_HEIGHT);
            g2d.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
        }
    }
}
