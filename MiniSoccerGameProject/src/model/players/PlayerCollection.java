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
	
	/**
	 * This is a default constructor
	 */
	public PlayerCollection() {
		collection = new ArrayList<GamePlayer>();
		size = 0;
	}
	
	/**
	 * This returns a collection of game players
	 * 
	 * @return the collection of GamePlayers
	 */
	public Collection<GamePlayer> getGamePlayers() { 
		return collection; 
	}
	
	/**
	 * This adds a player to a collection and increment its size by one
	 * 
	 * @param player a GamePlayer to add
	 */
	public void add(GamePlayer player) {
		size++;
		collection.add(player);
	}

	/**
	 * This is an iterator for a collection with game players
	 * 
	 * @return null if there is no element in the collection,
	 * otherwise, return the instantiation of PlayerCollectionIterator
	 */
	public Iterator<GamePlayer> iterator() {
		if (size == 0) return null;
		return new PlayerCollectionIterator(collection);
	}
	
	/**
	 * This iterates through list and returns player with matching name
	 * 
	 * @param name a String describing the type of game player
	 * @return a game player if exists, otherwise, return null
	 */
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
