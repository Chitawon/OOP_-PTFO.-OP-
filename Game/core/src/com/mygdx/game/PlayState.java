package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class PlayState extends State{
	private SpriteBatch batch;
	
	private Texture icon, dn, d1, d2, d3, d4;
	private Sprite Bag, backpack_bar, hpbar1, hpbar2;
	private Texture bp0, bp1_1, bp1_2, bp2_1, bp2_2, bp2_3;
	private Sprite dice_moving;
	
	private Random random;
	
	private Character Enemy;
	private Seele Seele;
	private Calico Calico;
	private Fight_Field Fight_Field;
	private Map Map;
	
	private CutScene CutScene;
	
	private int[][] weapon;
	private int num_player = 0, position_player = 1, pos_e = 1, current_Map, Stpe_moving, Scene = 1, num_enemy = 0;
	private int boss_skill1, boss_skill2;
	private int Event = 0; // 0 = ไม่มี, 1 = สู้, 2 = CutScene, 3 = เปลี่ยน map
	private int sp_event = 10;// เกิด Scene_group_7
	private	float time = 0; 
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
		gsm.bgMusic.play(gsm.bgMusic.MAP_1n2);
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
		bp0 = new Texture("UI/bp0.png");
		bp1_1 = new Texture("UI/bp1_1.png");
		bp1_2 = new Texture("UI/bp1_2.png");
		bp2_1 = new Texture("UI/bp2_1.png");
		bp2_2 = new Texture("UI/bp2_2.png");
		bp2_3 = new Texture("UI/bp2_3.png");
		backpack_bar = new Sprite(bp0);
		
		
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
		
		weapon = new int[][] {{496, 64, 96, 96}, {608, 64, 96, 96}, {720, 64, 96, 96}, {832, 64, 96, 96}, {944, 64, 96, 96}};
}
	
	@Override
	public void draw() {
		batch.begin();
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
			
		/*Weapon*/
		if(open_bag == true) {
			backpack_bar.setSize(576, 128);
			backpack_bar.setPosition(480, 48);
			backpack_bar.draw(batch);
		}
			
		/*Player*/
		Calico.draw(batch);
		
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
		setBackpackbar();
		hpbar2.setSize(Calico.getHP() * 10, 32);
		
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
			if(Enemy.getHP() <= 0 || (Map.CheckFight(position_player) == false) || (Calico.getHP() <= 0)) {
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
					if(boss_skill1 >= 6) {
						Enemy.setHP(Enemy.getHP() + num_enemy);
						Enemy.setAnimation(4);
						boss_skill1 = -1;
					}else {
						if(num_enemy >= num_player) {
							Enemy.TakeDMG(1);
							DELAY = 0.5;
						}else {
							Enemy.TakeDMG((num_player - num_enemy) * 2);
							DELAY = 0.5;
						}
					}

				}else if(Calico.skill_player == 2) {
					if(boss_skill1 >= 6) {
						Enemy.setHP(Enemy.getHP() + num_enemy);
						Enemy.setAnimation(4);
						boss_skill1 = -1;
					}else {
						if(num_enemy >= num_player * 2) {
							Enemy.TakeDMG(1);
							DELAY = 0.5;
						}else {
							Enemy.TakeDMG((num_player * 2) - num_enemy);
							DELAY = 0.5;
						}
					}

				}else if(Calico.skill_player == 3) {
					if(boss_skill1 >= 6) {
						Enemy.setHP(Enemy.getHP() + num_enemy);
						Enemy.setAnimation(4);
						boss_skill1 = -1;
					}else {
						if(num_enemy >= num_player) {
							Enemy.TakeDMG(5);
							DELAY = 0.5;
						}else {
							Enemy.TakeDMG((num_player + 5) - num_enemy);
							DELAY = 0.5;
						}
					}

				}else if(Calico.skill_player == 4) {
					if(boss_skill1 >= 6) {
						Enemy.setHP(Enemy.getHP() + num_enemy);
						Enemy.setAnimation(4);
						boss_skill1 = -1;
					}else {
						if(num_enemy >= num_player) {
							Enemy.TakeDMG(3);
							DELAY = 0.5;
						}else {
							Enemy.TakeDMG((num_player * 3) - num_enemy);
							DELAY = 0.5;
						}						
					}

				}else if(Calico.skill_player == 5) {
					if(boss_skill1 >= 6) {
						Enemy.setHP(Enemy.getHP() + num_enemy);
						Enemy.setAnimation(4);
						boss_skill1 = -1;
					}else {
						if(num_enemy >= num_player) {
							Enemy.TakeDMG(2);
							DELAY = 0.5;
						}else {
							Enemy.TakeDMG((num_player + 2) - num_enemy);
							DELAY = 0.5;
						}
					}
				}

				if(boss_event == 1) {
					boss_skill1 += 1;
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
					}else if(boss_event == 1){
						boss_event = 2;
						Map.Enemy_Alive(position_player);
					}
				}
				
			}else if((Fighting_Turn % 2 == 0) && (num_player == 0) && (num_enemy == 0)) {
				num_enemy = random.nextInt(6) + 1; // random เลข
			}else if((Fighting_Turn % 2 == 0) && (num_player != 0) && (num_enemy != 0)) {
				Calico.setAnimation(2);
				Enemy.setAnimation(1);
				
				if(Calico.skill_player == 1) {
					if(boss_skill2 >= 3) {
						Calico.TakeDMG(num_enemy * 2);
						Enemy.setAnimation(5);
						boss_skill2 = -1;
					}else {
						if(num_player >= num_enemy) {
							Calico.setHP(Calico.getHP() + 1);
							DELAY = 0.5;
						}else {
							Calico.TakeDMG(num_enemy - num_player);
							DELAY = 0.5;
						}
					}
					
				}else if(Calico.skill_player == 2) {
					if(boss_skill2 >= 3) {
						Calico.TakeDMG(num_enemy * 2);
						Enemy.setAnimation(5);
						boss_skill2 = -1;
					}else {
						if(num_player >= num_enemy) {
							Enemy.TakeDMG(num_player - num_enemy);
							Calico.TakeDMG(1);
							DELAY = 0.5;
							
						}else {
							Calico.TakeDMG(num_enemy - num_player);
							DELAY = 0.5;
						}
					}
				}else if(Calico.skill_player == 3) {
					if(boss_skill2 >= 3) {
						Calico.TakeDMG(num_enemy * 2);
						Enemy.setAnimation(5);
						boss_skill2 = -1;
					}else {
						if(num_player >= num_enemy) {
							Calico.TakeDMG(1);
							DELAY = 0.5;		
						}else {
							Calico.TakeDMG(num_enemy - num_player);
							DELAY = 0.5;
						}
					}
					
				}else if(Calico.skill_player == 4) {
					if(boss_skill2 >= 3) {
						Calico.TakeDMG(num_enemy * 2);
						Enemy.setAnimation(5);
						boss_skill2 = -1;
					}else {
						Calico.TakeDMG(1);
						DELAY = 0.5;
					}
				}else if(Calico.skill_player == 5) {
					if(boss_skill2 >= 3) {
						Calico.TakeDMG(num_enemy * 2);
						Enemy.setAnimation(5);
						boss_skill2 = -1;
					}else {
						Calico.TakeDMG(1);
						Calico.setAnimation(0);
						Enemy.setAnimation(0);
						Map.Enemy_Alive(position_player);
						if(boss_event == 1) {
							boss_event = 3;
						}
					}
				}
				
				if(boss_event == 1) {
					boss_skill2 += 1;
				}
				
				if(Calico.getHP() > 0) {
					num_player = 0;
					num_enemy = 0;
					Fighting_Turn += 1;
				}else {
					Calico.setAnimation(3);
				}
				
				if(Enemy.getHP() <= 0) {
					Calico.setAnimation(0);
					Enemy.setAnimation(3);
					if(boss_event != 1) {
						Map.Enemy_Alive(position_player);
					}else if(boss_event == 1){
						boss_event = 2;
						Map.Enemy_Alive(position_player);
					}
				}
				
			}
			DELAY = 1;
		}
		
		/*Seele*/
		
		if(Current_Status == Status_EnemyTurn) {
			num_enemy = random.nextInt(5) + 2;
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
		
		/*Secret Cutscene*/
		if(Current_Status == Status_PlayerTurn && position_player == 1 && current_Map == MAP_1 && (Calico.getSkill_available(5) == false)) {
			time += dt;
			if (time >= 1) {
				time = 0;
				sp_event -= 1;
			}
			if (sp_event <= 0) {
				sp_event = 0;
				Current_Status = Status_CheckEvent;
			}
		}
		
		
		/*CheckEvent*/
		
		if(Current_Status == Status_CheckEvent) {
			
			if(position_player == 47 && current_Map == MAP_1) {
				setMap(MAP_2);
				Calico.setSkill_available(3);
			}else if(position_player == 45 && current_Map == MAP_2) {
				setMap(MAP_3);	
				Calico.setSkill_available(4);
				ex_s2_event = 0;
			}
			
			if(Calico.getHP() <= 0) {
				setMap(current_Map);
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
			else if(position_player == 1 && current_Map == MAP_1 && sp_event <= 0 && (Calico.getSkill_available(5) == false)) {
				Event = 2;
				setCutScene_group(Scene_group_6);
			}
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
				gsm.bgMusic.setMusicState(false, gsm.bgMusic.Battle);
				if(current_Map == MAP_1 || current_Map == MAP_2) {
					gsm.bgMusic.setMusicState(true, gsm.bgMusic.MAP_1n2);
				}else if(current_Map == MAP_3) {
					gsm.bgMusic.setMusicState(true, gsm.bgMusic.MAP_3);
				}
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
				gsm.bgMusic.setMusicState(true, gsm.bgMusic.Battle);
				if(current_Map == MAP_1 || current_Map == MAP_2) {
					gsm.bgMusic.setMusicState(false, gsm.bgMusic.MAP_1n2);
				}else if(current_Map == MAP_3) {
					gsm.bgMusic.setMusicState(false, gsm.bgMusic.MAP_3);
				}
			}else if(Event == 2) {
				Current_Status = Status_CutScene;
				setDice_moving(0);
				num_enemy = 0;
				num_player = 0;
				gsm.bgMusic.setMusicState(false, gsm.bgMusic.Battle);
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
			if(Current_Status == Status_PlayerTurn) {
				if((Cursor[0] >= Dice_moving[0] && Cursor[0] <= Dice_moving[0] + Dice_moving[2]) 
					&& 
			(Cursor[1] <= Gdx.graphics.getHeight() - Dice_moving[1] && Cursor[1] >= Gdx.graphics.getHeight() - Dice_moving[1] - Dice_moving[3])){
					num_player = random.nextInt(4) + 1; // random เลข
					Current_Status = Status_PlayerMoving;
					setDice_moving(num_player);
					if(Calico.skill_player == 2) {
						num_player += 2;
					}
					open_bag = false;
					DELAY = 0.5;
				}
				/*Change Skill*/
				else if(open_bag == true) {
					/*Weapon 1*/
					if((Cursor[0] >= weapon[0][0] && Cursor[0] <= weapon[0][0] + weapon[0][2]) 
							&& 
					   (Cursor[1] <= Gdx.graphics.getHeight() - weapon[0][1] && Cursor[1] >= Gdx.graphics.getHeight() - weapon[0][1] - weapon[0][3])
					   		&& 
					   Calico.getSkill_available(1)) {
						Calico.setSkill_field(1);
						open_bag = false;
					}
					/*Weapon 2*/
					else if((Cursor[0] >= weapon[1][0] && Cursor[0] <= weapon[1][0] + weapon[1][2]) 
							&& 
						(Cursor[1] <= Gdx.graphics.getHeight() - weapon[1][1] && Cursor[1] >= Gdx.graphics.getHeight() - weapon[1][1] - weapon[1][3])
							&& 
						Calico.getSkill_available(2)) {
						Calico.setSkill_field(2);
						open_bag = false;
					}
					/*Weapon 3*/
					else if((Cursor[0] >= weapon[2][0] && Cursor[0] <= weapon[2][0] + weapon[2][2]) 
							&& 
						(Cursor[1] <= Gdx.graphics.getHeight() - weapon[2][1] && Cursor[1] >= Gdx.graphics.getHeight() - weapon[2][1] - weapon[2][3])
							&& 
						Calico.getSkill_available(3)) {
						Calico.setSkill_field(3);
						open_bag = false;
					}
					/*Weapon 4*/
					else if((Cursor[0] >= weapon[3][0] && Cursor[0] <= weapon[3][0] + weapon[3][2]) 
							&& 
						(Cursor[1] <= Gdx.graphics.getHeight() - weapon[3][1] && Cursor[1] >= Gdx.graphics.getHeight() - weapon[3][1] - weapon[3][3])
							&& 
						Calico.getSkill_available(4)) {
						Calico.setSkill_field(4);
						open_bag = false;
					}
					/*Weapon 5*/
					else if((Cursor[0] >= weapon[4][0] && Cursor[0] <= weapon[4][0] + weapon[4][2]) 
							&& 
						(Cursor[1] <= Gdx.graphics.getHeight() - weapon[4][1] && Cursor[1] >= Gdx.graphics.getHeight() - weapon[4][1] - weapon[4][3])
							&& 
						Calico.getSkill_available(5)) {
						Calico.setSkill_field(5);
						open_bag = false;
					}
				}
				/*Bag*/
				else if((Cursor[0] >= bag_postion[0] && Cursor[0] <= bag_postion[0] + bag_postion[2]) 
						&& 
				(Cursor[1] <= Gdx.graphics.getHeight() - bag_postion[1] && Cursor[1] >= Gdx.graphics.getHeight() - bag_postion[1] - bag_postion[3])) {
					if(open_bag == false) {
						open_bag = true;
					}else if(open_bag == true) {
						open_bag = false;
					}
				}
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
						gsm.setState(GameStateManager.Credit);
						gsm.bgMusic.setMusicState(false, gsm.bgMusic.Battle);
						gsm.bgMusic.setMusicState(false, gsm.bgMusic.MAP_3);
						gsm.bgMusic.setMusicState(true, gsm.bgMusic.START);
					}else if(position_player >= 13 && current_Map == MAP_2 && ex_s2_event == 0) {
						ex_s2_event = 1;
						Current_Status = Status_CheckEvent;
						Event = 3;
					}
					else if(position_player == 1 && current_Map == MAP_1 && sp_event <= 0 && (Calico.getSkill_available(5) == false)) {
						Calico.setSkill_available(5);
						Current_Status = Status_CheckEvent;
						Event = 0;
					}
					else {
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
			gsm.bgMusic.play(gsm.bgMusic.MAP_1n2);
		}else if(map == MAP_2) {
			Map = new Map_2();
			gsm.bgMusic.play(gsm.bgMusic.MAP_1n2);
		}else if(map == MAP_3) {
			Map = new Map_3();
			gsm.bgMusic.setMusicState(false, gsm.bgMusic.MAP_1n2);
			gsm.bgMusic.play(gsm.bgMusic.MAP_3);
		}
		current_Map = map;
		Map.init();
		if(Calico != null) {
			Event = 0;
			Calico.setHP(40);
			num_player = 0;
			position_player = 1;
			Calico.setPosition_Calico(Map.Position(position_player));
		}
		
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
	
	public void setBackpackbar() {
		if(Calico.getSkill_available(5) == false) {
			if(Calico.getSkill_available(3) == true) {
				backpack_bar.setTexture(bp1_1);
			} 
			if(Calico.getSkill_available(4) == true) {
				backpack_bar.setTexture(bp1_2);
			}
		}else if(Calico.getSkill_available(5) == true) {
			if(Calico.getSkill_available(5) == true) {
				backpack_bar.setTexture(bp2_1);
			}
			if(Calico.getSkill_available(3) == true) {
				backpack_bar.setTexture(bp2_2);
			} 
			if(Calico.getSkill_available(4) == true) {
				backpack_bar.setTexture(bp2_3);
			}
		}
	}
	
}
