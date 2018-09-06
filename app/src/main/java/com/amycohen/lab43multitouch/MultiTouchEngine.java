package com.amycohen.lab43multitouch;

import java.util.HashMap;
import java.util.Map;

public class MultiTouchEngine {

    /*
    Keep track of where you are touching on the screen. Separated from Drawer Engine because it doesn't actually draw anything, it just tracks what is drawn.
     */

    public Map<Integer, TouchPointer> pointers;
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
