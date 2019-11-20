package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class PlayState extends State{
	private SpriteBatch batch;
	private Sprite player, startButton, b1, b2;
	private Texture bad;
	private Random random; 
	private int num = 0, che = 0, pos = 0;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void init() {
		random = new Random();
		batch = new SpriteBatch();
		player = new Sprite(new Texture(Gdx.files.internal("M1985.png"))); //set Sprite เป็นรูป
		startButton = new Sprite(new Texture(Gdx.files.internal("Untitled.png"))); //set Sprite เป็นรูป
		b1 = new Sprite(new Texture(Gdx.files.internal("Untitled.png"))); //set Sprite เป็นรูป
		b2 = new Sprite(new Texture(Gdx.files.internal("Untitled.png"))); //set Sprite เป็นรูป
		bad = new Texture(Gdx.files.internal("Untitled.png"));
		
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
		if(pos == 0) {
			player.setPosition(b1.getX(), b1.getY()); //ถ้า num = 0 อยู่ b2
		}else if (pos == 1) {
			player.setPosition(b2.getX(), b2.getY()); //ถ้า num = 0 อยู่ b1
		}else if (pos == 2) {
			player.setPosition(b2.getX() + 100, b2.getY()); //ถ้า num = 0 อยู่ b1
		}else if (pos == 3) {
			player.setPosition(b2.getX() + 100, b2.getY() + 100); //ถ้า num = 0 อยู่ b1
		}else if (pos == 4) {
			player.setPosition(b1.getX() - 100, b1.getY()); //ถ้า num = 0 อยู่ b1
		}else if (pos == 5) {
			player.setPosition(b1.getX() - 100, b1.getY() - 100); //ถ้า num = 0 อยู่ b1
		}
		batch.draw(bad, b2.getX() + 100, b2.getY(), 96, 96);
		batch.draw(bad, b2.getX() + 100, b2.getY() + 100, 96, 96);
		batch.draw(bad, b1.getX() - 100, b1.getY(), 96, 96);
		batch.draw(bad, b1.getX() - 100, b1.getY() - 100, 96, 96);
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
		(y <= Gdx.graphics.getHeight() - startButton.getY() && y >= Gdx.graphics.getHeight() - startButton.getY() - startButton.getHeight())){
			if(InputManager.Isclick() && che == 0) {
				num = random.nextInt(6); // random เลข
				pos += num;
			}
		}
		if(pos > 6) {
			pos = 0;
		}
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
