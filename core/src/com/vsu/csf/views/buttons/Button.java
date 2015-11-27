package com.vsu.csf.views.buttons;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by olferuk on 27/11/15.
 */
public class Button {


    private static BitmapFont font = new BitmapFont() {{
        setColor(Color.YELLOW);
    }};

    private GlyphLayout glyphLayout;

    private boolean isHovered;
    private String title;

    private Sprite normalStateGfx;
    private Sprite hoveredStateGfx;

    private PressAction action;

    public Button() {
        isHovered = false;
        normalStateGfx = new Sprite(new Texture("gfx/button.png"));
        hoveredStateGfx = new Sprite(new Texture("gfx/buttonHovered.png"));
    }

    public void setTitle(String title) {
        this.title = title;
        glyphLayout = new GlyphLayout(font, this.title);
    }

    public void setAction(PressAction action) {
        this.action = action;
    }

    public void setPosition(int x, int y) {
        normalStateGfx.setPosition(x, y);
        hoveredStateGfx.setPosition(x, y);
    }

    public void setSize(int width, int height) {
        normalStateGfx.setSize(width, height);
        hoveredStateGfx.setSize(width, height);
    }

    public void render(SpriteBatch batch) {
        if (isHovered)
            hoveredStateGfx.draw(batch);
        else
            normalStateGfx.draw(batch);

        font.draw(batch, title, normalStateGfx.getX() + getTitleMarginX(), normalStateGfx.getY() + getTitleMarginY());
    }

    private float getTitleMarginX() {
        float btnWidth = normalStateGfx.getWidth();
        float stringWidth = glyphLayout.width;
        return (btnWidth - stringWidth)/2;
    }

    private float getTitleMarginY() {
        float btnHeight = normalStateGfx.getHeight();
        float stringHeight = glyphLayout.height;
        return btnHeight - (btnHeight - stringHeight)/2;
    }

    public void mouseHover(int x, int y) {
        isHovered = normalStateGfx.getBoundingRectangle().contains(x, y);
    }

    public void click() {
        if (isHovered)
            action.execute();
    }
}
