package me.crosswall.lib.coverflow.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * Created by yuweichen on 16/3/18.
 */
public class CustomScroller extends Scroller {

    private double mScrollFactor = 1;

    private static final int mDuration = 500;

    public CustomScroller(Context context) {
        super(context);
    }

    public CustomScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    @SuppressLint("NewApi")
    public CustomScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }

    public void setScrollDurationFactor(double scrollFactor) {
        mScrollFactor = scrollFactor;
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, (int) (mDuration * mScrollFactor));
    }

}
