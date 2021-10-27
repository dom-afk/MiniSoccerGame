package model.players;

import java.util.Random;

//import javafx.scene.paint.Color;
import java.awt.Color;

public class PlayerFactory {
	
		private Random ran;
		
		final private Color[] LIST_COL =
			{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA,
				Color.BLACK, Color.CYAN, Color.PINK};
		
		
		public PlayerFactory() {
			
			ran = new Random();
			
		}
		
		public GamePlayer getPlayer(String type) {
			if (type.equals("striker"))
				return new Striker("striker", LIST_COL[ran.nextInt(LIST_COL.length)]);
			else
				return new Goalkeeper("goalkeeper",(LIST_COL[ran.nextInt(LIST_COL.length)] ));
			
		}

	}

