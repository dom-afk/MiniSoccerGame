/**
 * 
 */
package model.players;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.nio.charset.Charset;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author gbemi
 *
 */
class PlayerFactoryTest {

	@Test
	void getPlayerFactoryTest() {
		PlayerFactory test = new PlayerFactory();
			
		GamePlayer gotStriker = new Striker("Striker", Color.RED);
		GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.BLACK);
		
		//Check if the Classes are equal
		assertEquals(test.getPlayer("Striker").getClass(), gotStriker.getClass());
		assertEquals(test.getPlayer("Goalkeeper").getClass(), gotGoalkeeper.getClass());
		
		//Check if the playerNames are equal
		assertEquals(test.getPlayer("Striker").getPlayerName(), gotStriker.getPlayerName());
		assertEquals(test.getPlayer("Goalkeeper").getPlayerName(), gotGoalkeeper.getPlayerName());

		//Check if the playerColours are equal
		assertEquals(test.getPlayer("Striker").getPlayerColor(), gotStriker.getPlayerColor());
		assertEquals(test.getPlayer("Goalkeeper").getPlayerColor(), gotGoalkeeper.getPlayerColor());

		
	}

}
