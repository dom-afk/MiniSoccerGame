package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameListener implements KeyListener {

	private final GamePanel gamePanel;
	
	/*
	 * This is a constructor to set up a main game panel
	 * 
	 * @param panel The interface we set for the game
	 */
	public GameListener(GamePanel panel) {
		gamePanel = panel;
	}

	/*
	 * This method shows players' behaviors when typing keys
	 * 
	 * @param e This is the event of keys
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	/*
	 * This methods shows how players behave when pressing arrow keys or a space bar
	 * 
	 * @param e This is the event of keys
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		if (!soccerGame.isPaused() && !soccerGame.isOver()) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					soccerGame.getActivePlayer().moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					soccerGame.getActivePlayer().moveRight();
					break;
				case KeyEvent.VK_UP:
					soccerGame.getActivePlayer().moveUp();
					break;
				case KeyEvent.VK_DOWN:
					soccerGame.getActivePlayer().moveDown();
					break;
				case KeyEvent.VK_SPACE:
					if (soccerGame.getActivePlayer().isPlayerHasBall()) {
						soccerGame.getActivePlayer().shootBall();
					}
					break;
			}
		}
	}

	/*
	 * This method shows how players behave when we release keys
	 * 
	 * @param e This is the event of keys
	 */
	@Override
	public void keyReleased(KeyEvent e) {

	}
}
