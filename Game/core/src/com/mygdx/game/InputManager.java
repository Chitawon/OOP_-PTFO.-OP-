package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter{
	
	public static boolean Isclick() {
		return Gdx.input.isTouched();
	}
	
	public static int getCursorX() {
		return Gdx.input.getX();
	}
	
	public static int getCursorY() {
		return Gdx.input.getY();
	}
	
	
}