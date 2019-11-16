package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter{
	
	public static boolean Isclick() { //เมื่อคลิก
		return Gdx.input.isTouched();
	}
	
	public static int getCursorX() { //ส่งค่าแกน X เมาส์
		return Gdx.input.getX();
	}
	
	public static int getCursorY() { //ส่งค่าแกน Y เมาส์
		return Gdx.input.getY();
	}
	
	
}