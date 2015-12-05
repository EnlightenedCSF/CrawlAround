package com.vsu.csf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.vsu.csf.views.buttons.Button;
import com.vsu.csf.views.buttons.PressAction;

public class MainMenuScreen extends AbstractScreen {

    float SCREEN_CENTER_X = AbstractScreen.WIDTH / 2;
    int MARGIN_X = 200;

    Button newGameButton;
    Button exitButton;

    public MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        newGameButton = new Button(){{
            setAction(new PressAction() {
                @Override
                protected void execute() {
                    game.setScreen(new GameScreen(game));
                }
            });
            setPosition((int) SCREEN_CENTER_X - 75, AbstractScreen.HEIGHT - MARGIN_X);
            setSize(150, 50);
            setTitle("New game");
        }
        };

        exitButton = new Button() {{
            setAction(new PressAction() {
                @Override
                protected void execute() {
                    Gdx.app.exit();
                }
            });
            setPosition((int) SCREEN_CENTER_X - 75, AbstractScreen.HEIGHT - MARGIN_X * 2);
            setSize(150, 50);
            setTitle("Exit");
        }
        };

        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                MainMenuScreen.this.newGameButton.click();
                MainMenuScreen.this.exitButton.click();
                return true;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                screenY = Gdx.graphics.getHeight() - screenY;
                newGameButton.mouseHover(screenX, screenY);
                exitButton.mouseHover(screenX, screenY);
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();
        newGameButton.render(batch);
        exitButton.render(batch);
        batch.end();
    }
}
