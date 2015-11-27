package com.vsu.csf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by olferuk on 27/11/15.
 */
public abstract class AbstractScreen implements Screen {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    protected Game game;
    protected SpriteBatch batch;

    public AbstractScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.gl.glClearColor(1, 1, 1, 1);

        batch = new SpriteBatch() {{
            getProjectionMatrix().setToOrtho2D(0, 0, WIDTH, HEIGHT);
        }};
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
