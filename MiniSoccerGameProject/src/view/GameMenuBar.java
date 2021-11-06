package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameMenuBar extends JMenuBar {

	/*
	 * This is a constructor to set up a menu bar.
	 * 
	 * @param menubarListener This is the action for the menu bar
	 */
	public GameMenuBar(ActionListener menubarListener) {
		super();
		JMenu gameMenu = new JMenu("Game");
		gameMenu.add(createMenuItem("New game", "NEW", KeyEvent.VK_N, menubarListener));
		gameMenu.addSeparator();
		gameMenu.add(createMenuItem("Exit", "EXIT", KeyEvent.VK_Q, menubarListener));
		super.add(gameMenu);
		JMenu controlMenu = new JMenu("Control");
		controlMenu.add(createMenuItem("Pause", "PAUSE", KeyEvent.VK_P, menubarListener));
		controlMenu.add(createMenuItem("Resume", "RESUME", KeyEvent.VK_R, menubarListener));
		super.add(controlMenu);
	}

	/*
	 * This creates options in the menu bar.
	 * 
	 * @param text The text of each option we want to add
	 * @param actionCommand The command text to add
	 * @param accelerator The amount of accelerator
	 * @param listener The action to add
	 */
	private JMenuItem createMenuItem(String text, String actionCommand, int accelerator, ActionListener listener) {
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.setActionCommand(actionCommand);
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator, 0));
		return menuItem;
	}

}
