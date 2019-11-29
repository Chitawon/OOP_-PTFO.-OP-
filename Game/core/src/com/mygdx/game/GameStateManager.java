package com.mygdx.game;

public class GameStateManager {
	private static State gameState;

	public static final int START = 1;
	public static final int PLAY = 2;
	public static final int TUTORIAL = 3;
	public static final int Credit = 4;
	
	public BackgroundMusicManager bgMusic;
	
	public GameStateManager() {	
			setState(START); // set ฉากหน้าเริ่ม
			bgMusic = new BackgroundMusicManager();
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
		}else if (state == Credit) {
			gameState = new EndCreditState(this); //ฝึกเล่น
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
