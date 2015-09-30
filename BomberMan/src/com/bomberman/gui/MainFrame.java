package com.bomberman.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bomberman.util.FileWorker;

public class MainFrame extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int GAME_STATE = -5;

	private int gameState = GAME_STATE;

	private MainPanel mainPanel = new MainPanel();

	private GameMenuBar menuBar = new GameMenuBar(this, mainPanel);

	private Thread thread = new Thread(this);

	public static final int DEFAULT_BLOCK = 40;
	public static final int DEFAULT_BLOCK_NUMBER = 17;
	public static final int DEFAULT_SCREEN_WIDTH = 686;
	public static final int DEFAULT_SCREEN_HEIGHT = 761;

	public MainFrame(String title) {

		super(title);

		initMainFrame();
		menuBar.initBarMenu();

		add(mainPanel);

		thread.start();
	}

	private void initMainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dem = kit.getScreenSize();

		Image icon = new ImageIcon("res/Bomb.png").getImage();
		setIconImage(icon);

		setLocation(dem.width / 5, 0);
		setSize(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private boolean isSomePlayerDead() {
		while (mainPanel.isPlayerOneDead() || mainPanel.isPlayerTwoDead()) {
			if (mainPanel.isPlayerOneDead()) {
				gameState = JOptionPane.showConfirmDialog(null, "Player Two is WIN\nRestart game?", "GAME OVER",
						JOptionPane.YES_NO_OPTION);
				return true;
			} else if (mainPanel.isPlayerTwoDead()) {
				gameState = JOptionPane.showConfirmDialog(null, "Player One is WIN\nRestart game?", "GAME OVER",
						JOptionPane.YES_NO_OPTION);
				return true;
			} else {
				gameState = JOptionPane.showConfirmDialog(null, "You both is Dead\nRestart game?", "GAME OVER",
						JOptionPane.YES_NO_OPTION);
			}
		}
		return false;
	}

	private void changeGameState() {
		if (gameState == JOptionPane.YES_OPTION) {
			MainFrame.this.remove(mainPanel);// TODO
			mainPanel = new MainPanel();
			MainFrame.this.add(mainPanel);
			mainPanel.setFocusOnGame();
			gameState = GAME_STATE;
		} else if (gameState == JOptionPane.NO_OPTION) {
			System.exit(0);
		}
	}

	private void savePlayersData() {
		mainPanel.getPlayerOne().saveBestAchievements();
		mainPanel.getPlayerTwo().saveBestAchievements();

		FileWorker.write("saves/playerOne", mainPanel.getPlayerOne().getName(), mainPanel.getPlayerOne().getBestScore(),
				mainPanel.getPlayerOne().getBestTime());
		FileWorker.write("saves/playerTwo", mainPanel.getPlayerTwo().getName(), mainPanel.getPlayerTwo().getBestScore(),
				mainPanel.getPlayerTwo().getBestTime());
	}

	@Override
	public void run() {
		while (true) {
			if (isSomePlayerDead()) {
				savePlayersData();
				changeGameState();
			}
		}
	}
}
