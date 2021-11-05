package model.players;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import model.SoccerGameTest;

/*
 * @Misato
 */

public class PlayerCollectionIteratorTest {

	@Test
	public void constructorTest() {
		Collection<GamePlayer> collection = new ArrayList<GamePlayer>();
		collection.add(new Striker("Striker", Color.RED));
		collection.add(new Goalkeeper("Goalkeeper", Color.BLACK));
		
		PlayerCollectionIterator itr = new PlayerCollectionIterator(collection);
		
		boolean isRightPlayer = false;
		
		for (GamePlayer playerName : collection) {
			if (itr.hasNext() && playerName.getPlayerName().equals(itr.next().getPlayerName())) {
				isRightPlayer = true;
			} else {
				isRightPlayer = false;
				break;
			}
		}
		assertEquals(true, isRightPlayer);
	}
	
	@Test
	public void test() {
		GamePlayerTest test1 = new GamePlayerTest();
		test1.constructorTest();
		test1.updateStatisticsTest();
		
		PlayerFactoryTest test2 = new PlayerFactoryTest();
		test2.getPlayerFactoryTest();
		
		PlayerStatisticsTest test3 = new PlayerStatisticsTest();
		test3.testGetStatistic();
		test3.testToString();
		
		PlayerCollectionTest test4 = new PlayerCollectionTest();
		test4.getGamePlayerTest();
		test4.getCollectionOfGamePlayersTest();
		
		SoccerGameTest test5 = new SoccerGameTest();
		test5.testAll();
	}
}
