package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Map_2 extends Map{
	private Texture img;
	private int[] Position;
	
	public void init() {
		Position = new int[2];
		img = new Texture("BG1.png");
	}

	public void setPosition(int pos_x, int pos_y) {
		Position[0] = pos_x;
		Position[1] = pos_y;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(img, 32, 624, 96, 96); // 1
		batch.draw(img, 32, 528, 96, 96); // 2
		batch.draw(img, 32, 432, 96, 96); // 3
		batch.draw(img, 32, 336, 96, 96); // 4
		batch.draw(img, 32, 240, 96, 96); // 5
		
		batch.draw(img, 128, 240, 96, 96); // 6
		
		batch.draw(img, 224, 240, 96, 96); // 7
		batch.draw(img, 224, 336, 96, 96); // 8
		batch.draw(img, 224, 432, 96, 96); // 9
		batch.draw(img, 224, 528, 96, 96); // 10
		batch.draw(img, 224, 624, 96, 96); // 11
		
		batch.draw(img, 320, 624, 96, 96); // 12
		
		batch.draw(img, 416, 624, 96, 96); // 13
		batch.draw(img, 416, 528, 96, 96); // 14
		batch.draw(img, 416, 432, 96, 96); // 15
		batch.draw(img, 416, 336, 96, 96); // 16
		batch.draw(img, 416, 240, 96, 96); // 17
		
		batch.draw(img, 512, 240, 96, 96); // 18
		
		batch.draw(img, 608, 240, 96, 96); // 19
		batch.draw(img, 608, 336, 96, 96); // 20
		batch.draw(img, 608, 432, 96, 96); // 21
		
		batch.draw(img, 704, 432, 96, 96); // 22
		
		batch.draw(img, 800, 432, 96, 96); // 23
		batch.draw(img, 800, 528, 96, 96); // 24
		batch.draw(img, 800, 624, 96, 96); // 25
		batch.draw(img, 800, 240, 96, 96); // 33
		batch.draw(img, 800, 144, 96, 96); // 34
		batch.draw(img, 800, 48, 96, 96);  // 35
		
		batch.draw(img, 896, 624, 96, 96); // 26
		batch.draw(img, 896, 240, 96, 96); // 32
		batch.draw(img, 896, 48, 96, 96);  // 36
		
		batch.draw(img, 992, 624, 96, 96); // 27
		batch.draw(img, 992, 528, 96, 96); // 28
		batch.draw(img, 992, 432, 96, 96); // 29
		batch.draw(img, 992, 336, 96, 96); // 30
		batch.draw(img, 992, 240, 96, 96); // 31
		batch.draw(img, 992, 48, 96, 96);  // 37
		
		batch.draw(img, 1088, 48, 96, 96); // 38
		
		batch.draw(img, 1184, 48, 96, 96);  // 39
		batch.draw(img, 1184, 144, 96, 96); // 40
		batch.draw(img, 1184, 240, 96, 96); // 41
		batch.draw(img, 1184, 336, 96, 96); // 42
		batch.draw(img, 1184, 432, 96, 96); // 43
		batch.draw(img, 1184, 528, 96, 96); // 44
		batch.draw(img, 1184, 624, 96, 96); // 45
	}

	public int[] Position(int pos) {
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

	public void dispose() {
		img.dispose();
	}
}
