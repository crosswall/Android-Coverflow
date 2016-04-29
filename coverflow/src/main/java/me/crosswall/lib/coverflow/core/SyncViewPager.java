package me.crosswall.lib.coverflow.core;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by yuweichen on 16/4/29.
 */
public class SyncViewPager extends ViewPager{
    public SyncViewPager(Context context) {
        super(context);
    }

    public SyncViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }




   /* @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(ev.getAction())
                break;

        }


        return super.onTouchEvent(ev);
    }*/
}
