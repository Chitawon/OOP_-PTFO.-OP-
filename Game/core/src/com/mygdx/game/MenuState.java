package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;


public class MenuState extends State{
	private SpriteBatch batch;
	private Sprite logo, startButton;
	private Texture bad;
	
	public MenuState(GameStateManager gsm) {
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
		startButton.setSize(1280, 720);
		startButton.draw(batch);
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
		if(InputManager.Isclick()) {
			dispose();
			gsm.setState(0);
		}
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
