public class Ball {
	private int x,y,cx,cy,speed,size;
	private Color color;

	public Ball(int x, int y, int cx, int cy, int speed, int size, Color color) {
		this.x = x; 
		this.y = y;
		this.cx = cx;
		this.cy = y;
		this.speed = speed;
		this.size = size;
		this.color = color;
	}

	public void paint(Graphics g){

	//set the brush color to the ball color
    	g.setColor(color);

    	//paint the ball at x, y with a width and height of the ball size
    	g.fillOval(x, y, size, size);

	}
}
