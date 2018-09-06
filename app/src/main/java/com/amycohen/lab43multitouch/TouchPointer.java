package com.amycohen.lab43multitouch;

import android.graphics.Color;

public class TouchPointer {

    int id;
    float xx;
    float yy;
    int color;

    public TouchPointer(int id, float xx, float yy) {
        this.id = id;
        this.xx = xx;
        this.yy = yy;

        //Establish the colors here using random numbers for the RGB values. Addressed in the constructor since it is a part of each pointer. Not necessary to create the random color generator elsewhere.

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        this.color = Color.rgb(red, green, blue);
    }
}
