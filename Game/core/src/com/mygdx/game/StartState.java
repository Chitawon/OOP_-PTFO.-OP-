package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Window;


public class StartState extends State{
	private SpriteBatch batch;
	private Sprite logo, startButton;
	
	public StartState(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void init() {
		logo = new Sprite(new Texture(Gdx.files.internal("C2_logo.png")));
		startButton = new Sprite(new Texture(Gdx.files.internal("M1891.png")));
	}
	
	@Override
	public void draw() {
		batch = new SpriteBatch();
		batch.begin();
		startButton.draw(batch);
		startButton.setSize(1280, 720);
		logo.draw(batch);
		logo.setPosition(640, 360);
		batch.end();
	}
	
	@Override
	public void update(float dt) {
		handle();
		
	}
	
	@Override
	public void handle() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
