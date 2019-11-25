package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy extends Character{

	private int HP, ATK;
	private Sprite enemy;
	private Texture dn_atk, dn_def, d1_combat, d2_combat, d3_combat, d4_combat, d5_combat, d6_combat;
	private Sprite dice_combat;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		enemy = new Sprite(new Texture(Gdx.files.internal("Board/player_board.png")));
		
		dice_combat = new Sprite(new Texture(Gdx.files.internal("Battle/dice_atk.png")));
		
		dn_atk = new Texture("Battle/dice_atk.png");
		dn_def = new Texture("Battle/dice_def.png");
		d1_combat = new Texture("Battle/dn1.png");
		d2_combat = new Texture("Battle/dn2.png");
		d3_combat = new Texture("Battle/dn3.png");
		d4_combat = new Texture("Battle/dn4.png");
		d5_combat = new Texture("Battle/dn5.png");
		d6_combat = new Texture("Battle/dn6.png");
	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(int[] pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawCombat(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.draw(dice_combat, 1184, 400);
		enemy.setPosition(896, 272);
		enemy.draw(batch);
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
	public void setHP(int dmg) {
		// TODO Auto-generated method stub
		this.HP -= dmg;
		
	}

	@Override
	public int getATK() {
		// TODO Auto-generated method stub
		return this.ATK;
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
