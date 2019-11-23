package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class CutScene {

	public abstract void init();
	
	public abstract void draw(SpriteBatch batch);
	
	public abstract void SetCutscreen(int order);
	
	public abstract int getFinal_scene();
	
}
