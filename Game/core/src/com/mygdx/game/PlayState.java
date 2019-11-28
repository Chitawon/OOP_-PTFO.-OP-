package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class PlayState extends State{
	private SpriteBatch batch;
	
	private Texture icon, dn, d1, d2, d3, d4;
	private Sprite weapon_1, weapon_2, weapon_3, weapon_4, weapon_5;
	private Sprite Bag, hpbar1, hpbar2;
	private Sprite dice_moving;
	
	private Random random;
	
	private Character Enemy;
	private Seele Seele;
	private Calico Calico;
	private Fight_Field Fight_Field;
	private Map Map;
	
	private CutScene CutScene;
	
	private float[][] weapon;
	private int num_player = 0, position_player = 1, pos_e = 1, current_Map, Stpe_moving, Scene = 1, num_enemy = 0, final_s = 0;
	private int Event = 0; // 0 = ไม่มี, 1 = สู้, 2 = CutScene, 3 = เปลี่ยน map
//	private int sp_event = 30; // เกิด Scene_group_7
	private int ex_s2_event = 0, countdown_e = 0; // เกิด ex_s2
	private int boss_event = 0; // เกิด boss event (CutScene, สู้)
	private boolean open_bag = false;
	
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
		hpbar1 = new Sprite(new Texture(Gdx.files.internal("UI/hpbar1.png")));
		hpbar2 = new Sprite(new Texture(Gdx.files.internal("UI/hpbar2.png")));
		
		Bag = new Sprite(new Texture(Gdx.files.internal("UI/BP.png")));
		
//		weapon_1 = new Sprite(new Texture(Gdx.files.internal("UI/dagger_icon.png")));
//		weapon_2 = new Sprite(new Texture(Gdx.files.internal("UI/pistol_icon.png")));
//		weapon_3 = new Sprite(new Texture(Gdx.files.internal("UI/sniper_icon.png")));
//		weapon_4 = new Sprite(new Texture(Gdx.files.internal("UI/dagger_icon.png")));
//		weapon_5 = new Sprite(new Texture(Gdx.files.internal("UI/dagger_icon.png")));
		
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
		Calico.setPosition_Calico(Map.Position(position_player));
		
		/*Seele*/
		Seele = new Seele();
		Seele.init();
//		
//		float[][] weapon = new float[5][];
//		weapon[0] = new float[] {weapon_1.getX(), weapon_1.getY(), weapon_1.getWidth(), weapon_1.getHeight()};
//		weapon[1] = new float[] {weapon_2.getX(), weapon_2.getY(), weapon_2.getWidth(), weapon_2.getHeight()};
//		weapon[2] = new float[] {weapon_3.getX(), weapon_3.getY(), weapon_3.getWidth(), weapon_3.getHeight()};
//		weapon[3] = new float[] {weapon_4.getX(), weapon_4.getY(), weapon_4.getWidth(), weapon_4.getHeight()};
//		weapon[4] = new float[] {weapon_5.getX(), weapon_5.getY(), weapon_5.getWidth(), weapon_5.getHeight()};
}
	
	@Override
	public void draw() {
		batch.begin();
		if(final_s == 0) {
			/* Map */
			Map.draw(batch);

			/* UI */
			batch.draw(icon, 32, 16, 128, 160);
			Bag.setPosition(448, 16);
			Bag.setSize(96, 96);
			Bag.draw(batch);
			hpbar1.setSize(408, 40);
			hpbar1.setPosition(192, 136);
			hpbar1.draw(batch);
			hpbar2.setPosition(196, 140);
			hpbar2.draw(batch);
			dice_moving.setPosition(320, 16);
			dice_moving.setSize(96, 96);
			dice_moving.draw(batch);
			
//			/*Weapon*/
//			if(open_bag == true) {
//				weapon_1.setPosition(448, 16);
//				weapon_1.setSize(96, 96);
//				weapon_1.draw(batch);
//				weapon_2.setPosition(448, 16);
//				weapon_2.setSize(96, 96);
//				weapon_2.draw(batch);
//				weapon_3.setPosition(448, 16);
//				weapon_3.setSize(96, 96);
//				weapon_3.draw(batch);
//				weapon_4.setPosition(448, 16);
//				weapon_4.setSize(96, 96);
//				weapon_4.draw(batch);
//				weapon_5.setPosition(448, 16);
//				weapon_5.setSize(96, 96);
//				weapon_5.draw(batch);
//			}
			
			/*Player*/
			Calico.draw(batch);
		}
		
		if(ex_s2_event != 0) {
			Seele.draw(batch);
		}
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
		
		if(Current_Status == Status_PlayerMoving || Current_Status == Status_CheckEvent || Current_Status == Status_Fighting || Current_Status == Status_EnemyMoving) {
			DELAY -= dt;
		}
		
		if(DELAY <= 0) {
			DELAY = 0;
		}
		
		if(Current_Status == Status_PlayerMoving && DELAY <= 0 && Stpe_moving != num_player) {
			Stpe_moving += 1;
			position_player += 1;
			
			if(position_player >= 47 && current_Map == MAP_1) {
				Stpe_moving = num_player;
				position_player = 47;
			}else if(position_player >= 45 && current_Map == MAP_2) {
				Stpe_moving = num_player;
				position_player = 45;
			}else if(position_player >= 51 && current_Map == MAP_3) {
				Stpe_moving = num_player;
				position_player = 51;
			}
			
			Calico.setPosition_Calico(Map.Position(position_player));
			DELAY = 0.5;
			
		}else if(Current_Status == Status_PlayerMoving && DELAY <= 0 && Stpe_moving == num_player) {
			Current_Status = Status_CheckEvent;
			Stpe_moving = 0;
			DELAY = 1;
			if((ex_s2_event == 3 && countdown_e <= 0) || ex_s2_event == 2) {
				ex_s2_event = 1;
				countdown_e = 0;
			}else if (ex_s2_event == 3 && countdown_e > 0) {
				countdown_e -= 1;
			}
		}
		
		
		//Fighting_Turn % 2 != 0 เทริน player
		//Fighting_Turn % 2 == 0 เทริน enemy
		
		if(Current_Status == Status_Fighting) {
			
			if(Fighting_Turn % 2 != 0){
				Calico.setSkill_atk(Calico.skill_player);
			}
			
			if((Fighting_Turn % 2 != 0) && (num_player == 0)) {
				Calico.setDice_atk(num_player);
			}else if((Fighting_Turn % 2 == 0) && (num_player == 0)){
				Calico.setDice_def(num_player);
			}else if((Fighting_Turn % 2 != 0) && (num_player != 0)){
				Calico.setDice_atk(num_player);
			}else if((Fighting_Turn % 2 == 0) && (num_player != 0)){
				Calico.setDice_def(num_player);
			}
			
			if(Fighting_Turn % 2 == 0){
				Calico.setSkill_def(Calico.skill_player);
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
			if(Enemy.getHP() <= 0 || (Map.CheckFight(position_player) == false)) {
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
				if(Calico.skill_player == 1) {
					if(num_enemy >= num_player) {
						Enemy.TakeDMG(1);
						DELAY = 0.5;
					}else {
						Enemy.TakeDMG((num_player - num_enemy) * 2);
						DELAY = 0.5;
					}
				}else if(Calico.skill_player == 2) {
					if(num_enemy >= num_player * 2) {
						Enemy.TakeDMG(1);
						DELAY = 0.5;
					}else {
						Enemy.TakeDMG((num_player * 2) - num_enemy);
						DELAY = 0.5;
					}
				}else if(Calico.skill_player == 3) {
					if(num_enemy >= num_player) {
						Enemy.TakeDMG(5);
						DELAY = 0.5;
					}else {
						Enemy.TakeDMG((num_player + 5) - num_enemy);
						DELAY = 0.5;
					}
				}else if(Calico.skill_player == 4) {
					if(num_enemy >= num_player) {
						Enemy.TakeDMG(3);
						DELAY = 0.5;
					}else {
						Enemy.TakeDMG((num_player * 3) - num_enemy);
						DELAY = 0.5;
					}
				}else if(Calico.skill_player == 5) {
					if(num_enemy >= num_player) {
						Enemy.TakeDMG(2);
						DELAY = 0.5;
					}else {
						Enemy.TakeDMG((num_player + 2) - num_enemy);
						DELAY = 0.5;
					}
				}
				if(Enemy.getHP() > 0) {
					num_player = 0;
					num_enemy = 0;
					Fighting_Turn += 1;
				}else {
					Calico.setAnimation(0);
					Enemy.setAnimation(3);
					if(boss_event != 1) {
						Map.Enemy_Alive(position_player);
					}else {
						boss_event = 2;
					}
				}
				
				
			}else if((Fighting_Turn % 2 == 0) && (num_player == 0) && (num_enemy == 0)) {
				num_enemy = random.nextInt(6) + 1; // random เลข
			}else if((Fighting_Turn % 2 == 0) && (num_player != 0) && (num_enemy != 0)) {
				Calico.setAnimation(2);
				Enemy.setAnimation(1);
				if(Calico.skill_player == 1) {
					if(num_player >= num_enemy) {
						Calico.setHP(Calico.getHP() + 1);
						DELAY = 0.5;
					}else {
						Calico.TakeDMG(num_enemy - num_player);
						DELAY = 0.5;
					}
				}else if(Calico.skill_player == 2) {
					if(num_player >= num_enemy) {
						Enemy.TakeDMG(num_player - num_enemy);
						Calico.TakeDMG(1);
						DELAY = 0.5;
						
					}else {
						Calico.TakeDMG(num_enemy - num_player);
						DELAY = 0.5;
					}
				}else if(Calico.skill_player == 3) {
					if(num_player >= num_enemy) {
						Calico.TakeDMG(1);
						DELAY = 0.5;		
					}else {
						Calico.TakeDMG(num_enemy - num_player);
						DELAY = 0.5;
					}
				}else if(Calico.skill_player == 4) {
					Calico.TakeDMG(1);
					DELAY = 0.5;
				}else if(Calico.skill_player == 5) {
					Calico.TakeDMG(1);
					Calico.setAnimation(0);
					Enemy.setAnimation(0);
					Map.Enemy_Alive(position_player);
					if(boss_event == 1) {
						boss_event = 3;
					}
				}
				if(Calico.getHP() > 0) {
					num_player = 0;
					num_enemy = 0;
					Fighting_Turn += 1;
				}else if(Enemy.getHP() <= 0) {
					Calico.setAnimation(0);
					Enemy.setAnimation(3);
					Map.Enemy_Alive(position_player);
				}else {
					Calico.setAnimation(3);
					Current_Status = Status_CheckEvent;
				}
			}
			DELAY = 1;
		}
		
		/*Seele*/
		
		if(Current_Status == Status_EnemyTurn) {
			num_enemy = random.nextInt(4) + 1;
			Current_Status = Status_EnemyMoving;
			DELAY = 0.5;
			
		}
		
		if(Current_Status == Status_EnemyMoving && DELAY <= 0 && Stpe_moving != num_enemy) {
			
			Stpe_moving += 1;
			pos_e += 1;
			
			if(position_player == pos_e) {
				Stpe_moving = num_enemy;
				pos_e = position_player;
			}

			Seele.setPosition_Seele(pos_e);
			DELAY = 0.5;
			
		}else if(Current_Status == Status_EnemyMoving && DELAY <= 0 && Stpe_moving == num_enemy) {
			Current_Status = Status_CheckEvent;
			ex_s2_event = 2;
			Stpe_moving = 0;
			DELAY = 1;
			if(position_player == pos_e) {
				Calico.TakeDMG(10);
				ex_s2_event = 3;
				countdown_e = 3;
			}
		}
		
		
		/*CheckEvent*/
		
		if(Current_Status == Status_CheckEvent) {
			
			if(position_player == 47 && current_Map == MAP_1) {
				Event = 0;
				Calico.setHP(50);
				setMap(MAP_2);
				num_player = 0;
				position_player = 1;
				Calico.setPosition_Calico(Map.Position(position_player));
			}else if(position_player == 45 && current_Map == MAP_2) {
				Event = 0;
				Calico.setHP(50);
				setMap(MAP_3);
				num_player = 0;
				position_player = 1;
				pos_e = 0;
				ex_s2_event = 0;
				Calico.setPosition_Calico(Map.Position(position_player));
			}
			
			if(current_Map == MAP_1 && Calico.getHP() <= 0) {
				Event = 0;
				Calico.setHP(50);
				setMap(MAP_1);
				num_player = 0;
				position_player = 1;
				Calico.setPosition_Calico(Map.Position(position_player));
			}else if(current_Map == MAP_2 && Calico.getHP() <= 0) {
				Event = 0;
				Calico.setHP(50);
				setMap(MAP_2);
				num_player = 0;
				position_player = 1;
				pos_e = 0;
				ex_s2_event = 0;
				Calico.setPosition_Calico(Map.Position(position_player));
			}else if(current_Map == MAP_3 && Calico.getHP() <= 0) {
				Event = 0;
				Calico.setHP(50);
				setMap(MAP_3);
				num_player = 0;
				position_player = 1;
				Calico.setPosition_Calico(Map.Position(position_player));
			}
			
			
			if(position_player >= 13 && current_Map == MAP_2 && ex_s2_event == 0) {
				Event = 2;
				setCutScene_group(Scene_group_2);
			}else if(position_player == 51 && current_Map == MAP_3 && boss_event == 0) {
				Event = 2;
				setCutScene_group(Scene_group_3);
			}else if(position_player == 51 && current_Map == MAP_3 && boss_event == 2) {
				Event = 2;
				setCutScene_group(Scene_group_4);
			}else if(position_player == 51 && current_Map == MAP_3 && boss_event == 3) {
				Event = 2;
				setCutScene_group(Scene_group_5);
			}
			/*sp cut*/
//			else if() {
//
//			}
			else if(Map.CheckFight(position_player)) {
				if(Calico.skill_player == 1 && (num_player == 1 || num_player == 2) && boss_event == 0) {
					Event = 0;
					Map.Enemy_Alive(position_player);
				}else if(Calico.skill_player == 5 && (num_player == 3 || num_player == 4) && boss_event == 0) {
					Event = 0;
					Map.Enemy_Alive(position_player);
				}else {
					Event = 1;
				}
			}else if(current_Map == MAP_3 && boss_event == 1) {
				Event = 1;
			}else if(current_Map == MAP_2 && ex_s2_event == 1) {
				Event = 3;
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
				setEnemy(1);
				if(Calico.skill_player == 4) {
					Fighting_Turn = 1;
				}else if(Calico.skill_player == 3) {
					Enemy.TakeDMG(5);
					Fighting_Turn = random.nextInt(2) + 1;
				}else {
					Fighting_Turn = random.nextInt(2) + 1;
				}
				Current_Status = Status_Fighting;
				setDice_moving(0);
				num_enemy = 0;
				num_player = 0;
			}else if(Event == 2) {
				Current_Status = Status_CutScene;
				setDice_moving(0);
				num_enemy = 0;
				num_player = 0;
			}else if(Event == 3) {
				Current_Status = Status_EnemyTurn;
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
		float[] bag_postion = {Bag.getX(), Bag.getY(), Bag.getWidth(), Bag.getHeight()};
		/*Mouse is click*/
		
		if(InputManager.Isclick()) {
			/*PlayerTurn*/
			if((Current_Status == Status_PlayerTurn)) {
				if((Cursor[0] >= Dice_moving[0] && Cursor[0] <= Dice_moving[0] + Dice_moving[2]) 
					&& 
			(Cursor[1] <= Gdx.graphics.getHeight() - Dice_moving[1] && Cursor[1] >= Gdx.graphics.getHeight() - Dice_moving[1] - Dice_moving[3])){
//					num_player = random.nextInt(4) + 1; // random เลข
					num_player = 4;
					Current_Status = Status_PlayerMoving;
					setDice_moving(num_player);
					if(Calico.skill_player == 2) {
						num_player += 2;
					}
					DELAY = 0.5;
				}
//				/*Bag*/
//				else if((Cursor[0] >= bag_postion[0] && Cursor[0] <= bag_postion[0] + bag_postion[3]) 
//						&& 
//				(Cursor[1] <= Gdx.graphics.getHeight() - bag_postion[1] && Cursor[1] >= Gdx.graphics.getHeight() - bag_postion[1] - bag_postion[4])) {
//					if(open_bag == false) {
//						open_bag = true;
//					}else if(open_bag == true) {
//						open_bag = false;
//					}
//				}
//				/*Change Skill*/
//				else if(open_bag == true) {
//					/*Weapon 1*/
//					if((Cursor[0] >= weapon[0][0] && Cursor[0] <= weapon[0][0] + weapon[0][3]) 
//							&& 
//				(Cursor[1] <= Gdx.graphics.getHeight() - weapon[0][1] && Cursor[1] >= Gdx.graphics.getHeight() - weapon[0][1] - weapon[0][4])) {
//						Calico.setSkill_field(1);
//					}
//					/*Weapon 2*/
//					else if((Cursor[0] >= weapon[1][0] && Cursor[0] <= weapon[1][0] + weapon[1][3]) 
//							&& 
//				(Cursor[1] <= Gdx.graphics.getHeight() - weapon[1][1] && Cursor[1] >= Gdx.graphics.getHeight() - weapon[1][1] - weapon[1][4])) {
//						Calico.setSkill_field(2);
//					}
//					/*Weapon 3*/
//					else if((Cursor[0] >= weapon[2][0] && Cursor[0] <= weapon[2][0] + weapon[2][3]) 
//							&& 
//				(Cursor[1] <= Gdx.graphics.getHeight() - weapon[2][1] && Cursor[1] >= Gdx.graphics.getHeight() - weapon[2][1] - weapon[2][4])) {
//						Calico.setSkill_field(3);
//					}
//					/*Weapon 4*/
//					else if((Cursor[0] >= weapon[3][0] && Cursor[0] <= weapon[3][0] + weapon[3][3]) 
//							&& 
//				(Cursor[1] <= Gdx.graphics.getHeight() - weapon[3][1] && Cursor[1] >= Gdx.graphics.getHeight() - weapon[3][1] - weapon[3][4])) {
//						Calico.setSkill_field(4);
//					}
//					/*Weapon 5*/
//					else if((Cursor[0] >= weapon[4][0] && Cursor[0] <= weapon[4][0] + weapon[4][3]) 
//							&& 
//				(Cursor[1] <= Gdx.graphics.getHeight() - weapon[4][1] && Cursor[1] >= Gdx.graphics.getHeight() - weapon[4][1] - weapon[4][4])) {
//						Calico.setSkill_field(5);
//					}
//				}
			}
			/* CutScene */
			else if(Current_Status == Status_CutScene) {
				if(Scene < CutScene.getFinal_scene()) {
					Scene += 1;
					CutScene.SetCutscreen(Scene);
				}else if(Scene >= CutScene.getFinal_scene()) {
					Scene = 1;
					if (current_Map == MAP_3 && position_player == 51 && boss_event == 0) {
						Current_Status = Status_CheckEvent;
						boss_event = 1;
						Event = 1;
					}else if(current_Map == MAP_3 && position_player == 51 && (boss_event == 2 || boss_event == 3)) {
						Current_Status = Status_CheckEvent;
						Event = 2;
						final_s = 1;
						gsm.setState(GameStateManager.Credit);
					}else if(position_player >= 13 && current_Map == MAP_2 && ex_s2_event == 0) {
						ex_s2_event = 1;
						Current_Status = Status_CheckEvent;
						Event = 3;
					}else {
						Event = 0;
						Current_Status = Status_CheckEvent;
					}
				}
			}
			/*Combat*/
			else if(Current_Status == Status_Fighting) {
				float[] dice_combat = {Calico.getDice_combat().getX(), Calico.getDice_combat().getY() ,Calico.getDice_combat().getWidth() ,Calico.getDice_combat().getHeight()};
				/*Dice Combat*/
				if((Cursor[0] >= dice_combat[0] && Cursor[0] <= dice_combat[0] + dice_combat[2]) 
						&& 
				(Cursor[1] <= Gdx.graphics.getHeight() - dice_combat[1] && Cursor[1] >= Gdx.graphics.getHeight() - dice_combat[1] - dice_combat[3])){
						if((Fighting_Turn % 2 != 0) && (num_player == 0) && (num_enemy == 0)){
							if(Calico.skill_player == 4) {
								num_player = random.nextInt(3) + 2; // random เลข
								DELAY = 0.5;
							}else {
								num_player = random.nextInt(6) + 1; // random เลข
								DELAY = 0.5;
							}
							
						}else if((Fighting_Turn % 2 == 0) && (num_enemy != 0) && (num_player == 0)){
							if(Calico.skill_player == 3) {
								num_player = random.nextInt(3) + 1; // random เลข
								DELAY = 0.5;
							}else {
								num_player = random.nextInt(6) + 1; // random เลข
								DELAY = 0.5;
							}
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
			if(current_Map == MAP_1){
				Enemy.init(random.nextInt(3) + 1);
			}else if(current_Map == MAP_2) {
				Enemy.init(random.nextInt(3) + 1);
			}else if(current_Map == MAP_3) {
				Enemy.init(random.nextInt(4) + 4);
			}
		}else if(num == 0){
			Enemy = null;
		}
	}
}
