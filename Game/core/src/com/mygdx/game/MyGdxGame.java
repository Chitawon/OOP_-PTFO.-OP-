package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	
	GameStateManager gsm; //สร้างเกม GameStateManager(เปลี่ยนฉาก)
	SpriteBatch batch;
	
	@Override
	public void create () {

		gsm = new GameStateManager();
		
		batch = new SpriteBatch();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		gsm.draw();
		gsm.update(Gdx.graphics.getDeltaTime());
		Gdx.input.setInputProcessor(new InputManager());//เปลี่ยนรับ Input ที่ InputManager ที่เราสร้างขึ้น
		
		batch.end();
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
