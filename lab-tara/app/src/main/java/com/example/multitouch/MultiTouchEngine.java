package com.example.multitouch;

import android.text.method.Touch;

import java.util.HashMap;
import java.util.Map;

class MultiTouchEngine {
    Map<Integer, TouchPointer> pointers;

    public MultiTouchEngine() {
        pointers = new HashMap<>();
    }

    public void add(int id, float xx, float yy) {
        TouchPointer pointer = new TouchPointer(id, xx, yy);
        pointers.put(id, pointer);
    }

    public void update(int id, float xx, float yy) {
        TouchPointer pointer = pointers.get(id);
        if (pointer != null) {
            pointer.xx = xx;
            pointer.yy = yy;
        }
    }

    public void remove(int id) {
        pointers.remove(id);
    }
}
