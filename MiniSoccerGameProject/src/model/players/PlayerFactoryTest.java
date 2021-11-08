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
public class PlayerFactoryTest {

	@Test
	public void getPlayerFactoryTest() {
		PlayerFactory test = new PlayerFactory();
			
		GamePlayer gotStriker = new Striker("Striker", Color.RED);
		GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.BLACK);
		
		//Check if the Classes are equal
		assertEquals(gotStriker.getClass(), test.getPlayer("Striker").getClass());
		assertEquals(gotGoalkeeper.getClass(), test.getPlayer("Goalkeeper").getClass());
		
		//Check if the playerNames are equal
		assertEquals(gotStriker.getPlayerName(), test.getPlayer("Striker").getPlayerName());
		assertEquals(gotGoalkeeper.getPlayerName(), test.getPlayer("Goalkeeper").getPlayerName());

		//Check if the playerColours are equal
		assertEquals(gotStriker.getPlayerColor(), test.getPlayer("Striker").getPlayerColor());
		assertEquals(gotGoalkeeper.getPlayerColor(), test.getPlayer("Goalkeeper").getPlayerColor());
		
	}

}
