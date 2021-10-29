package model.players;

import model.SoccerBall;

import java.awt.*;

public abstract class GamePlayer implements Comparable<GamePlayer> {

	protected final String playerName;

	protected final Color playerColor;

	protected Point playerPosition;

	protected final PlayerStatistics playerStatistics;

	/**
	 * This is a constructor to set up a game player
	 * 
	 * @param name a String representing the player's name
	 * @param color a color of the player
	 */
	public GamePlayer(String name, Color color) {
		playerName = name;
		playerColor = color;
		playerStatistics = new PlayerStatistics();
		setInitialPosition();
	}

	/**
	 * This shows whether a player is holding a soccer ball
	 * 
	 * @return true if the player is holding a soccer ball, otherwise false
	 */
	public boolean isPlayerHasBall() {
		Point playerPositionCenter = new Point(getPlayerPosition().x + 15, getPlayerPosition().y + 30);
		return playerPositionCenter.distance(SoccerBall.getSoccerBall().getPosition()) < 55;
	}

	/**
	 * This lets a player to grab a soccer ball
	 * 
	 */
	public void grabsBall() {
		SoccerBall ball = SoccerBall.getSoccerBall();
		if (getPlayerPosition().x + 15 > ball.getPosition().x) {
			ball.setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		} else {
			ball.setPosition(new Point(getPlayerPosition().x + 20, getPlayerPosition().y + 55));
		}
	}

	public abstract void moveLeft();

	public abstract void moveRight();

	public abstract void moveUp();

	public abstract void moveDown();

	public abstract void shootBall();

	/**
	 * This returns a player's name as String
	 * 
	 * @return a player's name
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * This returns a player's color
	 * 
	 * @return a player's color
	 */
	public Color getPlayerColor() {
		return playerColor;
	}

	/**
	 * This returns a player's position as Point
	 * 
	 * @return a player's name
	 */
	public Point getPlayerPosition() {
		return playerPosition;
	}

	public abstract void setInitialPosition();

	/**
	 * This sets a new position for a player 
	 * 
	 * @param new position to set
	 */
	public void setPlayerPosition(Point newPosition) {
		playerPosition = newPosition;
		if (isPlayerHasBall()) {
			grabsBall();
		}
	}

	/**
	 * This returns statistics of a player such as caught balls or scored goals
	 * 
	 * @return a player's caught balls or scored goals
	 */
	public Integer getPlayerStatistics() {
		return playerStatistics.getStatistics();
	}

	/**
	 * This sets new statistics of a player such as caught balls or scored goals
	 * 
	 * @param a player's new statistics to set
	 */
	public void setPlayerStatistics(Integer newStatistics) {
		playerStatistics.setStatistics(newStatistics);
	}

	/**
	 * This compares statistics between two players
	 * 
	 * @return other player to compare
	 */
	@Override
	public int compareTo(GamePlayer otherPlayer) {
		return otherPlayer.getPlayerStatistics().compareTo(this.getPlayerStatistics());
	}

	@Override
	public abstract String toString();
}
