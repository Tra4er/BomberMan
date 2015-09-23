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
	
	public static final int EMPTY_BLOCK = 0;
	public static final int DESTROYED_BLOCK = 1;
	public static final int STATIC_BLOCK = 2;
	public static final int BOMB_BLOCK = 3;
	public static final int BONUS_BLOCK = -1;
	
	private int[][] blocksArray = new int[MainFrame.DEFAULT_BLOCK_NUMBER][MainFrame.DEFAULT_BLOCK_NUMBER];
	
	public Bomberman playerOne;
	public Bomberman playerTwo;
	
	public static Stack<Point2D.Double> bombStack = new Stack<Point2D.Double>();
	
	private final int DETONATE_TIME = 100;
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
		if(playerOne.getLifes() < 1) System.out.println("DEAD");
		g.setColor(new Color(212, 235, 210));
		g.fillRect(0, 0, MainFrame.DEFAULT_SCREEN_WIDTH, MainFrame.DEFAULT_SCREEN_HEIGHT);

		g.setColor(Color.GRAY);
		for (int i = 0; i < MainFrame.DEFAULT_BLOCK_NUMBER; i++) {
			for (int j = 0; j < MainFrame.DEFAULT_BLOCK_NUMBER; j++) {
				switch (blocksArray[i][j]) {
				case EMPTY_BLOCK: g.setColor(new Color(0, 50, 50));
					break;
				case DESTROYED_BLOCK: g.setColor(new Color(0, 0, 255));
					break;
				case STATIC_BLOCK: g.setColor(new Color(0, 0, 0));
					break;
				case BOMB_BLOCK: g.setColor(new Color(0, 200, 100));
					break;
				}
				g.fillRect(i * MainFrame.DEFAULT_BLOCK, j * MainFrame.DEFAULT_BLOCK , MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK);
			}
		}
		
		g.setColor(Color.RED);
		g.fillRect(playerOne.getX() * MainFrame.DEFAULT_BLOCK, playerOne.getY() * MainFrame.DEFAULT_BLOCK, 40, 40);
		g.setColor(new Color(255, 255, 0));
		g.fillRect(playerTwo.getX() * MainFrame.DEFAULT_BLOCK, playerTwo.getY() * MainFrame.DEFAULT_BLOCK, 40, 40);
		repaint();
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
					blocksArray[i][j] = STATIC_BLOCK;
				} else if(Math.random() * 100 > BLOCK_SPAWN && i + j > 3
						&& i + j < 2 * (MainFrame.DEFAULT_BLOCK_NUMBER - 3)
						) {
					blocksArray[i][j] = DESTROYED_BLOCK;
				}
				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
				if(playerOne.bombs > 0){
					playerOne.setBomb();
					playerOne.bombs--;
					repaint();
				}
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
				if(playerTwo.bombs > 0){
					playerTwo.setBomb();
					playerTwo.bombs--;
					repaint();
				}
				break;
			}

		}
	}

}
