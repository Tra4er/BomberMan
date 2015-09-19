package com.bomberman.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 6822234907413574188L;

	private ScoreboardPanel scoreboardPanel;

	// TODO Change and remove ////////////////////
	public JLabel playerName = new JLabel("Iilai");
	public JLabel playerScore = new JLabel("2000");
	public JLabel playerScore1 = new JLabel("2000");
	public JLabel playerScore2 = new JLabel("2000");
	public JLabel playerScore3 = new JLabel("2000");

	private String creator = "by Tra4er";

	public MainPanel() {

		setLayout(new BorderLayout());

		setScoreboardPanel();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g = (Graphics2D) g;

		g.setColor(new Color(212, 235, 210));
		g.fillRect(0, 0, MainFrame.STANDART_SCREEN_WIDTH, MainFrame.STANDART_SCREEN_HEIGHT);
		g.setColor(new Color(0, 0, 0));
		g.drawString(creator, 400, 450);
	}

	private void setScoreboardPanel() {
		scoreboardPanel = new ScoreboardPanel(this);
		add(scoreboardPanel, BorderLayout.NORTH);
	}

}
