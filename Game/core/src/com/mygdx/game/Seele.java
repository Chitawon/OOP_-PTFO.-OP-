package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Seele extends Character{

	private int HP, ATK;
	
	private int[] Position_Seele;
	private Sprite Seele_field, Seele_combat;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		Seele_field = new Sprite(new Texture(Gdx.files.internal("Board/Seele.png")));
		Seele_combat = new Sprite(new Texture(Gdx.files.internal("Board/Seele.png")));

	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		Seele_field.setPosition(Position_Seele[0], Position_Seele[1]);
		Seele_field.setSize(84, 100);
		Seele_field.draw(batch);
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(int[] pos) {
		// TODO Auto-generated method stub
		Position_Seele = pos;
	}

	@Override
	public void drawCombat(SpriteBatch batch) {
		// TODO Auto-generated method stub
//		Seele_combat.setPosition();
//		Seele_combat.setSize(84, 100);
		Seele_combat.draw(batch);
		
	}

	@Override
	public void TakeDMG(int dmg) {
		// TODO Auto-generated method stub
		this.HP -= dmg;
	}
	
	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return this.HP;
	}
	
	@Override
	public void setDice_atk(int dice_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDice_def(int dice_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sprite getDice_combat() {
		// TODO Auto-generated method stub
		return null;
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
