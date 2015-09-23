package com.bomberman.objects;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.bomberman.gui.GamePanel;


public class Bomb implements ActionListener {
	
	private int x;
	private int y;
	
	private int[][] blocksArray;
	
	private Bomberman bomberman;
	
	private Timer timer;
	
	public Bomb(int x, int y, int[][] blocksArray, Bomberman bomberman) {
		this.x = x;
		this.y = y;
		this.blocksArray = blocksArray;
		this.bomberman = bomberman;
		blocksArray[x][y] = GamePanel.BOMB_BLOCK;
		timer = new Timer(3000, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(timer.isRepeats()) {
			int pX = bomberman.getX();
			int pY = bomberman.getY();
			bomberman.bombs++;
			blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
//			if(pX ){
//			if((pX >= x - 1 && pX <= x + 1) || (pY >= y - 1 && pY <= y + 1)) bomberman.lifes--;
//		}
//			Не баг а фіча
			if(blocksArray[x+1][y] != GamePanel.STATIC_BLOCK) blocksArray[x+1][y] = GamePanel.EMPTY_BLOCK;
			if(blocksArray[x-1][y] != GamePanel.STATIC_BLOCK) blocksArray[x-1][y] = GamePanel.EMPTY_BLOCK;
			if(blocksArray[x][y+1] != GamePanel.STATIC_BLOCK) blocksArray[x][y+1] = GamePanel.EMPTY_BLOCK;
			if(blocksArray[x][y-1] != GamePanel.STATIC_BLOCK) blocksArray[x][y-1] = GamePanel.EMPTY_BLOCK;
			timer.stop();
		}
	}
}
