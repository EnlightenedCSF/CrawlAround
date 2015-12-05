package com.vsu.csf.utils;


public class Utils {

    public static float getDistance(float x1, float y1, float x2, float y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        return (float)Math.sqrt(dx*dx + dy*dy);
    }

    public static boolean haveIntersection(float x1, float y1, float r1, float x2, float y2, float r2) {
        return getDistance(x1, y1, x2, y2) <= (r1 + r2);
    }
}
