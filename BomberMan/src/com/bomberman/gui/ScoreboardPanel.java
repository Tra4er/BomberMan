package com.bomberman.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ScoreboardPanel extends JPanel {

	private static final long serialVersionUID = -5566101902542874021L;
	
	private static final Border PADDING_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);

    private static final Border LINE_BORDER = BorderFactory.createLineBorder(Color.DARK_GRAY);
	
	public ScoreboardPanel(MainPanel menuPanel){
	
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		configLabels(menuPanel);
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 0;
		gc.gridy = 0;
		add(menuPanel.playerName, gc);
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(menuPanel.playerScore, gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 2;
		gc.gridy = 0;
		add(menuPanel.playerScore1, gc);
	
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 3;
		gc.gridy = 0;
		add(menuPanel.playerScore2, gc);
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 4;
		gc.gridy = 0;
		add(menuPanel.playerScore3, gc);
	}
	
	private void configLabels(MainPanel menuPanel){
		menuPanel.playerName.setBorder(BorderFactory.createCompoundBorder(LINE_BORDER, PADDING_BORDER));
	}
	
}
