package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class PlayState extends State{
	private SpriteBatch batch;
	
	private Texture icon, skill_moving, bag, dn, d1, d2, d3, d4;
	private Sprite hpbar1, hpbar2;
	private Sprite dice_moving, player;
	
	private Random random;
	
	private Character Enemy;
//	private Seele Seele;
	private Calico Calico;
	private Fight_Field Fight_Field;
	private Map Map;
	
	private CutScene CutScene;
	
	private int num_player = 0, pos = 1, current_Map, Stpe_moving, Scene = 1, num_enemy = 0, skill = 0, final_s = 0;
	private int Event = 0; // 0 = ไม่มี, 1 = สู้, 2 = CutScene, 3 = เปลี่ยน map
//	private int sp_event = 30; // เกิด Scene_group_7
	private int ex_s2_event = 0; // เกิด ex_s2
	private int boss_event = 0; // เกิด boss event (CutScene, สู้)
	
	private double DELAY;
	
	public static int Current_Status;
	public static int Fighting_Turn = 1;
	
	public static int Status_PlayerTurn = 0;
	public static int Status_PlayerMoving = 1;
	public static int Status_CheckEvent = 2;
	public static int Status_Fighting = 3;
	public static int Status_EnemyTurn = 4;
	public static int Status_EnemyMoving = 5;
	public static int Status_CutScene = 6;
	
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
		random = new Random();
		batch = new SpriteBatch();
		
		/*UI Move Field*/
		dice_moving = new Sprite(new Texture(Gdx.files.internal("UI/dice_walk.png")));
		icon = new Texture("UI/player_icon.png");
		skill_moving = new Texture("player_skill_1.png");
		hpbar1 = new Sprite(new Texture(Gdx.files.internal("UI/hpbar1.png")));
		hpbar2 = new Sprite(new Texture(Gdx.files.internal("UI/hpbar2.png")));
		bag = new Texture("UI/BP.png");
		dn = new Texture("UI/dice_walk.png");
		d1 = new Texture("UI/d1.png");
		d2 = new Texture("UI/d2.png");
		d3 = new Texture("UI/d3.png");
		d4 = new Texture("UI/d4.png");

		/*UI Combat Field*/
		Fight_Field = new Fight_Field();
		Fight_Field.init();
		
		/*Player*/
		Calico = new Calico();
		Calico.init();
		Calico.setPosition(Map.Position(pos));
		
//		/*Seele*/
//		Seele = new Seele();
//		Seele.init();
}
	
	@Override
	public void draw() {
		batch.begin();
		if(final_s == 0) {
			/* Map */
			Map.draw(batch);

			/* UI */
			batch.draw(icon, 32, 16, 128, 160);
			batch.draw(skill_moving, 192, 16, 96, 96);
			batch.draw(bag, 448, 16, 96, 96);
			hpbar1.setSize(408, 40);
			hpbar1.setPosition(192, 136);
			hpbar1.draw(batch);
			hpbar2.setPosition(196, 140);
			hpbar2.draw(batch);
			dice_moving.setPosition(320, 16);
			dice_moving.setSize(96, 96);
			dice_moving.draw(batch);
			Calico.draw(batch);
		}
//		if(ex_s2_event == 1) {
//			Seele.draw(batch);
//		}
		if(Current_Status == Status_CutScene) {
			CutScene.draw(batch);
		}
		if(Current_Status == Status_Fighting) {
			Fight_Field.draw(batch, Calico, Enemy);
		}
		batch.end();
	}
	
	@Override
	public void update(float dt) {
		handle();

		hpbar2.setSize(Calico.getHP() * 8, 32);
		
		if(Current_Status == Status_PlayerMoving || Current_Status == Status_CheckEvent || Current_Status == Status_Fighting) {
			DELAY -= dt;
		}
		
		if(DELAY <= 0) {
			DELAY = 0;
		}
		
		if(Current_Status == Status_PlayerMoving && DELAY <= 0 && Stpe_moving != num_player) {
			Stpe_moving += 1;
			pos += 1;
			
			if(pos >= 47 && current_Map == MAP_1) {
				Stpe_moving = num_player;
				pos = 47;
			}else if(pos >= 45 && current_Map == MAP_2) {
				Stpe_moving = num_player;
				pos = 45;
			}else if(pos >= 51 && current_Map == MAP_3) {
				Stpe_moving = num_player;
				pos = 51;
			}
			
			Calico.setPosition(Map.Position(pos));
			DELAY = 0.5;
			
		}else if(Current_Status == Status_PlayerMoving && DELAY <= 0 && Stpe_moving == num_player) {
			Current_Status = Status_CheckEvent;
			Stpe_moving = 0;
			DELAY = 1;
		}
		
		
		//Fighting_Turn % 2 != 0 เทริน player
		//Fighting_Turn % 2 == 0 เทริน enemy
		
		if(Current_Status == Status_Fighting) {
			if((Fighting_Turn % 2 != 0) && (num_player == 0)) {
				Calico.setDice_atk(num_player);
			}else if((Fighting_Turn % 2 == 0) && (num_player == 0)){
				Calico.setDice_def(num_player);
			}else if((Fighting_Turn % 2 != 0) && (num_player != 0)){
				Calico.setDice_atk(num_player);
			}else if((Fighting_Turn % 2 == 0) && (num_player != 0)){
				Calico.setDice_def(num_player);
			}
			
			if((Fighting_Turn % 2 == 0) && (num_enemy == 0)) {
				Enemy.setDice_atk(num_enemy);
			}else if((Fighting_Turn % 2 != 0) && (num_enemy == 0)){
				Enemy.setDice_def(num_enemy);
			}else if((Fighting_Turn % 2 != 0) && (num_enemy != 0)){
				Enemy.setDice_atk(num_enemy);
			}else if((Fighting_Turn % 2 == 0) && (num_enemy != 0)){
				Enemy.setDice_def(num_enemy);
			}
			Calico.update(dt);
			Enemy.update(dt);
		}
		
		if(Current_Status == Status_Fighting && DELAY <= 0) {
			if(Enemy.getHP() <= 0) {
				Current_Status = Status_CheckEvent;
			}
		}
		
		/*Fighting*/
		
		if(Current_Status == Status_Fighting && DELAY <= 0) {
			if((Fighting_Turn % 2 != 0) && (num_player != 0) && (num_enemy == 0)) {
				num_enemy = random.nextInt(6) + 1; // random เลข
			}else if((Fighting_Turn % 2 != 0) && (num_player != 0) && (num_enemy != 0)) {
				Calico.setAnimation(1);
				Enemy.setAnimation(2);
				if(num_enemy >= num_player) {
					Enemy.TakeDMG(1 * 20);
					DELAY = 0.5;
				}else {
					Enemy.TakeDMG(20 * num_player - num_enemy);
					DELAY = 0.5;
				}
				if(Enemy.getHP() > 0) {
					num_player = 0;
					num_enemy = 0;
					Fighting_Turn += 1;
				}else {
					Calico.setAnimation(0);
					Enemy.setAnimation(3);
					if(boss_event != 1) {
						Map.Enemy_Alive(pos);
					}else {
						boss_event = 2;
					}
				}
			}else if((Fighting_Turn % 2 == 0) && (num_player == 0) && (num_enemy == 0)) {
				num_enemy = random.nextInt(6) + 1; // random เลข
			}else if((Fighting_Turn % 2 == 0) && (num_player != 0) && (num_enemy != 0)) {
				if(num_player >= num_enemy) {
					Calico.setAnimation(2);
					Enemy.setAnimation(1);
					Calico.TakeDMG(1);
				}else {
					Calico.setAnimation(2);
					Enemy.setAnimation(1);
					Calico.TakeDMG(num_enemy - num_player);
				}
				if(Calico.getHP() > 0) {
					num_player = 0;
					num_enemy = 0;
					Fighting_Turn += 1;
				}
				else {
					Calico.setAnimation(3);
				}
			}
			DELAY = 1;
		}
		
		
		if(Current_Status == Status_CheckEvent) {
			
			if(pos == 47 && current_Map == MAP_1) {
				Event = 0;
				Calico.setHP(50);
				setMap(MAP_2);
				num_player = 0;
				pos = 1;
				Calico.setPosition(Map.Position(pos));
			}else if(pos == 45 && current_Map == MAP_2) {
				Event = 0;
				Calico.setHP(50);
				setMap(MAP_3);
				num_player = 0;
				pos = 1;
				Calico.setPosition(Map.Position(pos));
			}
			
			if(pos >= 13 && current_Map == MAP_2 && ex_s2_event == 0) {
				Event = 2;
				setCutScene_group(Scene_group_2);
			}else if(pos == 51 && current_Map == MAP_3 && boss_event == 0) {
				Event = 2;
				setCutScene_group(Scene_group_3);
			}else if(pos == 51 && current_Map == MAP_3 && boss_event == 2) {
				Event = 2;
				setCutScene_group(Scene_group_4);
			}else if(pos == 51 && current_Map == MAP_3 && boss_event == 3) {
				Event = 2;
				setCutScene_group(Scene_group_5);
			}else if(pos == 51 && current_Map == MAP_3 && boss_event == 4) {
				Event = 2;
				setCutScene_group(Scene_group_6);
			}else if(Map.CheckFight(pos)) {
				Event = 1;
			}else if(pos == 51 && current_Map == MAP_3 && boss_event == 1) {
				Event = 1;
			}else {
				Event = 0;
			}
		}
		
		if(Current_Status == Status_CheckEvent && DELAY <= 0) {
			if(Event == 0) {
				Current_Status = Status_PlayerTurn;
				setDice_moving(0);
				num_enemy = 0;
				num_player = 0;
				setEnemy(0);
			}else if(Event == 1) {
				Fighting_Turn = 1;
				setEnemy(1);
				Current_Status = Status_Fighting;
				setDice_moving(0);
				num_enemy = 0;
				num_player = 0;
			}else if(Event == 2) {
				Current_Status = Status_CutScene;
				setDice_moving(0);
				num_enemy = 0;
				num_player = 0;
			}
		}
	}
	
	@Override
	public void handle() {
		int[] Cursor = {InputManager.getCursorX(), InputManager.getCursorY()};
		float[] Dice_moving = {dice_moving.getX(), dice_moving.getY(), dice_moving.getWidth(), dice_moving.getHeight()};
		/*Mouse is click*/
		
		if(InputManager.Isclick()) {
			/*PlayerTurn*/
			if((Current_Status == Status_PlayerTurn)) {
				if((Cursor[0] >= Dice_moving[0] && Cursor[0] <= Dice_moving[0] + Dice_moving[2]) 
					&& 
			(Cursor[1] <= Gdx.graphics.getHeight() - Dice_moving[1] && Cursor[1] >= Gdx.graphics.getHeight() - Dice_moving[1] - Dice_moving[3])){
//					num_player = random.nextInt(4) + 1; // random เลข
					num_player = 40;
					Current_Status = Status_PlayerMoving;
					setDice_moving(num_player);
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
						Current_Status = Status_CheckEvent;
						boss_event = 1;
						Event = 1;
					}else if(current_Map == MAP_3 && pos == 51 && (boss_event == 2 || boss_event == 3)) {
						Current_Status = Status_CheckEvent;
						boss_event = 4;
						Event = 2;
						final_s = 1;
					}else if(boss_event == 4) {
						gsm.setState(GameStateManager.Credit);
					}else if(pos >= 13 && current_Map == MAP_2 && ex_s2_event == 0) {
						ex_s2_event = 1;
						Current_Status = Status_CheckEvent;
					}else {
						Event = 0;
						Current_Status = Status_CheckEvent;
					}
				}
			}
			/*Combat*/
			else if(Current_Status == Status_Fighting) {
				float[] dice_combat = {Calico.getDice_combat().getX(), Calico.getDice_combat().getY() ,Calico.getDice_combat().getWidth() ,Calico.getDice_combat().getHeight()};
//				float[] skill_combat = {Calico.getSkill_combat().getX(), Calico.getSkill_combat().getY() ,Calico.getSkill_combat().getWidth() ,Calico.getSkill_combat().getHeight()};
				/*Dice Combat*/
				if((Cursor[0] >= dice_combat[0] && Cursor[0] <= dice_combat[0] + dice_combat[2]) 
						&& 
				(Cursor[1] <= Gdx.graphics.getHeight() - dice_combat[1] && Cursor[1] >= Gdx.graphics.getHeight() - dice_combat[1] - dice_combat[3])){
						if((Fighting_Turn % 2 != 0) && (num_player == 0) && (num_enemy == 0)){
							num_player = random.nextInt(6) + 1; // random เลข
							DELAY = 0.5;
						}else if((Fighting_Turn % 2 == 0) && (num_enemy != 0) && (num_player == 0)){
							num_player = random.nextInt(6) + 1; // random เลข
							DELAY = 0.5;
						}
				}
//				/*Skill Combat*/
//				else if((Cursor[0] >= skill_combat[0] && Cursor[0] <= skill_combat[0] + skill_combat[3]) 
//						&& 
//				(Cursor[1] <= Gdx.graphics.getHeight() - skill_combat[1] && Cursor[1] >= Gdx.graphics.getHeight() - skill_combat[1] - skill_combat[4])) {
//					
//				}
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
	
	
	public void setDice_moving(int dice_num) {
		if(dice_num == 0) {
			dice_moving.setTexture(dn);
		}else if(dice_num == 1) {
			dice_moving.setTexture(d1);
		}else if(dice_num == 2) {
			dice_moving.setTexture(d2);
		}else if(dice_num == 3) {
			dice_moving.setTexture(d3);
		}else if(dice_num == 4) {
			dice_moving.setTexture(d4);
		}
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
			CutScene = new CutScene_EX_Secret_weapon();
		}
		CutScene.init();
	}
	
	public void setEnemy(int num) {
		if(num == 1 && boss_event == 1) {
			Enemy = new Theressa();
			Enemy.init();
		}else if(num == 1 && boss_event != 1) {
			Enemy = new Enemy();
			Enemy.init();
		}else if(num == 0){
			Enemy = null;
		}
	}
}
