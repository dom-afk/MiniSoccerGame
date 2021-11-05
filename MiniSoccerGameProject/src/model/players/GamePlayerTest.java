package model.players;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

import model.SoccerGameTest;

public class GamePlayerTest {
	
	@Test
	public void constructorTest() {
		GamePlayer player1 = new Striker("Striker", Color.RED);
		GamePlayer player2 = new Goalkeeper("Goalkeeper", Color.BLACK);
		
		player1.setInitialPosition();
		player2.setInitialPosition();
		
		Point p1 = new Point(500, 450); // Initial position for Striker
		Point p2 = new Point(280, 70); // Initial position for Goalkeeper
		
		Point initial1 = player1.getPlayerPosition();
		Point initial2 = player2.getPlayerPosition();
		
		player1.moveDown(); player1.moveUp(); player1.moveRight(); player1.moveLeft(); player1.moveLeft();
		player2.moveDown(); player2.moveUp(); player2.moveRight(); player2.moveLeft(); player2.moveLeft();
		
		// Player's name
		assertEquals("Striker", player1.getPlayerName());
		assertEquals("Goalkeeper", player2.getPlayerName());
		// Player's statistics
		assertEquals(0, player1.getPlayerStatistics());
		assertEquals(0, player2.getPlayerStatistics());
		// Player.s initial position
		assertEquals(p1, initial1);
		assertEquals(p2, initial2);
		// Player's color
		assertEquals(Color.RED, player1.getPlayerColor());
		assertEquals(Color.BLACK, player2.getPlayerColor());
	}
	
	@Test
	public void updateStatisticsTest() {
		GamePlayer player = new Striker("Striker", Color.RED);

		player.setPlayerStatistics(5);
		
		assertEquals(5, player.getPlayerStatistics());
	}
	
	@Test
	public void testAll() {
		constructorTest();
		updateStatisticsTest();
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
		
		PlayerCollectionIteratorTest test5 = new PlayerCollectionIteratorTest();
		test5.constructorTest();
		
		SoccerGameTest test6 = new SoccerGameTest();
		test6.testAll();
	}
}
