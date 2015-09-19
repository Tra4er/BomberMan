package com.bomberman;

import javax.swing.SwingUtilities;

import com.bomberman.gui.MainFrame;
import com.bomberman.gui.MenuPanel;

public class Game {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mainFrame = new MainFrame("BomberMan");
				mainFrame.setVisible(true);
			}
		});

	}

}
