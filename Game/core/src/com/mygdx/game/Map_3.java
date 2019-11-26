package com.mygdx.game;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Map_3 extends Map{
	private Texture tm, bg;
	private Texture enemy_board_r, enemy_board_l;
	private int[] Position;
	private int[] Enemy_Position = {2, 8, 9, 16, 20, 28, 32, 35, 41, 48};
	private boolean[] Enemy_Alive = {true, true, true, true, true, true, true, true, true, true};
	private int Player_Position;
	
	public void init() {
		Position = new int[2];
		tm = new Texture("Background/003.png");
		bg = new Texture("Background/BG2.png");
		enemy_board_r = new Texture("Character/Board/enemy_board_r.png");
		enemy_board_l = new Texture("Character/Board/enemy_board_l.png");
	}

	public void setPosition(int pos_x, int pos_y) {
		Position[0] = pos_x;
		Position[1] = pos_y;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(bg, 0, 0, 1312, 752);
		batch.draw(tm, 0, 0);
		
		if(Enemy_Alive[0]) {
			batch.draw(enemy_board_r, 32, 336, 96, 128);
		}
		if(Enemy_Alive[2]) {
			batch.draw(enemy_board_r, 416, 624, 96, 128);
		}
		if(Enemy_Alive[3]) {
			batch.draw(enemy_board_r, 224, 336, 96, 128);
		}
		if(Enemy_Alive[8]) {
			batch.draw(enemy_board_r, 704, 240, 96, 128);
		}
		if(Enemy_Alive[7]) {
			batch.draw(enemy_board_l, 1088, 48, 96, 128);
		}
		if(Enemy_Alive[1]) {
			batch.draw(enemy_board_l, 320, 624, 96, 128);
		}
		if(Enemy_Alive[4]) {
			batch.draw(enemy_board_l, 608, 432, 96, 128);
		}
		if(Enemy_Alive[5]) {
			batch.draw(enemy_board_l, 1184, 624, 96, 128);
		}
		if(Enemy_Alive[6]) {
			batch.draw(enemy_board_l, 1184, 240, 96, 128);
		}
		if(Enemy_Alive[9]) {
			batch.draw(enemy_board_l, 1056, 304, 96, 128);
		}
	}

	public int[] Position(int pos) {
		Player_Position = pos;
		if(pos == 1) {
			setPosition(32, 240);
			return Position;
		}else if(pos == 2) {
			setPosition(32, 336);
			return Position;
		}else if(pos == 3) {
			setPosition(32, 432);
			return Position;
		}else if(pos == 4) {
			setPosition(32, 528);
			return Position;
		}else if(pos == 5) {
			setPosition(32, 624);
			return Position;
		}else if(pos == 6) {
			setPosition(128, 624);
			return Position;
		}else if(pos == 7) {
			setPosition(224, 624);
			return Position;
		}else if(pos == 8) {
			setPosition(320, 624);
			return Position;		
		}else if(pos == 9) {
			setPosition(416, 624);
			return Position;	
		}else if(pos == 10) {
			setPosition(416, 528);
			return Position;			
		}else if(pos == 11) {
			setPosition(416, 432);
			return Position;			
		}else if(pos == 12) {
			setPosition(416, 336);
			return Position;			
		}else if(pos == 13) {
			setPosition(416, 240);
			return Position;	
		}else if(pos == 14) {
			setPosition(320, 240);
			return Position;
		}else if(pos == 15) {
			setPosition(224, 240);
			return Position;
		}else if(pos == 16) {
			setPosition(224, 336);
			return Position;
		}else if(pos == 17) {
			setPosition(224, 432);
			return Position;
		}else if(pos == 18) {
			setPosition(320, 432);
			return Position;
		}else if(pos == 19) {
			setPosition(512, 432);
			return Position;
		}else if(pos == 20) {
			setPosition(608, 432);
			return Position;
		}else if(pos == 21) {
			setPosition(608, 528);
			return Position;
		}else if(pos == 22) {
			setPosition(608, 624);
			return Position;
		}else if(pos == 23) {
			setPosition(704, 624);
			return Position;
		}else if(pos == 24) {
			setPosition(800, 624);
			return Position;
		}else if(pos == 25) {
			setPosition(896, 624);
			return Position;
		}else if(pos == 26) {
			setPosition(992, 624);
			return Position;
		}else if(pos == 27) {
			setPosition(1088, 624);
			return Position;
		}else if(pos == 28) {
			setPosition(1184, 624);
			return Position;
		}else if(pos == 29) {
			setPosition(1184, 528);
			return Position;
		}else if(pos == 30) {
			setPosition(1184, 432);
			return Position;
		}else if(pos == 31) {
			setPosition(1184, 336);
			return Position;
		}else if(pos == 32) {
			setPosition(1184, 240);
			return Position;
		}else if(pos == 33) {
			setPosition(1184, 144);
			return Position;
		}else if(pos == 34) {
			setPosition(1184, 48);
			return Position;
		}else if(pos == 35) {
			setPosition(1088, 48);
			return Position;
		}else if(pos == 36) {
			setPosition(992, 48);
			return Position;
		}else if(pos == 37) {
			setPosition(896, 48);
			return Position;
		}else if(pos == 38) {
			setPosition(800, 48);
			return Position;
		}else if(pos == 39) {
			setPosition(800, 144);
			return Position;
		}else if(pos == 40) {
			setPosition(704, 144);
			return Position;
		}else if(pos == 41) {
			setPosition(704, 240);
			return Position;	
		}else if(pos == 42) {
			setPosition(608, 240);
			return Position;	
		}else if(pos == 43) {
			setPosition(608, 336);
			return Position;	
		}
		else if(pos == 44) {
			setPosition(864, 496);
			return Position;	
		}else if(pos == 45) {
			setPosition(960, 496);
			return Position;	
		}else if(pos == 46) {
			setPosition(1056, 496);
			return Position;	
		}else if(pos == 47) {
			setPosition(1056, 400);
			return Position;	
		}else if(pos == 48) {
			setPosition(1056, 304);
			return Position;	
		}else if(pos == 49) {
			setPosition(960, 304);
			return Position;	
		}else if(pos == 50) {
			setPosition(864, 304);
			return Position;	
		}else if(pos == 51) {
			setPosition(864, 400);
			return Position;	
		}else {
			setPosition(864, 400);
			return Position;
		}
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
