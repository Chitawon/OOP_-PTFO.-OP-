package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class TutorialState extends State{
	private SpriteBatch batch;
	private int Current_Scene = 1;
	private Sprite Scene;
	private Texture Scene_1, Scene_2, Scene_3, Scene_4, Scene_5, Scene_6, Scene_7, Scene_8;
	
	public TutorialState(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void init() {
		batch = new SpriteBatch();
		Scene_1 = new Texture("CutScene/Tutorial/tutorial1.png");
		Scene_2 = new Texture("CutScene/Tutorial/tutorial2.png");
		Scene_3 = new Texture("CutScene/Tutorial/tutorial3.png");
		Scene_4 = new Texture("CutScene/Tutorial/tutorial4.png");
		Scene_5 = new Texture("CutScene/Tutorial/tutorial5.png");
		Scene_6 = new Texture("CutScene/Tutorial/tutorial6.png");
		Scene_7 = new Texture("CutScene/Tutorial/tutorial7.png");
		Scene_8 = new Texture("CutScene/Tutorial/tutorial8.png");
		Scene = new Sprite(Scene_1);
	}
	
	@Override
	public void draw() {
		batch.begin();
		Scene.draw(batch);
		batch.end();
	}
	
	@Override
	public void update(float dt) {
		handle();
	}
	
	@Override
	public void handle() {
		int[] Cursor = {InputManager.getCursorX(), InputManager.getCursorY()};
		if(InputManager.Isclick()) {
			if((Cursor[0] >= 0 && Cursor[0] <= 0 + 96) 
					&& 
			(Cursor[1] <= Gdx.graphics.getHeight() - 656 && Cursor[1] >= Gdx.graphics.getHeight() - 656 - 128)) {
				gsm.setState(GameStateManager.START);
			}else {
				if(Current_Scene < 8) {
					Current_Scene += 1;
					SetCutscreen(Current_Scene);
				}else if(Current_Scene >= 8) {
					gsm.setState(GameStateManager.PLAY);
					gsm.bgMusic.setMusicState(false, gsm.bgMusic.START);
				}
			}
		}
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void SetCutscreen(int order) {
		if(order == 2) {
			Scene.setTexture(Scene_2);
		}else if(order == 3) {
			Scene.setTexture(Scene_3);
		}else if(order == 4) {
			Scene.setTexture(Scene_4);
		}else if(order == 5) {
			Scene.setTexture(Scene_5);
		}else if(order == 6) {
			Scene.setTexture(Scene_6);
		}else if(order == 7) {
			Scene.setTexture(Scene_7);
		}else if(order == 8) {
			Scene.setTexture(Scene_8);
		}
	}

}
