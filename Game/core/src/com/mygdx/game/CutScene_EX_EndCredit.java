package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CutScene_EX_EndCredit extends CutScene{
	
	private Sprite Scene;
	private Texture Scene_1, Scene_2, Scene_3, Scene_4, Scene_5, Scene_6, Scene_7 ;
	private Texture Scene_8, Scene_9;
	public int final_scene = 9;
	@Override
	public void init() {	

		Scene_1 = new Texture("CutScene/EX_EndCredit/ec_1.png");
		Scene_2 = new Texture("CutScene/EX_EndCredit/ec_2.png");
		Scene_3 = new Texture("CutScene/EX_EndCredit/ec_3.png");
		Scene_4 = new Texture("CutScene/EX_EndCredit/ec_4.png");
		Scene_5 = new Texture("CutScene/EX_EndCredit/ec_5.png");
		Scene_6 = new Texture("CutScene/EX_EndCredit/ec_6.png");
		Scene_7 = new Texture("CutScene/EX_EndCredit/ec_7.png");
		Scene_8 = new Texture("CutScene/EX_EndCredit/ec_8.png");
		Scene_9 = new Texture("CutScene/EX_EndCredit/ec_9.png");

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
		}
	}
	
	@Override
	public int getFinal_scene() {
		// TODO Auto-generated method stub
		return final_scene;
	}
}
