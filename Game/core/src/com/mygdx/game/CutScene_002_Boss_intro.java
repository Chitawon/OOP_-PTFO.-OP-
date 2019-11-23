package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CutScene_002_Boss_intro extends CutScene{
	
	private Sprite Scene;
	private Texture Scene_1, Scene_2, Scene_3, Scene_4, Scene_5, Scene_6, Scene_7 ;
	private Texture Scene_8, Scene_9, Scene_10, Scene_11, Scene_12, Scene_13, Scene_14;
	public int final_scene = 14;
	@Override
	public void init() {	

		Scene_1 = new Texture("CutScene/002_Boss_intro/bi_0.png");
		Scene_2 = new Texture("CutScene/002_Boss_intro/bi_1.png");
		Scene_3 = new Texture("CutScene/002_Boss_intro/bi_2.png");
		Scene_4 = new Texture("CutScene/002_Boss_intro/bi_3.png");
		Scene_5 = new Texture("CutScene/002_Boss_intro/bi_4.png");
		Scene_6 = new Texture("CutScene/002_Boss_intro/bi_5.png");
		Scene_7 = new Texture("CutScene/002_Boss_intro/bi_6.png");
		Scene_8 = new Texture("CutScene/002_Boss_intro/bi_7.png");
		Scene_9 = new Texture("CutScene/002_Boss_intro/bi_8.png");
		Scene_10 = new Texture("CutScene/002_Boss_intro/bi_9.png");
		Scene_11 = new Texture("CutScene/002_Boss_intro/bi_10.png");
		Scene_12 = new Texture("CutScene/002_Boss_intro/bi_11.png");
		Scene_13 = new Texture("CutScene/002_Boss_intro/bi_12.png");
		Scene_14 = new Texture("CutScene/002_Boss_intro/bi_13.png");

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
		}else if(order == 11) {
			Scene.setTexture(Scene_11);
		}else if(order == 12) {
			Scene.setTexture(Scene_12);
		}else if(order == 13) {
			Scene.setTexture(Scene_13);
		}else if(order == 14) {
			Scene.setTexture(Scene_14);
		}
	}
	
	@Override
	public int getFinal_scene() {
		// TODO Auto-generated method stub
		return final_scene;
	}
}
