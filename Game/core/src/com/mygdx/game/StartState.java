package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;


public class StartState extends State{
	private SpriteBatch batch;
	private Sprite logo, startButton;
	private Texture bad;
	private boolean check = false;
	
	public StartState(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void init() {
		batch = new SpriteBatch();
		logo = new Sprite(new Texture(Gdx.files.internal("C2_logo.png")));
		startButton = new Sprite(new Texture(Gdx.files.internal("M1891.png")));
		bad = new Texture(Gdx.files.internal("badlogic.jpg"));
	}
	
	@Override
	public void draw() {
		batch.begin();
		
		if(check == true) {
			startButton.setSize(1280, 720);
			startButton.draw(batch);
		}
		logo.setSize(640, 360);
		logo.draw(batch);
		
		
		
		batch.end();
	}
	
	@Override
	public void update(float dt) {
		handle();
		
	}
	
	@Override
	public void handle() {
		int x = InputManager.getCursorX();
		int y = InputManager.getCursorY();
		if((x > 0) && (x < 360) && (y > 0) && (y < 640)) {
			if(InputManager.Isclick()) {
				dispose();
				gsm.setState(1);
			}
		}
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
