package model;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SoccerBall {

	private static final SoccerBall soccerBall = new SoccerBall();

	private Point position;

	private double velocity;

	private final Color color;

	/*
	 * This is a default constructor which sets the ball's color to white
	 * and set the ball position to initial.
	 * 
	 */
	private SoccerBall() {
		color = Color.white;
		resetSoccerBall();
	}

	/*
	 * This method allows to obtain an object of SoccerBall.
	 * Here, the Singleton pattern is utilized.
	 * 
	 * @return The object of the SoccerBall class
	 */
	public static SoccerBall getSoccerBall() {
		return soccerBall;
	}

	/*
	 * This method controls the ball's position and speed.
	 * 
	 * @param initialDistance The initial distance of the ball
	 * @param initialVelocity The initial velocity of the ball
	 * @param acceleration The acceleration of the ball
	 */
	public void moveBall(int initialDistance, double initialVelocity, double acceleration) {
		moveBallY(initialDistance);
		setVelocity(initialVelocity);
		Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				if (Math.abs(velocity) < 2) {
					velocity = 0.0;
					timer.cancel();
				} else {
					velocity = velocity - acceleration;
				}
				moveBallY((int) velocity);
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}

	/*
	 * This method deals with the y value of the ball.
	 * 
	 * @param distance The distance of the ball
	 */
	public void moveBallY(int distance) {
		if (getPosition().y + distance < 510 && getPosition().y - distance > 20) {
			setPosition(new Point(getPosition().x, getPosition().y - distance));
		} else {
			setVelocity(0.0);
		}
	}

	/*
	 * This brings the ball back to the initial position
	 * and sets the velocity to 0.
	 * 
	 */
	public void resetSoccerBall() {
		setVelocity(0.0);
		setPosition(new Point(480, 500));
	}

	/*
	 * This figures out whether the ball is on the keeper's side.
	 * 
	 * @return true if the ball is on the keeper side whose y value is less than 200,
	 * otherwise, return false
	 */
	public boolean onGoalkeeperSide() {
		return getPosition().y < 200;
	}

	/*
	 * This figures out whether the ball is in the goal gate.
	 * 
	 * @return true if the ball is in the gate whose x value is between 180 amd 400,
	 * and y value is between 10 and 60, otherwise, return false
	 */
	public boolean inGate() {
		return getPosition().x > 180 && getPosition().x < 400 && getPosition().y > 10 && getPosition().y < 60;
	}

	/*
	 * This sets the ball's velocity.
	 * 
	 * @param The velocity to set
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	/*
	 * This gets the position of the ball.
	 * 
	 * @return The position of the ball as a point with x and y values
	 */
	public Point getPosition() {
		return position;
	}

	/*
	 * This sets the position of the ball.
	 * 
	 * @param The position of the ball to set as a point with x and y values
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/*
	 * This gets the color of the ball which is always white.
	 * 
	 * @return The color of the ball
	 */
	public Color getColor() {
		return color;
	}
}
