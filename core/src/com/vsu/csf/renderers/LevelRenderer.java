package com.vsu.csf.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.vsu.csf.model.Level;
import com.vsu.csf.model.Segment;
import com.vsu.csf.utils.Consts;

import java.util.ArrayList;


public class LevelRenderer implements IRenderer {

    float TRIANGLE_SIDE = 50;
    float MARGIN = 10;
    float MARGIN_TO_CIRCLE = 3;
    float SEGMENT_SIZE = 30;
    float FOOD_RADIUS = 15;
    float RADIUS, FOOD_SPAWN_RADIUS;

    float CENTER_X, CENTER_Y;

    private Sprite marker;
    private Sprite circle;
    private TextureRegion segment;
    private TextureRegion food;

    private Level level;

    public LevelRenderer() {
        marker = new Sprite(new Texture("gfx/tr.png"));
        setMarkerSize();

        circle = new Sprite(new Texture("gfx/circle.png"));
        setCircleSizeAndPosition();

        segment = new TextureRegion(new Texture("gfx/segment.png"));
        food = new TextureRegion(new Texture("gfx/food.png"));

        level = new Level(FOOD_SPAWN_RADIUS);

        CENTER_X = Gdx.graphics.getWidth() / 2.0f;
        CENTER_Y = Gdx.graphics.getHeight() / 2.0f;
    }

    @Override
    public void render(SpriteBatch batch, float delta) {
        level.update(delta);

        circle.draw(batch);
        marker.draw(batch);
        drawFood(batch);
        drawSnake(batch);
    }

    private void drawFood(SpriteBatch batch) {
        batch.draw(food, CENTER_X + level.getFoodX() - FOOD_RADIUS/2, CENTER_Y + level.getFoodY() - FOOD_RADIUS/2, FOOD_RADIUS, FOOD_RADIUS);
    }

    private void drawSnake(SpriteBatch batch) {
        ArrayList<Segment> body = level.getSnakeBody();
        for (Segment s : body) {
            batch.draw(segment, CENTER_X + s.getX() - SEGMENT_SIZE/2, CENTER_Y + s.getY() - SEGMENT_SIZE/2, SEGMENT_SIZE, SEGMENT_SIZE);
        }
    }

    private void setCircleSizeAndPosition() {
        float diameter = Gdx.graphics.getHeight() - 2*(MARGIN + marker.getHeight() + MARGIN_TO_CIRCLE);
        circle.setSize(diameter, diameter);

        RADIUS = (float)(diameter/2 + MARGIN_TO_CIRCLE + TRIANGLE_SIDE*Math.sqrt(3)/4);
        FOOD_SPAWN_RADIUS = 0.9f * RADIUS;

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

    public void updateSnake(float sin, float cos) {
        level.updateSnakeAngle(sin, cos);
    }
}
