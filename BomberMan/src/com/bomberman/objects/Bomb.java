package com.bomberman.objects;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.bomberman.gui.GamePanel;


public class Bomb implements ActionListener {
	
	private int x;
	private int y;
	
	private int length = 2;
	
	private boolean up = true;
	private boolean right = true;
	private boolean down = true;
	private boolean left = true;
	
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
	
	public void detonate() {
		if(timer.isRepeats()) {
			bomberman.bombs++;
			blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			
			for(int i = 0; i <= length; i++) {
				if(up && y - i > 0){
					if(blocksArray[x][y - i] != GamePanel.STATIC_BLOCK){
						if(blocksArray[x][y - i] == GamePanel.DESTROYED_BLOCK){
							blocksArray[x][y - i] = GamePanel.EMPTY_BLOCK;
							up = false;	
	//						bomberman.lifes--;
						}
					} else up = false;
				}
				if(right && x + i > 0){
					if(blocksArray[x + i][y] != GamePanel.STATIC_BLOCK){
						if(blocksArray[x + i][y] == GamePanel.DESTROYED_BLOCK){
							blocksArray[x + i][y] = GamePanel.EMPTY_BLOCK;
							right = false;	
	//						bomberman.lifes--;
						}
					} else right = false;
				}
				if(down && y + i > 0) {
					if(blocksArray[x][y + i] != GamePanel.STATIC_BLOCK){
						if(blocksArray[x][y + i] == GamePanel.DESTROYED_BLOCK){
							blocksArray[x][y + i] = GamePanel.EMPTY_BLOCK;
							down = false;	
	//						bomberman.lifes--;
						} 
					} else down = false;
				}
				if(left && x - i > 0){
					if(blocksArray[x - i][y] != GamePanel.STATIC_BLOCK){
						if(blocksArray[x - i][y] == GamePanel.DESTROYED_BLOCK){
							blocksArray[x - i][y] = GamePanel.EMPTY_BLOCK;
							left = false;	
	//						bomberman.lifes--;
						} 
					} else left = false;
				}
			}
			timer.stop();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		detonate();
	}
}
