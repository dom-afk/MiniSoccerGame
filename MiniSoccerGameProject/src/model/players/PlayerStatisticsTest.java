/**
 * 
 */
package model.players;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * @author gbemi
 *
 */
public class PlayerStatisticsTest {

	@Test
	public void testGetStatistic() {
		PlayerStatistics testGetStat = new PlayerStatistics();
		
		Random rand = new Random();
		int min = 0;
		int max = 31;
		int testPoint = rand.nextInt(max - min + min);
		
		testGetStat.setStatistics(testPoint);
		assertTrue(testGetStat.getStatistics() == testPoint);
	}
	
	@Test
	public void testToString() {
		PlayerStatistics testGetStat = new PlayerStatistics();
		
		Random rand = new Random();
		int min = 0;
		int max = 31;
		Integer testPoint = rand.nextInt(max - min + min);
		testGetStat.setStatistics(testPoint);

		String stringTestPoint = testPoint.toString();	
		
		assertEquals(stringTestPoint, testGetStat.toString());
	}


}
