package com.bomberman.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	
	private JMenu game;
	private JMenuItem close;
	private JMenuItem restart;
	
	private JMenu players;
	private JMenuItem changeNames;
	
	private MainPanel mainPanel = new MainPanel();

	public static final int DEFAULT_BLOCK = 40;
	public static final int DEFAULT_BLOCK_NUMBER = 17;
	public static final int DEFAULT_SCREEN_WIDTH = 696;
	public static final int DEFAULT_SCREEN_HEIGHT = 772;

	public MainFrame(String title) {

		super(title);

		initMainFrame();
		initBarMenu();

		add(mainPanel);
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
		restart = new JMenuItem("Restart");
		close = new JMenuItem("Close");
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.remove(mainPanel);
				mainPanel = new MainPanel();
				MainFrame.this.add(mainPanel);
			}

		});
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
			}

		});
		game.add(restart);
		game.add(close);
		menuBar.add(game);
		
		players = new JMenu("Players");
		changeNames = new JMenuItem("Change Names");
		players.add(changeNames);
		menuBar.add(players);
		
		setJMenuBar(menuBar);
	}

}
