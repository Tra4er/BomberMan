package com.bomberman.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.Stack;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.bomberman.objects.Bomberman;

public class GamePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -5908210750286572643L;
	
	private final int BLOCK_SPAWN = 50;
	
	private int[][] blocksArray = new int[MainFrame.DEFAULT_BLOCK_NUMBER][MainFrame.DEFAULT_BLOCK_NUMBER];
	
	private int bombsSet;
	
	public Bomberman playerOne;
	public Bomberman playerTwo;
	
	private Stack<Point2D.Double> bombStack = new Stack<Point2D.Double>();
	
	private final int DETONATE_TIME = 5000;
	public Timer timer = new Timer(DETONATE_TIME, this);

	public GamePanel() {
		setFocusable(true);
		addKeyListener(new KeyController());
		initPlayers();
		initBlocksArray();
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(212, 235, 210));
		g.fillRect(0, 0, MainFrame.DEFAULT_SCREEN_WIDTH, MainFrame.DEFAULT_SCREEN_HEIGHT);

		g.setColor(Color.GRAY);
		for (int i = 0; i < MainFrame.DEFAULT_BLOCK_NUMBER; i++) {
			for (int j = 0; j < MainFrame.DEFAULT_BLOCK_NUMBER; j++) {
				switch (blocksArray[i][j]) {
				case 0: g.setColor(new Color(0, 50, 50));
					break;
				case 1: g.setColor(new Color(0, 0, 0));
					break;
				case 2: g.setColor(new Color(0, 0, 255));
					break;
				case 3: g.setColor(new Color(255, 50, 50));
				}
				g.fillRect(i * MainFrame.DEFAULT_BLOCK, j * MainFrame.DEFAULT_BLOCK , MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK);
			}
		}
		
		g.setColor(Color.RED);
		g.fillRect(playerOne.getX() * MainFrame.DEFAULT_BLOCK, playerOne.getY() * MainFrame.DEFAULT_BLOCK, 40, 40);
		g.setColor(new Color(255, 255, 0));
		g.fillRect(playerTwo.getX() * MainFrame.DEFAULT_BLOCK, playerTwo.getY() * MainFrame.DEFAULT_BLOCK, 40, 40);
	}

	private void initPlayers() {
		playerOne = new Bomberman(1, 1, "Illai", blocksArray);
		playerTwo = new Bomberman(15, 15, "YR17", blocksArray);
	}
	
	private void initBlocksArray() {
		for (int i = 0; i < MainFrame.DEFAULT_BLOCK_NUMBER; i++) {
			for (int j = 0; j < MainFrame.DEFAULT_BLOCK_NUMBER; j++) {
				if (i == 0 || i == MainFrame.DEFAULT_BLOCK_NUMBER - 1 || j == 0
						|| j == MainFrame.DEFAULT_BLOCK_NUMBER - 1 || (i % 2 == 0 && j % 2 == 0)) {
					blocksArray[i][j] = 1;
				} else if(Math.random() * 100 > BLOCK_SPAWN && i + j > 3
						&& i + j < 2 * (MainFrame.DEFAULT_BLOCK_NUMBER - 3)
						) {
					blocksArray[i][j] = 2;
				}
				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(bombsSet > 0 && timer.isRepeats()) {
			System.out.println("Pasted \"if\" of isBombSet and TimerRepeats");
			playerOne.detonate(bombStack);
//			playerTwo.detonate(bombStack);
			bombsSet--;
			if(bombsSet == 0) timer.stop();
		}
		repaint();
	}
	

	private class KeyController extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			int keyID = e.getKeyCode();

			switch (keyID) {
			case KeyEvent.VK_W:
				playerOne.moveUp();
				repaint();
				break;
			case KeyEvent.VK_D:
				playerOne.moveRight();
				repaint();
				break;
			case KeyEvent.VK_S:
				playerOne.moveDown();
				repaint();
				break;
			case KeyEvent.VK_A:
				playerOne.moveLeft();
				repaint();
				break;
			case KeyEvent.VK_SPACE:
				playerOne.setBomb(bombStack);
				timer.start();
				bombsSet++;
				repaint();
				break;
				
				
				
			case KeyEvent.VK_UP:
				playerTwo.moveUp();
				repaint();
				break;
			case KeyEvent.VK_RIGHT:
				playerTwo.moveRight();
				repaint();
				break;
			case KeyEvent.VK_DOWN:
				playerTwo.moveDown();
				repaint();
				break;	
			case KeyEvent.VK_LEFT:
				playerTwo.moveLeft();
				repaint();
				break;
				
			case KeyEvent.VK_ENTER:
				playerTwo.setBomb(bombStack);
				timer.start();
				bombsSet++;
				repaint();
				break;
			}

		}
	}

}
