package com.gbbeard.multitouch;

import java.util.HashMap;
import java.util.Map;

public class MultiTouchEngine {
    public Map<Integer, TouchPoints> points;

    public MultiTouchEngine() {
        points = new HashMap<>();
    }

    public void add(int id, float xx, float yy) {
        TouchPoints point = new TouchPoints(id, xx, yy);
        points.put(id, point);
    }

    public void update(int id, float xx, float yy) {
        TouchPoints point = points.get(id);

        if (point != null) {
            point.xx = xx;
            point.yy = yy;
        }
    }

    public void remove(int id) {
        points.remove(id);
    }
}
