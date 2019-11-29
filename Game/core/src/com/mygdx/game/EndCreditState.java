package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndCreditState extends State{
	private SpriteBatch batch;
	private Texture Credit;
	private int Scene = 1;
	private CutScene CutScene = new CutScene_EX_EndCredit();
	
	public EndCreditState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		CutScene.init();
		Credit = new Texture("CutScene/Credit/credit.png");
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		batch.begin();
		if(Scene == 1) {
			batch.draw(Credit, 0, 0);
		}else {
			CutScene.draw(batch);
		}
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
			if(Scene < CutScene.getFinal_scene()) {
				Scene += 1;
				CutScene.SetCutscreen(Scene);
			}else if(Scene >= CutScene.getFinal_scene()) {
				gsm.setState(GameStateManager.START);
			}
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
