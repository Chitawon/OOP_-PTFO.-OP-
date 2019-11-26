package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class TutorialState extends State{
	private SpriteBatch batch;
	private int Current_Scene = 1;
	private Sprite Scene;
	private Texture Scene_1, Scene_2, Scene_3;
	
	public TutorialState(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void init() {
		batch = new SpriteBatch();
		Scene_1 = new Texture("CutScene/Tutorial/tutorial1.png");
		Scene_2 = new Texture("CutScene/Tutorial/tutorial2.png");
		Scene_3 = new Texture("CutScene/Tutorial/tutorial3.png");
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
				if(Current_Scene < 3) {
					Current_Scene += 1;
					SetCutscreen(Current_Scene);
				}else if(Current_Scene >= 3) {
					gsm.setState(GameStateManager.PLAY);
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
		}
	}

}
