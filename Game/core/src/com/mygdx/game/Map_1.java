package com.mygdx.game;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Map_1 extends Map{
	private Texture tm, bg;
	private Texture enemy_board_r, enemy_board_l;
	private int[][] Position;
	private int[] Enemy_Position = {5, 8, 12, 16, 22, 27, 32, 37, 41, 46};
	private boolean[] Enemy_Alive = {true, true, true, true, true, true, true, true, true, true};

	
	public void init() {
		tm = new Texture("Background/001.png");
		bg = new Texture("Background/BG1.png");
		enemy_board_r = new Texture("Character/Board/enemy_board_r.png");
		enemy_board_l = new Texture("Character/Board/enemy_board_l.png");
		
		Position = new int[][] {
			{32, 240}, {32, 336}, {32, 432}, {32, 528} , {32, 624}
		  , {128, 624}, {224, 624}, {224, 528}, {224, 432}, {224, 336}
		  , {224, 240}, {320, 240}, {416, 240}, {416, 336}, {416, 432}
		  , {416, 528}, {416, 624}, {512, 624}, {608, 624}, {704, 624}
		  , {800, 624}, {800, 528}, {800, 432}, {704, 432}, {608, 432}
		  , {608, 336}, {608, 240}, {704, 240}, {800, 240}, {800, 144}
		  , {800, 48}, {896, 48}, {992, 48}, {992, 144}, {992, 240}
		  , {992, 336}, {992, 432}, {992, 528}, {992, 624}, {1088, 624}
		  , {1184, 624}, {1184, 528}, {1184, 432}, {1184, 336}, {1184, 240}
		  , {1184, 144}, {1184, 48}
		  };
	}

	public void draw(SpriteBatch batch) {
		batch.draw(bg, 0, 0, 1312, 752);
		batch.draw(tm, 0, 0);
		
		if(Enemy_Alive[0]) {
			batch.draw(enemy_board_r, 32, 624, 96, 128);
		}
		if(Enemy_Alive[3]) {
			batch.draw(enemy_board_r, 416, 528, 96, 128);
		}
		if(Enemy_Alive[5]) {
			batch.draw(enemy_board_r, 608, 240, 96, 128);
		}
		if(Enemy_Alive[7]) {
			batch.draw(enemy_board_r, 992, 432, 96, 128);
		}
		if(Enemy_Alive[1]) {
			batch.draw(enemy_board_l, 224, 528, 96, 128);
		}
		if(Enemy_Alive[2]) {
			batch.draw(enemy_board_l, 320, 240, 96, 128);
		}
		if(Enemy_Alive[4]) {
			batch.draw(enemy_board_l, 800, 528, 96, 128);
		}
		if(Enemy_Alive[6]) {
			batch.draw(enemy_board_l, 922, 48, 96, 128);
		}
		if(Enemy_Alive[8]) {
			batch.draw(enemy_board_l, 1184, 624, 96, 128);
		}
		if(Enemy_Alive[9]) {
			batch.draw(enemy_board_l, 1184, 144, 96, 128);
		}
	}
	
	public int[] Position(int pos) {
		return Position[pos - 1];
	}

	@Override
	public boolean CheckFight(int pos) {
		for (int i = 0; i < Enemy_Position.length; i++) {
			if(Enemy_Position[i] == pos) {
				if(Enemy_Alive[i] == true) {
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
				break;
			}
		}
	}

}
