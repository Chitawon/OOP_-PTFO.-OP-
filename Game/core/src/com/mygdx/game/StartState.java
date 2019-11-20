package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;


public class StartState extends State{
	private SpriteBatch batch;
	private Sprite startButton;
	public static boolean Change = false;
	public StartState(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void init() {
		batch = new SpriteBatch();
		startButton = new Sprite(new Texture(Gdx.files.internal("Untitled.png")));
	}
	
	@Override
	public void draw() {
		batch.begin();
		startButton.setCenter(600, 300);
		startButton.draw(batch);
		batch.end();
	}
	
	@Override
	public void update(float dt) {
		handle();
	}
	
	@Override
	public void handle() {
		if(InputManager.Isclick()) {
				dispose();
				gsm.setState(GameStateManager.MENU);
		}
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
