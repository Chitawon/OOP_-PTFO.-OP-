package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Map {

	private SpriteBatch batch;
	private Texture img;
	private int[] Position;
	
	public abstract void init();
	
	public abstract void setPosition(int pos_x, int pos_y);
	
	public abstract void draw();
	
	public abstract int[] Position(int pos);
	
	public abstract void dispose();
	
}
