package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.*;
	

public class GameStateManager {
	private static State gameState;
	
	public GameStateManager() {	
			setState(0); // set ฉาก
	}


	public void setState(int state) {
		if (gameState != null) {
			gameState.dispose();
		}
		if (state == 0) {
			gameState = new StartState(this); //หน้าเริ่ม
		}else if (state == 1) {
			gameState = new MenuState(this); //เมนู
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
