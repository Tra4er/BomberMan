package com.bomberman.objects;

import java.util.ArrayList;


public class Bomberman {

	private int x;
	private int y;
	
	public static int[][] blocksArray;
	
	private String name;
	private String bestTime;
	
	public ArrayList<Bomb> bombsList;
	
	private int score = 0;
	private int lifes = 1;
	private int speed = 4;
	private int firePower = 1;
	private int bombs = 3;
	

	public Bomberman() {
		this(1, 1, "Player", blocksArray);
	}

	public Bomberman(int x, int y) {
		this(x, y, "Player", blocksArray);
	}
	
	public Bomberman(String name){
		this(1, 1, name, blocksArray);
	}
	
	public Bomberman(int[][] blocksArray) {
		this(1, 1, "Player", blocksArray);
	}

	public Bomberman(int x, int y, String name, int[][] blocksArray) {
		this.setX(x);
		this.setY(y);
		this.setName(name);
		this.blocksArray = blocksArray;
	}
	
	public void moveUp() {
		if(y > 1 && x % 2 == 1 && blocksArray[x][y - 1] < 1){
			y--;
		}
	}
	
	public void moveRight() {
		if(x < 15 && y % 2 == 1 && blocksArray[x + 1][y] < 1 ){
			x++;
		}
	}
	
	public void moveDown() {
		if(y < 15 && x % 2 == 1 && blocksArray[x][y + 1] < 1){
			y++;
		}
	}
	
	public void moveLeft() {
		if(x > 1 && y % 2 == 1 && blocksArray[x - 1][y] < 1) {
			x--;
		}
	}
	
	public void setBomb() {
		bombsList.add(new Bomb(x, y, blocksArray));
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
