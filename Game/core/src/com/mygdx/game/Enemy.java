package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy extends Character{

	private int HP = 5;
	private double DELAY;
	
	private Sprite enemy;
	private Texture Enemy_stand, Enemy_ATK, Enemy_getHIT, Enemy_Down;
	private Texture dn_atk, dn_def, d1_combat, d2_combat, d3_combat, d4_combat, d5_combat, d6_combat;
	private Sprite hpbar1, hpbar2;
	private Sprite dice_combat;
	private int[] E_stand, E_ATK, E_getHIT, E_Down;
	private int current_animation;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		dice_combat = new Sprite(new Texture(Gdx.files.internal("Battle/dice_atk.png")));
		
		dn_atk = new Texture("Battle/dice_atk.png");
		dn_def = new Texture("Battle/dice_def.png");
		d1_combat = new Texture("Battle/dn1.png");
		d2_combat = new Texture("Battle/dn2.png");
		d3_combat = new Texture("Battle/dn3.png");
		d4_combat = new Texture("Battle/dn4.png");
		d5_combat = new Texture("Battle/dn5.png");
		d6_combat = new Texture("Battle/dn6.png");
		
		hpbar1 = new Sprite(new Texture(Gdx.files.internal("Battle/hpbar1.png")));
		hpbar2 = new Sprite(new Texture(Gdx.files.internal("Battle/hpbar2.png")));

	}
	
	public void init(int random) {
		if(random == 1) {
			Enemy_stand = new Texture(Gdx.files.internal("Character/Battle/Enemy/e1_stand.png"));
			Enemy_ATK = new Texture(Gdx.files.internal("Character/Battle/Enemy/e1_atk.png"));
			Enemy_getHIT = new Texture(Gdx.files.internal("Character/Battle/Enemy/e1_gethit.png"));
			Enemy_Down = new Texture(Gdx.files.internal("Character/Battle/Enemy/e1_down.png"));
			E_stand = new int[] {928, 240, 149, 198};
			E_ATK = new int[] {928, 240, 147, 198};
			E_getHIT = new int[] {928, 240, 161, 154};
			E_Down = new int[] {928, 240, 180, 126};
		}
		else if(random == 2) {
			Enemy_stand = new Texture(Gdx.files.internal("Character/Battle/Enemy/e2_stand.png"));
			Enemy_ATK = new Texture(Gdx.files.internal("Character/Battle/Enemy/e2_atk.png"));
			Enemy_getHIT = new Texture(Gdx.files.internal("Character/Battle/Enemy/e2_gethit.png"));
			Enemy_Down = new Texture(Gdx.files.internal("Character/Battle/Enemy/e2_down.png"));
			E_stand = new int[] {896, 240, 213, 200};
			E_ATK = new int[] {896, 240, 206, 204};
			E_getHIT = new int[] {896, 240, 236, 216};
			E_Down = new int[] {896, 240, 226, 125};
		}else if(random == 3) {
			Enemy_stand = new Texture(Gdx.files.internal("Character/Battle/Enemy/e3_stand.png"));
			Enemy_ATK = new Texture(Gdx.files.internal("Character/Battle/Enemy/e3_atk.png"));
			Enemy_getHIT = new Texture(Gdx.files.internal("Character/Battle/Enemy/e3_gethit.png"));
			Enemy_Down = new Texture(Gdx.files.internal("Character/Battle/Enemy/e3_down.png"));
			E_stand = new int[] {864, 240, 225, 219};
			E_ATK = new int[]  {864, 240, 259, 192};
			E_getHIT = new int[]  {877, 232, 239, 211};
			E_Down = new int[]  {877, 208, 240, 184};
		}else if(random == 4) {
			Enemy_stand = new Texture(Gdx.files.internal("Character/Battle/Enemy/e4_stand.png"));
			Enemy_ATK = new Texture(Gdx.files.internal("Character/Battle/Enemy/e4_atk.png"));
			Enemy_getHIT = new Texture(Gdx.files.internal("Character/Battle/Enemy/e4_gethit.png"));
			Enemy_Down = new Texture(Gdx.files.internal("Character/Battle/Enemy/e4_down.png"));
			E_stand = new int[] {960, 240, 107, 185};
			E_ATK = new int[] {960, 240, 109, 178};
			E_getHIT = new int[] {960, 240, 107, 185};
			E_Down = new int[] {960, 240, 171, 105};
		}else if(random == 5) {
			Enemy_stand = new Texture(Gdx.files.internal("Character/Battle/Enemy/e5_stand.png"));
			Enemy_ATK = new Texture(Gdx.files.internal("Character/Battle/Enemy/e5_atk.png"));
			Enemy_getHIT = new Texture(Gdx.files.internal("Character/Battle/Enemy/e5_gethit.png"));
			Enemy_Down = new Texture(Gdx.files.internal("Character/Battle/Enemy/e5_down.png"));
			E_stand = new int[] {960, 240, 109, 187};
			E_ATK = new int[] {928, 240, 110, 175};
			E_getHIT = new int[] {960, 240, 125, 184};
			E_Down = new int[] {928, 220, 183, 120};
		}else if(random == 6) {
			Enemy_stand = new Texture(Gdx.files.internal("Character/Battle/Enemy/e6_stand.png"));
			Enemy_ATK = new Texture(Gdx.files.internal("Character/Battle/Enemy/e6_atk.png"));
			Enemy_getHIT = new Texture(Gdx.files.internal("Character/Battle/Enemy/e6_gethit.png"));
			Enemy_Down = new Texture(Gdx.files.internal("Character/Battle/Enemy/e6_down.png"));
			E_stand = new int[] {928, 224, 126, 213};
			E_ATK = new int[] {896, 224, 135, 197};
			E_getHIT = new int[] {960, 224, 125, 184};
			E_Down = new int[] {896, 224, 190, 95};
		}else if(random == 7) {
			Enemy_stand = new Texture(Gdx.files.internal("Character/Battle/Enemy/e7_stand.png"));
			Enemy_ATK = new Texture(Gdx.files.internal("Character/Battle/Enemy/e7_atk.png"));
			Enemy_getHIT = new Texture(Gdx.files.internal("Character/Battle/Enemy/e7_gethit.png"));
			Enemy_Down = new Texture(Gdx.files.internal("Character/Battle/Enemy/e7_down.png"));
			E_stand = new int[] {928, 224, 148, 214};
			E_ATK = new int[] {896, 224, 246, 293};
			E_getHIT = new int[] {960, 224, 114, 210};
			E_Down = new int[] {960, 224, 188, 106};
		}
		enemy = new Sprite(Enemy_stand);
	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
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
		
		if(current_animation != 0 && DELAY <= 0 && current_animation != 3) {
			setAnimation(0);
		}else if(current_animation != 0 && DELAY <= 0 && current_animation == 3) {
			setAnimation(3);
			current_animation = 3;
		}

		hpbar2.setSize(this.HP * 80, 32);
	}

	@Override
	public void setPosition(int[] pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawCombat(SpriteBatch batch) {
		// TODO Auto-generated method stub
		dice_combat.setSize(96, 96);
		dice_combat.setPosition(1152, 304);
		dice_combat.draw(batch);
		hpbar1.setSize(408, 40);
		hpbar1.setPosition(796, 460);
		hpbar1.draw(batch);
		hpbar2.setPosition(800, 464);
		hpbar2.draw(batch);
		if(current_animation == 0) {
			enemy.setPosition(E_stand[0], E_stand[1]);
			enemy.setSize(E_stand[2], E_stand[3]);
		}
		enemy.draw(batch);
	}
	
	@Override
	public void setAnimation(int animation) {
		// TODO Auto-generated method stub
		if(animation == 0) {
			enemy.setPosition(E_stand[0], E_stand[1]);
			enemy.setSize(E_stand[2], E_stand[3]);
			enemy.setTexture(Enemy_stand);
		}else if(animation == 1) {
			enemy.setPosition(E_ATK[0], E_ATK[1]);
			enemy.setSize(E_ATK[2], E_ATK[3]);
			enemy.setTexture(Enemy_ATK);
		}else if(animation == 2) {
			enemy.setPosition(E_getHIT[0], E_getHIT[1]);
			enemy.setSize(E_getHIT[2], E_getHIT[3]);
			enemy.setTexture(Enemy_getHIT);
		}else if(animation == 3) {
			enemy.setPosition(E_Down[0], E_Down[1]);
			enemy.setSize(E_Down[2], E_Down[3]);
			enemy.setTexture(Enemy_Down);
		}
		DELAY = 1;
		current_animation = animation;
	}
	
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

	@Override
	public void TakeDMG(int dmg) {
		// TODO Auto-generated method stub
		this.HP -= dmg;
		if(HP <= 0) {
			this.HP = 0;
		}
	}
	
	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return this.HP;
	}

	@Override
	public Sprite getDice_combat() {
		// TODO Auto-generated method stub
		return dice_combat;
	}

	@Override
	public Sprite getSkill_combat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSkill_atk(int skill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSkill_def(int skill) {
		// TODO Auto-generated method stub
		
	}

}
