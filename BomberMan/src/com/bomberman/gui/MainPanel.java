package com.bomberman.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bomberman.objects.Bomberman;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 6822234907413574188L;

	private ScoreboardPanel scoreboardPanel;

	public Bomberman playerOne;
	public Bomberman playerTwo;

	private String creator = "by Tra4er";

	public MainPanel() {

		setLayout(new BorderLayout());

		setScoreboardPanel();
	}

	{
		playerOne = new Bomberman("Iilai");
		playerTwo = new Bomberman("Bomber");
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g = (Graphics2D) g;

		g.setColor(new Color(212, 235, 210));
		g.fillRect(0, 0, MainFrame.DEFAULT_SCREEN_WIDTH, MainFrame.DEFAULT_SCREEN_HEIGHT);
		g.setColor(new Color(0, 0, 0));
		g.drawString(creator, 400, 400);

		for (int i = 0; i < 17; i++) {
			g.setColor(new Color(200, 20, 100));
			g.fillRect(i * MainFrame.DEFAULT_BLOCK, 0, MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK);
			g.fillRect(i * MainFrame.DEFAULT_BLOCK, 15 * MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK);
			g.setColor(new Color(0, 0, 0));
			g.drawLine(i * MainFrame.DEFAULT_BLOCK, 0, i * MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_SCREEN_HEIGHT);
//			if(i % 2 == 0){
//				g.fillRect(x, y, width, height);
//			}
		}
		
		for (int i = 0; i < 17; i++) {
			g.setColor(new Color(200, 20, 100));
			g.fillRect(0, i * MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK);
			g.fillRect(15 * MainFrame.DEFAULT_BLOCK, i * MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_BLOCK);
			g.setColor(new Color(0, 0, 0));
			if(i == 16) g.setColor(new Color(255, 0, 0));
			g.drawLine(0, i * MainFrame.DEFAULT_BLOCK, MainFrame.DEFAULT_SCREEN_WIDTH, i * MainFrame.DEFAULT_BLOCK );
		}
		
	}

	private void setScoreboardPanel() {
		scoreboardPanel = new ScoreboardPanel(this);
		add(scoreboardPanel, BorderLayout.NORTH);
	}

}
