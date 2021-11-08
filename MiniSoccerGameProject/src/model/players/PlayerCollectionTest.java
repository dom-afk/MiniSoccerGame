package model.players;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerCollectionTest{

	GamePlayer gotStriker = new Striker("Striker", Color.RED);;
	GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.BLACK);;
	PlayerCollection PlayerCollectionTester = new PlayerCollection();

	@BeforeEach
	public void constructTheDatabase() {
		PlayerCollectionTester.add(gotStriker);
		PlayerCollectionTester.add(gotGoalkeeper);
	}
	@Test
	public void getGamePlayerTest() {
		//there is a Collection of players. Check they are equal
		assertEquals(PlayerCollectionTester.get("Striker"), gotStriker);
		assertEquals(PlayerCollectionTester.get("Goalkeeper"), gotGoalkeeper);

		assertEquals(null, PlayerCollectionTester.get(""));
		assertEquals(null, PlayerCollectionTester.get(""));
	}
	

	@Test
	public void getCollectionOfGamePlayersTest() {		
		Collection<GamePlayer> players = new ArrayList<GamePlayer>();
		players.add(gotStriker);
		players.add(gotGoalkeeper);

		//there is a Collection of players. Check they are equal
		assertEquals(players, PlayerCollectionTester.getGamePlayers());
	}
	
	@Test
	public void gamePlayerIteratorTest() {
		PlayerCollection PlayerCollectionTester2 = new PlayerCollection();

		Collection<GamePlayer> players = new ArrayList<GamePlayer>();
		players.add(gotStriker);
		players.add(gotGoalkeeper);

//		PlayerCollectionIterator iteratePlayerCollection = new PlayerCollectionIterator(players);
		
		//check if size 0 and returns null
		assertEquals(null, PlayerCollectionTester2.iterator());
//		assertEquals(iteratePlayerCollection, PlayerCollectionTester.iterator());
	}

	@Test
	public void testSort() {
		Collection<GamePlayer> players = new ArrayList<GamePlayer>();
		players.add(gotStriker);
		players.add(gotGoalkeeper);
		Collections.sort((List<GamePlayer>) players);
		
		// Call the sort method
		PlayerCollectionTester.sort();
		Collection<GamePlayer> sortedList = new ArrayList<GamePlayer>();
		sortedList.addAll(PlayerCollectionTester.getGamePlayers());

		assertEquals(players, sortedList);
	}
}
