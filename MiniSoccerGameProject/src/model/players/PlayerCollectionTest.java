package model.players;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.junit.jupiter.api.Test;

class PlayerCollectionTest{

	@Test
	public void getGamePlayerTest() {
		PlayerCollection PlayerCollectionTester = new PlayerCollection();

		GamePlayer gotStriker = new Striker("Striker", Color.RED);
		GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.BLACK);
		
		PlayerCollectionTester.add(gotStriker);
		PlayerCollectionTester.add(gotGoalkeeper);

		//there is a Collection of players. Check they are equal
		assertEquals(PlayerCollectionTester.get("Striker"), gotStriker);
		assertEquals(PlayerCollectionTester.get("Goalkeeper"), gotGoalkeeper);

		assertEquals(PlayerCollectionTester.get(""), null);
		assertEquals(PlayerCollectionTester.get(""), null);
	}
	

	@Test
	public void getCollectionOfGamePlayersTest() {
		PlayerCollection PlayerCollectionTester = new PlayerCollection();
		GamePlayer gotStriker = new Striker("Striker", Color.RED);
		GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.BLACK);
		
		PlayerCollectionTester.add(gotStriker);
		PlayerCollectionTester.add(gotGoalkeeper);
		

		Collection<GamePlayer> players = new ArrayList<GamePlayer>();
		players.add(gotStriker);
		players.add(gotGoalkeeper);

		//there is a Collection of players. Check they are equal
		assertEquals(PlayerCollectionTester.getGamePlayers(), players);
	}
	
	@Test
	public void gamePlayerIteratorTest() {
		PlayerCollection PlayerCollectionTester = new PlayerCollection();
		GamePlayer gotStriker = new Striker("Striker", Color.RED);
		GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.BLACK);
		
		PlayerCollectionTester.add(gotStriker);
		PlayerCollectionTester.add(gotGoalkeeper);
		
		
		Collection<GamePlayer> players1 = new ArrayList<GamePlayer>();
		Collection<GamePlayer> players2 = new ArrayList<GamePlayer>();
		players1.add(gotStriker);
		players1.add(gotGoalkeeper);

		PlayerCollectionIterator iteratePlayerCollection1 = new PlayerCollectionIterator(players1);

		
		//null
		assertEquals(null, PlayerCollectionTester.iterator());
	}

}
