package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class PlayState extends State{
	private SpriteBatch batch;
	private Texture icon, skill_1, skill_2, bag, dn, d1, d2, d3, d4, d5, d6;
	private Sprite dice, player;
	private Random random;
	private Map Map;
	private int num = 0, pos = 1, current_Map;
	private int[] Position_player;
	private float DELAY;
	
	public static int Current_Status = 0;
	
	public static int Status_PlayerTurn = 0;
	public static int Status_PlayerMoving = 1;
//	public static int Status_Fighting = 2;
//	public static int Status_ = 3;
//	public static int Status_ = 4;
//	public static int Status_ = 5;
//	public static int Status_ = 6;
//	public static int Status_ = 7;
//	public static int Status_ = 8;
//	public static int Status_ = 9;
	
	public static final int MAP_1 = 1;
	public static final int MAP_2 = 2;
	public static final int MAP_3 = 3;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		setMap(MAP_1);
		current_Map = MAP_1;
	}
	
	@Override
	public void init() {
		Position_player = new int[2];
		random = new Random();
		batch = new SpriteBatch();
		dice = new Sprite(new Texture(Gdx.files.internal("random.png")));
		player = new Sprite(new Texture(Gdx.files.internal("player.png"))); //set Sprite เป็นรูป
		icon = new Texture("player_icon.png");
		skill_1 = new Texture("player_skill_1.png");
		skill_2 = new Texture("player_skill_2_1.png");
		bag = new Texture("backpack.png");
		dn = new Texture("random.png");
		d1 = new Texture("d1.png");
		d2 = new Texture("d2.png");
		d3 = new Texture("d3.png");
		d4 = new Texture("d4.png");
		d5 = new Texture("d5.png");
		d6 = new Texture("d6.png");
		Position_player = Map.Position(pos);
}
	
	@Override
	public void draw() {
		batch.begin();
		/* Map */
		Map.draw(batch);

		/* UI */
		batch.draw(icon, 32, 16, 160, 192);
		batch.draw(skill_1, 244, 16, 96, 96);
		batch.draw(bag, 384, 16, 96, 96);
		dice.setPosition(512, 16);
		dice.setSize(96, 96);
		dice.draw(batch);
		player.setPosition(Position_player[0], Position_player[1]);
		player.setSize(84, 100);
		player.draw(batch);
		batch.end();
	}
	
	@Override
	public void update(float dt) {
		if(Current_Status ==) {
			DELAY -= dt;
		}
		if(DELAY <= 0) {
			DELAY = 0;
		}
		handle();
	}
	
	@Override
	public void handle() {
		int CursorX = InputManager.getCursorX();
		int CursorY = InputManager.getCursorY();
		if((CursorX >= dice.getX() && CursorX <= dice.getX() + dice.getWidth()) 
				&& 
		(CursorY <= Gdx.graphics.getHeight() - dice.getY() && CursorY >= Gdx.graphics.getHeight() - dice.getY() - dice.getHeight())){
			if(InputManager.Isclick() && Current_Status == Status_PlayerTurn) {
				num = random.nextInt(4) + 1; // random เลข
				setDice(num);
				pos += num;
				Current_Status = Status_PlayerMoving;
				DELAY = 1;
				if(pos > 47 && current_Map == MAP_1) {
					pos = 47;
				}
//				else if(pos > 45 && current_Map == MAP_2) {
//					pos = 45;
//				}else if(pos > 51 && current_Map == MAP_3) {
//					pos = 51;
//				}
				Position_player = Map.Position(pos);
			}
		}
}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void setMap(int map) {
		if(map == MAP_1) {
			Map = new Map_1();
		}else if(map == MAP_2) {
			Map = new Map_2();
		}else if(map == MAP_3) {
			Map = new Map_3();
		}
		current_Map = map;
		Map.init();
	}
	
	public void setDice(int dice_num) {
		if(dice_num == 1) {
			
		}else if(dice_num == 2) {

		}else if(dice_num == 3) {

		}else if(dice_num == 4) {

		}
	}
}
