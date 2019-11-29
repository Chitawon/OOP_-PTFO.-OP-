package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Calico extends Character{
	
	private Texture dn_atk, dn_def, d1_combat, d2_combat, d3_combat, d4_combat, d5_combat, d6_combat;
	private Texture skill_1_field, skill_2_field, skill_3_field, skill_4_field, skill_5_field;
	private Texture skill_1_atk, skill_2_atk, skill_3_atk, skill_4_atk, skill_5_atk;
	private Texture skill_1_def, skill_2_def, skill_3_def, skill_4_def, skill_5_def;
	private Sprite skill_field;
	private Sprite hpbar1, hpbar2;
	private Sprite dice_combat, skill_combat;
	private int HP = 40;
	public int skill_player = 1;
	private int current_animation;
	private double DELAY;
	
	private int[] Position_Calico;
	private boolean[] skill_available = {true, true, false, false, false};
	private int[] P_stand, P_ATK, P_getHIT, P_Down;
	private Texture Calico_stand, Calico_ATK, Calico_getHIT, Calico_Down;
	private Sprite Calico_field, Calico_combat;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		Position_Calico = new int[2];
		
		P_stand = new int[] {320, 240, 148, 169};
		P_ATK = new int[] {320, 240, 167, 171};
		P_getHIT = new int[] {320, 240, 164, 170};
		P_Down = new int[] {320, 240, 171, 96};
		
		
		Calico_field = new Sprite(new Texture(Gdx.files.internal("Character/Board/player_board.png"))); //set Sprite เป็นรูป
		Calico_combat = new Sprite(new Texture(Gdx.files.internal("Character/Battle/Calico/calico_stand.png")));
		
		Calico_stand = new Texture("Character/Battle/Calico/calico_stand.png");
		Calico_ATK = new Texture("Character/Battle/Calico/calico_atk.png");
		Calico_getHIT = new Texture("Character/Battle/Calico/calico_gethit.png");
		Calico_Down = new Texture("Character/Battle/Calico/calico_down.png");
		
		dice_combat = new Sprite(new Texture(Gdx.files.internal("Battle/dice_atk.png")));
		
		dn_atk = new Texture("Battle/dice_atk.png");
		dn_def = new Texture("Battle/dice_def.png");
		d1_combat = new Texture("Battle/dn1.png");
		d2_combat = new Texture("Battle/dn2.png");
		d3_combat = new Texture("Battle/dn3.png");
		d4_combat = new Texture("Battle/dn4.png");
		d5_combat = new Texture("Battle/dn5.png");
		d6_combat = new Texture("Battle/dn6.png");
		
		skill_field = new Sprite(new Texture(Gdx.files.internal("UI/dagger_walk.png")));
		
		skill_1_field = new Texture("UI/dagger_walk.png");
		skill_2_field = new Texture("UI/pistol_walk.png");
		skill_3_field = new Texture("UI/sniper_walk.png");
		skill_4_field = new Texture("UI/shotgun_walk.png");
		skill_5_field = new Texture("UI/suppressor_walk.png");
		
		skill_combat = new Sprite(new Texture(Gdx.files.internal("Battle/pistol_atk.png")));
		
		skill_1_atk = new Texture("Battle/dagger_atk.png");
		skill_2_atk = new Texture("Battle/pistol_atk.png");
		skill_3_atk = new Texture("Battle/sniper_atk.png");
		skill_4_atk = new Texture("Battle/shotgun_atk.png");	
		skill_5_atk = new Texture("Battle/suppressor_atk.png");
		
		skill_1_def = new Texture("Battle/dagger_def.png");
		skill_2_def = new Texture("Battle/pistol_def.png");
		skill_3_def = new Texture("Battle/sniper_def.png");
		skill_4_def = new Texture("Battle/shotgun_def.png");
		skill_5_def = new Texture("Battle/suppressor_def.png");
		
		hpbar1 = new Sprite(new Texture(Gdx.files.internal("Battle/hpbar1.png")));
		hpbar2 = new Sprite(new Texture(Gdx.files.internal("Battle/hpbar2.png")));
		
	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.draw(skill_field, 192, 16, 96, 96);
		Calico_field.setPosition(Position_Calico[0], Position_Calico[1]);
		Calico_field.setSize(84, 100);
		Calico_field.draw(batch);
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		if(DELAY > 0) {
			DELAY -= dt;
		}
		
		if(DELAY <= 0) {
			DELAY = 0;
		}
		
		if(current_animation != 0 && DELAY <= 0 && current_animation != 4) {
			setAnimation(0);
			current_animation = 0;
		}
		
		hpbar2.setSize(this.HP * 10, 32);
		
	}


	public void setPosition_Calico(int[] position) {
		// TODO Auto-generated method stub
		Position_Calico = position;
	}
	
	public Sprite getCombat() {
		return Calico_combat;
	}

	@Override
	public void drawCombat(SpriteBatch batch) {
		skill_combat.setSize(96, 96);
		skill_combat.setPosition(96, 256);
		skill_combat.draw(batch);
		dice_combat.setSize(96, 96);
		dice_combat.setPosition(96, 400);
		dice_combat.draw(batch);
		hpbar1.setPosition(220, 460);
		hpbar1.setSize(408, 40);
		hpbar1.draw(batch);
		hpbar2.setPosition(224, 464);
		hpbar2.draw(batch);
		if(current_animation == 0){
			Calico_combat.setPosition(320, 240);
			Calico_combat.setSize(148, 169);
		}
		Calico_combat.draw(batch);
	}

	@Override
	public void TakeDMG(int dmg) {
		this.HP -= dmg;
	}
	
	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return this.HP;
	}

	public void setHP(int hP) {
		HP = hP;
		if(HP >= 40) {
			HP = 40;
		}
	}

	@Override
	public void setAnimation(int animation) {
		// TODO Auto-generated method stub
		if(animation == 0) {
			Calico_combat.setPosition(P_stand[0], P_stand[1]);
			Calico_combat.setSize(P_stand[2], P_stand[3]);
			Calico_combat.setTexture(Calico_stand);
		}else if(animation == 1) {
			Calico_combat.setPosition(P_ATK[0], P_ATK[1]);
			Calico_combat.setSize(P_ATK[2], P_ATK[3]);
			Calico_combat.setTexture(Calico_ATK);
		}else if(animation == 2) {
			Calico_combat.setPosition(P_getHIT[0], P_getHIT[1]);
			Calico_combat.setSize(P_getHIT[2], P_getHIT[3]);
			Calico_combat.setTexture(Calico_getHIT);
		}else if(animation == 3) {
			Calico_combat.setPosition(P_Down[0], P_Down[1]);
			Calico_combat.setSize(P_Down[2], P_Down[3]);
			Calico_combat.setTexture(Calico_Down);
		}
		DELAY = 1;
		current_animation = animation;
	}
	
	@Override
	public void setDice_atk(int dice_num) {
		if(dice_num == 0) {
			dice_combat.setTexture(dn_atk);
		}else if(dice_num == 1) {
			dice_combat.setTexture(d1_combat);
		}else if(dice_num == 2) {
			dice_combat.setTexture(d2_combat);
		}else if(dice_num == 3) {
			dice_combat.setTexture(d3_combat);
		}else if(dice_num == 4) {
			dice_combat.setTexture(d4_combat);
		}else if(dice_num == 5) {
			dice_combat.setTexture(d5_combat);
		}else if(dice_num == 6) {
			dice_combat.setTexture(d6_combat);
		}
	}
	
	@Override
	public void setDice_def(int dice_num) {
		if(dice_num == 0) {
			dice_combat.setTexture(dn_def);
		}else if(dice_num == 1) {
			dice_combat.setTexture(d1_combat);
		}else if(dice_num == 2) {
			dice_combat.setTexture(d2_combat);
		}else if(dice_num == 3) {
			dice_combat.setTexture(d3_combat);
		}else if(dice_num == 4) {
			dice_combat.setTexture(d4_combat);
		}else if(dice_num == 5) {
			dice_combat.setTexture(d5_combat);
		}else if(dice_num == 6) {
			dice_combat.setTexture(d6_combat);
		}
	}
	
	public void setSkill_field(int skill) {
		skill_player = skill;
		if(skill == 1) {
			skill_field.setTexture(skill_1_field);
		}else if(skill == 2) {
			skill_field.setTexture(skill_2_field);
		}else if(skill == 3) {
			skill_field.setTexture(skill_3_field);
		}else if(skill == 4) {
			skill_field.setTexture(skill_4_field);
		}else if(skill == 5) {
			skill_field.setTexture(skill_5_field);
		}
	}
	
	
	@Override
	public void setSkill_atk(int skill) {
		if(skill == 1) {
			skill_combat.setTexture(skill_1_atk);
		}else if(skill == 2) {
			skill_combat.setTexture(skill_2_atk);
		}else if(skill == 3) {
			skill_combat.setTexture(skill_3_atk);
		}else if(skill == 4) {
			skill_combat.setTexture(skill_4_atk);
		}else if(skill == 5) {
			skill_combat.setTexture(skill_5_atk);
		}
	}

	@Override
	public void setSkill_def(int skill) {
		if(skill == 1) {
			skill_combat.setTexture(skill_1_def);
		}else if(skill == 2) {
			skill_combat.setTexture(skill_2_def);
		}else if(skill == 3) {
			skill_combat.setTexture(skill_3_def);
		}else if(skill == 4) {
			skill_combat.setTexture(skill_4_def);
		}else if(skill == 5) {
			skill_combat.setTexture(skill_5_def);
		}
	}
	
	public boolean getSkill_available(int skill) {
		if(skill_available[skill - 1]) {
			return skill_available[skill - 1];
		}
		return false;
	}

	public void setSkill_available(int skill) {
		skill_available[skill - 1] = true;
	}

	@Override
	public Sprite getDice_combat() {
		// TODO Auto-generated method stub
		return dice_combat;
	}

	@Override
	public void init(int random) {
		// TODO Auto-generated method stub
		
	}
	
}
