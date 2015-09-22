package com.bomberman.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ScoreboardPanel extends JPanel {

	private static final long serialVersionUID = -5566101902542874021L;
	
	private final Border LABEL_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private final Border MAIN_BORDER = BorderFactory.createMatteBorder(2, 2, 3, 2, Color.GREEN);
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
		GridBagConstraints gc = new GridBagConstraints();
		
		configLabels();
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 0;
		gc.gridy = 0;
		add(playerOneName, gc);
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(playerOneScore, gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 2;
		gc.gridy = 0;
		add(playerScore1, gc);
	
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 3;
		gc.gridy = 0;
		add(playerTwoScore, gc);
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 4;
		gc.gridy = 0;
		add(playerTwoName, gc);
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
