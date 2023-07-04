package dp;
import robocode.*;
import robocode.util.Utils;
import java.awt.geom.*;     // for Point2D's
import java.util.ArrayList; // for collection of waves
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * SecondModified - a robot by (your name here)
 */
public class SecondModified extends AdvancedRobot
{
	/*
	 * Variable declarations
	 */
	boolean ahead;
	int number = 0;
	String firstName;
	String secondName;
	
	static Hashtable enemies = new Hashtable();
	static microEnemy target;
	static Point2D.Double nextDestination;
	static Point2D.Double lastPosition;
	static Point2D.Double myPos;
	
	/**
	 * run: SecondModified's default behavior
	 */
	public void run() {
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForRobotTurn(true);
		// set color for robot interface
		setColors(Color.red, Color.Blue, Color.yellow);
		
		setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
		
		nextDestination = lastPosition = myPos = new Point2D.Double(getX(), getY());
	
		while(true) {
			
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		double distance = e.getDistance();
		String robotName = e.getName();
		
		if (!enemies.containsKey(robotName)) {
			enemies.put(robotName, new EnemyData());
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
	
	public void onRobotDeath(RobotDeathEvent e) {
		enemies.get(e.getName()).alive = false;
		nearestDistance = Double.POSIITVE_INFINITY;
	}
}

class EnemyWave {
	Point2D.Double fireLocation;
	long fireTime;
	double bulletVelocity, directAngle, distanceTraveled;
	int direction;
	
	public EnemyWave() {}
}

public double wallSmoothing(Point2D.Double botLocation, double angle, int orientation) {
	while (!_fieldRect.contains(project(botLocation, angle, WALL_STICK))) {
		angle += orientation * 0.05;
	}
	return angle;
}

public static Point2D.Double project(Point2D.Double sourceLocation, double angle, double length) {
	return new Point2D.Double(sourceLocation.x + Math.sin(angle) * length, sourceLocation.y + Math.cos(angle) * length);
}