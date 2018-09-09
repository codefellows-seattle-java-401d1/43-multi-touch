package com.gbbeard.multitouch;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements
        View.OnTouchListener,
        View.OnLayoutChangeListener {

    @BindView(R.id.imageView)
    public ImageView image;
    protected Bitmap bitmap;
    protected Canvas canvas;
    protected MultiTouchEngine engine;
    protected MultiTouchEngineDrawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }
}
