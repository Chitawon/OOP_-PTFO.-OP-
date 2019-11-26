package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndCreditState extends State{
	private SpriteBatch batch;
	private Texture Credit;
	
	public EndCreditState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		Credit = new Texture("CutScene/Credit/credit.png");
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		batch.begin();
		batch.draw(Credit, 0, 0);
		batch.end();
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		handle();
	}

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		if(InputManager.Isclick()) {
			gsm.setState(GameStateManager.START);
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
