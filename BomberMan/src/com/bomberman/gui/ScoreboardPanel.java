package com.bomberman.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ScoreboardPanel extends JPanel {

	private static final long serialVersionUID = -5566101902542874021L;
	
	private Image backgroundImage = new ImageIcon("res/ScoreBG.jpg").getImage();
	
	private final Border LABEL_BORDER = BorderFactory.createEmptyBorder(3, 3, 3, 3);
    private final Border MAIN_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN);
    private final Font FONT = new Font("Jokerman", Font.PLAIN, 14);
    
    private JLabel playerOneName;
    private JLabel playerOneScore;
    private JLabel playerScore1;
    private JLabel playerTwoScore;
    private JLabel playerTwoName;
	
    
	public ScoreboardPanel(GamePanel gamePanel){
		
		
		playerOneName = new JLabel(gamePanel.playerOne.getName());
		playerOneScore = new JLabel(gamePanel.playerOne.getScore());
		playerScore1 = new JLabel("2000");
		playerTwoScore = new JLabel(gamePanel.playerTwo.getScore());
		playerTwoName = new JLabel(gamePanel.playerTwo.getName());
	
		setLayout(new GridBagLayout());
		GridBagConstraints gridBag = new GridBagConstraints();
		
		configLabels();
		
		gridBag.weightx = 1;
		gridBag.weighty = 1;
		
		gridBag.anchor = GridBagConstraints.LINE_START;
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		add(playerOneName, gridBag);
		
		gridBag.anchor = GridBagConstraints.LINE_START;
		gridBag.gridx = 1;
		gridBag.gridy = 0;
		add(playerOneScore, gridBag);
		
		gridBag.anchor = GridBagConstraints.CENTER;
		gridBag.gridx = 2;
		gridBag.gridy = 0;
		add(playerScore1, gridBag);
	
		gridBag.anchor = GridBagConstraints.LINE_END;
		gridBag.gridx = 3;
		gridBag.gridy = 0;
		add(playerTwoScore, gridBag);
		
		gridBag.anchor = GridBagConstraints.LINE_END;
		gridBag.gridx = 4;
		gridBag.gridy = 0;
		add(playerTwoName, gridBag);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, MainFrame.DEFAULT_SCREEN_WIDTH, 30, null);
//		g.drawImage(backgroundImage, 0, 0, null);
	}
	
	private void configLabels(){
		playerOneName.setBorder(LABEL_BORDER);
		playerOneName.setFont(FONT);
		
		playerOneScore.setBorder(LABEL_BORDER);
		playerOneScore.setFont(FONT);
		
		playerScore1.setBorder(LABEL_BORDER);
		
		playerTwoScore.setBorder(LABEL_BORDER);
		playerTwoScore.setFont(FONT);
		
		playerTwoName.setBorder(LABEL_BORDER);
		playerTwoName.setFont(FONT);
		
		setBorder(MAIN_BORDER);
	}
	
}
