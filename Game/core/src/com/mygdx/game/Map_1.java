package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Map_1{
	private SpriteBatch batch;
	private Texture img, teri;
	
	public void init() {
		batch = new SpriteBatch();
		img = new Texture("BG1.png");
	}

	public void draw() {
		batch.begin();
		batch.draw(img, 32, 240, 96, 96); // 1
		batch.draw(img, 32, 336, 96, 96); // 2
		batch.draw(img, 32, 432, 96, 96); // 3
		batch.draw(img, 32, 528, 96, 96); // 4
		batch.draw(img, 32, 624, 96, 96); // 5
		
		batch.draw(img, 128, 624, 96, 96); // 6
		
		batch.draw(img, 224, 624, 96, 96); // 7
		batch.draw(img, 224, 528, 96, 96); // 8
		batch.draw(img, 224, 432, 96, 96); // 9
		batch.draw(img, 224, 336, 96, 96); // 10
		batch.draw(img, 224, 240, 96, 96); // 11
		
		batch.draw(img, 320, 240, 96, 96); // 12
		
		batch.draw(img, 416, 240, 96, 96); // 13
		batch.draw(img, 416, 336, 96, 96); // 14
		batch.draw(img, 416, 432, 96, 96); // 15
		batch.draw(img, 416, 528, 96, 96); // 16
		batch.draw(img, 416, 624, 96, 96); // 17
		
		batch.draw(img, 512, 624, 96, 96); // 18
		
		batch.draw(img, 608, 624, 96, 96); // 19
		batch.draw(img, 608, 432, 96, 96); // 25
		batch.draw(img, 608, 336, 96, 96); // 26 
		batch.draw(img, 608, 240, 96, 96); // 27
		
		batch.draw(img, 704, 624, 96, 96); // 20
		batch.draw(img, 704, 432, 96, 96); // 24
		batch.draw(img, 704, 240, 96, 96); // 28
		
		batch.draw(img, 800, 624, 96, 96); // 21
		batch.draw(img, 800, 528, 96, 96); // 22
		batch.draw(img, 800, 432, 96, 96); // 23
		batch.draw(img, 800, 240, 96, 96); // 29
		batch.draw(img, 800, 144, 96, 96); // 30
		batch.draw(img, 800, 48, 96, 96); // 31
		
		batch.draw(img, 896, 48, 96, 96); // 32
		
		batch.draw(img, 992, 48, 96, 96); // 33
		batch.draw(img, 992, 144, 96, 96); // 34
		batch.draw(img, 992, 240, 96, 96); // 35
		batch.draw(img, 992, 336, 96, 96); // 36
		batch.draw(img, 992, 432, 96, 96); // 37
		batch.draw(img, 992, 528, 96, 96); // 38
		batch.draw(img, 992, 624, 96, 96); // 39
		
		batch.draw(img, 1088, 624, 96, 96); // 40
		
		batch.draw(img, 1184, 624, 96, 96); // 41
		batch.draw(img, 1184, 528, 96, 96); // 42
		batch.draw(img, 1184, 432, 96, 96); // 43 
		batch.draw(img, 1184, 336, 96, 96); // 44
		batch.draw(img, 1184, 240, 96, 96); // 45
		batch.draw(img, 1184, 144, 96, 96); // 46
		batch.draw(img, 1184, 48, 96, 96); // 47
		batch.end();
	}

	public int PositionX(int pos) {
		if(pos == 1) {
			return 32;
		}else if(pos == 2) {
			return 32;
		}else if(pos == 3) {
			return 32;
		}else if(pos == 4) {
			return 32;
		}else if(pos == 5) {
			return 32;
		}else if(pos == 6) {
			return 128;
		}
//			else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}
		return 0;
	}
	
	public int PositionY(int pos) {
		if(pos == 1) {
			return 240;
		}else if(pos == 2) {
			return 336;
		}else if(pos == 3) {
			return 432;
		}else if(pos == 4) {
			return 528;
		}else if(pos == 5) {
			return 624;
		}else if(pos == 6) {
			return 624;
		}
//		else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}else if(pos == 1) {
//			
//		}

		return 0;
	}

	public void dispose() {
		img.dispose();
	}
}
