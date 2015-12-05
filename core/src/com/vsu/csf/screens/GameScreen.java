package com.vsu.csf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.vsu.csf.model.GameSettings;
import com.vsu.csf.renderers.LevelRenderer;

public class GameScreen extends AbstractScreen {

    private LevelRenderer levelRenderer;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        levelRenderer = new LevelRenderer();
        GameSettings.getInstance();

        Gdx.gl.glClearColor(1, 1, 1, 1);

        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                screenY = Gdx.graphics.getHeight() - screenY;
                screenX -= Gdx.graphics.getWidth()/2;
                screenY -= Gdx.graphics.getHeight()/2;
                float hyp = (float) Math.sqrt(screenX*screenX + screenY*screenY);
                float sin = screenY / hyp;
                float cos = screenX / hyp;
                levelRenderer.updateMarkerPos(sin, cos);
                levelRenderer.updateSnake(sin, cos);
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        levelRenderer.render(batch, delta);
        batch.end();
    }
}
