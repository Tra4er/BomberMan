package com.bomberman.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.bomberman.objects.Bomberman;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 6822234907413574188L;

	private ScoreboardPanel scoreboardPanel;
	private GamePanel gamePanel;

	public Bomberman playerOne;
	public Bomberman playerTwo;

	public MainPanel() {

		setLayout(new BorderLayout());

		setScoreboardPanel();
		setGamePanel();
	}

	{
		playerOne = new Bomberman("Iilai");
		playerTwo = new Bomberman("Bomber");
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
	
	private void setScoreboardPanel() {
		scoreboardPanel = new ScoreboardPanel(this);
		add(scoreboardPanel, BorderLayout.NORTH);
	}
	
	private void setGamePanel() {
		gamePanel = new GamePanel();
		add(gamePanel, BorderLayout.CENTER);
	}

}
