package com.bomberman.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 6822234907413574188L;

	private ScoreboardPanel scoreboardPanel;
	private GamePanel gamePanel;

	public MainPanel() {

		setLayout(new BorderLayout());

		setGamePanel();
		setScoreboardPanel();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	private void setScoreboardPanel() {
		scoreboardPanel = new ScoreboardPanel(gamePanel);
		add(scoreboardPanel, BorderLayout.NORTH);
	}

	private void setGamePanel() {
		gamePanel = new GamePanel();
		add(gamePanel, BorderLayout.CENTER);
	}
	
	public String getPlayerOneName() {
		return gamePanel.playerOne.getName();
	}
	
	public void setPlayerOneName(String name) {
		gamePanel.playerOne.setName(name);
	}
	
	public String getPlayerTwoName() {
		return gamePanel.playerTwo.getName();
	}
	
	public void setPlayerTwoName(String name) {
		gamePanel.playerTwo.setName(name);
	}
	
	public void updateScoreboard() {
		scoreboardPanel.repaint();
	}
	
	

}
