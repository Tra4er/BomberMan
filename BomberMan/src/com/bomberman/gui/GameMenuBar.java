package com.bomberman.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GameMenuBar extends JMenuBar{

	private static final long serialVersionUID = 4102461562752304677L;
	
	private MainPanel mainPanel;
	private MainFrame mainFrame;
	
	private JMenuBar menuBar;

	private JMenu game;
	private JMenuItem close;
	private JMenuItem restart;

	private JMenu players;
	private JMenuItem changeFirstPlayerName;
	private JMenuItem changeSecondPlayerName;
	
	public GameMenuBar(MainFrame mainFrame, MainPanel mainPanel) {
		this.mainFrame = mainFrame;
		this.mainPanel = mainPanel;
	}
	
	public void initBarMenu() {

		menuBar = new JMenuBar();

		game = new JMenu("Game");
		game.setFont(new Font("Jokerman", Font.ITALIC, 12));
		game.setForeground(Color.RED);
		
		restart = new JMenuItem("Restart");
		close = new JMenuItem("Close");
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.remove(mainPanel);
				mainPanel = new MainPanel();
				mainFrame.add(mainPanel);
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
				mainPanel.getPlayerOne().setName(JOptionPane.showInputDialog(null, "First player Name: ",
						mainPanel.getPlayerOne().getName(), JOptionPane.PLAIN_MESSAGE));
				mainPanel.updateScoreboard();
			}
		});
		changeSecondPlayerName = new JMenuItem("Change Second Player Name");
		changeSecondPlayerName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.getPlayerTwo().setName(JOptionPane.showInputDialog(null, "Second player Name: ",
						mainPanel.getPlayerTwo().getName(), JOptionPane.PLAIN_MESSAGE));
			}
		});

		players.add(changeFirstPlayerName);
		players.add(changeSecondPlayerName);
		menuBar.add(players);
		
		mainFrame.setJMenuBar(menuBar);
	}
	
}
