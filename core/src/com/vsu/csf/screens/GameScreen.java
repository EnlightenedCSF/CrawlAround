package com.vsu.csf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by olferuk on 27/11/15.
 */
public class GameScreen extends AbstractScreen {

    Texture img;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        Gdx.gl.glClearColor(0, 1, 0, 1);

        img = new Texture("emma-watson.png");

        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Gdx.app.log("MyGame", "Click at: " + screenX + "; " + screenY + " with pointer " + pointer + " and button: " + button);
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        super.render(delta);

    }
}
