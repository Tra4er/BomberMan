package com.bomberman.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = -5908210750286572643L;

	public GamePanel() {
		setLayout(new BorderLayout());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g = (Graphics2D) g;

		g.setColor(new Color(212, 235, 210));
		g.fillRect(0, 0, MainFrame.DEFAULT_SCREEN_WIDTH, MainFrame.DEFAULT_SCREEN_HEIGHT);

		for (int i = 0; i < MainFrame.DEFAULT_BLOCK_NUMBER; i++) {
			for (int j = 0; j < MainFrame.DEFAULT_BLOCK_NUMBER; j++) {
				if (i == 0 || i == MainFrame.DEFAULT_BLOCK_NUMBER - 1 || j ==
					0 || j == MainFrame.DEFAULT_BLOCK_NUMBER - 1 || 
				   (i % 2 == 0 && j % 2 == 0)) {
					
					g.setColor(Color.GRAY);
					g.fillRect(i * MainFrame.DEFAULT_BLOCK, j * (MainFrame.DEFAULT_BLOCK - 2), MainFrame.DEFAULT_BLOCK,
							MainFrame.DEFAULT_BLOCK);

				}
			}
		}
	}
}
