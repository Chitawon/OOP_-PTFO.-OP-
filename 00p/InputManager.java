package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter{
	public static boolean holdclick ,click = false;
	public static int CursorX, CursorY;
	public static int check = 0;
	
	public static boolean Isclick() {
		if (click && check == 0) {
			check = 1;
			return click;
		}else {
			return holdclick;
		}
	}
	
	public static int getCursorX() {
		return CursorX;
	}
	
	public static int getCursorY() {
		return CursorY;
	}
	
	public static void setCursorX(int cursorX) {
		CursorX = cursorX;
	}

	public static void setCursorY(int cursorY) {
		CursorY = cursorY;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		click = true;
		setCursorX(screenX);
		setCursorY(screenY);
		return super.touchDown(screenX, screenY, pointer, button);
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		click = false;
		check = 0;
		return super.touchUp(screenX, screenY, pointer, button);
	}
}