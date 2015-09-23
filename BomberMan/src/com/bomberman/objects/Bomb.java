package com.bomberman.objects;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Bomb implements ActionListener {
	
	private int x;
	private int y;
	
	private int[][] blocksArray;
	
	private Timer timer;
	
	public Bomb(int x, int y, int[][] blocksArray) {
		this.blocksArray = blocksArray;
		this.x = x;
		this.y = y;
		blocksArray[x][y] = 3;
		timer = new Timer(3000, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(timer.isRepeats()) {
			Bomberman.bombs++;
			blocksArray[x][y] = 0;
			blocksArray[x+1][y] = 0;
			blocksArray[x-1][y] = 0;
			blocksArray[x][y+1] = 0;
			blocksArray[x][y-1] = 0;
			timer.stop();
		}
	}
}
