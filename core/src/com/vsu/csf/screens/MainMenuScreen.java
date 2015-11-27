package com.vsu.csf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

/**
 * Created by olferuk on 27/11/15.
 */
public class MainMenuScreen extends AbstractScreen {

    public MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Gdx.app.log("", "Switching to the next screen....");
                game.setScreen(new GameScreen(game));
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}
