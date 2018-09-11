package com.gbbeard.multitouch;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.widget.ImageView;

public class MultiTouchDrawer {

    public static final int SIZE = 100;

    MultiTouchEngine engine;
    Bitmap bitmap;
    Canvas canvas;
    ImageView imageView;

    public MultiTouchDrawer(MultiTouchEngine engine, Bitmap bitmap, Canvas canvas, ImageView image){
        this.engine = engine;
        this.bitmap = bitmap;
        this.canvas = canvas;
        this.imageView = image;
    }

    public void clear() {
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        imageView.setImageBitmap(bitmap);
    }

    public void draw() {
        Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);
        for (TouchPoints point : engine.points.values()) {
            brush.setColor(point.color);
            canvas.drawCircle(point.xx, point.yy, SIZE, brush);
        }
        imageView.setImageBitmap(bitmap);
    }

}
