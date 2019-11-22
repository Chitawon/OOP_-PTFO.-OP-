package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	
	static int width, height;
	SpriteBatch batch;
	Texture img;
	private int n;
	Sprite sprite;
	
	OrthographicCamera cam;
	
	@Override
	public void create () {
		
		width = Gdx.graphics.getWidth();
		
		height = Gdx.graphics.getHeight();
		
		batch = new SpriteBatch();
		img = new Texture("random.png");
		sprite = new Sprite(img);
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		cam = new OrthographicCamera(width, height);
		cam.translate(width / 2, height/2);
		cam.update();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		Gdx.input.setInputProcessor(new InputManager());
		int x = InputManager.getCursorX();
		int y = InputManager.getCursorY();
		if(Gdx.input.isTouched()) {
			if(x > 20&&y > 20) {
			onMouseDown();}
		}
		sprite = new Sprite(img);
		batch.draw(sprite, sprite.getX(), sprite.getY());
		Gdx.input.setInputProcessor(new InputManager());
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
}