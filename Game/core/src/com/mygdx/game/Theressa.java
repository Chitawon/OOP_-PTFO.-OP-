package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Theressa extends Character{

	private int HP = 40;
	private double DELAY;
	
	private Sprite teri;
	private Texture teri_stand, teri_ATK, teri_getHIT, teri_Down, teri_skill1, teri_skill2;
	private Texture dn_atk, dn_def, d1_combat, d2_combat, d3_combat, d4_combat, d5_combat, d6_combat;
	private Sprite hpbar1, hpbar2;
	private Sprite dice_combat;
	private int[] E_stand, E_ATK, E_getHIT, E_Down, E_skill1, E_skill2;
	private int current_animation;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		teri = new Sprite(new Texture(Gdx.files.internal("Character/Battle/Theressa/teri_stand.png")));
		
		teri_stand = new Texture(Gdx.files.internal("Character/Battle/Theressa/teri_stand.png"));
		teri_ATK = new Texture(Gdx.files.internal("Character/Battle/Theressa/teri_atk.png"));
		teri_getHIT = new Texture(Gdx.files.internal("Character/Battle/Theressa/teri_gethit.png"));
		teri_Down = new Texture(Gdx.files.internal("Character/Battle/Theressa/teri_down.png"));
		teri_skill1 = new Texture(Gdx.files.internal("Character/Battle/Theressa/teri_skill1.png"));
		teri_skill2 = new Texture(Gdx.files.internal("Character/Battle/Theressa/teri_skill2.png"));
		
		E_stand = new int[] {928, 240, 153, 206};
		E_ATK = new int[] {832, 240, 233, 199};
		E_getHIT = new int[] {928, 240, 147, 216};
		E_Down = new int[] {928, 203, 203, 124};
		E_skill1 = new int[] {896, 240, 182, 209};
		E_skill2 = new int[] {768, 208, 276, 243};
		
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

		hpbar2.setSize(this.HP * 10, 32);
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
			teri.setSize(149, 198);
			teri.setPosition(928, 240);
		}
		teri.draw(batch);
	}
	
	@Override
	public void setAnimation(int animation) {
		// TODO Auto-generated method stub
		if(animation == 0) {
			teri.setPosition(E_stand[0], E_stand[1]);
			teri.setSize(E_stand[2], E_stand[3]);
			teri.setTexture(teri_stand);
		}else if(animation == 1) {
			teri.setPosition(E_ATK[0], E_ATK[1]);
			teri.setSize(E_ATK[2], E_ATK[3]);
			teri.setTexture(teri_ATK);
		}else if(animation == 2) {
			teri.setPosition(E_getHIT[0], E_getHIT[1]);
			teri.setSize(E_getHIT[2], E_getHIT[3]);
			teri.setTexture(teri_getHIT);
		}else if(animation == 3) {
			teri.setPosition(E_Down[0], E_Down[1]);
			teri.setSize(E_Down[2], E_Down[3]);
			teri.setTexture(teri_Down);
		}else if(animation == 4) {
			teri.setPosition(E_skill1[0], E_skill1[1]);
			teri.setSize(E_skill1[2], E_skill1[3]);
			teri.setTexture(teri_skill1);
		}else if(animation == 5) {
			teri.setPosition(E_skill2[0], E_skill2[1]);
			teri.setSize(E_skill2[2], E_skill2[3]);
			teri.setTexture(teri_skill2);
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
	public void setHP(int hP) {
		HP = hP;
		if(HP >= 40) {
			HP = 40;
		}
	}

	@Override
	public Sprite getDice_combat() {
		// TODO Auto-generated method stub
		return dice_combat;
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
