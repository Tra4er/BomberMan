package com.bomberman.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.bomberman.model.Bomberman;

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
	
	public Bomberman getPlayerOne(){
		return gamePanel.playerOne;
	}
	
	public Bomberman getPlayerTwo(){
		return gamePanel.playerTwo;
	}

	public void updateScoreboard() {
		scoreboardPanel.repaint();
	}
	
	public void setFocusOnGame() {
		gamePanel.requestFocus();
	}
	
	public synchronized boolean isPlayerOneDead() {
		return gamePanel.playerOne.dead;
	}
	
	public synchronized boolean isPlayerTwoDead() {
		return gamePanel.playerTwo.dead;
	}
	
	
	

}
