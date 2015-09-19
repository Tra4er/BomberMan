package com.bomberman.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class ScoreboardPanel extends JPanel {

	private static final long serialVersionUID = -5566101902542874021L;
	
	public ScoreboardPanel(MenuPanel menuPanel){
	
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
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
	
}
