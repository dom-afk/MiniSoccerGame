package model.players;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PlayerCollectionIterator implements Iterator<GamePlayer>{
	
	//List of players
    private List<GamePlayer> playerList;
    
    //index of element in list
    private int index = 0;

    /**
	 * This is a constructor to initialize a list
	 * 
	 * @param collection a colection of game players
	 */
    public PlayerCollectionIterator(Collection<GamePlayer> collection) {
    	this.playerList =  new ArrayList<GamePlayer>(collection);
    }
    
    /**
	 * This figures out whether there exists a next element in the list
	 * 
	 * @return true if a next element exists, otherwise false
	 */
	@Override
	public boolean hasNext() {
		return index < playerList.size();
	}

	/**
	 * This returns the next element in the list
	 * 
	 * @return a game player if exists
	 */
	@Override
	public GamePlayer next() {
		return playerList.get(index++);
	}

}
