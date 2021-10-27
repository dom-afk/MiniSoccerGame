package model.players;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerCollection implements Iterable<GamePlayer> {

	//List of players
    private List<GamePlayer> pList = new ArrayList<GamePlayer>(); 


	public void add(GamePlayer player) {
		pList.add(player);
	}

	public Iterator<GamePlayer> iterator() {
		return new PlayerCollectionIterator(pList);
	}
	
	//iterates through list, returns player with matching name
	public GamePlayer get(String name) {
		 for(GamePlayer gPlayer : pList) {
		        if(gPlayer.getPlayerName().equals(name)) {
		            return gPlayer;
		        }
		    }
		    return null;
	}

	public void sort() {
		// TODO Auto-generated method stub
		
	}
}
