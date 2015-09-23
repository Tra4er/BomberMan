package com.bomberman.objects;

import java.awt.geom.Point2D;
import java.util.Stack;


public class Bomberman {

	private int x;
	private int y;
	
	private static int[][] blocksArray;
	
	private String name;
	private String bestTime;
	
	private int score = 0;
	private int lifes = 1;
	private int speed = 4;
	private int firePower = 1;
	private int bombs = 1;
	

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
	
	public void setBomb(Stack<Point2D.Double> bombStack) {
		if(bombs > 0){
			blocksArray[x][y] = 3;
			bombs--;
			bombStack.push(new Point2D.Double((double)x, (double)y));
		}
	}
	
	public void addBomb(){
		bombs++;
	}
	
	public void detonate(Stack<Point2D.Double> bombStack){
		addBomb();
		if(!bombStack.isEmpty()){
			Point2D point = bombStack.pop();
			blocksArray[(int)point.getX()][(int)point.getY()] = 0;
		}
		System.out.println("Detonated");
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
