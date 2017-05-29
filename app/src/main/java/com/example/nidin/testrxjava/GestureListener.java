package com.example.nidin.testrxjava;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.gesture.Gesture;
import android.view.GestureDetector;

/**
 * Created by nidin on 27/5/17.
 */

public class GestureListener extends
        GestureDetector.SimpleOnGestureListener {

    static String message;

    @Override
    public boolean onSingleTapUp(MotionEvent ev) {
        message="onSingleTapUp\n"+ev.toString();

        return true;
    }
    @Override
    public void onShowPress(MotionEvent ev) {
        message="onShowPress\n"+ev.toString();

    }
    @Override
    public void onLongPress(MotionEvent ev) {
        message="onLongPress\n"+ev.toString();

    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        message="onScroll\n"+e1.toString()+ "\n"+e2.toString();

        return true;
    }
    @Override
    public boolean onDown(MotionEvent ev) {
        message="onDown\n"+ev.toString();

        return true;
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        message="onFling\n"+e1.toString()+ "\n"+e2.toString();
        return true;
    }
    
}
