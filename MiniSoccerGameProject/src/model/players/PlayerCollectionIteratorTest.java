package model.players;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

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
}
