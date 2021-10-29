package model.players;

import java.util.Random;

//import javafx.scene.paint.Color;
import java.awt.Color;

public class PlayerFactory {
	
		private Random ran;
		
		final private Color[] LIST_COL =
			{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA,
				Color.BLACK, Color.CYAN, Color.PINK};
		
		/**
		 * This is a default constructor
		 */
		public PlayerFactory() {
			
			ran = new Random();
			
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
				return new Striker("Striker", LIST_COL[ran.nextInt(LIST_COL.length)]);
			else
				return new Goalkeeper("Goalkeeper",(LIST_COL[ran.nextInt(LIST_COL.length)] ));
			
		}

	}

