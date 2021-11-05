package model.players;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

public class GamePlayerTest {
	
	@Test
	public void constructorTest() {
		GamePlayer player1 = new Striker("Striker", Color.RED);
		GamePlayer player2 = new Goalkeeper("Goalkeeper", Color.BLACK);
		
		Point p1 = new Point(500, 450); // Initial position for Striker
		Point p2 = new Point(280, 70); // Initial position for Goalkeeper
		
		// Player's name
		assertEquals("Striker", player1.getPlayerName());
		assertEquals("Goalkeeper", player2.getPlayerName());
		// Player's statistics
		assertEquals(0, player1.getPlayerStatistics());
		assertEquals(0, player2.getPlayerStatistics());
		// Player.s initial position
		assertEquals(p1, player1.getPlayerPosition());
		assertEquals(p2, player2.getPlayerPosition());
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
}
