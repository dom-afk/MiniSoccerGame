package model.players;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PlayerCollection implements Iterable<GamePlayer> {

	//List of players
   // private List<GamePlayer> pList = new ArrayList<GamePlayer>(); 
	private int size;
	private Collection<GamePlayer> collection;
	
	public PlayerCollection() {
		collection = new ArrayList<GamePlayer>();
		size = 0;
	}
	
	public Collection<GamePlayer> getGamePlayers() { 
		return collection; 
	}
	
	public void add(GamePlayer player) {
		size++;
		collection.add(player);
	}

	
	public Iterator<GamePlayer> iterator() {
		if (size == 0) return null;
		return new PlayerCollectionIterator(collection);
	}
	
	//iterates through list, returns player with matching name
	public GamePlayer get(String name) {
		 for(GamePlayer gPlayer : collection) {
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
