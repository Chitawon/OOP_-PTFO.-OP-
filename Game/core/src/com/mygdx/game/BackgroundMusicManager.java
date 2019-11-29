package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.*;

public class BackgroundMusicManager {

	public static final int START = 0;
	public static final int MAP_1n2 = 1;
	public static final int MAP_3 = 2;
	public static final int Battle = 3;
	
	private static Music Music[];
	
	public BackgroundMusicManager() {
		// TODO Auto-generated constructor stub
		Music = new Music[4];
		
		Music[0] = Gdx.audio.newMusic(Gdx.files.internal("Sound/start_Adaptative Algorithm.mp3"));
		Music[1] = Gdx.audio.newMusic(Gdx.files.internal("Sound/state1-2_Move On.mp3"));
		Music[2] = Gdx.audio.newMusic(Gdx.files.internal("Sound/state3_TO THE TWILIGHT.mp3"));
		Music[3] = Gdx.audio.newMusic(Gdx.files.internal("Sound/battle_SONWFAKE.mp3"));
	}
	
	public void play(int select) {
		Music[select].play();
		Music[select].setLooping(true);
		Music[select].setVolume(0.5f);	
	}
	
	public static void setMusicState(boolean state, int select) {

		if(state == true) {
			Music[select].play();
		}else if(state == false) {
			Music[select].pause();
		}

	}
}
