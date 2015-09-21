package com.bomberman.objects;

import java.awt.event.KeyEvent;

public class Bomberman {

	private int x;
	private int y;
	
	public boolean moveUp;
	public boolean moveRight;
	public boolean moveDown;
	public boolean moveLeft;

	private String name;
	private String bestTime;

	private int score = 0;
	private int lifes = 1;
	private int speed = 1; // Прибавляєм більший крок в пікселях
	private int firePower = 1;
	private int bombs = 1;
	
	
	
	

	public Bomberman() {
		this(1, 1, "Player");
	}

	public Bomberman(int x, int y) {
		this(x, y, "Player");
	}
	
	public Bomberman(String name){
		this(1, 1, name);
	}

	public Bomberman(int x, int y, String name) {
		this.setX(x);
		this.setY(y);
		this.setName(name);
	}
	
	
	
	public void stop(KeyEvent e) {
		int keyID = e.getKeyCode();
		
		switch (keyID) {
		case KeyEvent.VK_UP:
			moveUp = false;
			break;
		case KeyEvent.VK_RIGHT:
			moveRight = false;
			break;
		case KeyEvent.VK_DOWN:
			moveDown = false;
			break;
		case KeyEvent.VK_LEFT:
			moveLeft = false;
			break;
		}
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return "" + score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void move(KeyEvent e) {
		int keyID = e.getKeyCode();

		switch (keyID) {
		case KeyEvent.VK_UP:
			moveUp = true;
			break;
		case KeyEvent.VK_RIGHT:
			moveRight = true;
			break;
		case KeyEvent.VK_DOWN:
			moveDown = true;
			break;
		case KeyEvent.VK_LEFT:
			moveLeft = true;
			break;
		}
		
	}
}
