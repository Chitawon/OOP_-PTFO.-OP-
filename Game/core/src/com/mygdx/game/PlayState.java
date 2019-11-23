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
	private CutScene CutScene;
	private int num = 0, pos = 1, current_Map, Stpe_moving, Scene = 1;
	private int Event = 0; // 0 = ไม่มี, 1 = สู้, 2 = CutScene, 3 = เปลี่ยน map
	private int sp_event = 30; // เกิด Scene_group_7
	private int ex_s2_event = 0; // เกิด ex_s2
	private int boss_event = 0; // เกิด boss event (CutScene, สู้)
	private int[] Position_player;
	private double DELAY;
	
	public static int Current_Status;
	
	public static int Status_PlayerTurn = 0;
	public static int Status_PlayerMoving = 1;
	public static int Status_CheckEvent = 2;
	public static int Status_Fighting_PlayerTurn = 3;
	public static int Status_Fighting_EnemyTurn = 4;
	public static int Status_EnemyTurn = 5;
	public static int Status_EnemyMoving = 6;
	public static int Status_CutScene = 7;
	
	public static final int MAP_1 = 1;
	public static final int MAP_2 = 2;
	public static final int MAP_3 = 3;
	
	public static final int Scene_group_1 = 1;
	public static final int Scene_group_2 = 2;
	public static final int Scene_group_3 = 3;
	public static final int Scene_group_4 = 4;
	public static final int Scene_group_5 = 5;
	public static final int Scene_group_6 = 6;
	public static final int Scene_group_7 = 7;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		setMap(MAP_1);
		setCutScene_group(Scene_group_1);
		Current_Status = Status_CutScene;
	}
	
	@Override
	public void init() {
		Position_player = new int[2];
		random = new Random();
		batch = new SpriteBatch();
		dice = new Sprite(new Texture(Gdx.files.internal("UI/dice_walk.png")));
		player = new Sprite(new Texture(Gdx.files.internal("Board/player_board.png"))); //set Sprite เป็นรูป
		icon = new Texture("UI/player_icon.png");
		skill_1 = new Texture("player_skill_1.png");
		bag = new Texture("UI/BP.png");
		dn = new Texture("UI/dice_walk.png");
		d1 = new Texture("UI/d1.png");
		d2 = new Texture("UI/d2.png");
		d3 = new Texture("UI/d3.png");
		d4 = new Texture("UI/d4.png");
		Position_player = Map.Position(pos);
}
	
	@Override
	public void draw() {
		batch.begin();
		/* Map */
		Map.draw(batch);

		/* UI */
		batch.draw(icon, 32, 16, 128, 160);
		batch.draw(skill_1, 192,16, 96, 96);
		batch.draw(bag, 448, 16, 96, 96);
		dice.setPosition(320, 16);
		dice.setSize(96, 96);
		dice.draw(batch);
		player.setPosition(Position_player[0], Position_player[1]);
		player.setSize(84, 100);
		player.draw(batch);
		if(Current_Status == Status_CutScene) {
			CutScene.draw(batch);
		}
		batch.end();
	}
	
	@Override
	public void update(float dt) {
		handle();
		
		if(Current_Status == Status_PlayerMoving || Current_Status == Status_CheckEvent) {
			DELAY -= dt;
		}
		
		if(DELAY <= 0) {
			DELAY = 0;
		}
		
		if(Current_Status == Status_PlayerMoving && DELAY <= 0 && Stpe_moving != num) {
			Stpe_moving += 1;
			pos += 1;
			
			if(pos >= 47 && current_Map == MAP_1) {
				Stpe_moving = num;
				pos = 47;
			}else if(pos >= 45 && current_Map == MAP_2) {
				Stpe_moving = num;
				pos = 45;
			}else if(pos >= 51 && current_Map == MAP_3) {
				Stpe_moving = num;
				pos = 51;
			}
			
			setPosition();
			DELAY = 0.5;
			
		}else if(Current_Status == Status_PlayerMoving && DELAY <= 0 && Stpe_moving == num) {
			Current_Status = Status_CheckEvent;
			Stpe_moving = 0;
			DELAY = 1;
		}
		
		
		if(Current_Status == Status_CheckEvent) {
			if(pos == 47 && current_Map == MAP_1) {
				Event = 0;
				setMap(MAP_2);
				num = 0;
				pos = 1;
				setPosition();
			}else if(pos == 45 && current_Map == MAP_2) {
				Event = 0;
				setMap(MAP_3);
				num = 0;
				pos = 1;
				setPosition();
			}
			if(pos >= 13 && current_Map == MAP_2 && ex_s2_event == 0) {
				Event = 2;
				setCutScene_group(Scene_group_2);
				ex_s2_event = 1;
			}
			if(pos == 51 && current_Map == MAP_3 && boss_event == 0) {
				Event = 2;
				setCutScene_group(Scene_group_3);
			}else if(pos == 51 && current_Map == MAP_3 && boss_event == 2) {
				Event = 2;
				setCutScene_group(Scene_group_4);
			}else if(pos == 51 && current_Map == MAP_3 && boss_event == 3) {
				Event = 2;
				setCutScene_group(Scene_group_5);
			}
		}
		
//		if(Current_Status == Status_Fighting_PlayerTurn) {
//			if(boss_event == 1) {
//				
//			}
//		}
		
		
		if(Current_Status == Status_CheckEvent && DELAY <= 0) {
			if(Event == 0) {
				Current_Status = Status_PlayerTurn;
				setDice(0);
			}else if(Event == 1) {
				Current_Status = Status_Fighting_PlayerTurn;
				setDice(0);
			}else if(Event == 2) {
				Current_Status = Status_CutScene;
				setDice(0);
			}
		}
	}
	
	@Override
	public void handle() {
		int CursorX = InputManager.getCursorX();
		int CursorY = InputManager.getCursorY();
		
		/*Mouse is click*/
		
		if(InputManager.Isclick()) {
			/*PlayerTurn*/
			if((Current_Status == Status_PlayerTurn)) {
				if((CursorX >= dice.getX() && CursorX <= dice.getX() + dice.getWidth()) 
					&& 
			(CursorY <= Gdx.graphics.getHeight() - dice.getY() && CursorY >= Gdx.graphics.getHeight() - dice.getY() - dice.getHeight())){
					num = random.nextInt(4) + 1; // random เลข
					Current_Status = Status_PlayerMoving;
					setDice(num);
					DELAY = 0.5;
				}
			}
			/* CutScene */
			else if(Current_Status == Status_CutScene) {
				if(Scene < CutScene.getFinal_scene()) {
					Scene += 1;
					CutScene.SetCutscreen(Scene);
				}else if(Scene >= CutScene.getFinal_scene()) {
					Scene = 1;
					if (current_Map == MAP_3 && pos == 51 && boss_event == 0) {
						Current_Status = Status_Fighting_PlayerTurn;
						boss_event = 1;
						Event = 1;
					}else {
						Event = 0;
						Current_Status = Status_PlayerTurn;
					}
				}
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
		if(dice_num == 0) {
			dice.setTexture(dn);
		}else if(dice_num == 1) {
			dice.setTexture(d1);
		}else if(dice_num == 2) {
			dice.setTexture(d2);
		}else if(dice_num == 3) {
			dice.setTexture(d3);
		}else if(dice_num == 4) {
			dice.setTexture(d4);
		}
	}
	
	public void setPosition() {
		Position_player = Map.Position(pos);
	}
	
	public void setCutScene_group(int scene_group) {
		if(scene_group == Scene_group_1) {
			CutScene = new CutScene_001_Prologue();
		}else if(scene_group == Scene_group_2) {
			CutScene = new CutScene_EX_State2();
		}else if(scene_group == Scene_group_3) {
			CutScene = new CutScene_002_Boss_intro();
		}else if(scene_group == Scene_group_4) {
			CutScene = new CutScene_003_End1();
		}else if(scene_group == Scene_group_5) {
			CutScene = new CutScene_004_End2();
		}else if(scene_group == Scene_group_6) {
			CutScene = new CutScene_EX_EndCredit();
		}else if(scene_group == Scene_group_7) {
			CutScene = new CutScene_EX_Secret_wepon();
		}
		CutScene.init();
	}
}
