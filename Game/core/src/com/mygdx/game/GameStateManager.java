package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.*;
	

public class GameStateManager {
	private static State gameState;

	public static final int START = 1;
	public static final int PLAY = 2;
	public static final int TUTORIAL = 3;
	
	
	public GameStateManager() {	
			setState(START); // set ฉากหน้าเริ่ม
	}

	public void setState(int state) {
		if (gameState != null) {
			gameState.dispose();
		}
		if (state == START) {
			gameState = new StartState(this);//เมนู
		}else if (state == PLAY) {
			gameState = new PlayState(this); //เล่น
		}else if (state == TUTORIAL) {
			gameState = new TutorialState(this); //ฝึกเล่น
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
