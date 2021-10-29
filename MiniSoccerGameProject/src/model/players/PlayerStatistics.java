package model.players;

public class PlayerStatistics {

	private int points = 0;
	
	public Integer getStatistics() {
				return points;
	}

	public void setStatistics(Integer newStatistics) {
		points = newStatistics;
	}
	
	@Override
	public String toString() {
		return Integer.toString(points);
	}

}
