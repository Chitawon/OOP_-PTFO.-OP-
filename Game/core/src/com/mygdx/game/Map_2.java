package com.mygdx.game;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Map_2 extends Map{
	private Texture tm, bg;
	private Texture enemy_board_r, enemy_board_l, bear_sleep, bear_stand;
	private int[] Position;
	private int[] Enemy_Position = {5, 16, 32, 43, 8, 12, 22, 27, 37};
	private int Player_Position;

	public void init() {
		Position = new int[2];
		tm = new Texture("Background/002.png");
		bg = new Texture("Background/BG1.png");
		enemy_board_r = new Texture("Board/enemy_board_r.png");
		enemy_board_l = new Texture("Board/enemy_board_l.png");
		bear_stand = new Texture("Board/bear_stand.png");
		bear_sleep = new Texture("Board/bear_sleep.png");
	}

	public void setPosition(int pos_x, int pos_y) {
		Position[0] = pos_x;
		Position[1] = pos_y;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(bg, 0, 0, 1312, 752);
		batch.draw(tm, 0, 0);

		if(Player_Position >= 13) {
			batch.draw(bear_stand, 554, 624, 160, 120);
		}else if(Player_Position < 13) {
			batch.draw(bear_sleep, 554, 624, 200, 160);
		}
		
		if(Player_Position <= 5) {
			batch.draw(enemy_board_r, 32, 240, 96, 128);
		}
		if(Player_Position <= 16) {
			batch.draw(enemy_board_r, 416, 336, 96, 128);
		}
		if(Player_Position <= 32) {
			batch.draw(enemy_board_r, 896, 240, 96, 128);
		}
		if(Player_Position <= 43) {
			batch.draw(enemy_board_r, 1184, 432, 96, 128);
		}
		if(Player_Position <= 8) {
			batch.draw(enemy_board_l, 224, 336, 96, 128);
		}
		if(Player_Position <= 12) {
			batch.draw(enemy_board_l, 320, 624, 96, 128);
		}
		if(Player_Position <= 22) {
			batch.draw(enemy_board_l, 704, 432, 96, 128);
		}
		if(Player_Position <= 27) {
			batch.draw(enemy_board_l, 992, 624, 96, 128);
		}
		if(Player_Position <= 37) {
			batch.draw(enemy_board_l, 992, 48, 96, 128);
		}
		
	}

	public int[] Position(int pos) {
		Player_Position = pos;
		if(pos == 1) {
			setPosition(32, 624);
			return Position;
		}else if(pos == 2) {
			setPosition(32, 528);
			return Position;
		}else if(pos == 3) {
			setPosition(32, 432);
			return Position;
		}else if(pos == 4) {
			setPosition(32, 336);
			return Position;
		}else if(pos == 5) {
			setPosition(32, 240);
			return Position;
		}else if(pos == 6) {
			setPosition(128, 240);
			return Position;
		}else if(pos == 7) {
			setPosition(224, 240);
			return Position;
		}else if(pos == 8) {
			setPosition(224, 336);
			return Position;		
		}else if(pos == 9) {
			setPosition(224, 432);
			return Position;	
		}else if(pos == 10) {
			setPosition(224, 528);
			return Position;			
		}else if(pos == 11) {
			setPosition(224, 624);
			return Position;			
		}else if(pos == 12) {
			setPosition(320, 624);
			return Position;			
		}else if(pos == 13) {
			setPosition(416, 624);
			return Position;	
		}else if(pos == 14) {
			setPosition(416, 528);
			return Position;
		}else if(pos == 15) {
			setPosition(416, 432);
			return Position;
		}else if(pos == 16) {
			setPosition(416, 336);
			return Position;
		}else if(pos == 17) {
			setPosition(416, 240);
			return Position;
		}else if(pos == 18) {
			setPosition(512, 240);
			return Position;
		}else if(pos == 19) {
			setPosition(608, 240);
			return Position;
		}else if(pos == 20) {
			setPosition(608, 336);
			return Position;
		}else if(pos == 21) {
			setPosition(608, 432);
			return Position;
		}else if(pos == 22) {
			setPosition(704, 432);
			return Position;
		}else if(pos == 23) {
			setPosition(800, 432);
			return Position;
		}else if(pos == 24) {
			setPosition(800, 528);
			return Position;
		}else if(pos == 25) {
			setPosition(800, 624);
			return Position;
		}else if(pos == 26) {
			setPosition(896, 624);
			return Position;
		}else if(pos == 27) {
			setPosition(992, 624);
			return Position;
		}else if(pos == 28) {
			setPosition(992, 528);
			return Position;
		}else if(pos == 29) {
			setPosition(992, 432);
			return Position;
		}else if(pos == 30) {
			setPosition(992, 336);
			return Position;
		}else if(pos == 31) {
			setPosition(992, 240);
			return Position;
		}else if(pos == 32) {
			setPosition(896, 240);
			return Position;
		}else if(pos == 33) {
			setPosition(800, 240);
			return Position;
		}else if(pos == 34) {
			setPosition(800, 144);
			return Position;
		}else if(pos == 35) {
			setPosition(800, 48);
			return Position;
		}else if(pos == 36) {
			setPosition(896, 48);
			return Position;
		}else if(pos == 37) {
			setPosition(992, 48);
			return Position;
		}else if(pos == 38) {
			setPosition(1088, 48);
			return Position;
		}else if(pos == 39) {
			setPosition(1184, 48);
			return Position;
		}else if(pos == 40) {
			setPosition(1184, 144);
			return Position;
		}else if(pos == 41) {
			setPosition(1184, 240);
			return Position;	
		}else if(pos == 42) {
			setPosition(1184, 336);
			return Position;	
		}else if(pos == 43) {
			setPosition(1184, 432);
			return Position;	
		}else if(pos == 44) {
			setPosition(1184, 528);
			return Position;	
		}else if(pos == 45) {
			setPosition(1184, 624);
			return Position;	
		}else {
			setPosition(1184, 624);
			return Position;
		}
	}
	
	@Override
	public boolean CheckFight(int pos) {
		for (int i = 0; i < Enemy_Position.length; i++) {
			if(Enemy_Position[i] == pos) {
				return true;
			}
		}
		return false;
	}
}
