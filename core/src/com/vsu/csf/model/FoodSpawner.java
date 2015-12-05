package com.vsu.csf.model;


public class FoodSpawner {

    private float elapsed = 0;
    private boolean isFoodSpawned = false;

    private float foodX, foodY;
    private float foodRadius;

    public FoodSpawner(float foodRadius) {
        this.foodRadius = foodRadius;
        isFoodSpawned = true;
        spawn();
    }

    public boolean isFoodSpawned() {
        return isFoodSpawned;
    }

    public void update(float delta) {
//        elapsed += delta;
//        if (elapsed > GameSettings.getInstance().getFoodSpawnDelay()) {
//            elapsed = 0;
//            spawn();
//            isFoodSpawned = true;
//        }
    }

    private void spawn() {
        double t = 2*Math.PI*Math.random();
        double u = Math.random()+Math.random();
        double r;
        if (u>1)
            r = 2-u;
        else
            r = u;
        r *= foodRadius;
        foodX = (float) (r * Math.cos(t));
        foodY = (float) (r * Math.sin(t));
    }

    public void eatFood() {
        spawn();
    }

    public float getFoodX() {
        return foodX;
    }

    public float getFoodY() {
        return foodY;
    }
}
