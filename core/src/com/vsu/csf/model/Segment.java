package com.vsu.csf.model;

public class Segment {

    private float x, y;

    public void update(float sin, float cos, float shift) {
        x += shift * cos;
        y += shift * sin;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
