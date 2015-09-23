package com.bomberman.objects;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Bomb implements ActionListener {
	
	private int x;
	private int y;
	
//	private int number = 2;
	
	private int[][] blocksArray;
	
	private Timer timer;
	
	public Bomb(int x, int y, int[][] blocksArray) {
		this.blocksArray = blocksArray;
		this.x = x;
		this.y = y;
		blocksArray[x][y] = 3;
		timer = new Timer(3000, this);
		timer.start();
		System.out.println("Bomb is Set");	
	}
	
	public void detonate(){
		if(timer.isRepeats()) {
			blocksArray[x][y] = 0;
//			addBomb();
			timer.stop();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		detonate();
	}
}
