package com.vsu.csf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.vsu.csf.renderers.LevelRenderer;

/**
 * Created by olferuk on 27/11/15.
 */
public class GameScreen extends AbstractScreen {

    private LevelRenderer levelRenderer;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        levelRenderer = new LevelRenderer();

        Gdx.gl.glClearColor(1, 1, 1, 1);

        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                screenY = Gdx.graphics.getHeight() - screenY;
                screenX -= Gdx.graphics.getWidth()/2;
                screenY -= Gdx.graphics.getHeight()/2;
                double hyp = Math.sqrt(screenX*screenX + screenY*screenY);
                double sin = screenY / hyp;
                double cos = screenX / hyp;
                levelRenderer.updateMarkerPos(sin, cos);
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        levelRenderer.render(batch);
        batch.end();
    }
}
