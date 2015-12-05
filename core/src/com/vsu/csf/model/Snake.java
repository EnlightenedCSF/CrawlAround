package com.vsu.csf.model;

import com.vsu.csf.utils.Consts;

import java.util.LinkedList;

public class Snake {

    private LinkedList<Segment> body;
    private float angle;

    public Snake() {
        body = new LinkedList<Segment>() {{
            push(new Segment() {{
                setX(0);
                setY(0);
            }
            });
        }
        };
    }

    public LinkedList<Segment> getBody() {
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
        for (Segment s : body) {
            s.update(sin, cos, shift);
        }
    }
}
