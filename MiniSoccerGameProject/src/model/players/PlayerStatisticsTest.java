/**
 * 
 */
package model.players;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author gbemi
 *
 */
public class PlayerStatisticsTest {

	Random rand = new Random();
	PlayerStatistics testGetStat = new PlayerStatistics();
	int min;
	int max;
	Integer testPoint;		
	
		
	@BeforeEach
	public void constructTheDatabase() {
		min = 0;
		max = 31;
		testPoint = rand.nextInt(max - min + min);
		testGetStat.setStatistics(testPoint);
	}
	
	@Test
	public void testGetStatistic() {
		assertTrue(testGetStat.getStatistics() == testPoint);
	}
	
	@Test
	public void testToString() {		
		String stringTestPoint = testPoint.toString();	
		assertEquals(stringTestPoint, testGetStat.toString());
	}


}
