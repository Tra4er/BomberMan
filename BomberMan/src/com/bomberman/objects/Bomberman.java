package com.bomberman.objects;

public class Bomberman {

	private int x;
	private int y;

	private String name;
	private String bestTime;

	private int score = 0;
	private int lifes = 1;
	private int speed = 1; // Прибавляєм більший крок в пікселях
	private int firePower = 1;
	private int bombs = 1;

	public Bomberman() {
		this(0, 0, "Player");
	}

	public Bomberman(int x, int y) {
		this(x, y, "Player");
	}
	
	public Bomberman(String name){
		this(0, 0, name);
	}

	public Bomberman(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.setName(name);
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
}
