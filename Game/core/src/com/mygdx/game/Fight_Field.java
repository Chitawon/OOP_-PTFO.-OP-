package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fight_Field {
	private Texture fight_field;
	
	public void init() {
		/*UI Combat Field*/
		
		fight_field = new Texture("Battle/battlebar.png");
		
	}
	
	public void draw(SpriteBatch batch, Calico player, Character enemy) {
		batch.draw(fight_field, 0 ,0);
		player.drawCombat(batch);
		enemy.drawCombat(batch);
	}
}
