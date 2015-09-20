package com.bomberman.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ScoreboardPanel extends JPanel {

	private static final long serialVersionUID = -5566101902542874021L;
	
	private static final Border PADDING_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);

    private static final Border LINE_BORDER = BorderFactory.createLineBorder(Color.DARK_GRAY);
	
    
	public ScoreboardPanel(MainPanel menuPanel){
		
		JLabel playerOneName = new JLabel(menuPanel.playerOne.getName());
		JLabel playerOneScore = new JLabel(menuPanel.playerOne.getScore());
		JLabel playerScore1 = new JLabel("2000");
		JLabel playerTwoScore = new JLabel(menuPanel.playerTwo.getScore());
		JLabel playerTwoName = new JLabel(menuPanel.playerTwo.getName());
	
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		configLabels(menuPanel);
		
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
	
	private void configLabels(MainPanel menuPanel){
//		menuPanel.playerName.setBorder(BorderFactory.createCompoundBorder(LINE_BORDER, PADDING_BORDER));
	}
	
}
