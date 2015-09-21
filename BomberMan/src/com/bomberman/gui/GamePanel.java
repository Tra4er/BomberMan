package com.bomberman.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import com.bomberman.objects.Bomberman;

public class GamePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -5908210750286572643L;

	public Bomberman playerOne;
	public Bomberman playerTwo;
	

	public GamePanel() {
		setFocusable(true);
		addKeyListener(new KeyController());
		initPlayers();
		setLayout(new BorderLayout());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// g = (Graphics2D) g;

		g.setColor(new Color(212, 235, 210));
		g.fillRect(0, 0, MainFrame.DEFAULT_SCREEN_WIDTH, MainFrame.DEFAULT_SCREEN_HEIGHT);

		g.setColor(Color.GRAY);
		for (int i = 0; i < MainFrame.DEFAULT_BLOCK_NUMBER; i++) {
			for (int j = 0; j < MainFrame.DEFAULT_BLOCK_NUMBER; j++) {
				if (i == 0 || i == MainFrame.DEFAULT_BLOCK_NUMBER - 1 || j == 0
						|| j == MainFrame.DEFAULT_BLOCK_NUMBER - 1 || (i % 2 == 0 && j % 2 == 0)) {
					g.fillRect(i * MainFrame.DEFAULT_BLOCK, j * (MainFrame.DEFAULT_BLOCK - 2), MainFrame.DEFAULT_BLOCK,
							MainFrame.DEFAULT_BLOCK);
				}

			}
		}

		g.setColor(Color.RED);
		g.fillRect(playerOne.getX() * MainFrame.DEFAULT_BLOCK, playerOne.getY() * MainFrame.DEFAULT_BLOCK, 40, 40);
	}

	private void initPlayers() {
		playerOne = new Bomberman();
		playerTwo = new Bomberman();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	private class KeyController extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			playerOne.move(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			playerOne.stop(e);
		}
	}

}
