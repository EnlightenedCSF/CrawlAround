package com.vsu.csf.model;

import com.vsu.csf.utils.Utils;

public class Segment {

    private float x, y;

    public void update(float sin, float cos, float shift) {
        x += shift * cos;
        y += shift * sin;
    }

    public void update(float sin, float cos, float shift, Segment neighbour, float minDist) {
        float mbX = x + shift * cos;
        float mbY = y + shift * sin;
        float distance = Utils.getDistance(mbX, mbY, neighbour.getX(), neighbour.getY());
        if (distance < minDist) {
            float dd = minDist - distance;
            mbX -= dd * cos;
            mbY -= dd * sin;
        }
        x = mbX;
        y = mbY;
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
