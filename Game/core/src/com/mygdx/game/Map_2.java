package com.mygdx.game;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Map_2 extends Map{
	private Texture tm, bg;
	private Texture enemy_board_r, enemy_board_l, bear_sleep, bear_stand;
	private int[][] Position;
	private int[] Enemy_Position = {5, 8, 12, 16, 22, 27, 32, 37, 43};
	private boolean[] Enemy_Alive = {true, true, true, true, true, true, true, true, true};
	private int Player_Position;

	public void init() {
		tm = new Texture("Background/002.png");
		bg = new Texture("Background/BG1.png");
		enemy_board_r = new Texture("Character/Board/enemy_board_r.png");
		enemy_board_l = new Texture("Character/Board/enemy_board_l.png");
		bear_stand = new Texture("Character/Board/bear_stand.png");
		bear_sleep = new Texture("Character/Board/bear_sleep.png");
		
		
		Position = new int[][] {
			{32, 624}, {32, 528}, {32, 432}, {32, 336} , {32, 240}
		  , {128, 240}, {224, 240}, {224, 336}, {224, 432}, {224, 528}
		  , {224, 624}, {320, 624}, {416, 624}, {416, 528}, {416, 432}
		  , {416, 336}, {416, 240}, {512, 240}, {608, 240}, {608, 336}
		  , {608, 432}, {704, 432}, {800, 432}, {800, 528}, {800, 624}
		  , {896, 624}, {992, 624}, {992, 528}, {992, 432}, {992, 336}
		  , {992, 240}, {896, 240}, {800, 240}, {800, 144}, {800, 48}
		  , {896, 48}, {992, 48}, {1088, 48}, {1184, 48}, {1184, 144}
		  , {1184, 240}, {1184, 336}, {1184, 432}, {1184, 528}, {1184, 624}
		  };
	}

	public void draw(SpriteBatch batch) {
		batch.draw(bg, 0, 0, 1312, 752);
		batch.draw(tm, 0, 0);

		if(Player_Position >= 13) {
			batch.draw(bear_stand, 554, 624, 160, 120);
		}else if(Player_Position < 13) {
			batch.draw(bear_sleep, 554, 624, 200, 160);
		}
		
		if(Enemy_Alive[0]) {
			batch.draw(enemy_board_r, 32, 240, 96, 128);
		}
		if(Enemy_Alive[3]) {
			batch.draw(enemy_board_r, 416, 336, 96, 128);
		}
		if(Enemy_Alive[6]) {
			batch.draw(enemy_board_r, 896, 240, 96, 128);
		}
		if(Enemy_Alive[8]) {
			batch.draw(enemy_board_r, 1184, 432, 96, 128);
		}
		if(Enemy_Alive[1]) {
			batch.draw(enemy_board_l, 224, 336, 96, 128);
		}
		if(Enemy_Alive[2]) {
			batch.draw(enemy_board_l, 320, 624, 96, 128);
		}
		if(Enemy_Alive[4]) {
			batch.draw(enemy_board_l, 704, 432, 96, 128);
		}
		if(Enemy_Alive[5]) {
			batch.draw(enemy_board_l, 992, 624, 96, 128);
		}
		if(Enemy_Alive[7]) {
			batch.draw(enemy_board_l, 992, 48, 96, 128);
		}
		
	}

	public int[] Position(int pos) {
		Player_Position = pos;
		return Position[pos - 1];
	}
	
	@Override
	public boolean CheckFight(int pos) {
		for (int i = 0; i < Enemy_Position.length; i++) {
			if(Enemy_Position[i] == pos) {
				if(Enemy_Alive[i]) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void Enemy_Alive(int pos) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Enemy_Position.length; i++) {
			if(Enemy_Position[i] == pos) {
				Enemy_Alive[i] = false;
			}
		}
	}
}
