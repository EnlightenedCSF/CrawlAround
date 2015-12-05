package com.vsu.csf.model;

import com.badlogic.gdx.Gdx;
import com.vsu.csf.utils.Consts;
import com.vsu.csf.utils.Utils;

import java.util.ArrayList;

public class Snake {

    private float SEGMENT_DISTANCE = 35;
    private int length;

    private Segment head, tail;
    private ArrayList<Segment> body;
    private float angle;

    public Snake() {
        length = 1;
        body = new ArrayList<Segment>() {{
            add(new Segment() {
                {
                    setX(0);
                    setY(0);
                }
            });
        }
        };
        head = body.get(0);
        tail = body.get(0);
    }

    public Segment getHead() {
        return body.get(0);
    }

    public ArrayList<Segment> getBody() {
        return body;
    }

    public void updateAngle(float sin, float cos) {
        angle = (float) (90 - Math.asin(sin) * Consts.RADIANS_TO_DEGREES);
        if (cos > 0)
            angle *= -1;
    }

    public void update(float delta) {
        float shift = GameSettings.getInstance().getSnakeSpeed() * delta;
        float angle = (this.angle + 90) / Consts.RADIANS_TO_DEGREES;
        float sin = (float) Math.sin(angle);
        float cos = (float) Math.cos(angle);
        Segment previous = new Segment();
        for (Segment s : body) {
            if (s == head) {
                s.update(sin, cos, shift);
                previous = s;
            }
            else {
                float dist = Utils.getDistance(previous.getX(), previous.getY(), s.getX(), s.getY());
                float dx = previous.getX() - s.getX();
                float dy = previous.getY() - s.getY();
                float newSin = dy / dist;
                float newCos = dx / dist;
                s.update(newSin, newCos, shift, previous, SEGMENT_DISTANCE);
                previous = s;
            }
        }
    }

    public void grow() {
        Segment last = new Segment() {{
            setX(tail.getX());
            setY(tail.getY());
        }
        };
        body.add(last);
        tail = last;
        length += 1;
    }
}
