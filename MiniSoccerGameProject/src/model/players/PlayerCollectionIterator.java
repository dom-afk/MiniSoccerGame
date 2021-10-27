package model.players;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerCollectionIterator implements Iterator<GamePlayer>{
	
	//List of players
    private List<GamePlayer> playerList = new ArrayList<GamePlayer>();
    
    //index of element in list
    private int index = 0;

    //constructor, initializes list
    public PlayerCollectionIterator( List<GamePlayer> list) {
    	this.playerList =  list;
    }
    
    //returns true if there exists a next element in the list
	@Override
	public boolean hasNext() {
		return index < playerList.size();
	}

	//returns next element in list
	@Override
	public GamePlayer next() {
		return playerList.get(index++);
	}

}
