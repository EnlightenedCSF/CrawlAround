package com.vsu.csf.model;

import com.vsu.csf.utils.Utils;

import java.util.ArrayList;

public class Level {

    private Snake snake;
    private FoodSpawner spawner;

    public Level(float foodSpawnRadius) {
        snake = new Snake();
        spawner = new FoodSpawner(foodSpawnRadius);
    }

    public void update(float delta) {
        spawner.update(delta);
        snake.update(delta);

        checkCollisions();
    }

    private void checkCollisions() {
        Segment head = snake.getHead();
        if (Utils.haveIntersection(head.getX(), head.getY(), 30, getFoodX(), getFoodY(), 15)) {
            spawner.spawn();
            snake.grow();
        }
    }

    public float getFoodX() {
        return spawner.getFoodX();
    }

    public float getFoodY() {
        return spawner.getFoodY();
    }


    public ArrayList<Segment> getSnakeBody() {
        return snake.getBody();
    }

    public void updateSnakeAngle(float sin, float cos) {
        snake.updateAngle(sin, cos);
    }
}
