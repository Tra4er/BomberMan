package com.bomberman.objects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.bomberman.gui.GamePanel;
import com.bomberman.gui.MainFrame;

public class Bomb implements ActionListener {

	private final int BLOCK_BONUS = 10;
	private final int HIT_ENEMY_BONUS = 50;
	private final int HIT_ME_BONUS = 50;

	private int x;
	private int y;

	private int length = 2;

	private boolean up = true;
	private boolean right = true;
	private boolean down = true;
	private boolean left = true;

	private boolean hit;

	private boolean circle;

	private int[][] blocksArray;

	private Bomberman bomberman;
	private Bomberman secondPlayer;

	private Timer timer;

	public Bomb(int x, int y, int[][] blocksArray, Bomberman bomberman, Bomberman secondPlayer) {
		this.x = x;
		this.y = y;
		length = bomberman.getFirePower();
		this.blocksArray = blocksArray;
		this.bomberman = bomberman;
		this.secondPlayer = secondPlayer;
		blocksArray[x][y] = GamePanel.BOMB_BLOCK;
		timer = new Timer(3000, this);
		timer.start();
	}

	public void detonate() {

		bomberman.bombs++;

		for (int i = 0; i <= length; i++) {

			if (up && y - i > 0) {

				if (blocksArray[x][y - i] != GamePanel.STATIC_BLOCK) {

					if (blocksArray[x][y - i] == GamePanel.DESTROYED_BLOCK) {
						blocksArray[x][y - i] = GamePanel.FIRE_BLOCK;
						if (Math.random() * 100 < GamePanel.BONUS_SPAWN) {
							switch ((int) (Math.random() * 3)) {
							case 0:
								blocksArray[x][y - i] = GamePanel.FIRE_BONUS_BLOCK;
								break;
							case 1:
								blocksArray[x][y - i] = GamePanel.BOMB_BONUS_BLOCK;
								break;
							case 2:
								blocksArray[x][y - i] = GamePanel.LIFE_BONUS_BLOCK;
								break;
							}
						}
						bomberman.score += BLOCK_BONUS;
						System.out.println("Bomberman bonus for dest. block: 10");
						up = false;
					}
					if (up) {
						blocksArray[x][y - i] = GamePanel.FIRE_BLOCK;
					}
					if (!hit) {

						if (x == bomberman.getX() && y - i == bomberman.getY()) {
							bomberman.lifes--;
							bomberman.score -= HIT_ME_BONUS;
							System.out.println("Took your bonuses for hit yourself: 50");
							hit = true;
						}
						if (x == secondPlayer.getX() && y - i == secondPlayer.getY()) {
							secondPlayer.lifes--;
							secondPlayer.score += HIT_ENEMY_BONUS;
							System.out.println("Bonus for Hit Second Player: 50");
							hit = true;
						}

						if (!bomberman.dead) {
							if (bomberman.lifes < 1) {
								bomberman.dead = true;
								// bomberman.score -= 100;
								System.out.println("Dead bomberman");
							}
						}
						if (!secondPlayer.dead) {
							if (secondPlayer.lifes < 1) {
								secondPlayer.dead = true;
								// bomberman.score += 100;
								System.out.println("Dead secondPlayer");
							}
						}
					}
				} else
					up = false;
			}
			if (right && x + i < MainFrame.DEFAULT_BLOCK_NUMBER - 1) {

				if (blocksArray[x + i][y] != GamePanel.STATIC_BLOCK) {

					if (blocksArray[x + i][y] == GamePanel.DESTROYED_BLOCK) {
						blocksArray[x + i][y] = GamePanel.FIRE_BLOCK;
						if (Math.random() * 100 < GamePanel.BONUS_SPAWN) {
							switch ((int) (Math.random() * 3)) {
							case 0:
								blocksArray[x + i][y] = GamePanel.FIRE_BONUS_BLOCK;
								break;
							case 1:
								blocksArray[x + i][y] = GamePanel.BOMB_BONUS_BLOCK;
								break;
							case 2:
								blocksArray[x + i][y] = GamePanel.LIFE_BONUS_BLOCK;
								break;
							}
						}
						bomberman.score += BLOCK_BONUS;
						System.out.println("Bomberman bonus for dest. block: 10");
						right = false;
					}
					if (right) {
						blocksArray[x + i][y] = GamePanel.FIRE_BLOCK;
					}
					if (!hit) {

						if (x + i == bomberman.getX() && y == bomberman.getY()) {
							bomberman.lifes--;
							bomberman.score -= HIT_ME_BONUS;
							System.out.println("Took your bonuses for hit yourself: 50");
							hit = true;
						}
						if (x + i == secondPlayer.getX() && y == secondPlayer.getY()) {
							secondPlayer.lifes--;
							secondPlayer.score += HIT_ENEMY_BONUS;
							System.out.println("Bonus for Hit Second Player: 50");
							hit = true;
						}

						if (!bomberman.dead) {
							if (bomberman.lifes < 1) {
								bomberman.dead = true;
								System.out.println("Dead bomberman");
							}
						}
						if (!secondPlayer.dead) {
							if (secondPlayer.lifes < 1) {
								secondPlayer.dead = true;
								System.out.println("Dead secondPlayer");
							}
						}
					}
				} else
					right = false;
			}
			if (down && y + i < MainFrame.DEFAULT_BLOCK_NUMBER - 1) {

				if (blocksArray[x][y + i] != GamePanel.STATIC_BLOCK) {

					if (blocksArray[x][y + i] == GamePanel.DESTROYED_BLOCK) {
						blocksArray[x][y + i] = GamePanel.FIRE_BLOCK;
						if (Math.random() * 100 < GamePanel.BONUS_SPAWN) {
							switch ((int) (Math.random() * 3)) {
							case 0:
								blocksArray[x][y + i] = GamePanel.FIRE_BONUS_BLOCK;
								break;
							case 1:
								blocksArray[x][y + i] = GamePanel.BOMB_BONUS_BLOCK;
								break;
							case 2:
								blocksArray[x][y + i] = GamePanel.LIFE_BONUS_BLOCK;
								break;
							}
						}
						bomberman.score += BLOCK_BONUS;
						System.out.println("Bomberman bonus for dest. block: 10");
						down = false;
					}
					if (down) {
						blocksArray[x][y + i] = GamePanel.FIRE_BLOCK;
					}
					if (!hit) {

						if (x == bomberman.getX() && y + i == bomberman.getY()) {
							bomberman.lifes--;
							bomberman.score -= HIT_ME_BONUS;
							System.out.println("Took your bonuses for hit yourself: 50");
							hit = true;
						}
						if (x == secondPlayer.getX() && y + i == secondPlayer.getY()) {
							secondPlayer.lifes--;
							secondPlayer.score += HIT_ENEMY_BONUS;
							System.out.println("Bonus for Hit Second Player: 50");
							hit = true;
						}

						if (!bomberman.dead) {
							if (bomberman.lifes < 1) {
								bomberman.dead = true;
								System.out.println("Dead bomberman");
							}
						}
						if (!secondPlayer.dead) {
							if (secondPlayer.lifes < 1) {
								secondPlayer.dead = true;
								System.out.println("Dead secondPlayer");
							}
						}
					}
				} else
					down = false;
			}
			if (left && x - i > 0) {

				if (blocksArray[x - i][y] != GamePanel.STATIC_BLOCK) {

					if (blocksArray[x - i][y] == GamePanel.DESTROYED_BLOCK) {
						blocksArray[x - i][y] = GamePanel.FIRE_BLOCK;
						if (Math.random() * 100 < GamePanel.BONUS_SPAWN) {
							switch ((int) (Math.random() * 3)) {
							case 0:
								blocksArray[x - i][y] = GamePanel.FIRE_BONUS_BLOCK;
								break;
							case 1:
								blocksArray[x - i][y] = GamePanel.BOMB_BONUS_BLOCK;
								break;
							case 2:
								blocksArray[x - i][y] = GamePanel.LIFE_BONUS_BLOCK;
								break;
							}
						}
						bomberman.score += BLOCK_BONUS;
						System.out.println("Bomberman bonus for dest. block: 10");
						left = false;
					}
					if (left) {
						blocksArray[x - i][y] = GamePanel.FIRE_BLOCK;
					}
					if (!hit) {

						if (x - i == bomberman.getX() && y == bomberman.getY()) {
							bomberman.lifes--;
							bomberman.score -= HIT_ME_BONUS;
							System.out.println("Took your bonuses for hit yourself: 50");
							hit = true;
						}
						if (x - i == secondPlayer.getX() && y == secondPlayer.getY()) {
							secondPlayer.lifes--;
							secondPlayer.score += HIT_ENEMY_BONUS;
							System.out.println("Bonus for Hit Second Player: 50");
							hit = true;
						}

						if (!bomberman.dead) {
							if (bomberman.lifes < 1) {
								bomberman.dead = true;
//								bomberman.saveBestAchievements();
								System.out.println("Dead bomberman");
							}
						}
						if (!secondPlayer.dead) {
							if (secondPlayer.lifes < 1) {
								secondPlayer.dead = true;
//								secondPlayer.saveBestAchievements();
								System.out.println("Dead secondPlayer");
							}
						}
					}
				} else
					left = false;
				if(bomberman.dead || secondPlayer.dead) {
					bomberman.saveBestAchievements();
					secondPlayer.saveBestAchievements();
				}
			}
		}
		System.out.println("Bomber score: " + bomberman.score);
	}

	private void stampAFireOut() {
		for (int i = 0; i <= length; i++) {
			if (y - i > 0) {
				if (blocksArray[x][y - i] == GamePanel.FIRE_BLOCK) {
					blocksArray[x][y - i] = GamePanel.EMPTY_BLOCK;
				}
			}
			if (x + i < MainFrame.DEFAULT_BLOCK_NUMBER) {
				if (blocksArray[x + i][y] == GamePanel.FIRE_BLOCK) {
					blocksArray[x + i][y] = GamePanel.EMPTY_BLOCK;
				}
			}
			if (y + i < MainFrame.DEFAULT_BLOCK_NUMBER) {
				if (blocksArray[x][y + i] == GamePanel.FIRE_BLOCK) {
					blocksArray[x][y + i] = GamePanel.EMPTY_BLOCK;
				}
			}
			if (x - i > 0) {
				if (blocksArray[x - i][y] == GamePanel.FIRE_BLOCK) {
					blocksArray[x - i][y] = GamePanel.EMPTY_BLOCK;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!circle) {
			detonate();
		}
		timer.setInitialDelay(500);
		timer.restart();
		if (circle) {
			stampAFireOut();
			timer.stop();
		}
		circle = true;
	}
}
