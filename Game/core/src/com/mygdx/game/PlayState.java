package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class PlayState extends State{
	private SpriteBatch batch;
	private Texture icon, skill_1, skill_2, bag, dn, d1, d2, d3, d4, d5, d6, teri;
	private Sprite dice, player;
	private Random random;
	private Map_1 map1;
	private int num = 0, pos = 1, p_x = 0, p_y = 0;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void init() {
		random = new Random();
		batch = new SpriteBatch();
		dice = new Sprite(new Texture(Gdx.files.internal("random.png")));
		player = new Sprite(new Texture(Gdx.files.internal("player.png"))); //set Sprite เป็นรูป
		icon = new Texture("player_icon.png");
		skill_1 = new Texture("player_skill_1.png");
		skill_2 = new Texture("player_skill_2_1.png");
		bag = new Texture("backpack.png");
		d1 = new Texture("d1.png");
		d2 = new Texture("d2.png");
		d3 = new Texture("d3.png");
		d4 = new Texture("d4.png");
		d5 = new Texture("d5.png");
		d6 = new Texture("d6.png");
		map1 = new Map_1();
		map1.init();
		p_x = map1.PositionX(pos);
		p_y = map1.PositionY(pos);
}
	
	@Override
	public void draw() {
		if(true) {
			map1.draw();
		}
		/* UI */
		batch.begin();
		batch.draw(icon, 32, 16, 160, 192);
		batch.draw(skill_1, 244, 16, 96, 96);
		batch.draw(bag, 384, 16, 96, 96);
		dice.setPosition(512, 16);
		dice.setSize(96, 96);
		dice.draw(batch);
		player.setPosition(p_x, p_y);
		player.setSize(84, 100);
		player.draw(batch);
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
		if((x >= dice.getX() && x <= dice.getX() + dice.getWidth()) 
				&& 
		(y <= Gdx.graphics.getHeight() - dice.getY() && y >= Gdx.graphics.getHeight() - dice.getY() - dice.getHeight())){
			if(InputManager.Isclick()) {
				num = random.nextInt(6) + 1; // random เลข
				pos += num;
				p_x = map1.PositionX(pos);
				p_y = map1.PositionY(pos);
			}
		}
}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
