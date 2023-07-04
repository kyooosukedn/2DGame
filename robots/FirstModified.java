package dp;

import robocode.*;
import robocode.util.Utils;
import java.awt.Color;
import java.util.Hashtable;
import java.util.Enumeration;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;


public class FirstModified extends AdvancedRobot {
	static Hashtable enemies = new Hashtable();
	static microEnemy target;
	static Point2D.Double nextDestination;
	static Point2D.Double lastPosition;
	static Point2D.Double myPos;
	static double myEnergy;

	public void run() {
		setColors(Color.black, Color.red, Color.orange);
		// Gun and Radar should be capable to turn independently from lower part
		setAdjustGunForRobotTurn(true); 
		setAdjustRadarForGunTurn(true);
		
		setTurnRadarRightRadians(Double.POSITIVE_INFINITY);

		nextDestination = lastPosition = myPos = new Point2D.Double(getX(), getY());
		target = new microEnemy();

		do {
		
			myPos = new Point2D.Double(getX(), getY());
			myEnergy = getEnergy();
			
			// wait until all other bots have been scanned, takes about 7-9 ticks.
			if(target.live && getTime() > 9) {
				doMovementAndGun();
			}
			execute();
		} while(true);

	}
	
	public void doMovementAndGun() {
		double distanceToTarget = myPos.distance(target.pos);
		
		// gun
		// using HeadOnTargeting
		if (getGunTurnRemaining() == 0 && myEnergy > 1) {
			setFire(Math.min(Math.min(myEnergy/6d, 1300d/distanceToTarget), target.energy/3d));
			
		}
		
		setTurnGunRightRadians(Utils.normalRelativeAngle(calcAngle(target.pos, myPos) - getGunHeadingRadians()));

		//movement
		double distanceToNextDestination = myPos.distance(nextDestination);
		//search a new destination iff I reached this one
		if (distanceToNextDestination < 15) {
			// addLast will mostly be 1
			double addLast = 1 - Math.rint(Math.pow(Math.random(), getOthers()));
			Rectangle2D.Double battleField = new Rectangle2D.Double(30,30, getBattleFieldWidth() - 60, getBattleFieldHeight() - 60);
			Point2D.Double testPoint;
			int i = 0;
			
			do {
				// Calculate the testPoint somewhere around the current Position. 
				// 100 + 200*Math.random() -> around 10 bots in a 1000x 1000 field
				// distanceToTarget has to be limited , so distanceToTarget * 0.8 so the bot wont run into the target (should mostly be the closest bot)
				testPoint = calcPoint(myPos, Math.min(distanceToTarget * 0.8, 100 + 200* Math.random()), 2 * Math.PI * Math.random());
				if (battleField.contains(testPoint) && evaluate(testPoint, addLast) < evaluate(nextDestination, addLast)) {
					
				}
			} while (true);
		}
	}
	
	public static void evaluate(Point2D.Double p, double addLast) {
		// the bot uses more space on the battlefield.
		double eval = addLast * 0.08/p.distanceSq(lastPosition)
	}
	
	private static Point2D.Double calcPoint(Point2D.Double p, double dist, double ang) {
		return new Point2D.Double(p.x + dist*Math.sin(ang), p.y + dist*Math.cos(ang));
	}
	
	private static double calcAngle(Point2D.Double p2, Point2D.Double p1) {
		return Math.atan2(p2.x - p1.x, p2.y - p1.y);
	}
}
