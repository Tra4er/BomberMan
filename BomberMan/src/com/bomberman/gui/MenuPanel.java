package com.bomberman.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int state = 0;
	
	private String creator = "by Tra4er";
	
	private JButton newGameButton;
	private JButton settingsButton;
	private JButton exitGameButton;
	
	private Image img = new ImageIcon("res/Bomberman.gif").getImage();
	

	public MenuPanel() {
		
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPanel.this.removeAll();
				MenuPanel.this.img = null;
				MenuPanel.this.creator = "";
				repaint();
			}
		});
		add(newGameButton);
		
		settingsButton = new JButton("Settings");
		settingsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				state = 2;
				
			}
		});
		add(settingsButton);
		
		exitGameButton = new JButton("Exit Game");
		exitGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(exitGameButton);
		
	}

	public void paint(Graphics g) {
		g.setColor(new Color(212, 235, 210));
		g.fillRect(0, 0, MainFrame.STANDART_SCREEN_WIDTH, MainFrame.STANDART_SCREEN_HEIGHT);
		g = (Graphics2D) g;
		g.drawImage(img, 0, 0, null);
		g.setColor(new Color(0, 0, 0));
		g.drawString(creator, 400, 450);
	}

	public int getState() {
		return state;
	}

}
