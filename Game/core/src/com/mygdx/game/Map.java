package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Map {
	
	public abstract void init();
	
	public abstract void setPosition(int pos_x, int pos_y);
	
	public abstract void draw(SpriteBatch batch);
	
	public abstract int[] Position(int pos);
	
}
