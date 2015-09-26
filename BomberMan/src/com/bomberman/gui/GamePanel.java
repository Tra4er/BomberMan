package com.bomberman.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.bomberman.objects.Bomberman;

public class GamePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -5908210750286572643L;

	private final int BLOCK_SPAWN = 50;

	public static final int EMPTY_BLOCK = 0;
	public static final int DESTROYED_BLOCK = 1;
	public static final int STATIC_BLOCK = 2;
	public static final int BOMB_BLOCK = 3;
	public static final int BONUS_BLOCK = -1;
	public static final int FIRE_BLOCK = -2;

	private int[][] blocksArray = new int[MainFrame.DEFAULT_BLOCK_NUMBER][MainFrame.DEFAULT_BLOCK_NUMBER];
	private int[][] bonusArray = new int[MainFrame.DEFAULT_BLOCK_NUMBER][MainFrame.DEFAULT_BLOCK_NUMBER];

	public Bomberman playerOne;
	public Bomberman playerTwo;

	private Image playerOneImage = new ImageIcon("res/PinkBomberman.png").getImage();
	private Image playerTwoImage = new ImageIcon("res/YellowBomberman.png").getImage();

	private Image emptyBlockImage = new ImageIcon("res/EmptyBlock.jpg").getImage();
	private Image destroyedBlockImage = new ImageIcon("res/DestroyedBlock.jpg").getImage();
	private Image staticBlockImage = new ImageIcon("res/StaticBlock.jpg").getImage();
	private Image bombImage = new ImageIcon("res/Bomb.png").getImage();

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
				case EMPTY_BLOCK:
					g.drawImage(emptyBlockImage, i * MainFrame.DEFAULT_BLOCK, j * MainFrame.DEFAULT_BLOCK,
							MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK, null);
					break;
				case DESTROYED_BLOCK:
					g.drawImage(destroyedBlockImage, i * MainFrame.DEFAULT_BLOCK, j * MainFrame.DEFAULT_BLOCK,
							MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK, null);
					break;
				case STATIC_BLOCK:
					g.drawImage(staticBlockImage, i * MainFrame.DEFAULT_BLOCK, j * MainFrame.DEFAULT_BLOCK,
							MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK, null);
					break;
				case BOMB_BLOCK:
					g.drawImage(bombImage, i * MainFrame.DEFAULT_BLOCK, j * MainFrame.DEFAULT_BLOCK,
							MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK, null);
					break;
				case FIRE_BLOCK:
					g.setColor(Color.RED);
					g.fillRect(i * MainFrame.DEFAULT_BLOCK, j * MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK,
							MainFrame.DEFAULT_BLOCK);
					break;
				}
			}
		}

		g.drawImage(playerOneImage, playerOne.getX() * MainFrame.DEFAULT_BLOCK,
				playerOne.getY() * MainFrame.DEFAULT_BLOCK, 40, 40, null);
		g.drawImage(playerTwoImage, playerTwo.getX() * MainFrame.DEFAULT_BLOCK,
				playerTwo.getY() * MainFrame.DEFAULT_BLOCK, 40, 40, null);
		repaint();
	}

	private void initPlayers() {
		playerOne = new Bomberman(1, 1, "Illai", blocksArray);
		playerOne.setFirePower(1);
		playerTwo = new Bomberman(15, 15, "YR17", blocksArray);
	}

	private void initBlocksArray() {
		for (int i = 0; i < MainFrame.DEFAULT_BLOCK_NUMBER; i++) {
			for (int j = 0; j < MainFrame.DEFAULT_BLOCK_NUMBER; j++) {
				if (i == 0 || i == MainFrame.DEFAULT_BLOCK_NUMBER - 1 || j == 0
						|| j == MainFrame.DEFAULT_BLOCK_NUMBER - 1 || (i % 2 == 0 && j % 2 == 0)) {
					blocksArray[i][j] = STATIC_BLOCK;
				} else if (Math.random() * 100 > BLOCK_SPAWN && i + j > 3
						&& i + j < 2 * (MainFrame.DEFAULT_BLOCK_NUMBER - 3)) {
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
				if (playerOne.bombs > 0) {
					playerOne.setBomb(playerTwo);
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
				if (playerTwo.bombs > 0) {
					playerTwo.setBomb(playerOne);
					playerTwo.bombs--;
					repaint();
				}
				break;
			}

		}
	}

}
