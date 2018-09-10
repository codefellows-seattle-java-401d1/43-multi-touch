package com.android.sooz.multitouch;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class WaitToChooseFingerTask extends AsyncTask<Void, Void, Void> {
    MultiTouchEngine engine;
    long lastTouch;
    int minWait;
    boolean isFinished;
    TextView timeLeft;

//    see lecture at 4:45
    public WaitToChooseFingerTask(MultiTouchEngine engine, int minWait, TextView timeLeft){
        this.engine = engine;
        this.minWait = minWait;
        this.timeLeft = timeLeft;

        isFinished = false;
        update();
    }

    public void update(){
        lastTouch = System.currentTimeMillis();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        boolean hasWaitedLongEnough = false;
        boolean isCancelled = false;

        while(!hasWaitedLongEnough && !isCancelled){
            long now = System.currentTimeMillis();
            long delta = now - lastTouch;
            if(delta > this.minWait){
                hasWaitedLongEnough = true;
                Log.d("COUNTDOWN", "" + delta);
            }

            long left = minWait - delta;
            left = Math.max(delta, 0);
            timeLeft.setText("" + left);

            try{
                    //run at 60 frames per second
                Thread.sleep(1000/60);

            } catch(InterruptedException e){
                isCancelled = true;
            }
        }

        if (isCancelled) {
            isFinished = true;
            timeLeft.setText("cancelled");
            return null;
        }

        engine.pickOneWinner();
        isFinished = true;
        return null;
    }

}
