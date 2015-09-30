package com.bomberman.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public static final int GAME_STATE = -5;

	private int gameState = GAME_STATE;

	private JMenuBar menuBar;

	private JMenu game;
	private JMenuItem close;
	private JMenuItem restart;

	private JMenu players;
	private JMenuItem changeFirstPlayerName;
	private JMenuItem changeSecondPlayerName;

	private MainPanel mainPanel = new MainPanel();

	private Thread thread = new Thread(this);

	public static final int DEFAULT_BLOCK = 40;
	public static final int DEFAULT_BLOCK_NUMBER = 17;
	public static final int DEFAULT_SCREEN_WIDTH = 686;
	public static final int DEFAULT_SCREEN_HEIGHT = 761;

	public MainFrame(String title) {

		super(title);

		initMainFrame();
		initBarMenu();

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

	private void initBarMenu() {

		menuBar = new JMenuBar();

		game = new JMenu("Game");
		game.setFont(new Font("Jokerman", Font.ITALIC, 12));
		game.setForeground(Color.RED);
		
		restart = new JMenuItem("Restart");
		close = new JMenuItem("Close");
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.remove(mainPanel);
				mainPanel = new MainPanel();
				MainFrame.this.add(mainPanel);
				mainPanel.setFocusOnGame();
			}

		});

		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		game.add(restart);
		game.add(close);
		menuBar.add(game);

		players = new JMenu("Players");
		players.setFont(new Font("Jokerman", Font.ITALIC, 13));
		players.setForeground(Color.RED);
		
		changeFirstPlayerName = new JMenuItem("Change First Player Name");
		changeFirstPlayerName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setPlayerOneName(JOptionPane.showInputDialog(null, "First player Name: ",
						mainPanel.getPlayerOneName(), JOptionPane.PLAIN_MESSAGE));
				mainPanel.updateScoreboard();
			}
		});
		changeSecondPlayerName = new JMenuItem("Change Second Player Name");
		changeSecondPlayerName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setPlayerTwoName(JOptionPane.showInputDialog(null, "Second player Name: ",
						mainPanel.getPlayerTwoName(), JOptionPane.PLAIN_MESSAGE));
			}
		});

		players.add(changeFirstPlayerName);
		players.add(changeSecondPlayerName);
		menuBar.add(players);

		setJMenuBar(menuBar);
	}

	private boolean isSomePlayerDead() {
			while (mainPanel.isPlayerOneDead() || mainPanel.isPlayerTwoDead()) {
				if (mainPanel.isPlayerOneDead()) {
					gameState = JOptionPane.showConfirmDialog(null, "Player Two is WIN\nRestart game?", "GAME OVER",
							JOptionPane.YES_NO_OPTION);
					return true;
				} else if(mainPanel.isPlayerTwoDead()){
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
				MainFrame.this.remove(mainPanel);
				mainPanel = new MainPanel();
				MainFrame.this.add(mainPanel);
				mainPanel.setFocusOnGame();
				gameState = GAME_STATE;
			} else if (gameState == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
	}

	@Override
	public void run() {
		while (true) {
			if(isSomePlayerDead()) 
				changeGameState();
		}
	}
}
