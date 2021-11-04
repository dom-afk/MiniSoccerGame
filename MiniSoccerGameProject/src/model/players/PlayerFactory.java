package model.players;

import java.util.Random;

//import javafx.scene.paint.Color;
import java.awt.Color;

public class PlayerFactory {
			
		final private Color strikerRed = Color.RED;
		final private Color goalKeeperBlack = Color.BLACK;

		
		
		/**
		 * This is a default constructor
		 */
		public PlayerFactory() {
						
		}
		
		/**
		 * This returns an object, Striker if the String parameter is equal to "Striker"
		 * Otherwise, it returns an object, Goalkeeper
		 * 
		 * @param type a String describing the type of game player
		 * @return the object which is either Striker or Goalkeeper
		 */
		public GamePlayer getPlayer(String type) {
			if (type.equals("Striker"))
				return new Striker("Striker", strikerRed);
			else
				return new Goalkeeper("Goalkeeper", goalKeeperBlack);
			
		}

	}

