package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.game.sceens.play;

public class TileMap extends Game {

	public void create() {
		setScreen(new play());
		
	}
	public void dispose(){
		super.dispose();
	}
	public void render() {
		super.render();
	}
	public void resize(int width,int height) {
		super.resize(width, height);
	}
	public void pause() {
		super.pause();
	}
	public void resume() {
		super.resume();
	}
}