package com.vsu.csf;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vsu.csf.screens.GameScreen;
import com.vsu.csf.screens.MainMenuScreen;

public class CrawlAround extends Game {

	Screen screen;

	@Override
	public void create () {
		screen = new MainMenuScreen(this);
		setScreen(screen);
	}
}
