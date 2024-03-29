package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CutScene_EX_State2 extends CutScene{
	
	private Sprite Scene;
	private Texture Scene_1, Scene_2, Scene_3, Scene_4, Scene_5, Scene_6, Scene_7 ;
	private Texture Scene_8, Scene_9, Scene_10;
	public int final_scene = 10;
	@Override
	public void init() {	

		Scene_1 = new Texture("CutScene/EX_State2_seele/es_1.png");
		Scene_2 = new Texture("CutScene/EX_State2_seele/es_2.png");
		Scene_3 = new Texture("CutScene/EX_State2_seele/es_3.png");
		Scene_4 = new Texture("CutScene/EX_State2_seele/es_4.png");
		Scene_5 = new Texture("CutScene/EX_State2_seele/es_5.png");
		Scene_6 = new Texture("CutScene/EX_State2_seele/es_6.png");
		Scene_7 = new Texture("CutScene/EX_State2_seele/es_7.png");
		Scene_8 = new Texture("CutScene/EX_State2_seele/es_8.png");
		Scene_9 = new Texture("CutScene/EX_State2_seele/es_9.png");
		Scene_10 = new Texture("CutScene/EX_State2_seele/es_10.png");

		Scene = new Sprite(Scene_1);
			
	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		Scene.draw(batch);
	}

	@Override
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
		}else if(order == 9) {
			Scene.setTexture(Scene_9);
		}else if(order == 10) {
			Scene.setTexture(Scene_10);
		}
	}
	
	@Override
	public int getFinal_scene() {
		// TODO Auto-generated method stub
		return final_scene;
	}
}
