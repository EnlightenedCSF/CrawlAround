package com.vsu.csf.model;

public class GameSettings {

    //region Singleton
    private GameSettings(){}
    private static GameSettings instance;

    public static GameSettings getInstance() {
        if (instance == null)
            instance = new GameSettings();
        return instance;
    }
    //endregion

    private float snakeSpeed = 400;
    private float foodSpawnDelay = 5;

    public float getSnakeSpeed() {
        return snakeSpeed;
    }

    public void setSnakeSpeed(float snakeSpeed) {
        this.snakeSpeed = snakeSpeed;
    }

    public float getFoodSpawnDelay() {
        return foodSpawnDelay;
    }

    public void setFoodSpawnDelay(float foodSpawnDelay) {
        this.foodSpawnDelay = foodSpawnDelay;
    }
}
