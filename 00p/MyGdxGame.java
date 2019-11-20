package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	
	static int width, height;
	SpriteBatch batch;
	Texture img;
	private int n,a = 0;
	Sprite sprite;
	
	@Override
	public void create () {

		width = Gdx.graphics.getWidth();
		
		height = Gdx.graphics.getHeight();
		
		batch = new SpriteBatch();
		img = new Texture("random.png");
		sprite = new Sprite(img);
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
	}
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		 if (button == Input.Buttons.LEFT) {
			 a = 1;
           return true;     
	      }
		 a = 0; 
	      return false;
	   }		

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
	if(Gdx.input.isTouched()) {
		onMouseDown();
	}
		sprite = new Sprite(img);
		batch.draw(sprite, sprite.getX(), sprite.getY());
		batch.end();
	}
	
	
	

	
	private void onMouseDown() {
		Random rand = new Random();;
		n = rand.nextInt(6);
		n += 1;
		if(n == 6) {
		img = new Texture("d6.png");
		sprite = new Sprite(img);
		batch.draw(sprite, sprite.getX(), sprite.getY());}
		else if(n == 1) {
			img = new Texture("d1.png");
			sprite = new Sprite(img);
			batch.draw(sprite, sprite.getX(), sprite.getY());}
	else if(n == 2) {
		img = new Texture("d2.png");
		sprite = new Sprite(img);
		batch.draw(sprite, sprite.getX(), sprite.getY());}
	else if(n == 3) {
	img = new Texture("d3.png");
	sprite = new Sprite(img);
	batch.draw(sprite, sprite.getX(), sprite.getY());}
	else if(n == 4) {
    img = new Texture("d4.png");
	sprite = new Sprite(img);
	batch.draw(sprite, sprite.getX(), sprite.getY());}
	else if(n == 5) {
		img = new Texture("d5.png");
	sprite = new Sprite(img);
	batch.draw(sprite, sprite.getX(), sprite.getY());}
    }
	
	@Override
	public void dispose () {
		batch.dispose();
	}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
