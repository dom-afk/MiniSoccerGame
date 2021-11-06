package model.players;

public class PlayerStatistics {

	private int points = 0;
	
	/*
	 * This gets the points of a player.
	 * 
	 * @return The points of a player
	 */
	public Integer getStatistics() {
		return points;
	}

	/*
	 * This sets a player's point (statistics).
	 * 
	 * @param The new point to set
	 */
	public void setStatistics(Integer newStatistics) {
		points = newStatistics;
	}
	
	/*
	 * This converts the statistics to a string.
	 * 
	 * @return The string value of the points
	 */
	@Override
	public String toString() {
		return Integer.toString(points);
	}

}
