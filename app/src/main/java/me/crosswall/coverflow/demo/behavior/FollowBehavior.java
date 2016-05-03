package me.crosswall.coverflow.demo.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import me.crosswall.coverflow.demo.R;

/**
 * Created by yuweichen on 16/5/3.
 */
public class FollowBehavior extends CoordinatorLayout.Behavior{
    private int targetId;

    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FollowBehavior);
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            if(a.getIndex(i) == R.styleable.FollowBehavior_target){
                targetId = a.getResourceId(attr, -1);
            }
        }
        a.recycle();
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setY(dependency.getY()+dependency.getHeight());
        return true;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency.getId() == targetId;
    }

}
