package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Map {
	
	public abstract void init();
	
	public abstract void draw(SpriteBatch batch);
	
	public abstract int[] Position(int pos);
	
	public abstract boolean CheckFight(int pos);
	
	public abstract void Enemy_Alive(int pos);
}
