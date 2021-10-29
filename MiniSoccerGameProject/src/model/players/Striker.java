package model.players;

import model.SoccerBall;

import java.awt.*;

public class Striker extends GamePlayer {
	
	/**
	 * This is a constructor to create a striker
	 * 
	 * @param name the name of a striker
	 * @param color the color of a striker
	 * 
	 */
	public Striker(String name, Color color) {
		super(name, color);
	}

	/**
	 * This allows a striker to move left in a certain range
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 10 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - 5, getPlayerPosition().y));
		}
	}

	/**
	 * This allows a striker to move right in a certain range
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + 5, getPlayerPosition().y));
		}
	}

	/**
	 * This allows a striker to move up in a certain range
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 200) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	/**
	 * This allows a striker to move down in a certain range
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 500) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	/**
	 * This allows a striker to shoot a ball back
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(60, 5.0, 0.05);
	}

	/**
	 * This initializes a striker's position
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(500, 450));
	}

	/**
	 * This returns a string representing the numbers of caught and scored balls
	 * This method overrides the one in abstract GamePlayer class
	 * 
	 * @return a string to show the numbers of caught and scored balls
	 */
	@Override
	public String toString() {
		return playerName + " scored " + playerStatistics.toString() + " goals";
	}
}
