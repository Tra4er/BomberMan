package com.bomberman.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 6822234907413574188L;
	
	private ScoreboardPanel scoreboardPanel;
	public JLabel playerName = new JLabel("Iilai");
	public JLabel playerScore = new JLabel("2000");
	public JLabel playerScore1 = new JLabel("2000");
	public JLabel playerScore2 = new JLabel("2000");
	public JLabel playerScore3 = new JLabel("2000");
	
	private String creator = "by Tra4er";

	public MenuPanel() {
		setLayout(new BorderLayout());
		scoreboardPanel = new ScoreboardPanel(this);
		add(scoreboardPanel, BorderLayout.NORTH);
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

}
