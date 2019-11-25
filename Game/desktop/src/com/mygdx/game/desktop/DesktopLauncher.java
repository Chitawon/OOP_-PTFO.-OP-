package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1312; //ความกว้างจอ
		config.height = 752; //ความสูงจอ
		config.title = "Memory Fragments File.003";
		config.resizable = false;
		new LwjglApplication(new MyGdxGame(), config);
	}
}