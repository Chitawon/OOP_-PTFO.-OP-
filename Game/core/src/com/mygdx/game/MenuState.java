package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;


public class MenuState extends State{
	private SpriteBatch batch;
	private Sprite player, startButton, b1, b2;
	private Texture bad;
	//private Random random; 
	private int num = 0;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void init() {
		//random = new Random();
		//num = random.nextInt(3) + 1; random เลข
		batch = new SpriteBatch();
		player = new Sprite(new Texture(Gdx.files.internal("M1985.png"))); //set Sprite เป็นรูป
		startButton = new Sprite(new Texture(Gdx.files.internal("Untitled.png"))); //set Sprite เป็นรูป
		b1 = new Sprite(new Texture(Gdx.files.internal("Untitled.png"))); //set Sprite เป็นรูป
		b2 = new Sprite(new Texture(Gdx.files.internal("Untitled.png"))); //set Sprite เป็นรูป
		
	}
	
	@Override
	public void draw() {
		batch.begin();
		startButton.setSize(300, 100);//set ขนาด
		b1.setSize(144, 100); //set ขนาด
		b2.setSize(144, 100); //set ขนาด
		b1.setCenter(440, 360); //set ภาพตรงกลางจุดที่กำหนด
		b2.setCenter(840, 360); //set ภาพตรงกลางจุดที่กำหนด
		startButton.setCenter(640, 260); //set ภาพตรงกลางจุดที่กำหนด
		player.setPosition(b1.getX(), b1.getY()); //set ภาพตรงจุดที่กำหนด
		if(num == 0) {
			player.setPosition(b2.getX(), b2.getY()); //ถ้า num = 0 อยู่ b2
		}else if (num == 1) {
			player.setPosition(b1.getX(), b1.getY()); //ถ้า num = 0 อยู่ b1
			}
		b1.draw(batch);
		b2.draw(batch);
		startButton.draw(batch);
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
		if((x >= startButton.getX() && x <= startButton.getX() + startButton.getWidth()) 
				&& 
		(y >= startButton.getY() && y <= startButton.getY() + startButton.getHeight())){
			if(InputManager.Isclick()) {
				if(num == 0) {
					num = 1;
					Gdx.app.log("Log:", num + "");
				}else if(num == 1) {
					num = 0;
					Gdx.app.log("Log:", num + "");
				}
				
			}
		}
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
