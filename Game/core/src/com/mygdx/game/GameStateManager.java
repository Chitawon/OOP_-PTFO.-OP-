package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.*;
	

public class GameStateManager {
	private static State gameState;

	public static final int START = 0;
	public static final int MENU = 1;
	public static final int PLAY = 2;
	
	
	public GameStateManager() {	
			setState(START); // set ฉาก
	}


	public void setState(int state) {
		if (gameState != null) {
			gameState.dispose();
		}
		if (state == START) {
			gameState = new StartState(this);//หน้าเริ่ม
		}else if (state == MENU) {
			gameState = new MenuState(this); //เมนู
		}else if (state == PLAY) {
			gameState = new PlayState(this); //เมนู
		}
		gameState.init();
	}

	public void draw() {
		gameState.draw();
	}

	public void update(float dt) {
		gameState.update(dt);
	}

	public void dispose() {
		gameState.dispose();
	}
}
