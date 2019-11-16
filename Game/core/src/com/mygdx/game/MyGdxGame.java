package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	
	static int width, height;
	GameStateManager gsm; //สร้างเกม GameStateManager(เปลี่ยนฉาก)
	SpriteBatch batch;
	
	OrthographicCamera cam; //กล้องของเกม
	
	@Override
	public void create () {
		
		width = Gdx.graphics.getWidth();
		
		height = Gdx.graphics.getHeight();
		
		gsm = new GameStateManager();
		
		batch = new SpriteBatch();

		cam = new OrthographicCamera(width, height);
		cam.translate(width / 2, height/2); //กลางจอ
		cam.update();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		gsm.draw();
		gsm.update(Gdx.graphics.getDeltaTime());
		
		Gdx.input.setInputProcessor(new InputManager());//เปลี่ยนไปที่ InputManager ที่เราสร้างขึ้น
		
		batch.end();
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
