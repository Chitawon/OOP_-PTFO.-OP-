package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;


public class StartState extends State{
	private Sprite btn1, btn2, btn3, gametitle;
	private SpriteBatch batch;
	
	public StartState(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void init() {
		batch = new SpriteBatch();
		gametitle = new Sprite(new Texture(Gdx.files.internal("Background/gametitle.png")));
		btn1 = new Sprite(new Texture(Gdx.files.internal("Background/Untitled.png")));
		btn2 = new Sprite(new Texture(Gdx.files.internal("Background/Untitled.png")));
		btn3 = new Sprite(new Texture(Gdx.files.internal("Background/Untitled.png")));
	}
	
	@Override
	public void draw() {
		batch.begin();
		btn1.setSize(256, 64);
		btn2.setSize(352, 64);
		btn3.setSize(192, 96);
		btn1.setPosition(864, 464);
		btn2.setPosition(864, 336);
		btn3.setPosition(864, 176);
		
		
		btn1.draw(batch);
		btn2.draw(batch);
		btn3.draw(batch);
		gametitle.draw(batch);
		batch.end();
		gsm.bgMusic.play(gsm.bgMusic.START);
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
			/*Start Game*/
			if((x >= btn1.getX() && x <= btn1.getX() + btn1.getWidth()) 
				&& 
		(y <= Gdx.graphics.getHeight() - btn1.getY() && y >= Gdx.graphics.getHeight() - btn1.getY() - btn1.getHeight())){
				dispose();
				gsm.setState(GameStateManager.PLAY);
				gsm.bgMusic.setMusicState(false, gsm.bgMusic.START);
			}
			/*TUTORIAL*/
			else if((x >= btn2.getX() && x <= btn2.getX() + btn2.getWidth()) 
					&& 
		(y <= Gdx.graphics.getHeight() - btn2.getY() && y >= Gdx.graphics.getHeight() - btn2.getY() - btn2.getHeight())) {
				gsm.setState(GameStateManager.TUTORIAL);
			}
			/*Exit*/
			else if((x >= btn3.getX() && x <= btn3.getX() + btn3.getWidth()) 
					&& 
		(y <= Gdx.graphics.getHeight() - btn3.getY() && y >= Gdx.graphics.getHeight() - btn3.getY() - btn3.getHeight())) {
				Gdx.app.exit();
			}
		}
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
