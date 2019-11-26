package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Character {
	
	public abstract void init();
	
	public abstract void draw(SpriteBatch batch);
	
	public abstract void update(float dt);
	
	public abstract void setPosition(int[] pos);
	
	public abstract void drawCombat(SpriteBatch batch);
	
	public abstract void TakeDMG(int dmg);
	
	public abstract int getHP();
	
	public abstract void setDice_atk(int dice_num);
	
	public abstract void setDice_def(int dice_num);
	
	public abstract Sprite getDice_combat();

	public abstract Sprite getSkill_combat();
	
	public abstract void setSkill_atk(int skill);
	
	public abstract void setSkill_def(int skill);
	
	public abstract void setAnimation(int animation);
}
