package com.bomberman.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.bomberman.util.RoundTimer;

public class ScoreboardPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -5566101902542874021L;
	
	private Image backgroundImage = new ImageIcon("res/ScoreBG.jpg").getImage();
	
	private final Border LABEL_BORDER = BorderFactory.createEmptyBorder(3, 3, 3, 3);
    private final Border MAIN_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN);
    private final Font FONT = new Font("Jokerman", Font.PLAIN, 14);
    
    private Timer timer = new Timer();
    private JLabel playerOneName;
    private JLabel playerOneScore;
    private RoundTimer roundTimer;
    private JLabel playerTwoScore;
    private JLabel playerTwoName;
	
    
	public ScoreboardPanel(GamePanel gamePanel){
		
		playerOneName = new JLabel(gamePanel.playerOne.getName());
		playerOneScore = new JLabel(gamePanel.playerOne.getScore());
		roundTimer = new RoundTimer(timer);
		playerTwoScore = new JLabel(gamePanel.playerTwo.getScore());
		playerTwoName = new JLabel(gamePanel.playerTwo.getName());
	
		setLayout(new GridBagLayout());
		GridBagConstraints gridBag = new GridBagConstraints();
		
		configLabels();
		
		gridBag.weightx = 1;
		gridBag.weighty = 1;
		
		gridBag.anchor = GridBagConstraints.PAGE_START;
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		add(playerOneName, gridBag);
		
		gridBag.anchor = GridBagConstraints.PAGE_START;
		gridBag.gridx = 1;
		gridBag.gridy = 0;
		add(playerOneScore, gridBag);
		
		gridBag.anchor = GridBagConstraints.CENTER;
		gridBag.gridx = 2;
		gridBag.gridy = 0;
		add(roundTimer, gridBag);
	
		gridBag.anchor = GridBagConstraints.PAGE_END;
		gridBag.gridx = 3;
		gridBag.gridy = 0;
		add(playerTwoScore, gridBag);
		
		gridBag.anchor = GridBagConstraints.PAGE_END;
		gridBag.gridx = 4;
		gridBag.gridy = 0;
		add(playerTwoName, gridBag);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, MainFrame.DEFAULT_SCREEN_WIDTH, 30, null);
	}
	
	private void configLabels(){
		playerOneName.setBorder(LABEL_BORDER);
		playerOneName.setFont(FONT);
		
		playerOneScore.setBorder(LABEL_BORDER);
		playerOneScore.setFont(FONT);
		
		roundTimer.setBorder(LABEL_BORDER);
//		roundTimer.setFont(FONT);
		
		playerTwoScore.setBorder(LABEL_BORDER);
		playerTwoScore.setFont(FONT);
		
		playerTwoName.setBorder(LABEL_BORDER);
		playerTwoName.setFont(FONT);
		
		setBorder(MAIN_BORDER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		playerOneScore.
	}
	
}
