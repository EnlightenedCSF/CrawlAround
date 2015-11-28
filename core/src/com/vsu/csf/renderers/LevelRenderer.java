package com.vsu.csf.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vsu.csf.utils.Consts;

/**
 * Created by olferuk on 27/11/15.
 */
public class LevelRenderer implements IRenderer {

    float TRIANGLE_SIDE = 50;
    float MARGIN = 10;
    float MARGIN_TO_CIRCLE = 3;
    double RADIUS;

    private Sprite marker;
    private Sprite circle;

    public LevelRenderer() {
        marker = new Sprite(new Texture("gfx/tr.png"));
        setMarkerSize();

        circle = new Sprite(new Texture("gfx/circle.png"));
        setCircleSizeAndPosition();
    }

    private void setCircleSizeAndPosition() {
        float diameter = Gdx.graphics.getHeight() - 2*(MARGIN + marker.getHeight() + MARGIN_TO_CIRCLE);
        circle.setSize(diameter, diameter);

        RADIUS = diameter/2 + MARGIN_TO_CIRCLE + TRIANGLE_SIDE*Math.sqrt(3)/4;

        float x = (Gdx.graphics.getWidth() - diameter)/2;
        float y = (Gdx.graphics.getHeight() - diameter)/2;
        circle.setPosition(x, y);
    }

    private void setMarkerSize() {
        float ratio = marker.getWidth() / marker.getHeight();
        marker.setSize(TRIANGLE_SIDE, TRIANGLE_SIDE / ratio);
        marker.setOriginCenter();
    }

    public void updateMarkerPos(double sin, double cos) {
        marker.setCenter(Gdx.graphics.getWidth() / 2 + (float) (RADIUS * cos),
                Gdx.graphics.getHeight() / 2 + (float) (RADIUS * sin));
        float rotation = (float) (90 - Math.asin(sin) * Consts.RADIANS_TO_DEGREES);
        if (cos > 0)
            rotation *= -1;
        marker.setRotation(rotation);
    }

    @Override
    public void render(SpriteBatch batch) {
        circle.draw(batch);
        marker.draw(batch);
    }
}
