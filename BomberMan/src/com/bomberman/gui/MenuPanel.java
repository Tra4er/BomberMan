package com.bomberman.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton newGameButton;
	private JButton settingsButton;
	private JButton exitGameButton;
	
	Image img = new ImageIcon("res/Bomberman.gif").getImage();

	public MenuPanel() {
		newGameButton = new JButton("New Game");
		add(newGameButton);
		settingsButton = new JButton("Settings");
		add(settingsButton);
		exitGameButton = new JButton("Exit Game");
		add(exitGameButton);
		
	}

	public void paint(Graphics g) {
		g = (Graphics2D) g;
		g.drawImage(img, 0, 0, null);
		g.setColor(new Color(212, 235, 210));
//		g.fillRect(0, 0, MainFrame.STANDART_SCREEN_WIDTH, MainFrame.STANDART_SCREEN_HEIGHT);

	}

}
