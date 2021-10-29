package model.players;

import model.SoccerBall;

import java.awt.*;
import java.util.Random;

public class Goalkeeper extends GamePlayer {

	private int movementStep;

	/**
	 * This is a constructor to create a goalkeeper
	 * 
	 * @param name the name of a goalkeeper
	 * @param color the color of a goalkeeper
	 */
	public Goalkeeper(String name, Color color) {
		super(name, color);
		movementStep = 10;
	}

	/**
	 * This allows a goalkeeper to move left in a certain range
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 5 - movementStep > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - movementStep, getPlayerPosition().y));
		}
	}

	/**
	 * This allows a goalkeeper to move right in a certain range
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 + movementStep < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + movementStep, getPlayerPosition().y));
		}
	}

	/**
	 * This allows a goalkeeper to move up in a certain range
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	/**
	 * This allows a goalkeeper to move down in a certain range
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 300) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	/**
	 * This allows a goalkeeper to shoot a ball back
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(-20, -5.0, -0.05);
	}

	/**
	 * This moves a goalkeeper in a random direction
	 * 
	 */
	public void moveRandomly() {
		Random random = new Random();
		double playerCurrentXPosition = (double) getPlayerPosition().x + 15;
		double chanceOfMovingLeft = (playerCurrentXPosition - 300) / 100 - (random.nextGaussian());
		movementStep = (int) Math.abs(30 * chanceOfMovingLeft);
		if (chanceOfMovingLeft > 0) {
			moveLeft();
		} else {
			moveRight();
		}
	}

	/**
	 * This initializes a goalkeeper's position
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(280, 70));
	}

	/**
	 * This returns a string representing the numbers of caught and scored balls
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 * @return a string to show the numbers of caught and scored balls
	 */
	@Override
	public String toString() {
		return playerName + " caught " + playerStatistics.toString() + " balls";
	}
}
