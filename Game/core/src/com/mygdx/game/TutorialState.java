package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class TutorialState extends State{
	private SpriteBatch batch;
	private Sprite startButton, b1, b2;
	
	public TutorialState(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void init() {
		batch = new SpriteBatch();
		startButton = new Sprite(new Texture(Gdx.files.internal("Background/Untitled.png")));
		b1 = new Sprite(new Texture(Gdx.files.internal("Background/Untitled.png")));
		b2 = new Sprite(new Texture(Gdx.files.internal("Background/Untitled.png")));
		
	}
	
	@Override
	public void draw() {
		batch.begin();
		startButton.setSize(300, 100);
		b1.setSize(144, 100);
		b2.setSize(144, 100);
		b1.setCenter(440, 360);
		b2.setCenter(840, 360);
		startButton.setCenter(640, 260);
		b1.draw(batch);
		b2.draw(batch);
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
			gsm.setState(GameStateManager.START);
			}
		}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
