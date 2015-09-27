package com.bomberman.objects;

import com.bomberman.gui.GamePanel;
import com.bomberman.gui.ScoreboardPanel;

public class Bomberman {

	private static final String DEFAULT_PLAYER_NAME = "Player";

	private int x;
	private int y;

	public static int[][] blocksArray;

	private String name;
	private String bestTime;
	private int bestScore;

	public int score = 0;
	public int lifes = 1;
	// private int speed = 4;
	private int firePower = 1;
	public int bombs = 1;
	public boolean dead;
	

	// public Bomberman() {
	// this(1, 1, "Player", blocksArray);
	// }
	//
	// public Bomberman(int x, int y) {
	// this(x, y, "Player", blocksArray);
	// }
	//
	// public Bomberman(String name){
	// this(1, 1, name, blocksArray);
	// }

	public Bomberman(int[][] blocksArray) {
		this(1, 1, DEFAULT_PLAYER_NAME, blocksArray);
	}

	public Bomberman(int x, int y, String name, int[][] blocksArray) {
		this.setX(x);
		this.setY(y);
		this.setName(name);
		this.blocksArray = blocksArray;
	}

	public void setBomb(Bomberman secondPlayer) {
		new Bomb(x, y, blocksArray, this, secondPlayer);
	}

	public void moveUp() {
		if (y > 1 && x % 2 == 1 && blocksArray[x][y - 1] < GamePanel.DESTROYED_BLOCK) {
			y--;
			if (blocksArray[x][y] == GamePanel.FIRE_BLOCK)
				lifes--;
			if (blocksArray[x][y] == GamePanel.FIRE_BONUS_BLOCK) {
				firePower++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
			if (blocksArray[x][y] == GamePanel.BOMB_BONUS_BLOCK) {
				bombs++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
			if (blocksArray[x][y] == GamePanel.LIFE_BONUS_BLOCK) {
				lifes++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
		}
	}

	public void moveRight() {
		if (x < 15 && y % 2 == 1 && blocksArray[x + 1][y] < GamePanel.DESTROYED_BLOCK) {
			x++;
			if (blocksArray[x][y] == GamePanel.FIRE_BLOCK)
				lifes--;
			if (blocksArray[x][y] == GamePanel.FIRE_BONUS_BLOCK) {
				firePower++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
			if (blocksArray[x][y] == GamePanel.BOMB_BONUS_BLOCK) {
				bombs++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
			if (blocksArray[x][y] == GamePanel.LIFE_BONUS_BLOCK) {
				lifes++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
		}
	}

	public void moveDown() {
		if (y < 15 && x % 2 == 1 && blocksArray[x][y + 1] < GamePanel.DESTROYED_BLOCK) {
			y++;
			if (blocksArray[x][y] == GamePanel.FIRE_BLOCK)
				lifes--;
			if (blocksArray[x][y] == GamePanel.FIRE_BONUS_BLOCK) {
				firePower++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
			if (blocksArray[x][y] == GamePanel.BOMB_BONUS_BLOCK) {
				bombs++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
			if (blocksArray[x][y] == GamePanel.LIFE_BONUS_BLOCK) {
				lifes++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
		}
	}

	public void moveLeft() {
		if (x > 1 && y % 2 == 1 && blocksArray[x - 1][y] < GamePanel.DESTROYED_BLOCK) {
			x--;
			if (blocksArray[x][y] == GamePanel.FIRE_BLOCK)
				lifes--;
			if (blocksArray[x][y] == GamePanel.FIRE_BONUS_BLOCK) {
				firePower++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
			if (blocksArray[x][y] == GamePanel.BOMB_BONUS_BLOCK) {
				bombs++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
			if (blocksArray[x][y] == GamePanel.LIFE_BONUS_BLOCK) {
				lifes++;
				blocksArray[x][y] = GamePanel.EMPTY_BLOCK;
			}
		}
	}
	
	public void saveBestAchievements() {
		bestScore = score;
		bestTime = ScoreboardPanel.roundTimer.getText();
		System.out.println("Scores Saved Method");
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

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public int getFirePower() {
		return firePower;
	}

	public void setFirePower(int firePower) {
		this.firePower = firePower;
	}

}
