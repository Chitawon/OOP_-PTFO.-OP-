package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CutScene_004_End2 extends CutScene{

	private Sprite Scene;
	private Texture Scene_1, Scene_2, Scene_3, Scene_4, Scene_5, Scene_6, Scene_7;
	private Texture Scene_8, Scene_9, Scene_10, Scene_11, Scene_12, Scene_13;
	private Texture Scene_14, Scene_15, Scene_16, Scene_17, Scene_18, Scene_19;
	private Texture Scene_20, Scene_21, Scene_22, Scene_23;
	public int final_scene = 23;
	@Override
	public void init() {	

		Scene_1 = new Texture("CutScene/004_End2/E2_1.png");
		Scene_2 = new Texture("CutScene/004_End2/E2_2.png");
		Scene_3 = new Texture("CutScene/004_End2/E2_3.png");
		Scene_4 = new Texture("CutScene/004_End2/E2_4.png");
		Scene_5 = new Texture("CutScene/004_End2/E2_5.png");
		Scene_6 = new Texture("CutScene/004_End2/E2_5_1.png");
		Scene_7 = new Texture("CutScene/004_End2/E2_5_2.png");
		Scene_8 = new Texture("CutScene/004_End2/E2_5_3.png");
		Scene_9 = new Texture("CutScene/004_End2/E2_5_4.png");
		Scene_10 = new Texture("CutScene/004_End2/E2_5_5.png");
		Scene_11 = new Texture("CutScene/004_End2/E2_5_6.png");
		Scene_12 = new Texture("CutScene/004_End2/E2_5_7.png");
		Scene_13 = new Texture("CutScene/004_End2/E2_5_8.png");
		Scene_14 = new Texture("CutScene/004_End2/E2_5_9.png");
		Scene_15 = new Texture("CutScene/004_End2/E2_5_10.png");
		Scene_16 = new Texture("CutScene/004_End2/E2_6.png");
		Scene_17 = new Texture("CutScene/004_End2/E2_7.png");
		Scene_18 = new Texture("CutScene/004_End2/E2_8.png");
		Scene_19 = new Texture("CutScene/004_End2/E2_9.png");
		Scene_20 = new Texture("CutScene/004_End2/E2_10.png");
		Scene_21 = new Texture("CutScene/004_End2/E2_11.png");
		Scene_22 = new Texture("CutScene/004_End2/E2_12.png");
		Scene_23 = new Texture("CutScene/004_End2/E2_13.png");

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
		}else if(order == 15) {
			Scene.setTexture(Scene_15);
		}else if(order == 16) {
			Scene.setTexture(Scene_16);
		}else if(order == 17) {
			Scene.setTexture(Scene_17);
		}else if(order == 18) {
			Scene.setTexture(Scene_18);
		}else if(order == 19) {
			Scene.setTexture(Scene_19);
		}else if(order == 20) {
			Scene.setTexture(Scene_20);
		}else if(order == 21) {
			Scene.setTexture(Scene_21);
		}else if(order == 22) {
			Scene.setTexture(Scene_22);
		}else if(order == 23) {
			Scene.setTexture(Scene_23);
		}
	}
	
	@Override
	public int getFinal_scene() {
		// TODO Auto-generated method stub
		return final_scene;
	}
}
