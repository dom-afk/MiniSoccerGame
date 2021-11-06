package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenubarListener implements ActionListener {

	private final GamePanel gamePanel;

	/*
	 * This is a constructor to add interface to the menu bar.
	 * 
	 * @param panel The interface to add
	 */
	public MenubarListener(GamePanel panel) {
		gamePanel = panel;
	}


	/*
	 * This method shows what actions will be taken when buttons on the menu bar are clicked.
	 * 
	 * @param e The action we took such as clicking one of menu bar buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		switch (e.getActionCommand()) {
			case "NEW":
				gamePanel.setupSoccerGame();
				break;
			case "EXIT":
				System.exit(0);
				break;
			case "PAUSE":
				if (!soccerGame.isPaused() && !soccerGame.isOver()) {
					soccerGame.setPaused(true);
				} else if (soccerGame.isPaused()) {
					System.out.println("game is already on pause!");
				} else if (soccerGame.isOver()) {
					System.out.println("game is over, please start a new game.");
				}
				break;
			case "RESUME":
				if (soccerGame.isPaused() && !soccerGame.isOver()) {
					soccerGame.setPaused(false);
				} else if (!soccerGame.isPaused()) {
					System.out.println("game is already running!");
				} else if (soccerGame.isOver()) {
					System.out.println("game is over, please start a new game.");
				}
				break;
			default:
				throw new RuntimeException("Invalid action command " + e.getActionCommand());
		}
	}
}
